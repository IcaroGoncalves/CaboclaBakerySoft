package entities;

public class Prato {
private static int idCont = 1; //contador é alimentado em +1 a cada produto adicionado
private int id;
private String nome;
private Double preco;



public Prato(String nome, Double preco) {
	super();
	this.id = idCont;
	this.nome = nome;
	this.preco = preco;
	Prato.idCont += 1;
}


public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public Double getPreco() {
	return preco;
}
public void setPreco(Double preco) {
	this.preco = preco;
}


public int getId() {
	return id;
}




@Override
	public String toString() {
		return "Id:" + this.getId() +
        "\n Item:" + this.getNome() +
        "\n Valor:R$"+ this.getPreco();
	}



}
