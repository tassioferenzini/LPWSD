/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tassio
 */
@Entity
@Table(name = "tbEmprestimo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEmprestimo.findAll", query = "SELECT t FROM TbEmprestimo t")
    , @NamedQuery(name = "TbEmprestimo.findByIdtbEmprestimo", query = "SELECT t FROM TbEmprestimo t WHERE t.idtbEmprestimo = :idtbEmprestimo")
    , @NamedQuery(name = "TbEmprestimo.findByDataEmprestimo", query = "SELECT t FROM TbEmprestimo t WHERE t.dataEmprestimo = :dataEmprestimo")})
public class TbEmprestimo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtbEmprestimo")
    private Integer idtbEmprestimo;
    @Column(name = "dataEmprestimo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmprestimo;
    @JoinColumn(name = "tbExemplar_idtbExemplar", referencedColumnName = "idtbExemplar")
    @ManyToOne(optional = false)
    private TbExemplar tbExemplaridtbExemplar;
    @JoinColumn(name = "tbUsuario_idtbUsuario", referencedColumnName = "idtbUsuario")
    @ManyToOne(optional = false)
    private TbUsuario tbUsuarioidtbUsuario;

    public TbEmprestimo() {
    }

    public TbEmprestimo(Integer idtbEmprestimo) {
        this.idtbEmprestimo = idtbEmprestimo;
    }

    public Integer getIdtbEmprestimo() {
        return idtbEmprestimo;
    }

    public void setIdtbEmprestimo(Integer idtbEmprestimo) {
        this.idtbEmprestimo = idtbEmprestimo;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public TbExemplar getTbExemplaridtbExemplar() {
        return tbExemplaridtbExemplar;
    }

    public void setTbExemplaridtbExemplar(TbExemplar tbExemplaridtbExemplar) {
        this.tbExemplaridtbExemplar = tbExemplaridtbExemplar;
    }

    public TbUsuario getTbUsuarioidtbUsuario() {
        return tbUsuarioidtbUsuario;
    }

    public void setTbUsuarioidtbUsuario(TbUsuario tbUsuarioidtbUsuario) {
        this.tbUsuarioidtbUsuario = tbUsuarioidtbUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtbEmprestimo != null ? idtbEmprestimo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEmprestimo)) {
            return false;
        }
        TbEmprestimo other = (TbEmprestimo) object;
        if ((this.idtbEmprestimo == null && other.idtbEmprestimo != null) || (this.idtbEmprestimo != null && !this.idtbEmprestimo.equals(other.idtbEmprestimo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.rio.puc.inf.les.model.TbEmprestimo[ idtbEmprestimo=" + idtbEmprestimo + " ]";
    }
    
}
