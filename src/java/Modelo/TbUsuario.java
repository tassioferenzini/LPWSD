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
@Table(name = "tbUsuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUsuario.findAll", query = "SELECT t FROM TbUsuario t")
    , @NamedQuery(name = "TbUsuario.findByIdtbUsuario", query = "SELECT t FROM TbUsuario t WHERE t.idtbUsuario = :idtbUsuario")
    , @NamedQuery(name = "TbUsuario.findByNomeUsuario", query = "SELECT t FROM TbUsuario t WHERE t.nomeUsuario = :nomeUsuario")
    , @NamedQuery(name = "TbUsuario.findByEmail", query = "SELECT t FROM TbUsuario t WHERE t.email = :email")
    , @NamedQuery(name = "TbUsuario.findBySenha", query = "SELECT t FROM TbUsuario t WHERE t.senha = :senha")})
public class TbUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtbUsuario")
    private Integer idtbUsuario;
    @Basic(optional = false)
    @Column(name = "nomeUsuario")
    private String nomeUsuario;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbUsuarioidtbUsuario")
    private List<TbEmprestimo> tbEmprestimoList;

    public TbUsuario() {
    }

    public TbUsuario(Integer idtbUsuario) {
        this.idtbUsuario = idtbUsuario;
    }

    public TbUsuario(Integer idtbUsuario, String nomeUsuario, String email, String senha) {
        this.idtbUsuario = idtbUsuario;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }

    public Integer getIdtbUsuario() {
        return idtbUsuario;
    }

    public void setIdtbUsuario(Integer idtbUsuario) {
        this.idtbUsuario = idtbUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
        hash += (idtbUsuario != null ? idtbUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsuario)) {
            return false;
        }
        TbUsuario other = (TbUsuario) object;
        if ((this.idtbUsuario == null && other.idtbUsuario != null) || (this.idtbUsuario != null && !this.idtbUsuario.equals(other.idtbUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.rio.puc.inf.les.model.TbUsuario[ idtbUsuario=" + idtbUsuario + " ]";
    }
    
}
