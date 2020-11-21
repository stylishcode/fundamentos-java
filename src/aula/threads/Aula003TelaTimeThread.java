package aula.threads;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeoutException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Aula003TelaTimeThread extends JDialog {

	private JPanel jPanel = new JPanel(
			new GridBagLayout()); /*
									 * Jpanel é o Painel de componenentes. GridBagLayout é o gerenciador de Layout
									 */

	private JLabel descricaoHora1 = new JLabel("Time da Thread 1");
	private JLabel descricaoHora2 = new JLabel("Time da Thread 2");

	private JTextField mostraHora1 = new JTextField();
	private JTextField mostraHora2 = new JTextField();

	private JButton botaoStart = new JButton("Start");
	private JButton botaoStop = new JButton("Stop");
	
	/*Ao iniciar a tela o botão stop estará parado*/

	private Runnable thread1 = new Runnable() {

		@Override
		public void run() {

			while (true) {
				mostraHora1
						.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm.ss").format(Calendar.getInstance().getTime()));
				try {					
					Thread.sleep(1000);
					
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	};

	private Runnable thread2 = new Runnable() {

		@Override
		public void run() {

			while (true) {
				mostraHora2
						.setText(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
				try {					
					Thread.sleep(1000);
					
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			

		}
	};
	
	private Thread thread1Time;
	private Thread thread2Time;

	public Aula003TelaTimeThread() { /* Executa o que tiver dentro no momento da abertura da tela */
		botaoStop.setEnabled(false);
		setTitle("Minha tela de time com Thread");
		setSize(new Dimension(240, 240)); /* tamanho em pixels */
		setLocationRelativeTo(null); /*
										 * Posição da tela em relação a algum componente, null centraliza, já que não
										 * tem posição relativa a nenhum componente
										 */
		setResizable(false); /* Impede de redimensionar */
		/* Parte de configurações iniciais da tela */

		/* Código dos componentes da tela */
		GridBagConstraints gridBagConstraints = new GridBagConstraints(); /*
																			 * Controlador de posicionamento de
																			 * componentes
																			 */
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2; /*
											 * Os componentes ocupam o espaço de dois, isso é importante entender,
											 * porque para alinhar elementos, um do lado do outro, é necessário saber
											 * que eles obedecem a quantidade ocupada dos componentes de cima, mesmo que
											 * ocupem 1, senão não é possível alinhar elementos
											 */

		gridBagConstraints.insets = new Insets(5, 17, 5, 5); /* Espaçamento top, left, bottom, right */
		gridBagConstraints.anchor = gridBagConstraints.WEST; /* Âncoragem (alinhamento) dos elementos pra esquerda */

		descricaoHora1.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoHora1, gridBagConstraints);

		mostraHora1.setPreferredSize(new Dimension(200, 25));
		mostraHora1.setEditable(false);
		gridBagConstraints.gridy++; /* Move para a proxima posição y do gridBagConstraints */
		jPanel.add(mostraHora1, gridBagConstraints);

		descricaoHora2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(descricaoHora2, gridBagConstraints);

		mostraHora2.setPreferredSize(new Dimension(200, 25));
		mostraHora2.setEditable(false);
		gridBagConstraints.gridy++;
		jPanel.add(mostraHora2, gridBagConstraints);

		gridBagConstraints.gridwidth = 1; /*
											 * Os componentes voltam a ocupar o espaço de 1 componentes, mas graças ao
											 * ocupamento de 2 espaços dos componentes de cima, será possível alinhar os
											 * elementos que ocupam 1 espaço, lado a lado e não um embaixo do outro
											 */

		botaoStart.setPreferredSize(new Dimension(89, 25));
		gridBagConstraints.gridy++;
		jPanel.add(botaoStart, gridBagConstraints);

		botaoStop.setPreferredSize(new Dimension(89, 25));
		gridBagConstraints.gridx++;
		jPanel.add(botaoStop, gridBagConstraints);
		
		
		botaoStart.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				thread1Time = new Thread(thread1);
				thread1Time.start();
				
				thread2Time = new Thread(thread2);
				thread2Time.start();
				
				botaoStart.setEnabled(false);
				botaoStop.setEnabled(true);
			}
			
		});
		
		botaoStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				thread1Time.stop();
				thread2Time.stop();
				
				botaoStart.setEnabled(true);
				botaoStop.setEnabled(false);
			}
			
		});
		
		
		/*
		 * Adiciona o painel no Dialog, usa a constante border layout para o painel se
		 * posionar a esquerda do Dialog
		 */
		add(jPanel, BorderLayout.WEST);
		setVisible(true); /* Torna a janela visível (Sempre tem que ser o último a ser executado) */
	}
}
