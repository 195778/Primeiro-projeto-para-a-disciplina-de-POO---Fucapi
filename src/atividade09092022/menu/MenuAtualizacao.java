package atividade09092022.menu;

import java.util.List;
import java.util.Scanner;

import atividade09092022.entities.Aluno;

public class MenuAtualizacao {
	public static void menuAtualizarAluno(List<Aluno> alunos, Scanner sc) {
		
		System.out.println("-----------------------------------------------");
		System.out.print("Informe a matricula do aluno que deseja atualizar: ");
		String matricula = sc.next();
		Aluno alunoASerAtualizado = null;
		
		boolean matriculaValida = false;
		for (Aluno aluno : alunos) {
			
			if(aluno.getMatriculaAluno().equals(matricula)) {
				matriculaValida = true;
				alunoASerAtualizado = aluno;
			}
		}
		if(matriculaValida == true) {
			int opcao = 1;
			while (opcao != 0) {
				System.out.println();
				System.out.println("O que deseja alterar do aluno " + alunoASerAtualizado.getNomeAluno() + ": ");
				System.out.println("1 - Nome do aluno");
				System.out.println("2 - Sobrenome do aluno");
				System.out.println("3 - Matricula do aluno");
				System.out.println("4 - Curso do aluno");
				System.out.println("0 - Voltar");
				System.out.print("Opcao: ");
				opcao = sc.nextInt();
				
				switch(opcao) {
				
				case 0:
					System.out.println("Sessao finalizada.");
					break;
				case 1:
					alteraNomeDoAluno(alunoASerAtualizado,sc);
					break;
				case 2:
					alteraSobrenomeDoAluno(alunoASerAtualizado,sc);
					break;
				case 3:
					alteraMatriculaDoAluno(alunos, alunoASerAtualizado,sc);
					break;
				case 4:
					alteraCursoDoAluno(alunoASerAtualizado,sc);
					break;
				default:
					System.out.println("Opcao incorreta, tente novamente.");
					System.out.println();
					break;
				}
			}
		}else {
			System.out.println("Matricula não encontrada!");
		}
	}

	private static void alteraCursoDoAluno(Aluno alunoASerAtualizado, Scanner sc) {
		System.out.print("Informe o novo curso: ");
		String curso = sc.next();
		alunoASerAtualizado.atualizarNomeCurso(curso);
	}

	private static void alteraMatriculaDoAluno(List<Aluno> alunos, Aluno alunoASerAtualizado, Scanner sc) {
		MenuInicio menuInicio = new MenuInicio();
		boolean matriculaDisponivel = false;
		String matricula = null;
		while(matriculaDisponivel == false) {
			System.out.print("Informe a nova matricula (Informe 0 para sair): ");
			matricula = sc.next();
			if(matricula == "0") {
				return;
			}
			matriculaDisponivel = menuInicio.verificarMatriculaDisponivel(alunos, matricula);
		}
		if(matricula != null) {
			alunoASerAtualizado.atualizarMatriculaAluno(matricula);
		}
	}

	private static void alteraSobrenomeDoAluno(Aluno alunoASerAtualizado, Scanner sc) {
		System.out.print("Informe o novo sobrenome: ");
		String sobrenome = sc.next();
		alunoASerAtualizado.atualizarSobrenomeAluno(sobrenome);
	}

	private static void alteraNomeDoAluno(Aluno alunoASerAtualizado, Scanner sc) {
		System.out.print("Informe o novo nome: ");
		String nome = sc.next();
		alunoASerAtualizado.atualizarNomeAluno(nome);
	}
}
