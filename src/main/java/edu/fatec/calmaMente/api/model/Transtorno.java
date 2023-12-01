package edu.fatec.calmaMente.api.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="transtorno")
public class Transtorno {
    @Id
    @GeneratedValue
    private Integer id;
    private String titulo;
    private String descricao;
    //@ManyToMany(targetEntity=Transtorno.class)
    //private Set<Usuario> usuarios;

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
}
