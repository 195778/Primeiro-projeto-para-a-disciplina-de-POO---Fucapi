package atividade09092022.entities;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	private String nomeAluno;
	private String sobrenomeAluno;
	private String matriculaAluno;
	private String nomeCurso;
	private List<String> disciplinasAprovadasAluno = new ArrayList<>();
	private List<Double> notasAluno = new ArrayList<>();
	private List<String> disciplinasMatriculadasAluno = new ArrayList<>();
	
	public Aluno() {
	}
	
	public Aluno(String nomeAluno, String sobrenomeAluno, String matriculaAluno, String nomeCurso) {
		this.nomeAluno = nomeAluno;
		this.sobrenomeAluno = sobrenomeAluno;
		this.matriculaAluno = matriculaAluno;
		this.nomeCurso = nomeCurso;
	}
	
	public String getNomeAluno() {
		return nomeAluno;
	}

	public String getSobrenomeAluno() {
		return sobrenomeAluno;
	}

	public String getMatriculaAluno() {
		return matriculaAluno;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}
	
	public void atualizarNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	
	public void atualizarSobrenomeAluno(String sobrenomeAluno) {
		this.sobrenomeAluno = sobrenomeAluno;
	}
	
	public void atualizarMatriculaAluno(String matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}
	
	public void atualizarNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public void adicionarNotasAluno(Double nota) {
		notasAluno.add(nota);
	}
	
	public void listaNotasAluno() {
		System.out.println("Notas do aluno:");
		for (Double notas : notasAluno) {
			System.out.println(notas);
		}
	}
	
	/*Verifica todas as disciplinas aprovadas, retirando automaticamente da lista de matriculadas caso encontrado.*/
	private void atualizarListaAprovadasEMatriculadas() {
		for (String disciplinaMatricula : disciplinasMatriculadasAluno) {
			if(disciplinasAprovadasAluno.contains(disciplinaMatricula)) {
				disciplinasMatriculadasAluno.remove(disciplinaMatricula);
			}
		}
	}
	
	public void adicionarDisciplinaAprovada(String disciplina) {
		boolean jaContemDisciplinaNaLista = false;
		if (disciplinasAprovadasAluno.contains(disciplina)) {
			jaContemDisciplinaNaLista = true;
			return;
		}if(!jaContemDisciplinaNaLista) {
			disciplinasAprovadasAluno.add(disciplina);
			atualizarListaAprovadasEMatriculadas();
		}
	}
	
	public void adicionarDisciplinaMatriculada(String disciplina) {
		boolean jaContemDisciplinaNaLista = false;
		if(disciplinasMatriculadasAluno.contains(disciplina) || disciplinasAprovadasAluno.contains(disciplina)) {
			System.out.println();
			System.out.println("Disciplina (" + disciplina +") já matriculada e/ou aprovada.");
			System.out.println();
			return;
		}if(!jaContemDisciplinaNaLista) {
			disciplinasMatriculadasAluno.add(disciplina);
		}
	}
	
	public void moverDisciplinaDeMatriculadaParaAprovada(String disciplina) {
		for (String string : disciplinasMatriculadasAluno) {
			if(disciplinasMatriculadasAluno.contains(disciplina)) {
				disciplinasMatriculadasAluno.remove(disciplina);
				adicionarDisciplinaAprovada(disciplina);
			}
		}
	}
	
	public void exibeListaDeDisciplinasAprovadas() {
		System.out.println("Disciplinas aprovadas pelo aluno:");
		for (String disciplinaAprovada : disciplinasAprovadasAluno) {
			System.out.println(disciplinaAprovada);
		}
		System.out.println();
	}
	
	public void exibeListaDeDisciplinasMatriculadas() {
		System.out.println("Disciplinas matriculadas:");
		for (String disciplinaMatriculada : disciplinasMatriculadasAluno) {
			System.out.println(disciplinaMatriculada);
		}
		System.out.println();
	}
	
	@Override
	public String toString() {
		return "Nome: "
				+ this.nomeAluno
				+ "	|	Sobrenome: "
				+ this.sobrenomeAluno
				+ "	|	Matricula: "
				+ this.matriculaAluno
				+ "	|	Curso: "
				+ this.nomeCurso;
	}
}
