package lives.venda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Venda {

	private Long id;
	private String descricaoVenda;
	private String nomeCliente;
	private String enderecoEntrega;
	private BigDecimal valorTotal;
	private List<Produto> listaProdutos = new ArrayList<Produto>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoVenda() {
		return descricaoVenda;
	}

	public void setDescricaoVenda(String descricaoVenda) {
		this.descricaoVenda = descricaoVenda;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public BigDecimal getValorTotal() {
		valorTotal = BigDecimal.valueOf(totalVenda());
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	/* Método para adicionar na lista mas fazer validações antes */
	public void addProduto(Produto produto) {
		/* Aqui iria as validações antes de adicionar na lista */
		this.listaProdutos.add(produto);
	}
	
	/*Somente calcula o total da venda e passa para o getValorTotal*/
	private double totalVenda() {
		double total = 0.0;
		for (Produto produto : listaProdutos) {
			total += produto.getValor().doubleValue();
		}
		return total;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", descricaoVenda=" + descricaoVenda + ", nomeCliente=" + nomeCliente
				+ ", enderecoEntrega=" + enderecoEntrega + ", valorTotal=" + getValorTotal() + ", listaProdutos="
				+ listaProdutos + "]";
	}

}
