package atividade09092022.menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import atividade09092022.entities.Aluno;

public class MenuDisciplinas {
	
	public static void menuPrincipalDisciplinas(List<Aluno> alunos, Scanner sc) throws IOException {
		
		System.out.println("-----------------------------------------------");
		System.out.print("Informe a matricula do aluno para consultar suas disciplinas: ");
		String matricula = sc.next();
		Aluno alunoConsultado = null;
		
		boolean matriculaValida = false;
		for (Aluno aluno : alunos) {
			
			if(aluno.getMatriculaAluno().equals(matricula)) {
				matriculaValida = true;
				alunoConsultado = aluno;
			}
		}if(matriculaValida) {
			try {
				int opcao = 1;
				String pausa = null;
				while (opcao != 0) {
					System.out.println("-----------------------------------------------");
					System.out.println("Selecione umas das opcoes para as disciplinas de " + alunoConsultado.getNomeAluno() + ": ");
					System.out.println("1 - Cadastrar disciplina aprovada");
					System.out.println("2 - Cadastrar disciplina matriculada");
					System.out.println("3 - Mover disciplina matriculada para aprovada");
					System.out.println("4 - Listar disciplinas aprovadas");
					System.out.println("5 - Listar disciplinas matriculadas");
					System.out.println("0 - Voltar");
					System.out.print("Opcao: ");
					opcao = sc.nextInt();
					
					switch(opcao) {
					
					case 0:
						System.out.println("Sessao finalizada.");
						break;
					case 1:
						System.out.print("Infome a disciplina aprovada que deseja cadastrar: ");
						String disciplinaAprovada = sc.next();
						alunoConsultado.adicionarDisciplinaAprovada(disciplinaAprovada);
						break;
					case 2:
						System.out.print("Infome a nova disciplina matriculada: ");
						String disciplinaMatriculada = sc.next();
						alunoConsultado.adicionarDisciplinaMatriculada(disciplinaMatriculada);
						break;
					case 3:
						System.out.print("Informe a disciplina que deseja mover: ");
						String disciplinaASerMovida = sc.next();
						alunoConsultado.moverDisciplinaDeMatriculadaParaAprovada(disciplinaASerMovida);
						break;
					case 4:
						System.out.println("-----------------------------------------------");
						alunoConsultado.exibeListaDeDisciplinasAprovadas();
						System.out.println();
						System.out.println("Pressione ENTER para continuar");
						System.in.read();
						break;
					case 5:
						System.out.println("-----------------------------------------------");
						alunoConsultado.exibeListaDeDisciplinasMatriculadas();
						System.out.println();
						System.out.println("Pressione ENTER para continuar");
						System.in.read();
						break;
					default:
						System.out.println("Opcao incorreta, tente novamente.");
						System.out.println();
						break;
					}
				}
			}catch(InputMismatchException e) {
				System.out.println();
				System.out.println("Informe um dado válido!");
				System.out.println("Pressione ENTER para continuar");
				System.in.read();
				menuPrincipalDisciplinas(alunos, new Scanner(System.in));
			}finally {
				sc.close();
			}
		}else {
			System.out.println("Matricula não encontrada!");
		}
	}
	
}	
