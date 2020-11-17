package aula.arraymatrizes;

public class Matriz {

	public static void main(String[] args) {

		int notas[][] = new int[2][3];

		notas[0][0] = 80;
		notas[0][1] = 90;
		notas[0][2] = 70;

		notas[1][0] = 40;
		notas[1][1] = 60;
		notas[1][2] = 50;

		System.out.println(notas); /* Mostra o endereço somente */

		for (int linha = 0; linha < notas.length; linha++) {
			for (int coluna = 0; coluna < notas[linha].length; coluna++) {
				System.out.println(
						"Nota na linha " + (linha + 1) + " na coluna " + (coluna + 1) + " = " + notas[linha][coluna]);
			}
		}

	}
}
