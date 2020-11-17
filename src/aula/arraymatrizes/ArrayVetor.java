package aula.arraymatrizes;

import aula.introducaopoo.classes.Aluno;
import aula.introducaopoo.classes.Disciplina;

public class ArrayVetor {
	
	public static void main(String[] args) {
		
		/*Array ou vetor, pode ser de todos os tipos de dados e objetos também*/
		
		double[] notas = {8.8, 9.7, 7.6, 6.8};
		double[] notasLogica = {7.1, 5.7, 7.9, 7.8};
		
		/*Criação do aluno*/
		Aluno aluno = new Aluno();
		aluno.setNome("Matheus Enrique");
		aluno.setNomeEscola("Jdev treinamentos");
		
		/*Criação das disciplinas*/
		Disciplina disciplina = new Disciplina();
		disciplina.setDisciplina("Java");
		disciplina.setNotas(notas);
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDisciplina("Lógica de Programação");
		disciplina2.setNotas(notasLogica);
		
		aluno.getDisciplina().add(disciplina);
		aluno.getDisciplina().add(disciplina2);
		
		/*Array de alunos*/
		Aluno[] arrayAlunos = new Aluno[1];
		
		arrayAlunos[0] = aluno;
		
		for (int pos = 0; pos < arrayAlunos.length; pos++) {
			System.out.println("Nome: " + arrayAlunos[pos].getNome());
			
			for (Disciplina d : arrayAlunos[pos].getDisciplina()) {
				System.out.println("Nome da disciplina: " + d.getDisciplina());
				
				for (int posNota = 0; posNota < d.getNotas().length; posNota++) {
					System.out.println("Nota " + (posNota+1) + "= " + d.getNotas()[posNota]);
				}
			}
		}
		
		/*aqui*/
		
	}
}
