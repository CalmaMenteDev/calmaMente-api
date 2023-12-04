package edu.fatec.calmaMente.api.model;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name="Usuario")
public class Usuario {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    @Column(name="data_nascimento")

    private String dataNascimento;
    private String cpf;
    private String senha;
    @ManyToMany
    @JoinTable(
        name = "usuario_transtorno",
        //uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "transtorno_id"}),
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "transtorno_id")
    )
    private Set<Transtorno> transtornos;

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTranstornos(Transtorno transtornos) {
        this.transtornos.add(transtornos);
    }

    public Set<Transtorno> getTranstornos() {
        return transtornos;
    }
}
