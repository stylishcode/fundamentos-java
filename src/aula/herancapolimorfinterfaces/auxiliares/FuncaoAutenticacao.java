package aula.herancapolimorfinterfaces.auxiliares;

import aula.herancapolimorfinterfaces.interfaces.PermitirAcesso;

/*Realmente e somente receber somente quem tem o contrato da interface de PermitirAcesso e chamar o autenticar*/
public class FuncaoAutenticacao {
	
	private PermitirAcesso permitirAcesso;
	
	/*Esse construtor GARANTE que o que pode ser passado SEJA uma classe que implementa a interface PermitirAcesso*/
	public FuncaoAutenticacao(PermitirAcesso acesso) {
		this.permitirAcesso = acesso;
	}
	
	/*Recebe e retorna o método de autenticação de qualquer classe que TIVER o contrato de PermitirAcesso*/
	public boolean autenticar() {
		/*Recebe a classe que implementa PermitirAcesso do construtor e chama o método autenticar*/
		return permitirAcesso.autenticar();
	}
	
}
