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
@Table(name = "tbEditora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEditora.findAll", query = "SELECT t FROM TbEditora t")
    , @NamedQuery(name = "TbEditora.findByIdtbEditora", query = "SELECT t FROM TbEditora t WHERE t.idtbEditora = :idtbEditora")
    , @NamedQuery(name = "TbEditora.findByNomeEditora", query = "SELECT t FROM TbEditora t WHERE t.nomeEditora = :nomeEditora")})
public class TbEditora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtbEditora")
    private Integer idtbEditora;
    @Basic(optional = false)
    @Column(name = "nomeEditora")
    private String nomeEditora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbEditoraidtbEditora")
    private List<TbLivro> tbLivroList;

    public TbEditora() {
    }

    public TbEditora(Integer idtbEditora) {
        this.idtbEditora = idtbEditora;
    }

    public TbEditora(Integer idtbEditora, String nomeEditora) {
        this.idtbEditora = idtbEditora;
        this.nomeEditora = nomeEditora;
    }

    public Integer getIdtbEditora() {
        return idtbEditora;
    }

    public void setIdtbEditora(Integer idtbEditora) {
        this.idtbEditora = idtbEditora;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
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
        hash += (idtbEditora != null ? idtbEditora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEditora)) {
            return false;
        }
        TbEditora other = (TbEditora) object;
        if ((this.idtbEditora == null && other.idtbEditora != null) || (this.idtbEditora != null && !this.idtbEditora.equals(other.idtbEditora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.rio.puc.inf.les.model.TbEditora[ idtbEditora=" + idtbEditora + " ]";
    }
    
}
