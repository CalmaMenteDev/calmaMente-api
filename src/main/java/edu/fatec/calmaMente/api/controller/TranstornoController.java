package edu.fatec.calmaMente.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;

import edu.fatec.calmaMente.api.dao.ArtigoDao;
import edu.fatec.calmaMente.api.dao.TranstornoDao;
import edu.fatec.calmaMente.api.model.Transtorno;

public class TranstornoController {
    private TranstornoDao repository;


	TranstornoController(TranstornoDao transtornodao) {
		this.repository = transtornodao;
	}

	@GetMapping
	public List findAll(){
		return repository.findAll();
	}
}
