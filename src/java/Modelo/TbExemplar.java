/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tassio
 */
@Entity
@Table(name = "tbExemplar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbExemplar.findAll", query = "SELECT t FROM TbExemplar t")
    , @NamedQuery(name = "TbExemplar.findByIdtbExemplar", query = "SELECT t FROM TbExemplar t WHERE t.idtbExemplar = :idtbExemplar")
    , @NamedQuery(name = "TbExemplar.findByCircular", query = "SELECT t FROM TbExemplar t WHERE t.circular = :circular")})
public class TbExemplar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtbExemplar")
    private Integer idtbExemplar;
    @Basic(optional = false)
    @Column(name = "circular")
    private short circular;
    @JoinColumn(name = "tbLivro_idtbLivro", referencedColumnName = "idtbLivro")
    @ManyToOne(optional = false)
    private TbLivro tbLivroidtbLivro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbExemplaridtbExemplar")
    private List<TbEmprestimo> tbEmprestimoList;

    public TbExemplar() {
    }

    public TbExemplar(Integer idtbExemplar) {
        this.idtbExemplar = idtbExemplar;
    }

    public TbExemplar(Integer idtbExemplar, short circular) {
        this.idtbExemplar = idtbExemplar;
        this.circular = circular;
    }

    public Integer getIdtbExemplar() {
        return idtbExemplar;
    }

    public void setIdtbExemplar(Integer idtbExemplar) {
        this.idtbExemplar = idtbExemplar;
    }

    public short getCircular() {
        return circular;
    }

    public void setCircular(short circular) {
        this.circular = circular;
    }

    public TbLivro getTbLivroidtbLivro() {
        return tbLivroidtbLivro;
    }

    public void setTbLivroidtbLivro(TbLivro tbLivroidtbLivro) {
        this.tbLivroidtbLivro = tbLivroidtbLivro;
    }

    @XmlTransient
    public List<TbEmprestimo> getTbEmprestimoList() {
        return tbEmprestimoList;
    }

    public void setTbEmprestimoList(List<TbEmprestimo> tbEmprestimoList) {
        this.tbEmprestimoList = tbEmprestimoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtbExemplar != null ? idtbExemplar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbExemplar)) {
            return false;
        }
        TbExemplar other = (TbExemplar) object;
        if ((this.idtbExemplar == null && other.idtbExemplar != null) || (this.idtbExemplar != null && !this.idtbExemplar.equals(other.idtbExemplar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.rio.puc.inf.les.model.TbExemplar[ idtbExemplar=" + idtbExemplar + " ]";
    }
    
}
