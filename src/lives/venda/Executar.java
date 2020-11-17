package lives.venda;

import java.math.BigDecimal;

public class Executar {
	
	public static void main(String[] args) {
		/*Criando um produto*/
		Produto produto1 = new Produto();
		produto1.setId(1L);
		produto1.setNome("Módulo de Orientação a Objetos");
		produto1.setValor(BigDecimal.valueOf(100));
		
		Produto produto2 = new Produto();
		produto2.setId(2L);
		produto2.setNome("Módulo de Spring Boot");
		produto2.setValor(BigDecimal.valueOf(300));
		
		/*Criando uma venda*/
		Venda venda = new Venda();
		venda.setDescricaoVenda("Venda Curso Formação Java");
		venda.setEnderecoEntrega("Entrega pelo e-mail");
		venda.setId(10L);
		venda.setNomeCliente("Matheus Enrique");
		
		/*Adicionando produtos na lista de produtos da venda*/
		venda.getListaProdutos().add(produto1); /*Adicione dessa forma se não precisar fazer validações*/
		venda.addProduto(produto2); /*Adicione com um método customizado caso precise validar antes de inserir*/
		
		for (Produto produto : venda.getListaProdutos()) {
			System.out.println("Descrição produto: " + produto);
		}
		
		System.out.println("Descricão Venda: " + venda);
		
	}
}
