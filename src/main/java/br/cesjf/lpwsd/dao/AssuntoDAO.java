package br.cesjf.lpwsd.dao;

import br.cesjf.lpwsd.db.Conexao;
import br.cesjf.lpwsd.model.TbAssunto;
import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author tassio
 */
public class AssuntoDAO implements Serializable {

    Logger logger = Logger.getLogger("DAO");
    public static AssuntoDAO assuntoDAO;

    public static AssuntoDAO getInstance() {
        if (assuntoDAO == null) {
            assuntoDAO = new AssuntoDAO();
        }
        return assuntoDAO;
    }

    private Session session;

    public void save(TbAssunto tbAssunto) {
        logger.trace("Start Method");
        Transaction tx = null;
        try {
            session = (Session) Conexao.getSession();
            tx = session.beginTransaction();
            session.save(tbAssunto);
            session.flush();
            tx.commit();
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            tx.rollback();
        } finally {
            logger.trace("Ended Method");
        }
    }

    public TbAssunto getTbAssunto(int id) {
        logger.trace("Start Method");
        try {
            session = (Session) Conexao.getSession();
            TbAssunto tbAssunto = (TbAssunto) session.get(TbAssunto.class, new Integer(id));
            session.close();
            return tbAssunto;
        } catch (Exception ex) {
            logger.error("Unexpected error", ex);
        }
        logger.trace("Ended Method");
        return null;
    }

    public List<TbAssunto> getAll() {
        logger.trace("Start Method");
        try {
            session = Conexao.getSession();
            Query query = session.createQuery("from TbAssunto");
            List<TbAssunto> list = query.list();
            session.close();
            return list;
        } catch (Exception ex) {
            logger.error("Unexpected error", ex);
        }
        logger.trace("Ended Method");
        return null;
    }

    public TbAssunto deleteTbAssunto(int id) {
        logger.trace("Start Method");
        Transaction tx = null;
        try {
            session = (Session) Conexao.getSession();
            TbAssunto tbAssunto = (TbAssunto) session.get(TbAssunto.class, new Integer(id));
            tx = session.beginTransaction();
            session.delete(tbAssunto);
            session.flush();
            tx.commit();
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            tx.rollback();
        } finally {
            logger.trace("Ended Method");
        }
        return null;
    }

    public void deleteTbAssunto(TbAssunto tbAssunto) {
        logger.trace("Start Method");
        Transaction tx = null;
        try {
            session = (Session) Conexao.getSession();
            tx = session.beginTransaction();
            session.delete(tbAssunto);
            session.flush();
            tx.commit();
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            tx.rollback();
        } finally {
            logger.trace("Ended Method");
        }
    }

    public void deleteAllTbAssunto() {
        logger.trace("Start Method");
        Transaction tx = null;
        try {
            session = (Session) Conexao.getSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("delete from TbAssunto");
            query.executeUpdate();
            session.flush();
            tx.commit();
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            tx.rollback();
        } finally {
            logger.trace("Ended Method");
        }
    }

}
