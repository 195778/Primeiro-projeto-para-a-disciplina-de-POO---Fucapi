package atividade09092022.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import atividade09092022.entities.Aluno;
import atividade09092022.menu.MenuInicio;

public class Program {
	
	
	public static void main(String[] args) throws IOException {
		MenuInicio menuInicio = new MenuInicio();
		
		List<Aluno> alunos = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		menuInicio.menuPrincipal(alunos, sc);
	}
	
}
