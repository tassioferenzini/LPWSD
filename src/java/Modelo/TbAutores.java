/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tassio
 */
@Entity
@Table(name = "tbAutores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAutores.findAll", query = "SELECT t FROM TbAutores t")
    , @NamedQuery(name = "TbAutores.findByIdtbAutores", query = "SELECT t FROM TbAutores t WHERE t.idtbAutores = :idtbAutores")
    , @NamedQuery(name = "TbAutores.findByNomeAutor", query = "SELECT t FROM TbAutores t WHERE t.nomeAutor = :nomeAutor")})
public class TbAutores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtbAutores")
    private Integer idtbAutores;
    @Basic(optional = false)
    @Column(name = "nomeAutor")
    private String nomeAutor;
    @JoinTable(name = "tbAutorLivro", joinColumns = {
        @JoinColumn(name = "tbAutores_idtbAutores", referencedColumnName = "idtbAutores")}, inverseJoinColumns = {
        @JoinColumn(name = "tbLivro_idtbLivro", referencedColumnName = "idtbLivro")})
    @ManyToMany
    private List<TbLivro> tbLivroList;

    public TbAutores() {
    }

    public TbAutores(Integer idtbAutores) {
        this.idtbAutores = idtbAutores;
    }

    public TbAutores(Integer idtbAutores, String nomeAutor) {
        this.idtbAutores = idtbAutores;
        this.nomeAutor = nomeAutor;
    }

    public Integer getIdtbAutores() {
        return idtbAutores;
    }

    public void setIdtbAutores(Integer idtbAutores) {
        this.idtbAutores = idtbAutores;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
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
        hash += (idtbAutores != null ? idtbAutores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAutores)) {
            return false;
        }
        TbAutores other = (TbAutores) object;
        if ((this.idtbAutores == null && other.idtbAutores != null) || (this.idtbAutores != null && !this.idtbAutores.equals(other.idtbAutores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.rio.puc.inf.les.model.TbAutores[ idtbAutores=" + idtbAutores + " ]";
    }
    
}
