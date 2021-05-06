package Principal;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

import Modelagem.Carro;
import Modelagem.Marca;
import Modelagem.Modelo;

public class Principal {
	private static Carro[] vagas = new Carro[100];
	private static ArrayList<Marca> marcas = new ArrayList<Marca>();
	private static ArrayList<Carro> historico = new ArrayList<Carro>();
	private static ArrayList<Modelo> modelos = new ArrayList<Modelo>();

	public static void main(String[] args) {

		// DUMMIES
		// -> Marcas e Modelos
		final Marca m1 = new Marca("Fiat");
		final Marca m2 = new Marca("Renault");
		final Marca m3 = new Marca("Chevrolet");

		m1.addModeloNome("Uno");
		m1.addModeloNome("Argo");
		m2.addModeloNome("Kwid");
		m2.addModeloNome("Duster");
		m3.addModeloNome("Camaro");
		m3.addModeloNome("Cruze");

		marcas.add(m1);
		marcas.add(m2);
		marcas.add(m3);

		// -> Carros
		Carro c1 = new Carro(new Modelo("Argo"), "ARG-0001", LocalDateTime.of(2021, 5, 6, 9, 30));
		Carro c2 = new Carro(new Modelo("Argo"), "ARG-0002");
		Carro c3 = new Carro(new Modelo("Camaro"), "CAM-0001");

		vagas[0] = c1;
		vagas[1] = c2;
		vagas[2] = c3;

		historico.add(c1);
		historico.add(c2);
		historico.add(c3);

		// -> Criacao de variaveis
		boolean appOn = true;
		Scanner scanner = new Scanner(System.in);

		// -> Loop do menu
		while (appOn) {
			int escolha = menu();
			switch (escolha) {
				case 1:
					// -> Entrada do carro
					menuEntrada(vagas, historico);
					break;
				case 2:
					// -> Saida do carro
					menuSaida();
					break;
				case 3:
					// -> Todas as placas
					mostrarTodasPlacas(vagas);
					break;
				case 4:
					// -> Marcas e Modelos
					pesquisaPorMarca();
					break;
				case 5:
					// -> Historico
					verHistorico(historico);
					break;
				case 0:
					// ->Sair do menu
					appOn = false;
					break;
				default:
					System.out.println("Escolha inválida, tente novamente.");
					break;
			}
		}
		scanner.close();
	}

	public static int menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n--- Menu ---");
		System.out.println("<1> Registrar entrada de um carro");
		System.out.println("<2> Registrar saida de um carro");
		System.out.println("<3> Ver todos os carros");
		System.out.println("<4> Pesquisar por marca/modelo");
		System.out.println("<5> Ver historico de movimentacoes");
		System.out.println("<0> Sair do aplicativo");
		System.out.print(">> ");
		return scanner.nextInt();
	}

	public static void menuEntrada(Carro[] vagas, ArrayList<Carro> historico) {
		Scanner scanner = new Scanner(System.in);
		int emptyVagas = 100;
		int i = 0;
		System.out.println("\n--- Entrada ---");
		System.out.println("<1> Registrar entrada sem especificar horario");
		System.out.println("<2> Registrar entrada especificando horario");
		System.out.println("<0> Voltar ao menu");
		System.out.print(">> ");
		int opcao = scanner.nextInt();
		if (opcao != 0) {
			for (Carro carro : vagas) {
				if (carro != null) {
					emptyVagas -= 1;
					i += 1;
				}
			}
			System.out.println("\nTotal de vagas vazias: " + emptyVagas);
			scanner.nextLine();
			switch (opcao) {
				case 1:
					System.out.print("Placa do carro: ");
					String placa = scanner.nextLine();
					vagas[i] = new Carro(placa);
					System.out.println("\nEntrada registrada!");
					System.out.println("Placa do Carro: " + vagas[i].getPlaca());
					System.out.println("Hora de entrada: " + vagas[i].getHoraEntrada());
					// TODO -> Pedir para criar modelo
					historico.add(vagas[i]);
					break;
				case 2:

					break;
				default:
					System.out.println("Escolha invalida!");
					break;
			}
		} else {
			return;
		}
	}

	public static void menuSaida() {
		Carro carro = new Carro("ABC-1234");
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n--- Saida ---");
		System.out.println("<1> Registrar saida sem especificar horario");
		System.out.println("<2> Registrar saida especificando horario");
		System.out.println("<0> Voltar ao menu");
		System.out.print(">> ");
		// Saída testada, mudei a comparação de horas para a comparação de minutos e deu
		// certo, agora fazer o menu
		int opcao = scanner.nextInt();
		if (opcao != 0) {
			switch (opcao) {
				case 1:
					System.out.println("Valor total: RS" + carro.saidaCarro());
					break;
				case 2:
					System.out.println("Valor total: RS" + carro.saidaCarroHorario(0, 33, 10, 06, 05, 2021));
					break;
				default:
					System.out.println("Escolha invalida!");
					break;
			}
		} else {
			return;
		}
	}

	public static void mostrarTodasPlacas(Carro[] vagas) {
		System.out.println("\n--- Placas ---");
		for (Carro carro : vagas) {
			if (carro != null) {
				System.out.println(carro.getPlaca() + " -- " + carro.getModelo());
			}
		}
	}

	public static void pesquisaPorMarca() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n--- Marca ---");
		System.out.println("As marcas disponiveis no sistema sao:\n");
		for (Marca marca : marcas) {
			System.out.println("<" + marcas.indexOf(marca) + "> " + marca.getMarca());
		}
		System.out.println("<" + marcas.size() + "> Adicionar nova marca");
		System.out.println("\nEscolha uma opcao de marca:");
		System.out.print(">> ");
		int opcao = scanner.nextInt();

		scanner.nextLine(); // Para evitar que o nextLine abaixo seja ignorado

		if (opcao == marcas.size()) {
			System.out.println("\nNome da marca a ser adicionada:");
			System.out.print(">> ");
			String nomeMar = scanner.nextLine();
			marcas.add(new Marca(nomeMar));
			System.out.println("\nMarca adicionada: " + nomeMar);
		} else {

			Marca marcaEsc = marcas.get(opcao);
			modelos = marcas.get(opcao).getALModelo();

			System.out.println("\nA marca selecionada foi: " + marcaEsc.getMarca());
			System.out.println("Os modelos disponiveis no sistema sao:\n");
			for (Modelo modelo : modelos) {
				System.out.println("<" + modelos.indexOf(modelo) + "> " + modelo.getModelo());
			}
			System.out.println("<" + modelos.size() + "> Adicionar novo modelo");
			System.out.println("\nEscolha uma opcao de modelo:\n");
			System.out.print(">> ");
			opcao = scanner.nextInt();

			scanner.nextLine(); // Para evitar que o nextLine abaixo seja ignorado

			if (opcao != modelos.size()) {
				System.out.println("\nAs placas deste modelo sao:\n");
				Modelo modeloEsc = modelos.get(opcao);
				for (Carro carro : vagas) {
					if (carro != null) {
						if (modeloEsc.getModelo().equals(carro.getModelo())) {
							System.out.println(carro.getPlaca());
						}
					}
				}
			} else {
				System.out.println("\nMarca: " + marcaEsc.getMarca());
				System.out.println("Nome do modelo a ser adicionado:");
				System.out.print(">> ");
				String nomeMod = scanner.nextLine();
				marcaEsc.addModeloNome(nomeMod);
				System.out.println("\nModelo adicionado: " + nomeMod);
			}
		}
	}

	public static void verHistorico(ArrayList<Carro> historico) {
		System.out.println("\n--- Historico ---");
		for (Carro carro : historico) {
			System.out.println("Modelo: " + carro.getModelo());
			System.out.println("Placa: " + carro.getPlaca());
			System.out.println("Hora de entrada: " + carro.getHoraEntrada() + "\n");
		}
	}

}
