package entities;

public class CupomFixo extends Cupom{
	private static Double cpValue = 6.0;


	public void descCupom (Double total) {
		total -= cpValue; 
		System.out.println("Valor total com desconto:R$ "+ total);
	}
}
