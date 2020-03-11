package br.edu.ifce.computacao.estruturadedados.pilha;

public class TestePilha {

	public static void main(String[] args) {
		
		Pilha pilha = new PilhaImpl(5);
		
		pilha.imprime();
		
		pilha.adicionaTopo(18);
		pilha.imprime();
		
		pilha.adicionaTopo(16);
		pilha.imprime();
		
		pilha.adicionaTopo(14);
		pilha.imprime();
		
		pilha.adicionaTopo(12);
		pilha.imprime();
		
		pilha.adicionaTopo(10);
		pilha.imprime();
		
		pilha.adicionaTopo(8);
		pilha.imprime();
		
		pilha.removeTopo();
		pilha.imprime();
		
		pilha.removeTopo();
		pilha.imprime();
		
		pilha.removeTopo();
		pilha.imprime();
		
		pilha.removeTopo();
		pilha.imprime();
		
		pilha.removeTopo();
		pilha.imprime();
		
		pilha.removeTopo();
		pilha.imprime();
	}
}
