package edu.fatec.calmaMente.api.controller;

import org.springframework.web.bind.annotation.RestController;

import edu.fatec.calmaMente.api.dao.UsuarioDao;
import edu.fatec.calmaMente.api.model.Transtorno;
import edu.fatec.calmaMente.api.model.Usuario;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public List<Usuario> findAll(){
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

    @PostMapping(path = {"/transtorno"})
    public Usuario assoiarUsuarioTranstorno(@RequestBody Map<String, String> payload){
        Integer idTranstorno = Integer.parseInt(payload.get("idTranstorno").toString());
        Integer idUsuario = Integer.parseInt(payload.get("idUsuario").toString());

        if (idTranstorno == null || idUsuario == null) {
            //return ResponseEntity.badRequest().body("ID do transtorno ou ID do usuário não pode ser nulo");
        }

        Usuario usuario = findUserById(idUsuario);
        if (usuario == null) {
            //return ((BodyBuilder) ResponseEntity.notFound()).body("Usuario não encontrado");
        }

        Transtorno transtorno = em.find(Transtorno.class, idTranstorno);
        if (transtorno == null) {
            //return ((BodyBuilder) ResponseEntity.notFound()).body("Transtorno não encontrado");
            //return ResponseEntity.notFound().body("Transtorno não encontrado");
        }
        System.out.println("Usuario: " + transtorno.getTitulo());
        usuario.setTranstornos(transtorno);
        //transtorno.setUsuarios(usuario);

        return repository.save(usuario);
        // em.persist(transtorno);

        //return ResponseEntity.ok().build();
        //em.persist(transtorno);
        
        //return ResponseEntity.ok().build();
    }

    @PostMapping(path = {"/login"})
    public ResponseEntity<Usuario> findByNome(@RequestBody Usuario usuario) {
        String query = "SELECT u FROM Usuario u WHERE u.cpf = :cpf AND u.senha = :senha";

        TypedQuery<Usuario> typedQuery = em.createQuery(query, Usuario.class);
        typedQuery.setParameter("cpf", usuario.getCpf());
        typedQuery.setParameter("senha", usuario.getSenha());
        typedQuery.setMaxResults(1); // Limit the result to 1

        List<Usuario> resultList = typedQuery.getResultList();
        if (!resultList.isEmpty()) {
            return ResponseEntity.ok().body(resultList.get(0));
        } else {
            return ResponseEntity.notFound().build();
        }
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

    @DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable int id) {
		return repository.findById((int)id)
				.map(record -> {
					repository.deleteById((int) id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}

    private Usuario findUserById(Integer id){
        Optional<Usuario> optionalUser = repository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        } else {
            return null;
        }
    }
}
