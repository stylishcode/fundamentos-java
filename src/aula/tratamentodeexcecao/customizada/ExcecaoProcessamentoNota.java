package aula.tratamentodeexcecao.customizada;

public class ExcecaoProcessamentoNota extends Exception {
	
	/*Construtor vai receber o erro e passar para o pai, que por sua vez vai lançar a exceção*/
	public ExcecaoProcessamentoNota(String erro) {
		super("vixxx, um erro no processamento do arquivo ao processar as notas do aluno " + erro);
	}
}
