package principio.responsabilidadeunicasolid;

public class Execucao {
	
	public static void main(String[] args) {
		
		ContaBancaria conta = new ContaBancaria();
		conta.setDescricao("Conta bancária do Matheus");
		
		System.out.println(conta);
		
		conta.diminui100reais();
		conta.diminui100reais();
		
		System.out.println(conta);
		
		conta.sacarDinheiro(400);
		
		System.out.println(conta);
		
		conta.depositarDinheiro(1000);
		
		System.out.println(conta);
		
		conta.soma100reais();
		
		System.out.println(conta);
	}
}
