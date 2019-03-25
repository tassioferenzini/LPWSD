/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tassio
 */
@Entity
@Table(name = "tbLivro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbLivro.findAll", query = "SELECT t FROM TbLivro t")
    , @NamedQuery(name = "TbLivro.findByIdtbLivro", query = "SELECT t FROM TbLivro t WHERE t.idtbLivro = :idtbLivro")
    , @NamedQuery(name = "TbLivro.findByTitulo", query = "SELECT t FROM TbLivro t WHERE t.titulo = :titulo")
    , @NamedQuery(name = "TbLivro.findByIsbn", query = "SELECT t FROM TbLivro t WHERE t.isbn = :isbn")
    , @NamedQuery(name = "TbLivro.findByEdicao", query = "SELECT t FROM TbLivro t WHERE t.edicao = :edicao")
    , @NamedQuery(name = "TbLivro.findByAno", query = "SELECT t FROM TbLivro t WHERE t.ano = :ano")})
public class TbLivro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtbLivro")
    private Integer idtbLivro;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "isbn")
    private String isbn;
    @Basic(optional = false)
    @Column(name = "edicao")
    private int edicao;
    @Basic(optional = false)
    @Column(name = "ano")
    @Temporal(TemporalType.DATE)
    private Date ano;
    @ManyToMany(mappedBy = "tbLivroList")
    private List<TbAutores> tbAutoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbLivroidtbLivro")
    private List<TbExemplar> tbExemplarList;
    @JoinColumn(name = "tbAssunto_idtbAssunto", referencedColumnName = "idtbAssunto")
    @ManyToOne(optional = false)
    private TbAssunto tbAssuntoidtbAssunto;
    @JoinColumn(name = "tbEditora_idtbEditora", referencedColumnName = "idtbEditora")
    @ManyToOne(optional = false)
    private TbEditora tbEditoraidtbEditora;

    public TbLivro() {
    }

    public TbLivro(Integer idtbLivro) {
        this.idtbLivro = idtbLivro;
    }

    public TbLivro(Integer idtbLivro, String titulo, String isbn, int edicao, Date ano) {
        this.idtbLivro = idtbLivro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.edicao = edicao;
        this.ano = ano;
    }

    public Integer getIdtbLivro() {
        return idtbLivro;
    }

    public void setIdtbLivro(Integer idtbLivro) {
        this.idtbLivro = idtbLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    @XmlTransient
    public List<TbAutores> getTbAutoresList() {
        return tbAutoresList;
    }

    public void setTbAutoresList(List<TbAutores> tbAutoresList) {
        this.tbAutoresList = tbAutoresList;
    }

    @XmlTransient
    public List<TbExemplar> getTbExemplarList() {
        return tbExemplarList;
    }

    public void setTbExemplarList(List<TbExemplar> tbExemplarList) {
        this.tbExemplarList = tbExemplarList;
    }

    public TbAssunto getTbAssuntoidtbAssunto() {
        return tbAssuntoidtbAssunto;
    }

    public void setTbAssuntoidtbAssunto(TbAssunto tbAssuntoidtbAssunto) {
        this.tbAssuntoidtbAssunto = tbAssuntoidtbAssunto;
    }

    public TbEditora getTbEditoraidtbEditora() {
        return tbEditoraidtbEditora;
    }

    public void setTbEditoraidtbEditora(TbEditora tbEditoraidtbEditora) {
        this.tbEditoraidtbEditora = tbEditoraidtbEditora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtbLivro != null ? idtbLivro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbLivro)) {
            return false;
        }
        TbLivro other = (TbLivro) object;
        if ((this.idtbLivro == null && other.idtbLivro != null) || (this.idtbLivro != null && !this.idtbLivro.equals(other.idtbLivro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.rio.puc.inf.les.model.TbLivro[ idtbLivro=" + idtbLivro + " ]";
    }
    
}
