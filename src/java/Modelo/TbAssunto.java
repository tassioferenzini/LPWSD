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
import javax.persistence.Lob;
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
@Table(name = "tbAssunto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAssunto.findAll", query = "SELECT t FROM TbAssunto t")
    , @NamedQuery(name = "TbAssunto.findByIdtbAssunto", query = "SELECT t FROM TbAssunto t WHERE t.idtbAssunto = :idtbAssunto")
    , @NamedQuery(name = "TbAssunto.findByNomeAssunto", query = "SELECT t FROM TbAssunto t WHERE t.nomeAssunto = :nomeAssunto")
    , @NamedQuery(name = "TbAssunto.findByAssunto", query = "SELECT t FROM TbAssunto t WHERE t.assunto = :assunto")})
public class TbAssunto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtbAssunto")
    private Integer idtbAssunto;
    @Basic(optional = false)
    @Column(name = "nomeAssunto")
    private String nomeAssunto;
    @Basic(optional = false)
    @Lob
    @Column(name = "descricaoAssunto")
    private String descricaoAssunto;
    @Basic(optional = false)
    @Column(name = "assunto")
    private String assunto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAssuntoidtbAssunto")
    private List<TbLivro> tbLivroList;

    public TbAssunto() {
    }

    public TbAssunto(Integer idtbAssunto) {
        this.idtbAssunto = idtbAssunto;
    }

    public TbAssunto(Integer idtbAssunto, String nomeAssunto, String descricaoAssunto, String assunto) {
        this.idtbAssunto = idtbAssunto;
        this.nomeAssunto = nomeAssunto;
        this.descricaoAssunto = descricaoAssunto;
        this.assunto = assunto;
    }

    public Integer getIdtbAssunto() {
        return idtbAssunto;
    }

    public void setIdtbAssunto(Integer idtbAssunto) {
        this.idtbAssunto = idtbAssunto;
    }

    public String getNomeAssunto() {
        return nomeAssunto;
    }

    public void setNomeAssunto(String nomeAssunto) {
        this.nomeAssunto = nomeAssunto;
    }

    public String getDescricaoAssunto() {
        return descricaoAssunto;
    }

    public void setDescricaoAssunto(String descricaoAssunto) {
        this.descricaoAssunto = descricaoAssunto;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    @XmlTransient
    public List<TbLivro> getTbLivroList() {
        return tbLivroList;
    }

    public void setTbLivroList(List<TbLivro> tbLivroList) {
        this.tbLivroList = tbLivroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtbAssunto != null ? idtbAssunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAssunto)) {
            return false;
        }
        TbAssunto other = (TbAssunto) object;
        if ((this.idtbAssunto == null && other.idtbAssunto != null) || (this.idtbAssunto != null && !this.idtbAssunto.equals(other.idtbAssunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.rio.puc.inf.les.model.TbAssunto[ idtbAssunto=" + idtbAssunto + " ]";
    }
    
}
