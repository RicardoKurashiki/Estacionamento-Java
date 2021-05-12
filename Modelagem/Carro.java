package Modelagem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.*;

public class Carro implements Comparable<Carro>{

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

	// -> Setter de placa
	public void setPlaca(String placaNova) {
		this.placa = placaNova;
	}

	// -> Getter da placa
	public String getPlaca() {
		return placa;
	}

	// -> Setter do modelo
	public void setModelo(String setmodelo) {
		this.modelo = new Modelo(setmodelo);
	}

	// -> Getter do modelo
	public String getModelo() {
		return modelo.getModelo();
	}

	// -> Setter de hora de entrada
	public void setHoraEntrada(int ano, int mes, int dia, int hora, int minuto) {
		this.entrada = LocalDateTime.of(ano, mes, dia, hora, minuto);
	}

	// -> Getter da hora de entrada
	public String getHoraEntrada() {
		return entrada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm a"));
	}

	public LocalDateTime getHoraEntradaLDT() {return entrada;}

	// -> Getter do valor pago
	public float getValor() {
		return valor;
	}

	public float saidaCarro() {
		// Estabelece o LocalDateTime saída como now()
		this.saida = LocalDateTime.now();
		float periodo = entrada.until(saida, MINUTES);
		if (periodo <= 60) {
			this.valor = 10;
		}
		if (periodo > 60) {
			periodo -= 60;
			this.valor = 10 + ((periodo / 15) * 2);
		}
		return valor;
	}

	public float saidaCarroHorario(LocalDateTime data) {
		this.saida = data;
		float periodo = entrada.until(saida, MINUTES);
		if (periodo <= 60) {
			this.valor = 10;
		}
		if (periodo > 60) {
			periodo -= 60;
			this.valor = 10 + ((periodo / 15) * 2);
		}
		return this.valor;
	}

	public float saidaCarroHorarioInt(int dia, int mes, int ano, int hora, int minuto) {
		this.saida = LocalDateTime.of(ano, mes, dia, hora, minuto);
		float periodo = entrada.until(saida, MINUTES);
		if (periodo <= 60) {
			this.valor = 10;
		}
		if (periodo > 60) {
			periodo -= 60;
			this.valor = 10 + ((periodo / 15) * 2);
		}
		return this.valor;
	}

	public String getHoraSaidaString() {
		return saida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm"));
	}

	public LocalDateTime getHoraSaida() { return saida; }

	@Override
	public String toString() {return "Carro de placa: " + placa + ", de modelo: " + modelo + ", entrou no estacionamento às: " + entrada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm a"));}

	@Override
	public int compareTo(Carro outroCarro) {
		return entrada.compareTo(outroCarro.getHoraEntradaLDT());
	}
}
