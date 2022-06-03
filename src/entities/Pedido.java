package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//import entities.Pedido;
//import entities.Produto;

public class Pedido{
	private static Scanner ler = new Scanner(System.in);
	private static ArrayList<Prato>prato; // criçao  de lista para guardar multiplos pratos em um cardapio 
	private static Map<Prato, Integer>itens; //Interface MAP para guardar itens no carrinho de itens
public static void main(String[] args) {
	
		prato = new ArrayList<Prato>(); // Instanciamento do array dentro de variavel produto
		itens = new HashMap<>(); // instanciamento do MAP do carrinho de itens
		
	    
	  
     menu();
	
	


}

private static void menu() {
	System.out.println("====================================================================================");
	System.out.println("                                  DEV FOOD                                          ");
	System.out.println("  APLICAÇÕES:  1) CADASTRAR NO CARDAPIO    ");
	System.out.println("               2) REALIZAR PEDIDO");
	System.out.println("               3) MOSTRAR CARDAPIO");
	System.out.println("               4) SAIR");
	System.out.println("====================================================================================");
	int opcao = ler.nextInt();
	
	switch(opcao) {
	default:
		System.out.println("Opçao invalida");
		menu();
		break;
	case 1:
		cadastrarPrato();
		break;
	case 2:
		comprar();
		break;
	case 3:
		mostrarCardapio();
		break;
	case 4:
		System.out.println("Obrigado pela preferencia! :)");
		System.exit(opcao);
	}
}

private static void cadastrarPrato() { // metodo para cadastro de novos pratos ao cardapio
	System.out.print("Nome do prato:");
	String nome = ler.next();
	
	System.out.print("Defina o preco do item:");
	Double preco  = ler.nextDouble();
	
	Prato p = new Prato(nome,preco);
	prato.add(p);
	
	System.out.println(p.getNome() + " castrado com sucesso!");
	menu();
}

private static void mostrarCardapio() { //metodo para exibir os produtos cadastrados
	if (prato.size() > 0) { // Se o tamanho da lista for maior que 0 , exibir os produtos cadastrados 
		System.out.println("---------- Produtos castrados----------\n");
		
		for(Prato p : prato) { // Percorre e exibe cada produto p e seus atributos
			System.out.println(p);
		}
		
	}else {
		System.out.println("Não há produtos cadastrados!"); // exibe mensagem caso não exista itens dentro da lista, ou seja produto.size < 0
	}
	menu();
}



private static void comprar() { //Metodo para compra de produto(Ao realizar a compra , o produto já é cadastrado no carrinho)
	if (prato.size()>0) {
		System.out.print("Selecione o id do produto desejado:\n");
		System.out.println("\n---------- Itens disponiveis---------------\n");
		for(Prato p : prato) {
			System.out.println(p +"\n");
		}//exibe a lista de produtos cadastrados e seus respectivos id´s 
		int id = Integer.parseInt(ler.next());
		boolean presente = false; // variavel validadadora de id
		
		for(Prato p : prato) {
			if(p.getId() == id) {   //Valida se o ip digitado pelo usuário está na lista
				int qtd = 0;  
				
				try {
					qtd = itens.get(p);	
					itens.put(p, qtd + 1 ); // Será inserido o objeto p no carrinho como valor e a quantidade 'quant' como chave que irá incrementar em + 1 a cada item adc
				}catch(NullPointerException e){
					itens.put(p, 1);
				}// exceçao lançada para não exibir erro de exceção caso o usuário didgite um id que não existe na lista
				
				System.out.println(p.getNome() + " adicionado ao carrinho com sucesso!!!");
				presente = true; //validador modificado para "true", pois já foi inserido um produto ao carrinho
				
				if(presente) {
					System.out.println("Deseja adicionar outro item na lista?");
					System.out.print("Digite 1 para sim |  Digite 2 para finalizar pedido:");
					int opcao = Integer.parseInt(ler.next());
					
					if(opcao == 1) {
						comprar();
					}else {
					    finalizarPedido();	
					}
				}
			}
			
	}
	
	
	
	}else {
		System.out.println("Não existem produtos cadastrados");
		menu();
	}
	
	
	
}

Double total;
private static void finalizarPedido() {//funçao para finalizar pedido
	
		Double total = 0.0;
		for (Prato p : itens.keySet()) {
			int qtd = itens.get(p);
			total += p.getPreco() * qtd;
			System.out.println(p);
			System.out.println("Quantidade:"+ qtd);
			System.out.println("-------------------------");
		}
		System.out.println("Valor total:R$"+ total);
		System.out.print("Deseja adicionar um cupom de desconto a sua compra?(1 - SIM 2 - NÂO):");
		int opcao = Integer.parseInt(ler.next());
		
	     if(opcao == 1) {
	    	 System.out.println("Escolha um cupom ");
			System.out.print("|1  -  20% | 6 R$ de desconto: ");
			int opc = Integer.parseInt(ler.next());
		        if (opc == 1) {
		        	Cupom c =  new CupomPerc();
		        	 c.descCupom(total);
		        }else {
		        	Cupom f = new CupomFixo();
		           f.descCupom(total);
		        }
		}
		
		itens.clear();
		System.out.println("O pedido está sendo preparado pelo estabelecimento");
         menu();
}




}


	
	