package edu.fatec.calmaMente.api.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="artigo")

public class Artigo {
    @Id
	@GeneratedValue
	private Integer id;	
    private String titulo;
    private String descricao;
    private String conteudo;
    private String tema;
    @ManyToMany
    @JoinTable(
        name = "artigo_transtorno",
        joinColumns = @JoinColumn(name = "artigo_id"),
        inverseJoinColumns = @JoinColumn(name = "transtorno_id")
    )
    private Set<Transtorno> transtornos;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String nome) {
        this.titulo = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String endereco) {
        this.descricao = endereco;
    }

    public String getConteudo() {
        return conteudo;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }

    public Set<Transtorno> getTranstornos() {
        return transtornos;
    }
    public void setTranstornos(Transtorno transtornos) {
        this.transtornos.add(transtornos);
    }
}
