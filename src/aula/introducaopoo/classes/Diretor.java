package aula.introducaopoo.classes;

import aula.herancapolimorfinterfaces.classesAbstratas.Pessoa;
import aula.herancapolimorfinterfaces.interfaces.PermitirAcesso;

public class Diretor extends Pessoa implements PermitirAcesso {

	private String registroEducacao;
	private String tempoDirecao;
	private String titulacao;
	
	private String login;
	private String senha;
	
	public Diretor(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public Diretor() {
	}

	public String getRegistroEducacao() {
		return registroEducacao;
	}

	public void setRegistroEducacao(String registroEducacao) {
		this.registroEducacao = registroEducacao;
	}

	public String getTempoDirecao() {
		return tempoDirecao;
	}

	public void setTempoDirecao(String tempoDirecao) {
		this.tempoDirecao = tempoDirecao;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}
	
	@Override
	public boolean autenticar() {
		return login.equalsIgnoreCase("admin") && senha.equals("fallen");
	}
	
	/*Método abstrato de Pessoa*/
	@Override
	public double salario() {
		return 3900.78;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((registroEducacao == null) ? 0 : registroEducacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diretor other = (Diretor) obj;
		if (registroEducacao == null) {
			if (other.registroEducacao != null)
				return false;
		} else if (!registroEducacao.equals(other.registroEducacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Diretor [nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", rg=" + rg
				+ ", cpf=" + cpf + ", nomeMae=" + nomeMae + ", nomePai=" + nomePai + ", registroEducacao="
				+ registroEducacao + ", tempoDirecao=" + tempoDirecao + ", titulacao=" + titulacao + "]";
	}

}
