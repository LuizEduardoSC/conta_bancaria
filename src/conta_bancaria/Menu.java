package conta_bancaria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
		contas.cadastrar(cp1);

		while (true) {

			System.out.println(Cores.TEXT_BLUE + Cores.ANSI_WHITE_BACKGROUND);

			System.out.println("*************************************************");
			System.out.println("                                                 ");
			System.out.println("              BANCO DO BRAZIL COM Z              ");
			System.out.println("                                                 ");
			System.out.println("*************************************************");
			System.out.println("                                                 ");
			System.out.println("          1 - Criar Conta                        ");
			System.out.println("          2 - Listar todas as Contas             ");
			System.out.println("          3 - Buscar conta por Número            ");
			System.out.println("          4 - Atualizar Dados da Conta           ");
			System.out.println("          5 - Apagar Conta                       ");
			System.out.println("          6 - Sacar                              ");
			System.out.println("          7 - Depositar                          ");
			System.out.println("          8 - Transferir Valores entre Contas    ");
			System.out.println("          9 - Sair                               ");
			System.out.println("                                                 ");
			System.out.println("*************************************************");
			System.out.println("Entre com a opção desejada                       ");
			System.out.println("                                                 " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_RESET + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta\n\n");

				System.out.println("Digite o número da Agência: ");
				agencia = leia.nextInt();

				System.out.println("Digite o nome do Titular: ");
				leia.skip("\\R");
				titular = leia.nextLine();

				System.out.println("Digite o tipo da Conta (1 - CC ou 2 - CP): ");
				tipo = leia.nextInt();

				while (tipo < 1 || tipo > 2) {
					System.out.println("Escolha entre a opção 1 - CC ou 2 - CP)");
					tipo = leia.nextInt();
				}

				System.out.println("Digite o Saldo da Conta: ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o limite da conta: ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				
				case 2 -> {
					System.out.println("Digite o dia do aniversário da conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}

				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\\n\\n");
				contas.listarTodas();

				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\\n\\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				contas.procurarPorNumero(numero);

				keyPress();
				break;

			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\\n\\n");

				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\\n\\n");

				System.out.println(Cores.TEXT_RESET + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				numero = leia.nextInt();

				contas.deletar(numero);

				keyPress();
				break;

			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\\n\\n");

				keyPress();
				break;

			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\\n\\n");

				keyPress();
				break;

			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\\n\\n");

				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_BLUE + "\nOpção Inválida! \n" + Cores.ANSI_WHITE_BACKGROUND);
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*************************************************");
		System.out.println("Projeto Desenvolvido por: Luiz Eduardo!");
		System.out.println("Luiz Eduardo - luizeduardoedd1@gmail.com");
		System.out.println("github.com/LuizEduardoSC");
		System.out.println("***************************************************");
	}

	public static void keyPress() {
		try {

			System.out.println("\n\nPressione a tecla Enter para continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla inválida!");
		}
	}
}