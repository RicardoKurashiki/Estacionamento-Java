package Modelagem;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.HOURS;

public class Carro {

	private Modelo modelo;
	private String placa;
	private LocalDateTime entrada;
	private LocalDateTime saida;
	private float valor;

	// -> Construtor apenas com placa
	public Carro(String placa) {
		this.placa = placa;
		this.modelo = new Modelo();
		this.entrada = LocalDateTime.now();
	}

	// -> Construtor com o nome do modelo e a placa;
	public Carro(String modelo, String placa) {
		this.placa = placa;
		this.modelo = new Modelo(modelo);
		this.entrada = LocalDateTime.now();
	}

	// -> Construtor com o objeto modelo e com a placa
	public Carro(Modelo modelo, String placa) {
		this.placa = placa;
		this.modelo = modelo;
		this.entrada = LocalDateTime.now();
	}

	// -> Construtor com o nome do modelo, placa e instância da data de entrada
	public Carro(String modelo, String placa, LocalDateTime entrada) {
		this.placa = placa;
		this.modelo = new Modelo(modelo);
		this.entrada = entrada;
	}

	// -> Construtor com o nome do modelo, placa e informações da hora de entrada
	public Carro(String modelo, String placa, int hora, int minuto, int dia, int mes, int ano) {
		this.placa = placa;
		this.modelo = new Modelo(modelo);
		this.entrada = LocalDateTime.of(ano, mes, dia, hora, minuto);
	}

	// -> Construtor com o objeto modelo, placa e instância da hora de entrada
	public Carro(Modelo modelo, String placa, LocalDateTime entrada) {
		this.placa = placa;
		this.modelo = modelo;
		this.entrada = entrada;
	}

	// -> Construtor com o objeto modelo, placa e informações da hora de entrada
	public Carro(Modelo modelo, String placa, int hora, int minuto, int dia, int mes, int ano) {
		this.placa = placa;
		this.modelo = modelo;
		this.entrada = LocalDateTime.of(ano, mes, dia, hora, minuto);
	}

	// -> Construtor com placa e instância da hora de entrada
	public Carro(String placa, LocalDateTime entrada) {
		this.placa = placa;
		this.modelo = new Modelo();
		this.entrada = entrada;
	}

	// -> Construtor com placa e informações da hora de entrada
	public Carro(String placa, int hora, int minuto, int dia, int mes, int ano) {
		this.placa = placa;
		this.modelo = new Modelo();
		this.entrada = LocalDateTime.of(ano, mes, dia, hora, minuto);
	}

	// -> Getter da placa
	public String getPlaca() {
		return placa;
	}

	public String getModelo() {
		return modelo.getModelo();
	}

	public float saidaCarro() {
		float valor = 0;
		// Estabelece o LocalDateTime saída como now()
		this.saida = LocalDateTime.now();
		float horas = entrada.until(saida, HOURS);
		if (horas <= 1) {
			valor = 10;
		}
		if (horas > 1) {
			horas -= 1;
			float minutos = horas * 60;
			valor = 10 + ((minutos / 15) * 2);
		}
		// Calcula valor com a diferença entre o tempo de registro e o tempo de saida
		return valor;
	}

	public float saidaCarroHorario(int segundo, int minuto, int hora, int dia, int mes, int ano) {
		float valor = 0;
		this.saida = LocalDateTime.of(ano, mes, dia, hora, minuto, segundo);
		float horas = entrada.until(saida, HOURS);
		System.out.println("HORA ATUAL: " + this.entrada);
		System.out.println("HORA SAIDA: " + this.saida);
		System.out.println("HORAS: " + horas);
		if (horas <= 1) {
			valor = 10;
		}
		if (horas > 1) {
			horas -= 1;
			float minutos = horas * 60;
			valor = 10 + ((minutos / 15) * 2);
		}
		return valor;
	}

}
