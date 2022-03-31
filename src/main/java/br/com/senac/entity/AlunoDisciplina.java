package br.com.senac.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AlunoDisciplina implements Serializable {

	private static final long serialVersionUID = -3633942199087339259L;

	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	private Disciplina disciplina;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
