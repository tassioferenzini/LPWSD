/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author tassio
 */
public class Conexao {

    private static SessionFactory sessionFactory;

    private static final void inicializar() throws Exception {
        try {
            sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (HibernateException e) {
            throw new Exception("Error loading Hibernate: " + e.getMessage());
        }
    }

    public static Session getSession() throws Exception {
        if (sessionFactory == null) {
            inicializar();
        }
        try {
            return sessionFactory.openSession();
        } catch (HibernateException e) {
            throw new Exception("Error creating Hibernate session: " + e.getMessage());
        }
    }
}
