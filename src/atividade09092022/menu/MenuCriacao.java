package atividade09092022.menu;

import java.util.List;
import java.util.Scanner;

import atividade09092022.entities.Aluno;

public class MenuCriacao {
	
	static MenuInicio menuInicio = new MenuInicio();
	
	public static void menuAdicionarAluno(List<Aluno> alunos, Scanner sc) {
		boolean matriculaDisponivel = false;
		
		System.out.print("Nome do aluno: ");
		String nomeAluno = sc.next();
		System.out.print("Sobrenome do aluno: ");
		String sobrenomeAluno = sc.next();
		
		String matriculaAluno = null;
		while(matriculaDisponivel == false) {
			System.out.print("Matricula do aluno: ");
			matriculaAluno = sc.next();
			matriculaDisponivel = menuInicio.verificarMatriculaDisponivel(alunos, matriculaAluno);
		}
		
		System.out.print("Curso matriculado: ");
		String nomeCurso = sc.next();
		
		alunos.add(new Aluno(nomeAluno, sobrenomeAluno, matriculaAluno, nomeCurso));
	}
}
