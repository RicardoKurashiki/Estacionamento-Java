package Modelagem;

public class Modelo {
	private String nome;

	// -> Construtor do modelo sem inputs
	public Modelo(){
		nome = "Sem modelo";
	}
	// -> Construtor do modelo com nome
	public Modelo(String nome){
		this.nome = nome;
	}
	// -> Método para mudar ou colocar nome em uma marca
	public void setModelo(String nome){
		this.nome = nome;
	}
	// -> Método para retornar nome do modelo
	public String getModelo (){
		return nome;
	}
}
