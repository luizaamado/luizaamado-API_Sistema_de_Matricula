package br.com.senac.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.AlunoDisciplina;
import br.com.senac.entity.Avaliacao;
import br.com.senac.entity.Disciplina;
import br.com.senac.entity.Professor;
import br.com.senac.entity.Turma;
import br.com.senac.repository.AlunoRepository;
import br.com.senac.repository.DisciplinaRepository;
import br.com.senac.repository.ProfessorRepository;
import br.com.senac.repository.TurmaRepository;
import br.com.senac.service.AvaliacaoService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	AlunoRepository alunoRepo;
	
	@Autowired
	ProfessorRepository professorRepo;
	
	@Autowired
	DisciplinaRepository disciplinaRepo;
	
	@Autowired
	TurmaRepository turmaRepo;
	
	@Autowired
	AvaliacaoService avaliacaoService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("Programação Web II");		
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setNome("Engenharia de Software I");
		
		Disciplina disciplina3 = new Disciplina();
		disciplina3.setNome("Banco de Dados I");
		
		Disciplina disciplina4 = new Disciplina();
		disciplina4.setNome("Segurança da Informação");
		
		disciplinaRepo.saveAll(Arrays.asList(disciplina1, disciplina2, disciplina3, disciplina4));
		
		Turma turma1 = new Turma();
		turma1.setNome("Turma ADS I");
		turma1.setAno(2020);
		turma1.setCurso("Análise e Desenvolvimento de Sistemas");
		
		Turma turma2 = new Turma();
		turma2.setNome("Turma Redes II");
		turma2.setAno(2022);
		turma2.setCurso("Redes de Computadores");
		
		Turma turma3 = new Turma();
		turma3.setNome("Turma Design I");
		turma3.setAno(2021);
		turma3.setCurso("Design Gráfico");
		
		Turma turma4 = new Turma();
		turma4.setNome("Turma Marketing");
		turma4.setAno(2020);
		turma4.setCurso("Marketing");
		
		turmaRepo.saveAll(Arrays.asList(turma1, turma2, turma3, turma4));
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		aluno1.setTurma(turma1);
		aluno1.setDisciplinas(Arrays.asList(disciplina1, disciplina2));
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Matheus");
		aluno2.setTurma(turma3);
		aluno2.setDisciplinas(Arrays.asList(disciplina2, disciplina4));
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Gisella");
		aluno3.setTurma(turma1);
		aluno3.setDisciplinas(Arrays.asList(disciplina1, disciplina3));
		
		Aluno aluno4 = new Aluno();
		aluno4.setNome("Mariana");
		aluno4.setTurma(turma4);
		aluno4.setDisciplinas(Arrays.asList(disciplina3, disciplina2));
		
		alunoRepo.saveAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4));
		
		Professor professor1 = new Professor();
		professor1.setNome("Alfredo");		
		
		Professor professor2 = new Professor();
		professor2.setNome("Flavio");
		
		Professor professor3 = new Professor();
		professor3.setNome("Jessica");
		
		Professor professor4 = new Professor();
		professor4.setNome("Heloisa");
		
		professorRepo.saveAll(Arrays.asList(professor1, professor2, professor3, professor4));
		
		Avaliacao avaliacaoAluno1 = new Avaliacao();
		
		AlunoDisciplina alunoDisciplina1 = new AlunoDisciplina();
		alunoDisciplina1.setAluno(aluno1);
		alunoDisciplina1.setDisciplina(disciplina3);
		
		avaliacaoAluno1.setAlunoDisciplina(alunoDisciplina1);
		avaliacaoAluno1.setConceito("A");
		avaliacaoService.save(avaliacaoAluno1);
		
		Avaliacao avaliacaoAluno2 = new Avaliacao();
		
		AlunoDisciplina alunoDisciplina2 = new AlunoDisciplina();
		alunoDisciplina2.setAluno(aluno2);
		alunoDisciplina2.setDisciplina(disciplina2);
		
		avaliacaoAluno2.setAlunoDisciplina(alunoDisciplina2);
		avaliacaoAluno2.setConceito("B");
		avaliacaoService.save(avaliacaoAluno2);
	}
	
}
