package edu.fatec.calmaMente.api.model;

import javax.persistence.*;

import ch.qos.logback.classic.db.names.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    // @ManyToMany(targetEntity=Transtorno.class)
    // @JoinTable(
    //     name = "usuario_transtorno",
    //     joinColumns = {
    //         @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
    //         @JoinColumn(name = "transtorno_id", referencedColumnName = "id")

    //     },
    //     foreignKey = @ForeignKey(name = "fk_usuario_transtorno_usuario"),
    //     inverseForeignKey = @ForeignKey(name = "fk_usuario_transtorno_transtorno"),
    //     uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "transtorno_id"})
    // )
    // private Set<Transtorno> transtornoSet;

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
}
