package principio.responsabilidadeunicasolid;

public class ContaBancaria {

	/*
	 * O Principio da responsabilidade única (SOLID) fala que se eu tenho tudo o que
	 * preciso na classe, não preciso delegar responsabilidades a métodos externos
	 * desnecessários para complicar as coisas, trabalho apenas dentro da classe e
	 * que a classe tenha total responsabilidade, tarefas que são do próprio objeto,
	 * como os métodos da classe String por exemplo
	 */

	/*
	 * Nessa classe por exemplo, tem tudo o que é necessário para criar e trabalhar
	 * com estes métodos, não estou usando nada de métodos ou classes externas.
	 */

	private String descricao;
	private double saldo = 8000;

	public void soma100reais() {
		saldo += 100;
	}

	public void diminui100reais() {
		saldo -= 100;
	}

	public void sacarDinheiro(double saque) {
		saldo -= saque;
	}

	public void depositarDinheiro(double deposito) {
		saldo += deposito;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "ContaBancaria [descricao=" + descricao + ", saldo=" + saldo + "]";
	}

}
