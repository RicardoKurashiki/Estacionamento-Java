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

		boolean appOn = true;
		Scanner scanner = new Scanner(System.in);

		while (appOn) {
			int escolha = menu();
			switch (escolha) {
				case 0:
					appOn = false;
					break;
				default:
					System.out.println("Escolha inválida, tente novamente.");
					break;
			}
		}
		scanner.close();
	}

	private static void entradaCarro() {
	}

	private static float saidaCarro() {
		float preco = 0;
		return preco;
	}

	public static int menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n--------------------");
		System.out.println("<1> Cadastrar entrada de um carro");
		System.out.println("<2> Registrar saida de um carro");
		System.out.println("<3> Ver histórico de movimentacoes");
		System.out.println("<0> Sair do aplicativo");
		System.out.println("--------------------");
		System.out.print(">> ");
		return scanner.nextInt();
	}
}
