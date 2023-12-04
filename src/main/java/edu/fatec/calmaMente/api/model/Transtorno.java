package edu.fatec.calmaMente.api.model;

import javax.persistence.*;

import java.util.Set;
import java.util.Set;

@Entity
@Table(name="transtorno")
public class Transtorno {
    @Id
    @GeneratedValue
    private Integer id;
    private String titulo;
    private String descricao;
    @ManyToMany(mappedBy = "transtornos")
    private Set<Usuario> usuarios;
    
    @ManyToMany(mappedBy = "transtornos")
    private Set<Artigo> artigos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // public Set<Usuario> getUsuarios() {
    //     return usuarios;
    // }

    public void setUsuarios(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void setArtigos(Artigo artigo) {
        this.artigos.add(artigo);
    }
}
