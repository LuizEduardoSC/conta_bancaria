package conta_bancaria.model;

public class ContaCorrente extends Conta{ // Extends
	
	private float limite; //Atributo expecífico da classe ContaCorrente

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo); // Superclasse Sempre parte do Abstrato
		this.limite = limite; // Expecífico da clasee ContaCorrente
	}

	// Método Get e Set
	public float getLimite() {
			
		// Atualiza o limite caso o saldo seja negativo
		if(this.getSaldo() < 0)
				return this.limite - Math.abs(this.getSaldo());
		
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	
	@Override
    public boolean sacar(float valor) {
		
		if(this.getSaldo() + this.getLimite() < valor) { // Regra para verificar se o saldo + o limite é suficiente
			System.out.println("\nSaldo Insuficiente");
			return false;
		}
		
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	
	@Override // Indica que este método foi sobrescrito a partir da classe que ele está herdando.
	public void visualizar() {
		super.visualizar(); //Mostra na tela todos os dados qu pertencem a classe Conta
		System.out.println("Limite da conta: " + this.getLimite()); // Chama o Método get
	}
}