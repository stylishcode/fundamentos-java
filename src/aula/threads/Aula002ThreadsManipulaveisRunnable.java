package aula.threads;

public class Aula002ThreadsManipulaveisRunnable {

	public static void main(String[] args) {

		/*
		 * Não podemos fazer isso sem o Runnable: Thread algumaThread = new Thread()
		 * algumaThread.start();
		 */
		
		/*Passando um Runnable como parametro da Thread, ela se torna um objeto manipulavel*/
		Thread threadEmail = new Thread(thread1);
		threadEmail.start();
		
		Thread threadNFCE = new Thread(thread2);
		threadNFCE.start();
	}

	/*
	 * Interface Runnable permite que manipulemos Thread como objetos, diminui a
	 * poluição de instânciar diretamente as Threads e facilita a manipulação,
	 * manutenção.. etc
	 */
	private static Runnable thread1 = new Runnable() {
		
		/*Método run normalmente, como em uma instância direta da Thread*/
		@Override
		public void run() {
			/* Código da rotina */
			for (int pos = 0; pos < 10; pos++) {

				try {
					/* Executando envio com um tempo de parada ou tempo determinado */
					System.out.println("Executando alguma rotina, envio de E-MAIL por exemplo");
					Thread.sleep(1000);/* Dá um tempo */

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} /* Fim do código em paralelo */
		}

	}; /* Esse ponto e vírgula é necessário */

	/* Outra Thread com Runnable */
	private static Runnable thread2 = new Runnable() {
		
		/*Método run normalmente, como em uma instância direta da Thread*/
		@Override
		public void run() {
			/* Código da rotina */
			for (int pos = 0; pos < 10; pos++) {

				try {
					/* Executando envio com um tempo de parada ou tempo determinado */
					System.out.println("Executando alguma rotina, envio de NOTA FISCAL por exemplo");
					Thread.sleep(1000);/* Dá um tempo */

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} /* Fim do código em paralelo */
		}

	}; /* Esse ponto e vírgula é necessário */
}
