package entities;

public class CupomPerc extends Cupom{
	
private static Double cpValue = 0.2;


	public void descCupom (Double total) {
		Double calcperc = total * cpValue;
		total -= calcperc; 
		System.out.println("Valor total com desconto:R$ "+ total);
	}

}
