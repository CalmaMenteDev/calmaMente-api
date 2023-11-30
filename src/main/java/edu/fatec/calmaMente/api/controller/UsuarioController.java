package edu.fatec.calmaMente.api.controller;

import org.springframework.web.bind.annotation.RestController;

import edu.fatec.calmaMente.api.dao.UsuarioDao;
import edu.fatec.calmaMente.api.model.Usuario;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/usuario")
@RestController
@SpringBootApplication
@CrossOrigin (origins = "*")
public class UsuarioController {
    private UsuarioDao repository;
    @PersistenceContext
    private EntityManager em;

    UsuarioController(UsuarioDao usuariodao) {
        this.repository = usuariodao;
    }

    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable int id) {
        return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario){
        return repository.save(usuario);
    }

    @PostMapping(path = {"/login"})
    public List findByNome(@RequestBody String cpf) {
        
        //String cpf = "123";
        String query = "SELECT u FROM Usuario u WHERE u.cpf = :cpf";
        TypedQuery<Usuario> TypedQuery = em.createQuery(query, Usuario.class);
        TypedQuery.setParameter("cpf", cpf);
        return TypedQuery.getResultList();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody Usuario usuario) {
        return repository.findById(id)
				.map(record -> {
					record.setNome(usuario.getNome());
					record.setCpf(usuario.getCpf());
					record.setDataNascimento(usuario.getDataNascimento());
                    record.setSenha(usuario.getSenha());
					Usuario updated = repository.save(record);
					return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());
    }
}
