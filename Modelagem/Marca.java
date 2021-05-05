package Modelagem;

import java.util.ArrayList;

public class Marca {

	private String nome;
	private ArrayList<Modelo> modelo;

	public Marca(){
		nome = "Sem marca";
		modelo = new ArrayList<Modelo>();
	}

	public Marca(String nome){
		this.nome = nome;
		modelo = new ArrayList<Modelo>();
	}

	public void setMarca(String nome){
		this.nome = nome;
	}

	public String getMarca(){
		return nome;
	}

	public String getModelo(){
		return "Ainda não sei o que fazer aqui";
	}

	public void addModelo(String nomeMod){
		Modelo novoMod = new Modelo(nomeMod);
		modelo.add(novoMod);
	}
}
