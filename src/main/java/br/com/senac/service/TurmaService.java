package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Turma;
import br.com.senac.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepo;
	
	public List<Turma> listaTodasTurmas(){
		return turmaRepo.findAll();
	}
	
	public Turma buscarPorId(Integer id) throws ObjectNotFoundException {
		Optional<Turma> turma = turmaRepo.findById(id);
		return turma.orElseThrow(() -> new ObjectNotFoundException(null, "Turma não encontrada."));
	}
	
	public Turma salvar(Turma turma) {
		return turmaRepo.save(turma);
	}
	
	public void excluir(Integer id) {
		turmaRepo.deleteById(id);
	}
	
	public Turma alterar(Turma objTurma) {
		Turma turma = buscarPorId(objTurma.getId());
		turma.setNome(objTurma.getNome());
		return salvar(turma);
	}
}
