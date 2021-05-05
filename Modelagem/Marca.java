package Modelagem;

import java.util.ArrayList;

public class Marca {

	private String nome;
	private ArrayList<Modelo> modelo;

	// -> Método construtor sem nome
	public Marca(){
		nome = "Sem marca";
		modelo = new ArrayList<Modelo>();
	}

	// -> Método construtor com nome
	public Marca(String nome){
		this.nome = nome;
		modelo = new ArrayList<Modelo>();
	}

	// -> Colocar ou mudar o nome de uma marca
	public void setMarca(String nome){
		this.nome = nome;
	}

	// -> Retorna nome da marca
	public String getMarca(){
		return nome;
	}

	// -> Retorna o objeto da classe modelo de acordo com o índice
	public Modelo getModelo(int index){
		return modelo.get(index);
	}

	// -> Adiciona modelos na marca
	public void addModelo(String nomeMod){
		Modelo novoMod = new Modelo(nomeMod);
		modelo.add(novoMod);
	}
}
