package Principal;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
		final Marca m4 = new Marca("BMW");

		m1.addModeloNome("Uno");
		m1.addModeloNome("Argo");
		m2.addModeloNome("Kwid");
		m2.addModeloNome("Duster");
		m3.addModeloNome("Camaro");
		m3.addModeloNome("Cruze");
		m4.addModelo(new Modelo("BMW 320i"));

		marcas.add(m1);
		marcas.add(m2);
		marcas.add(m3);
		marcas.add(m4);

		// -> Carros
		Carro c1 = new Carro(new Modelo("Argo"), "ARG-0001", LocalDateTime.of(2021, 5, 3, 8, 45));
		c1.saidaCarroHorario(LocalDateTime.of(2021, 05, 03, 19, 30));
		Carro c2 = new Carro(new Modelo("Argo"), "ARG-0002");
		Carro c3 = new Carro(new Modelo("Camaro"), "CAM-0001");
		Carro c4 = new Carro(new Modelo("Kwid"), "KWD-0001", LocalDateTime.of(2021, 5, 3, 6, 17));
		c4.saidaCarroHorario(LocalDateTime.of(2021, 05, 03, 10, 30));
		Carro c5 = new Carro(new Modelo("Duster"), "DTR-0001", LocalDateTime.of(2021, 5, 3, 10, 30));
		c5.saidaCarroHorario(LocalDateTime.of(2021, 05, 03, 15, 30));
		Carro c6 = new Carro(new Modelo("Cruze"), "CRZ-0001", LocalDateTime.of(2021, 5, 3, 7, 00));
		c6.saidaCarroHorario(LocalDateTime.of(2021, 05, 03, 21, 30));

		vagas[0] = c1;
		vagas[1] = c2;
		vagas[2] = c3;
		vagas[3] = c4;
		vagas[4] = c5;
		vagas[5] = c6;

		historico.add(c1);
		historico.add(c4);
		historico.add(c5);
		historico.add(c6);
		// FIM DOS DUMMIES

		// -- CODIGO PRINCIPAL -- //
		// -> Criacao de variaveis
		boolean appOn = true;
		Scanner scanner = new Scanner(System.in);

		// -> Loop do menu
		while (appOn) {
			int escolha = menu();
			switch (escolha) {
				case 1:
					// -> Entrada do carro
					menuEntrada(vagas, historico, marcas);
					break;
				case 2:
					// -> Saida do carro
					menuSaida(vagas);
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
					verRelatorio(vagas, historico);
					break;
				case 6:
					// -> Mudar informa????es de algum carro
					mudarInfo(vagas);
					break;
				case 7:
					// -> Cadastrar marcas
					cadastrarMarca();
					break;
				case 8:
					// -> Cadastrar modelos em marcas
					cadastrarModelo();
					break;
				case 0:
					// ->Sair do menu
					appOn = false;
					break;
				default:
					System.out.println("Escolha inv??lida, tente novamente.");
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
		System.out.println("<5> Ver relatorio de movimentacoes");
		System.out.println("<6> Alterar dados dos carros");
		System.out.println("<7> Cadastrar nova marca");
		System.out.println("<8> Cadastrar novo modelo");
		System.out.println("<0> Sair do aplicativo");
		System.out.print(">> ");
		return scanner.nextInt();
	}

	public static void menuEntrada(Carro[] vagas, ArrayList<Carro> historico, ArrayList<Marca> marcas) {
		Scanner scanner = new Scanner(System.in);
		int dia, mes, ano, hora, minuto;
		int emptyVagas = 100;
		int opcao = 0;
		int i = 0;
		int posVazia = 0;
		boolean invalidInput = true;
		while (invalidInput) {
			System.out.println("\n--- Entrada ---");
			System.out.println("<1> Registrar entrada sem especificar horario");
			System.out.println("<2> Registrar entrada especificando horario");
			System.out.println("<0> Voltar ao menu");
			System.out.print(">> ");
			opcao = scanner.nextInt();
			if (opcao >= 0 && opcao < 3) {
				invalidInput = false;
			} else {
				System.out.println("\nValor incorreto! Tente novamente.");
			}
		}
		if (opcao != 0) {
			for (Carro carro : vagas) {
				if (carro != null) {
					emptyVagas -= 1;
					i += 1;
				}
			}

			for (int j = 0; vagas[j] != null; j += 1) {
				posVazia += 1;
			}

			System.out.println("\nTotal de vagas vazias: " + emptyVagas);
			scanner.nextLine();
			switch (opcao) {
				case 0:
					break;
				case 1:
					// Marca
					System.out.println("\n--- Selecione a marca do carro ---");
					for (Marca marca : marcas) {
						System.out.println("<" + marcas.indexOf(marca) + "> " + marca.getMarca());
					}
					System.out.println("<" + marcas.size() + "> Adicionar nova marca");
					System.out.println("\nEscolha uma opcao de marca:");
					System.out.print(">> ");
					int escMarca = scanner.nextInt();

					if (escMarca == marcas.size()) {
						System.out.println("\nNome da marca a ser adicionada:");
						System.out.print(">> ");
						scanner.nextLine();
						String nomeMar = scanner.nextLine();
						marcas.add(new Marca(nomeMar));
						System.out.println("\nMarca adicionada: " + nomeMar);
					} else {
						// Modelo
						Marca marcaSel = marcas.get(escMarca);
						ArrayList<Modelo> modelosMarca = marcaSel.getALModelo();

						System.out.println("\n--- Selecione o modelo do carro ---");
						for (Modelo modelo : modelosMarca) {
							System.out.println("<" + modelosMarca.indexOf(modelo) + "> " + modelo.getModelo());
						}
						System.out.println("<" + modelosMarca.size() + "> Adicionar novo modelo");
						System.out.println("\nEscolha uma opcao de modelo:");
						System.out.print(">> ");
						int escModelo = scanner.nextInt();

						if (escModelo == modelosMarca.size()) {
							System.out.println("\nMarca: " + marcaSel.getMarca());
							System.out.println("Nome do modelo a ser adicionado:");
							System.out.print(">> ");
							scanner.nextLine();
							String nomeMod = scanner.nextLine();
							marcaSel.addModeloNome(nomeMod);
							System.out.println("\nModelo adicionado: " + nomeMod);
						} else {
							// Placa
							System.out.println("\n--- Digite a placa do carro ---");
							System.out.print(">> ");
							scanner.nextLine();
							String placa = scanner.nextLine();
							vagas[posVazia] = new Carro(modelosMarca.get(escModelo), placa);
							System.out.println("\nEntrada registrada!");
							System.out.println("Placa do Carro: " + vagas[posVazia].getPlaca());
							System.out.println("Modelo do Carro: " + vagas[posVazia].getModelo());
							System.out.println("Hora de entrada: " + vagas[posVazia].getHoraEntrada());
						}
					}
					break;
				case 2:
					// Marca
					System.out.println("\n--- Selecione a marca do carro ---");
					for (Marca marca : marcas) {
						System.out.println("<" + marcas.indexOf(marca) + "> " + marca.getMarca());
					}
					System.out.println("<" + marcas.size() + "> Adicionar nova marca");
					System.out.println("\nEscolha uma opcao de marca:");
					System.out.print(">> ");
					escMarca = scanner.nextInt();

					if (escMarca == marcas.size()) {
						System.out.println("\nNome da marca a ser adicionada:");
						System.out.print(">> ");
						scanner.nextLine();
						String nomeMar = scanner.nextLine();
						marcas.add(new Marca(nomeMar));
						System.out.println("\nMarca adicionada: " + nomeMar);
					} else {
						// Modelo
						Marca marcaSel = marcas.get(escMarca);
						ArrayList<Modelo> modelosMarca = marcaSel.getALModelo();

						System.out.println("\n--- Selecione o modelo do carro ---");
						for (Modelo modelo : modelosMarca) {
							System.out.println("<" + modelosMarca.indexOf(modelo) + "> " + modelo.getModelo());
						}
						System.out.println("<" + modelosMarca.size() + "> Adicionar novo modelo");
						System.out.println("\nEscolha uma opcao de modelo:");
						System.out.print(">> ");
						int escModelo = scanner.nextInt();

						if (escModelo == modelosMarca.size()) {
							System.out.println("\nMarca: " + marcaSel.getMarca());
							System.out.println("Nome do modelo a ser adicionado:");
							System.out.print(">> ");
							scanner.nextLine();
							String nomeMod = scanner.nextLine();
							marcaSel.addModeloNome(nomeMod);
							System.out.println("\nModelo adicionado: " + nomeMod);
						} else {
							// Placa
							System.out.println("\n--- Digite a placa do carro ---");
							System.out.print(">> ");
							scanner.nextLine();
							String placa = scanner.nextLine();

							// Hor??rio
							// Verifica????o e confirma????o do hor??rio
							System.out.println("\n--- Digite o hor??rio de entrada ---");
							System.out.print("Dia (dia/mes/ano): ");
							String diaInteiro = scanner.nextLine();
							String[] valoresDia = diaInteiro.split("/");

							if (valoresDia.length != 3){
								System.out.println("\nDigite a data no formato correto!");
								return;
							} else {
								dia = Integer.parseInt(valoresDia[0]);
								mes = Integer.parseInt(valoresDia[1]);
								ano = Integer.parseInt(valoresDia[2]);
							}

							// Verifica????o e confirma????o do hor??rio
							System.out.print("Horario (hora:minuto - 24h): ");
							String horaInteira = scanner.nextLine();
							String[] valoresHora = horaInteira.split(":");
							if (valoresHora.length != 2){
								System.out.println("\nDigite o hor??rio no formato correto!");
								return;
							} else {
								hora = Integer.parseInt(valoresHora[0]);
								minuto = Integer.parseInt(valoresHora[1]);
							}
							vagas[posVazia] = new Carro(modelosMarca.get(escModelo), placa, hora, minuto, dia, mes, ano);
							System.out.println("\nEntrada registrada!");
							System.out.println("Placa do Carro: " + vagas[posVazia].getPlaca());
							System.out.println("Modelo do Carro: " + vagas[posVazia].getModelo());
							System.out.println("Hora de entrada: " + vagas[posVazia].getHoraEntrada());
						}
					}
					break;
				default:
					System.out.println("Escolha invalida!");
					break;
			}
		} else {
			return;
		}
	}

	public static void menuSaida(Carro[] vagas) {
		Scanner scanner = new Scanner(System.in);
		int dia, mes, ano, hora, minuto;

		System.out.println("\n--- Selecionar Carro ---");
		System.out.println("<0> Voltar ao menu");
		for (int i = 0; i < 100; i++) {
			if (vagas[i] != null) {
				System.out.println("<" + (i+1) + "> " + vagas[i].getPlaca() + " - " + vagas[i].getModelo() + " - "
						+ vagas[i].getHoraEntrada());
			}
		}

		System.out.println("\nEscolha um carro:");
		System.out.print(">> ");
		int escolhaCarro = scanner.nextInt();

		if (escolhaCarro == 0) {
			return;
		} else {
			escolhaCarro -= 1;
		}

		System.out.println("\n--- Saida ---");
		System.out.println("<1> Registrar saida sem especificar horario");
		System.out.println("<2> Registrar saida especificando horario");
		System.out.println("<0> Voltar ao menu");
		System.out.println("\nEscolha uma op????o: ");
		System.out.print(">> ");
		int escolhaHorario = scanner.nextInt();
		scanner.nextLine();
		if (escolhaHorario != 0) {
			switch (escolhaHorario) {
				case 1:
					System.out.println("\nCarro removido com sucesso!");
					System.out.println("Valor total: RS" + vagas[escolhaCarro].saidaCarro());
					historico.add(vagas[escolhaCarro]);
					vagas[escolhaCarro] = null;
					break;
				case 2:
					System.out.println("\nEspecifique o hor??rio:");

					// -> Escaneando e confirmando a data
					System.out.print("Dia (dia/mes/ano): ");
					String diaInteiro = scanner.nextLine();
					String[] valoresDia = diaInteiro.split("/");
					if (valoresDia.length != 3){
						System.out.println("\nDigite a data no formato correto!");
						break;
					} else {
						dia = Integer.parseInt(valoresDia[0]);
						mes = Integer.parseInt(valoresDia[1]);
						ano = Integer.parseInt(valoresDia[2]);
					}

					// -> Escaneando e confirmando a hora
					System.out.print("Horario (hora:minuto - 24h): ");
					String horaInteira = scanner.nextLine();
					String[] valoresHora = horaInteira.split(":");

					if (valoresHora.length != 2){
						System.out.println("\nDigite o hor??rio no formato correto!");
						break;
					} else {
						hora = Integer.parseInt(valoresHora[0]);
						minuto = Integer.parseInt(valoresHora[1]);
					}

					System.out.println("\nCarro removido com sucesso!");
					System.out.println("Valor total: RS" + vagas[escolhaCarro].saidaCarroHorarioInt(dia, mes, ano, hora, minuto));
					historico.add(vagas[escolhaCarro]);
					vagas[escolhaCarro] = null;
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
			modelos = marcaEsc.getALModelo();

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

	public static void verRelatorio(Carro[] vagas, ArrayList<Carro> historico) {
		boolean temRegistro = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n--- Relatorio ---");
		System.out.println("Qual data deseja consultar?");
		System.out.print("Dia (dia/mes/ano): ");
		String data = scanner.nextLine();

		// -> Verifica????o do formato da data
		String[] valoresDia = data.split("/");
		if (valoresDia.length != 3){
			System.out.println("\nDigite a data no formato correto!");
			return;
		}
		// -> Organiza????o da ArrayList historico com base na ordem natural
		Collections.sort(historico);

		// -> Printando carros com a data correspondente
		for (Carro carro : historico) {
			String dataSaida = carro.getHoraSaida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			if (data.equals(dataSaida)) {
				temRegistro = true;
				// Print dos carros no carrosRegistro
				System.out.println("\n--- Carro n" + (historico.indexOf(carro) + 1) + " ---");
				System.out.println("Placa: " + carro.getPlaca());
				System.out.println("Modelo: " + carro.getModelo());
				for (Marca marca : marcas) {
					for (Modelo modelo : marca.getALModelo()) {
						if (modelo.getModelo() == carro.getModelo())
							System.out.println("Marca: " + marca.getMarca());
					}
				}
				System.out.println("Entrada: " + carro.getHoraEntrada());
				System.out.println("Saida:" + carro.getHoraSaidaString());
				System.out.println("Valor pago: " + carro.getValor());
			}
		}

		if (!temRegistro){
			System.out.println("\nNenhum registro na data selecionada.");
		}
	}

	public static void mudarInfo(Carro[] vagas) {
		Scanner sc = new Scanner(System.in);

		System.out.println("\n --- Mudar Informa????es ---");
		System.out.println("<0> Voltar ao menu");
		for (int i = 0; i < 100; i++) {
			if (vagas[i] != null) {
				System.out.println("<" + (i+1) + "> " + vagas[i].getPlaca() + " - " + vagas[i].getModelo() + " - "
						+ vagas[i].getHoraEntrada());
			}
		}
		System.out.println("\nEscolha uma op????o:");
		System.out.print(">> ");
		int escolhaCarro = sc.nextInt();
		if (escolhaCarro == 0){
			return;
		} else {
			escolhaCarro -= 1;
		}
		System.out.println("\n--- Qual informa????o deseja mudar ---");
		System.out.println("<1> Placa");
		System.out.println("<2> Modelo");
		System.out.println("<3> Hor??rio de entrada");
		System.out.println("<4> Voltar ao menu");
		System.out.println("\nEscolha a op????o:");
		System.out.print(">> ");
		int escolha = sc.nextInt();
		sc.nextLine();
		switch (escolha) {
			case 1:
				System.out.println("Placa atual: " + vagas[escolhaCarro].getPlaca());
				System.out.println("\nDigite a nova placa: ");
				System.out.print(">> ");
				String placaNova = sc.nextLine();
				vagas[escolhaCarro].setPlaca(placaNova);
				System.out.println("\nPlaca alterada com sucesso!");
				System.out.print("Nova placa: " + vagas[escolhaCarro].getPlaca());
				break;
			case 2:
				System.out.println("Modelo atual: " + vagas[escolhaCarro].getModelo());
				System.out.println("\nDigite o novo modelo: ");
				System.out.print(">> ");
				String modeloNovo = sc.nextLine();
				vagas[escolhaCarro].setModelo(modeloNovo);
				System.out.println("\nPlaca alterada com sucesso!");
				System.out.println("Novo modelo: " + vagas[escolhaCarro].getModelo());
				break;
			case 3:
				int dia, mes, ano, hora, minuto = 0;
				System.out.println("\nHor??rio de entrada atual: " + vagas[escolhaCarro].getHoraEntrada());
				System.out.print("Nova data (dia/mes/ano): ");
				String diaInteiro = sc.nextLine();
				String[] valoresDia = diaInteiro.split("/");

				// Verifica????o e confirma????o da data
				if (valoresDia.length != 3){
					System.out.println("\nDigite a data no formato correto!");
					return;
				} else {
					dia = Integer.parseInt(valoresDia[0]);
					mes = Integer.parseInt(valoresDia[1]);
					ano = Integer.parseInt(valoresDia[2]);
				}

				// Verifica????o e confirma????o do hor??rio
				System.out.print("Novo hor??rio (hora:minuto - 24h): ");
				String horaInteira = sc.nextLine();
				String[] valoresHora = horaInteira.split(":");
				if (valoresHora.length != 2){
					System.out.println("\nDigite o hor??rio no formato correto!");
					return;
				} else {
					hora = Integer.parseInt(valoresHora[0]);
					minuto = Integer.parseInt(valoresHora[1]);
				}

				// Registro do novo hor??rio
				vagas[escolhaCarro].setHoraEntrada(ano, mes, dia, hora, minuto);
				System.out.println("\nHor??rio modificado com sucesso!");
				System.out.println("Novo hor??rio: " + vagas[escolhaCarro].getHoraEntrada());
				break;
			case 4:
				break;
			default:
				System.out.println("Digite uma op????o v??lida!");
				break;
		}
	}

	public static void cadastrarMarca(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n--- Registro de Marcas ---");
		System.out.println("\n- Marcas j?? registradas -\n");
		for (Marca marca : marcas){
			System.out.println(marca.getMarca());
		}
		System.out.println("\n<1> Cadastrar nova marca");
		System.out.println("<0> Retornar ao menu");
		System.out.println("\n- Selecione a op????o: ");
		System.out.print(">> ");
		int opcao = scanner.nextInt();

		switch (opcao) {
			case 0:
				break;
			case 1:
				System.out.println("\n- Digite o nome da marca que deseja adicionar: ");
				System.out.print(">> ");
				scanner.nextLine();
				String nomeMarca = scanner.nextLine();
				Marca novaMarca = new Marca(nomeMarca);
				marcas.add(novaMarca);
				System.out.println("\n" + novaMarca.getMarca() + " adicionada com sucesso!");
				break;
			default:
				System.out.println("\nDigite uma op????o v??lida!");
				break;
		}
	}

	public static void cadastrarModelo(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n--- Registro de Modelos ---");
		System.out.println("\n- Selecione a marca que deseja adicionar o modelo -\n");
		for (Marca marca : marcas){
			System.out.println("<" + marcas.indexOf(marca) + "> " + marca.getMarca());
		}
		System.out.println("<"+ marcas.size() + "> Retornar ao menu");
		System.out.println("\n- Selecione a op????o: ");
		System.out.print(">> ");
		int opcaoMarca = scanner.nextInt();

		if(opcaoMarca != marcas.size()) {
			System.out.println("\n- Modelos j?? registrados em " + marcas.get(opcaoMarca).getMarca() + "-\n");
			for (Modelo modelo : marcas.get(opcaoMarca).getALModelo()){
				System.out.println(modelo.getModelo());
			}
			System.out.println("\n<1> Cadastrar novo modelo");
			System.out.println("<0> Retornar ao menu");
			System.out.println("\n- Selecione a op????o: ");
			System.out.print(">> ");
			int opcaoMod = scanner.nextInt();
			switch (opcaoMod) {
				case 0:
					break;
				case 1:
					System.out.println("\n- Digite o nome do modelo que deseja adicionar: ");
					System.out.print(">> ");
					scanner.nextLine();
					String nomeModelo = scanner.nextLine();
					marcas.get(opcaoMarca).addModeloNome(nomeModelo);
					System.out.println("\n" + nomeModelo + " adicionado com sucesso em " + marcas.get(opcaoMarca).getMarca() + "!");
					break;
				default:
					System.out.println("\nDigite uma op????o v??lida!");
					break;
			}
		}
	}
}