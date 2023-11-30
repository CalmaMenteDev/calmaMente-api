package edu.fatec.calmaMente.api.dao;

import edu.fatec.calmaMente.api.model.Transtorno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranstornoDao extends JpaRepository<Transtorno, Integer> {
}
