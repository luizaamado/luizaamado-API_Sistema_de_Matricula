package br.com.senac.resource;

import java.net.URI;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.senac.entity.Turma;
import br.com.senac.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaResource {
	
	@Autowired
	private TurmaService turmaService;
	
	//@GetMapping
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Turma>> listarTurmas() {
		List<Turma> turmas = turmaService.listaTodasTurmas();
		return ResponseEntity.ok().body(turmas);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Turma> buscaPorId(@PathVariable Integer id) throws ObjectNotFoundException {
		Turma turma = turmaService.buscarPorId(id);
		return ResponseEntity.ok().body(turma);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Turma objTurma) {
		Turma turma = turmaService.salvar(objTurma);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(turma.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		turmaService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody Turma objTurma, @PathVariable Integer id) {
		objTurma.setId(id);
		turmaService.alterar(objTurma);
		return ResponseEntity.noContent().build();
	}
}
