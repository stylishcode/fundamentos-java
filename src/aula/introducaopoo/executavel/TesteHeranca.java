package aula.introducaopoo.executavel;

import aula.introducaopoo.classes.Aluno;

public class TesteHeranca {
	
	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		aluno.setNome("Matheus");
		aluno.setIdade("22");
		aluno.setCpf("045.681.512-01");
		
		System.out.println(aluno);
	}
}
