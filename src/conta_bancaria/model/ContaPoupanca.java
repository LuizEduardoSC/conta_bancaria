package conta_bancaria.model;

public class ContaPoupanca extends Conta {
	
	private int aniversario; //Atributo expecífico da classe ContaPoupanca
	
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversario = aniversario;
		
	}

	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	
	@Override
    public void visualizar() {
		super.visualizar();
		System.out.println("Aniversário da conta: " + this.aniversario);
		}
}
