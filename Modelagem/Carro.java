package Modelagem;

import java.time.LocalDateTime;

public class Carro {

	private Modelo modelo;
	private String placa;
	private LocalDateTime entrada;
	private LocalDateTime saida;
	private float valor;

	// -> Construtor apenas com placa
	public Carro(String placa){
		this.placa = placa;
		this.modelo = new Modelo();
		this.entrada = LocalDateTime.now();
	}

	// -> Construtor com o nome do modelo e a placa;
	public Carro(String modelo, String placa){
		this.placa = placa;
		this.modelo = new Modelo(modelo);
		this.entrada = LocalDateTime.now();
	}

	// -> Construtor com o objeto modelo e com a placa
	public Carro(Modelo modelo, String placa){
		this.placa = placa;
		this.modelo = modelo;
		this.entrada = LocalDateTime.now();
	}

	// -> Construtor com o nome do modelo, placa e instância da data de entrada
	public Carro(String modelo, String placa, LocalDateTime entrada){
		this.placa = placa;
		this.modelo = new Modelo(modelo);
		this.entrada = entrada;
	}

	// -> Construtor com o nome do modelo, placa e informações da hora de entrada
	public Carro(String modelo, String placa, int hora, int minuto, int dia, int mes, int ano){
		this.placa = placa;
		this.modelo = new Modelo(modelo);
		this.entrada = LocalDateTime.of(ano, mes, dia, hora, minuto);
	}

	// -> Construtor com o objeto modelo, placa e instância da hora de entrada
	public Carro(Modelo modelo, String placa, LocalDateTime entrada){
		this.placa = placa;
		this.modelo = modelo;
		this.entrada = entrada;
	}

	// -> Construtor com o objeto modelo, placa e informações da hora de entrada
	public Carro(Modelo modelo, String placa, int hora, int minuto, int dia, int mes, int ano){
		this.placa = placa;
		this.modelo = modelo;
		this.entrada = LocalDateTime.of(ano, mes, dia, hora, minuto);
	}



	public float saidaCarro(){
		// Estabelece o LocalDateTime saída como now()
		// Calcula valor com a diferença entre o tempo de registro e o tempo de saida
	}

	public float saidaCarroHorario(){
		// Estabelece o LocalDateTime saída com a data e horário passado pelo usuário
		// Calcula valor com a diferença de entrada e saída;
	}

}
