package br.com.senac.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.entity.Professor;
import br.com.senac.service.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {
	
	@Autowired
	private ProfessorService professorService;
	
	//@GetMapping
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Professor>> listarProfessores() {
		List<Professor> professores = professorService.listaTodosProfessores();
		return ResponseEntity.ok().body(professores);
	}

}
