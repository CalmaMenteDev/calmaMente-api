package edu.fatec.calmaMente.api.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fatec.calmaMente.api.dao.ArtigoDao;
import edu.fatec.calmaMente.api.model.Artigo;

@RequestMapping("/artigo")
@RestController
@SpringBootApplication
@CrossOrigin (origins = "*")
public class ArtigoController {
    private ArtigoDao repository;

	ArtigoController(ArtigoDao artigodao) {
		this.repository = artigodao;
	}

	@GetMapping
	public List findAll(){
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable int id){
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Artigo create(@RequestBody Artigo artigo){
		return repository.save(artigo);
	}

	@PutMapping(value="/{id}")
	public ResponseEntity update(@PathVariable("id") int id, @RequestBody Artigo artigo) {
		return repository.findById(id)
				.map(record -> {
					record.setConteudo(artigo.getConteudo());
                    record.setTitulo(artigo.getTitulo());
                    record.setDescricao(artigo.getDescricao());
                    record.setTema(artigo.getTema());
					Artigo updated = repository.save(record);
					return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable int id) {
		return repository.findById((int)id)
				.map(record -> {
					repository.deleteById((int) id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
}
