package conta_bancaria.model;

public abstract class Conta {

	// Definir os Atributos da Classe (Quais caracteristicas temos que preencher
	// quando criarmos a conta)
	// Todo objeto que for criado na classe "Conta" vai obrgatoriamente ter =
	// numero, agencia, tipo, titular e saldo

	private int numero; // Atributo numero;
	private int agencia; // Atributo agencia;
	private int tipo; // Atributo tipo;
	private String titular; // Atributo titular;
	private float saldo; // Atributo saldo;

	// Criamos o método Construtor
	// Metodo Construtor = Serve para criar objetos no modelo de dados e vai ter o
	// mesmo nome da classe (sempre começa com Maiúsculo)
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero; // Parâmetro (this.numero =)
		this.agencia = agencia; // Parâmetro this.agencia)
		this.tipo = tipo; // Parâmetro this.tipo =)
		this.titular = titular; // Parâmetro this.titular =)
		this.saldo = saldo; // Parâmetro this.saldo =)
	}

	// Criamos os métodos get e set
	// Métodos de acesso e modificação (get e set)
	// Sempre vai ser tipado com o mesmo
	// Sempre vai ser void pois não vai retornar nada
	// get e set sempre vai ser minúsculo
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean sacar(float valor) {

		if (this.getSaldo() < valor) {
			System.out.println("\nSaldo Insuficiente");
			return false;
		}

		this.setSaldo(this.getSaldo() - valor);
		return true;
	}

	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
	}

	// Método auxiliar visualizar
	public void visualizar() {

		String tipo = "";

		switch (this.tipo) {
		case 1 -> tipo = "Conta Corrente";
		case 2 -> tipo = "Conta Poupança";
		}

		System.out.println("\n\n********************************************");
		System.out.println("Dados da Conta");
		System.out.println("********************************************");
		System.out.println("Número da Conta: " + this.numero);
		System.out.println("Agência: " + this.agencia);
		System.out.println("Tipo da Conta: " + tipo);
		System.out.println("Titular da Conta: " + this.titular);
		System.out.println("Saldo da Conta: " + this.saldo);
	}
}