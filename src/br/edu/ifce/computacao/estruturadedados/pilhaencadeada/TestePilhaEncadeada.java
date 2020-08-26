package br.edu.ifce.computacao.estruturadedados.pilhaencadeada;

public class TestePilhaEncadeada {
	
	public static void main(String[] args) {
		
		TADPilha<Integer> pilha = new PilhaEncadeada<Integer>(); 
		
		pilha.insereTopo(10);
		pilha.imprimePilha();
		
		pilha.insereTopo(8);
		pilha.imprimePilha();
		
		pilha.insereTopo(6);
		pilha.imprimePilha();
		
		pilha.insereTopo(4);
		pilha.imprimePilha();
		
		pilha.removeTopo();
		pilha.imprimePilha();
		
		pilha.removeTopo();
		pilha.imprimePilha();
		
		pilha.removeTopo();
		pilha.imprimePilha();
		
		pilha.removeTopo();
		pilha.imprimePilha();
		
		pilha.removeTopo();
		pilha.imprimePilha();
		
		
	}

}
