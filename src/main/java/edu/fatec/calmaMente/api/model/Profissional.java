package edu.fatec.calmaMente.api.model;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name="Usuario")
public class Profissional{
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="data_nascimento")
    private String dataNascimento;
    private String cpf;
    private String registro;
    private String especialidade;
    private String email;
    private String senha;
    private String nome;
    
    
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


    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
