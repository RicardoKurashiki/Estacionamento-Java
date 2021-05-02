package Modelagem;

import java.time.LocalDateTime;

public class Carro {

	private Modelo modelo;
	private String placa;
	private LocalDateTime entrada;
	private LocalDateTime saida;
	private float valor;

	// -> Construtor para entrada de carro
	public Carro(Modelo modelo, String placa, LocalDateTime entrada) {
		this.modelo = modelo;
		this.placa = placa;
		this.entrada = entrada;
	}

	// -> Construtor para saida de carro
	public Carro(Modelo modelo, String placa, LocalDateTime saida, float valor) {
		this.modelo = modelo;
		this.placa = placa;
		this.saida = saida;
		this.valor = valor;
	}

}
