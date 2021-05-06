package Modelagem;

import java.util.ArrayList;

public class Marca {

	private String nome;
	private ArrayList<Modelo> alModelo;

	// -> Método construtor sem nome
	public Marca() {
		nome = "Sem marca";
		alModelo = new ArrayList<Modelo>();
	}

	// -> Método construtor com nome
	public Marca(String nome) {
		this.nome = nome;
		alModelo = new ArrayList<Modelo>();
	}

	// -> Colocar ou mudar o nome de uma marca
	public void setMarca(String nome) {
		this.nome = nome;
	}

	// -> Retorna nome da marca
	public String getMarca() {
		return nome;
	}

	// -> Retorna o Array List da classe modelo
	public ArrayList<Modelo> getALModelo() {
		return alModelo;
	}

	// -> Retorna o objeto da classe modelo de acordo com o índice
	public Modelo getModelo(int index) {
		return alModelo.get(index);
	}

	// -> Adiciona modelos na marca com o nome dos modelos
	public void addModeloNome(String nomeMod) {
		Modelo novoMod = new Modelo(nomeMod);
		alModelo.add(novoMod);
	}

	// -> Adiciona modelos na marca com objetos de Modelo
	public void addModelo(Modelo novoModelo) {
		alModelo.add(novoModelo);
	}
}
