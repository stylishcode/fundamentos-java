package aula.introducaopoo.executavel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import aula.herancapolimorfinterfaces.auxiliares.FuncaoAutenticacao;
import aula.introducaopoo.classes.Aluno;
import aula.introducaopoo.classes.Disciplina;
import aula.introducaopoo.classes.Secretario;
import aula.introducaopoo.constantes.StatusAluno;

public class Execucao {

	public static void main(String[] args) {

		try {

//			lerArquivo();

			String login = JOptionPane.showInputDialog("Informe o login");
			String senha = JOptionPane.showInputDialog("Informe a senha");

			/*
			 * Vou travar o contrato para autorizar somente quem realmente tem o contrato
			 * 100%* legítimo com PermitirAcesso
			 */
			if (new FuncaoAutenticacao(new Secretario(login, senha)).autenticar()) {

				/* Lista de alunos */
				List<Aluno> alunos = new ArrayList<Aluno>();

				/* Lista de alunos colocados por situação */
				HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

				/* Quantidade de alunos a serem inseridos */
				for (int qtd = 0; qtd < 1; qtd++) {
					/* Inserção de dados */
					String nome = JOptionPane.showInputDialog("Nome do aluno " + (qtd + 1));
					String idade = JOptionPane.showInputDialog("Idade");
					// String dataNascimento = JOptionPane.showInputDialog("Data de nascimento");
					// String rg = JOptionPane.showInputDialog("RG");
					// String cpf = JOptionPane.showInputDialog("CPF");
					// String nomeMae = JOptionPane.showInputDialog("Nome da mãe");
					// String nomePai = JOptionPane.showInputDialog("Nome do pai");
					// String dataMatricula = JOptionPane.showInputDialog("Data da matrícula");
					// String serie = JOptionPane.showInputDialog("Série");
					// String nomeEscola = JOptionPane.showInputDialog("Nome da escola");

					/* Aluno aluno -> var de referência */
					/* new Aluno() -> Instância (criação) do objeto */
					Aluno aluno = new Aluno();

					aluno.setNome(nome);
					aluno.setIdade(idade);
					// aluno.setDataNascimento(dataNascimento);
					// aluno.setRg(rg);
					// aluno.setCpf(cpf);
					// aluno.setNomeMae(nomeMae);
					// aluno.setNomePai(nomePai);
					// aluno.setDataMatricula(dataMatricula);
					// aluno.setSerieMatriculado(serie);
					// aluno.setNomeEscola(nomeEscola);

					/* Adiciona disciplinas dinamicamente */
					for (int pos = 0; pos < 1; pos++) {
						String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + (pos + 1));

						/* Adiciona 4 notas em cada disciplina */
						double[] notas = new double[4];
						for (int nota = 0; nota < notas.length; nota++) {
							double valorNota = Double
									.valueOf(JOptionPane.showInputDialog("Informe a " + (nota + 1) + "ª nota"));
							notas[nota] = valorNota;
						}

						Disciplina disciplina = new Disciplina();

						disciplina.setDisciplina(nomeDisciplina);
						disciplina.setNotas(notas);

						aluno.getDisciplina().add(disciplina);
					}

					/* Opção para remover disciplinas dinamicamente */
					int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");

					if (escolha == 0) { /* 0 é SIM */
						int continuarRemover = 0;

						int posicao = 1; /*
											 * Ajuda a não dar erro de estouro de lista devido a reorganização de
											 * índices após exclusão
											 */

						while (continuarRemover == 0) {
							String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina? 1, 2, 3 ou 4?");
							aluno.getDisciplina().remove(Integer.valueOf(disciplinaRemover) - posicao);
							posicao++; /* Incrementa para ser feito o calculo indice - posição */
							continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover?");
						}
					}

					alunos.add(aluno);
				}

				/* Criando as listas baseadas pelas chaves */
				maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
				maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
				maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

				/* Filtrando alunos pela situação e adicionando no hashmap */
				for (Aluno aluno : alunos) {
					if (aluno.getAlunoAprovadoString().equalsIgnoreCase(StatusAluno.APROVADO)) {
						maps.get(StatusAluno.APROVADO).add(aluno);
					}

					if (aluno.getAlunoAprovadoString().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
						maps.get(StatusAluno.RECUPERACAO).add(aluno);
					}

					if (aluno.getAlunoAprovadoString().equalsIgnoreCase(StatusAluno.REPROVADO)) {
						maps.get(StatusAluno.REPROVADO).add(aluno);
					}
				}

				/* Opção para remover algum aluno da lista (por posição) */
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja listar e remover algum aluno?");

				if (opcao == 0) {/* 0 é SIM */
					int continuarEncontrar = 0;

					while (continuarEncontrar == 0) {
						String alunosEncontrados = "";

						/* for pela posição */
						for (int pos = 0; pos < alunos.size(); pos++) {
							Aluno aln = alunos.get(pos);
							alunosEncontrados += pos + " : " + aln.getNome() + "\n";

						}

						int escolhido = Integer.valueOf(JOptionPane.showInputDialog(
								"Lista de Alunos (Escolha o índice para remover o aluno)\n" + alunosEncontrados));

						alunos.remove(escolhido);

						JOptionPane.showMessageDialog(null, "Aluno removido com sucesso");
						continuarEncontrar = JOptionPane.showConfirmDialog(null,
								"Desejar listar e remover outro aluno?");
					}
				}

				/* Opção para obter informações de alunos da lista (for each) */
				opcao = JOptionPane.showConfirmDialog(null, "Deseja obter informações de algum aluno da lista?");

				if (opcao == 0) {/* 0 é SIM */
					int continuarEncontrar = 0;

					while (continuarEncontrar == 0) {
						String alunosEncontrados = "";

						for (Aluno aluno : alunos) {
							alunosEncontrados += " - " + aluno.getNome() + "\n";
						}

						String escolhido = JOptionPane
								.showInputDialog("Lista de Alunos (Digite o nome)\n" + alunosEncontrados);

						for (Aluno aluno : alunos) {
							if (aluno.getNome().equalsIgnoreCase(escolhido)) {
								System.out.println("Nome do aluno = " + aluno.getNome());
								System.out.println("Disciplinas = " + aluno.getDisciplina());
								System.out.println("Média = " + aluno.getMediaNota());
								System.out.println("--------------------------------------------------------------");
								break;
							}
						}

						continuarEncontrar = JOptionPane.showConfirmDialog(null,
								"Deseja obter informações de outro aluno?");
					}

				}

				/* Opção para substituir alunos da lista */
				opcao = JOptionPane.showConfirmDialog(null, "Deseja listar e substituir algum aluno?");

				if (opcao == 0) {/* 0 é SIM */
					int continuarSubstituir = 0;

					while (continuarSubstituir == 0) {
						String alunosEncontrados = "";

						for (Aluno aluno : alunos) {
							alunosEncontrados += " - " + aluno.getNome() + "\n";
						}

						String alunoTrocar = JOptionPane.showInputDialog(
								"Lista de Alunos (Digite o nome do aluno que deseja trocar)\n" + alunosEncontrados);

						/* Código de substituição do aluno */
						for (int pos = 0; pos < alunos.size(); pos++) {
							Aluno aluno = alunos.get(pos);

							if (aluno.getNome().equalsIgnoreCase(alunoTrocar)) {
								Aluno novoAluno = new Aluno();
								String nome = JOptionPane.showInputDialog("Nome do aluno");
								novoAluno.setNome(nome);

								Disciplina disciplinaTrocar = new Disciplina();
								String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina");

								/* Adiciona 4 notas em cada disciplina */
								double[] notas = new double[4];
								for (int nota = 0; nota < notas.length; nota++) {
									double valorNota = Double
											.valueOf(JOptionPane.showInputDialog("Informe a " + (nota + 1) + "ª nota"));
									notas[nota] = valorNota;
								}

								disciplinaTrocar.setDisciplina(nomeDisciplina);
								disciplinaTrocar.setNotas(notas);

								novoAluno.getDisciplina().add(disciplinaTrocar);

								/* Coloca o novo aluno na posição do antigo */
								alunos.set(pos, novoAluno);
								/* Atualizando a lista */
								aluno = alunos.get(pos);
								/* Mostra o aluno trocado */
								System.out.println("Nome = " + alunos.get(pos).getNome());
								System.out.println("Disciplina = " + alunos.get(pos).getDisciplina());
							}

						}

						continuarSubstituir = JOptionPane.showConfirmDialog(null, "Deseja substituir outro aluno?");
					}
				}

				/* Opção para ver a maior e menor nota dos alunos da lista */
				opcao = JOptionPane.showConfirmDialog(null, "Deseja ver a maior e menor nota de algum aluno?");

				if (opcao == 0) {/* 0 é SIM */
					int continuarVerNota = 0;

					while (continuarVerNota == 0) {
						String alunosEncontrados = "";

						int posicaoAluno = -1; /*
												 * Só uma variavel auxiliar pra guardar posição para calculo de maior e
												 * menor nota
												 */

						for (Aluno aluno : alunos) {
							alunosEncontrados += " - " + aluno.getNome() + "\n";
							posicaoAluno++;
						}

						String alunoVerNota = JOptionPane.showInputDialog(
								"Lista de Alunos (Digite o nome do aluno que deseja ver a nota)\n" + alunosEncontrados);

						/* Código de maior e menor nota */
						double maiorNota = 0.0;
						double menorNota = 0.0;

						for (Aluno aluno : alunos) {
							if (aluno.getNome().equalsIgnoreCase(alunoVerNota)) {
								for (int pos = 0; pos < aluno.getDisciplina().get(posicaoAluno)
										.getNotas().length; pos++) {

									if (pos == 0) {
										maiorNota = aluno.getDisciplina().get(posicaoAluno).getNotas()[pos];
										menorNota = aluno.getDisciplina().get(posicaoAluno).getNotas()[pos];
										
									} else {
										if (aluno.getDisciplina().get(posicaoAluno).getNotas()[pos] > maiorNota) {
											maiorNota = aluno.getDisciplina().get(posicaoAluno).getNotas()[pos];
										}
										
										if (aluno.getDisciplina().get(posicaoAluno).getNotas()[pos] < menorNota) {
											menorNota = aluno.getDisciplina().get(posicaoAluno).getNotas()[pos];
										}
									}

								}
							}
						} /*Fim maior e menor nota*/

						JOptionPane.showMessageDialog(null, "Maior nota: " + maiorNota + "\nMenor nota: " + menorNota);

						continuarVerNota = JOptionPane.showConfirmDialog(null,
								"Deseja ver a maior e menor nota de  outro aluno?");
					}
				}

				/* Lista de alunos APROVADOS, RECUPERAÇÃO E REPROVADOS */
				/* APROVADOS */
				System.out.println("---------------------------- LISTA DOS APROVADOS ---------------------------");
				for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
					System.out.println("Aluno = " + aluno.getNome() + ", Situacao = " + aluno.getAlunoAprovadoString()
							+ " com média = " + aluno.getMediaNota());
				}
				/* RECUPERAÇÃO */
				System.out.println("--------------------------- LISTA DE RECUPERAÇÃO ---------------------------");
				for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
					System.out.println("Aluno = " + aluno.getNome() + ", Situacao = " + aluno.getAlunoAprovadoString()
							+ " com média = " + aluno.getMediaNota());
				}
				/* REPROVADOS */
				System.out.println("--------------------------- LISTA DOS REPROVADOS ---------------------------");
				for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
					System.out.println("Aluno = " + aluno.getNome() + ", Situacao = " + aluno.getAlunoAprovadoString()
							+ " com média = " + aluno.getMediaNota());
				}

			} else {
				JOptionPane.showMessageDialog(null, "Acesso não permitido");
			} /* bracket validação de acesso */

		} catch (Exception e) { /* Captura todas as exceções que não prevemos (forma mais genérica) */
			StringBuilder saida = new StringBuilder();

			/* Imprime erro no console Java */
			e.printStackTrace();

			/* Mensagem de erro ou causa */
			System.out.println("Mensagem: " + e.getMessage());

			/* Percorre a pilha de exceção */
			for (int pos = 0; pos < e.getStackTrace().length; pos++) {
				saida.append("\nClasse de erro: " + e.getStackTrace()[pos].getClassName());
				saida.append("\nMétodo do erro: " + e.getStackTrace()[pos].getMethodName());
				saida.append("\nLinha do erro: " + e.getStackTrace()[pos].getLineNumber());
				saida.append("\nClasse: " + e.getStackTrace()[pos].getClass().getName());
			}

			JOptionPane.showMessageDialog(null, "Erro de conversão de número " + saida.toString());

		} finally { /* Sempre é executado, ocorrendo erros ou não */
			/*
			 * Por quê o uso do finally? -> finally sempre é executado quando se precisa
			 * executar um processo, ocorrendo erros ou não no sistema, por exemplo, o
			 * fechamento de uma sessão ou transação/operação (não é fechamento de conexão)
			 * com o banco de dados.
			 */
			JOptionPane.showMessageDialog(null, "Obrigado por aprender java comigo");

		} /* bracket try catch */

	} /* bracket main */

	public static void lerArquivo() throws FileNotFoundException { /* throws declara que esse método lança exceções */

		File file = new File("/home/matheus/lines.txt");
		Scanner scanner = new Scanner(file);
		/*
		 * Lança a exceção para cima para ser delegada a responsabilidade do tratamento
		 * ao método principal (método pai). Esse é mais padrão, lançar pra cima, do que
		 * colocar em try catch try catch geralmente fica no método principal
		 */
	}

} /* bracket classe */
