package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.Optional;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	// Criar a Collection
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();

	// Variável para receber o número da Conta
	int numero = 0;
	
	

	@Override
	public void procurarPorNumero(int numero) {

		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) { /* Verifica se a conta foi encontrada (se for encontrada ele exibe)*/
			conta.get().visualizar(); /*Serve para abrir a caixa e mostrar o elemento*/
		}else
			System.out.println("A Conta número: " + numero + "não foi encontrada!");

	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar(); // Visualizar os dados de cada conta que eu tiver dentro da minha coleção
		}

	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A conta número: " + conta.getNumero() + " foi criado com Sucesso!");

	}

	@Override
	public void atualizar(Conta conta) {
		
		Optional<Conta> buscCconta = buscarNaCollection(conta.getNumero());

		if (buscCconta.isPresent()) { /* Verifica se a conta foi encontrada (se for encontrada ele exibe)*/
			listaContas.set(listaContas.indexOf(buscCconta.get()), conta);
		    System.out.println("A conta número: " + conta.getNumero() + " foi atualizada com Sucesso!");
		}else
			System.out.println("A Conta número: " + conta.getNumero() + "não foi encontrada!");


	}

	@Override
	public void deletar(int numero) {

		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			if (listaContas.remove(conta.get()) == true)
				System.out.println("A Conta número: " + numero + "foi excluída com sucesso!");
		} else
			System.out.println("A Conta número: " + numero + "não foi encontrada!");

	}

	@Override
	public void sacar(int numero, float valor) {
		
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			if (conta.get().sacar(valor) == true)
				System.out.println("A Conta número: " + numero + "foi excluída com sucesso!");
		} else
			System.out.println("A Conta número: " + numero + "não foi encontrada!");
	}

	@Override
	public void depositar(int numero, float valor) {
		
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			    conta.get().depositar (valor);
				System.out.println("O Depósito na Conta número: " + numero + "foi excluída com sucesso!");
		} else
			System.out.println("A Conta número: " + numero + "foi efetuado com sucesso!");
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		
		Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);

		if (contaOrigem.isPresent() && contaOrigem.isPresent()) {
			if (contaOrigem.get().sacar(valor) == true)
				contaDestino.get().depositar(valor);			
			    System.out.println("A Tranferência da Conta número: "+ numeroOrigem + " para a Conta número: " + numeroDestino + " foi efetuada com sucesso!");
		} else
			System.out.println("A Conta de Origem e/ou Destino não foram encontradas!");
	}

	
	
	/* Métodos Auxiliares */

	public int gerarNumero() {
		return ++numero;
	}

	public Optional<Conta> buscarNaCollection(int numero) {
		
		for (var conta : listaContas) {
			if (conta.getNumero() == numero)
				return Optional.of(conta); /*Retorna um Optional com o objeto conta baseado no número que foi mandado*/
		}
		return Optional.empty(); /*Retornar vazio*/
	}
}