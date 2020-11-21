package aula.threads;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Aula004ImplementacaoFilaThread extends Thread {

	private static ConcurrentLinkedQueue<Aula004ObjetoFilaThread> pilhaFila = 
			new ConcurrentLinkedQueue<Aula004ObjetoFilaThread>();
	
	public static void add(Aula004ObjetoFilaThread objetoFilaThread) {
		pilhaFila.add(objetoFilaThread);
	}
	
	@Override
	public void run() {
		Iterator iteracao = pilhaFila.iterator();
		
		synchronized (iteracao) { /*Bloqueia o acesso a essa lista por outros processos*/
			
			while(iteracao.hasNext()) { /*Enquanto conter dados na lista, irá processar*/
				/*Pega os elementos do tipo ObjetoFilaThread de dentro do iterator da pilhaFila*/
				Aula004ObjetoFilaThread processar = (Aula004ObjetoFilaThread) iteracao.next();
				
				/*Coisas que poderiam ser feitas:
				 * Processar 10 mil notas fiscais
				 * Gerar uma lista enorme de PDF's
				 * Gerar um envio em massa de email*/
				System.out.println("--------------------------------------------");
				
				System.out.println(processar.getEmail());
				System.out.println(processar.getNome());
				
				iteracao.remove(); /*Remove depois de processar*/
				
				try {
					Thread.sleep(100); /*Dar um tempo para descarga de memória*/
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		try {
			Thread.sleep(1000); /*Dar um tempo após o processamento da uma lista*/
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
