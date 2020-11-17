package aula.threads;

import javax.swing.JOptionPane;

public class Aula001CriacaoThread {

	public static void main(String[] args) {
		
		/*Thread de envio de e-mail*/
		new Thread() {

			public void run() { /* Executa o que queremos */
				/*Código da rotina*/
				for (int pos = 0; pos < 10; pos++) {
					
					try {
						/*Executando envio com um tempo de parada ou tempo determinado*/
						System.out.println("Executando alguma rotina, envio de E-MAIL por exemplo");
						Thread.sleep(1000);/*Dá um tempo*/
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				} /*Fim do código em paralelo*/
			};

		}.start(); /* Start liga a Thread que fica processando paralelamente por trás */
		
		/*Thread de envio de NFC-e*/
		new Thread() {

			public void run() { /* Executa o que queremos */
				/*Código da rotina*/
				for (int pos = 0; pos < 10; pos++) {
					
					try {
						/*Executando envio com um tempo de parada ou tempo determinado*/
						System.out.println("Executando alguma rotina, envio de NOTA FISCAL por exemplo");
						Thread.sleep(2000);/*Dá um tempo*/
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				} /*Fim do código em paralelo*/
			};

		}.start(); /* Start liga a Thread que fica processando paralelamente por trás */
		
		/*Código do sistema do usuário continua o fluxo de trabalho*/
		System.out.println("CHEGOU AO FIM DO CÓDIGO DE TESTE DE THREAD");
		/*Fluxo do sistema, cadastro de venda, emissão de nota fiscal, algo do tipo*/
		JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuário");
	}
}
