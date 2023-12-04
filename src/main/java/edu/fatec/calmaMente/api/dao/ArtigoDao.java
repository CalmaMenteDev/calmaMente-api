package edu.fatec.calmaMente.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.fatec.calmaMente.api.model.Artigo;

@Repository
public interface ArtigoDao extends JpaRepository<Artigo, Integer> {

}
