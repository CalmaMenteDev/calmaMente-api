package edu.fatec.calmaMente.api.dao;

import edu.fatec.calmaMente.api.model.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u WHERE u.nome = :nome")
    List<Usuario> findByNome(String nome);
}
