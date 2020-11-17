package aula.arraymatrizes;

import java.util.Arrays;
import java.util.List;

public class SplitArray {
	
	public static void main(String[] args) {
		
		String texto = "Matheus, curso, java, 80, 70, 90, 89";
		
		/*Método muito útil para trabalhar com separação de informações especificas que vem em arrays*/
		String[] valoresSplitados = texto.split(",");
		
		for (int pos = 0; pos < valoresSplitados.length; pos++) {
			System.out.println(pos + ":" + valoresSplitados[pos]);
		}
		
		/*Convertendo arrays para listas*/
		List<String> arrayConvertido = Arrays.asList(valoresSplitados);
		int pos = 0;
		System.out.println("Array para lista");
		for (String elemento : arrayConvertido) {
			System.out.println(pos + ":" + elemento);
			pos++;
		}
		
		/*Convertendo listas para arrays*/
		String[] listaConvertida = arrayConvertido.toArray(new String[arrayConvertido.size()]);
		System.out.println("Lista para Array");
		for (int posicao = 0; posicao < listaConvertida.length; posicao++) {
			System.out.println(posicao + ":" + listaConvertida[posicao]);
		}
		
	}
}
