package aula.threads;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaFilaThread extends JDialog {
	
	private JPanel jPanel = new JPanel(new GridBagLayout());
	
	private JLabel descricaoNome = new JLabel("Nome");
	private JLabel descricaoEmail = new JLabel("E-mail");
	
	private JTextField campoNome = new JTextField();
	private JTextField campoEmail = new JTextField();
	
	private JButton botaoAddLista = new JButton("Gerar Lote");
	private JButton botaoStopFila = new JButton("Stop");
	
	private Aula004ImplementacaoFilaThread fila = new Aula004ImplementacaoFilaThread();
	
	public TelaFilaThread() {
		/*Configuração de tela*/
		setTitle("Tela do sistema");
		setSize(new Dimension(240, 240));
		setLocationRelativeTo(null);
		setResizable(false);
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(5, 17, 5, 5);
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		
		descricaoNome.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoNome, gridBagConstraints);
		
		campoNome.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(campoNome, gridBagConstraints);
		
		descricaoEmail.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(descricaoEmail, gridBagConstraints);
		
		campoEmail.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(campoEmail, gridBagConstraints);
		
		gridBagConstraints.gridwidth = 1;
		
		botaoAddLista.setPreferredSize(new Dimension(89, 25));
		gridBagConstraints.gridy++;
		jPanel.add(botaoAddLista, gridBagConstraints);
		
		botaoStopFila.setPreferredSize(new Dimension(89, 25));
		gridBagConstraints.gridx++;
		jPanel.add(botaoStopFila, gridBagConstraints);
		
		
		botaoAddLista.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (fila == null) {
					fila = new Aula004ImplementacaoFilaThread();
					fila.start();
					
				} 
				/*Esse bloco executará instântaneamente, o que ficara rodando em background é a exibição dos emails que está
				 * na fila*/
				for (int qtd = 0; qtd <= 100; qtd++) { /*Simulando 100 envios em massa de e-mail*/
					Aula004ObjetoFilaThread objetoFilaThread = new Aula004ObjetoFilaThread();
					objetoFilaThread.setNome(campoNome.getText());
					objetoFilaThread.setEmail(campoEmail.getText() + " - " + qtd);
					
					fila.add(objetoFilaThread);
				}
				
				campoNome.setText("");
				campoEmail.setText("");	
				
			}
			
		});
		
		botaoStopFila.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fila.stop();
				fila = null;
			}
			
		});
		
		fila.start();
		
		add(jPanel, BorderLayout.WEST);
		setVisible(true);
	}

}
