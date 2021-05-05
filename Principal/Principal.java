package Principal;

import java.util.ArrayList;
import java.util.Scanner;

import Modelagem.Carro;
import Modelagem.Marca;
import Modelagem.Modelo;

public class Principal {
	private static Carro[] vagas = new Carro[100];
	private static ArrayList<Marca> marcas = new ArrayList<Marca>();
	private static ArrayList<Carro> historico = new ArrayList<Carro>();

	public static void main(String[] args) {

		// -> Dummies para exemplos
		final Marca m1 = new Marca("Fiat");
		final Marca m2 = new Marca("Renault");
		final Marca m3 = new Marca("Chevrolet");

		m1.addModelo("Uno");
		m1.addModelo("Argo");
		m2.addModelo("Kwid");
		m2.addModelo("Duster");
		m3.addModelo("Camaro");
		m3.addModelo("Cruze");

		marcas.add(m1);
		marcas.add(m2);
		marcas.add(m3);

		// -> Criacao de variaveis
		boolean appOn = true;
		Scanner scanner = new Scanner(System.in);

		// -> Loop do menu
		while (appOn) {
			int escolha = menu();
			switch (escolha) {
				case 1:
					// -> Entrada do carro
					appOn = false;
					break;
				case 2:
					// -> Saida do carro
					appOn = false;
					break;
				case 3:
					// -> Nova marca
					appOn = false;
					break;
				case 4:
					// -> Novo modelo
					appOn = false;
					break;
				case 5:
					// -> Historico
					mostrarMarcas();
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
		System.out.println("\n--------------------");
		System.out.println("<1> Registrar entrada de um carro");
		System.out.println("<2> Registrar saida de um carro");
		System.out.println("<3> Ver/Registrar marcas de carro");
		System.out.println("<4> Ver/Registrar novo modelo de carro");
		System.out.println("<5> Ver historico de movimentacoes");
		System.out.println("<0> Sair do aplicativo");
		System.out.println("--------------------");
		System.out.print(">> ");
		return scanner.nextInt();
	}

	public static void mostrarMarcas() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n--------------------");
		System.out.println("As marcas disponiveis no sistema sao:");
		for (Marca marca : marcas) {
			System.out.println("<" + marcas.indexOf(marca) + "> " + marca.getMarca());
		}
		int opcao = scanner.nextInt() + 1;
	}
}
