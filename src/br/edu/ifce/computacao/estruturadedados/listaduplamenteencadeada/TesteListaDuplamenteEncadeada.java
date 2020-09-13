package br.edu.ifce.computacao.estruturadedados.listaduplamenteencadeada;

public class TesteListaDuplamenteEncadeada {

	public static void main(String[] args) {
		
		TADListaDuplamenteEncadeada<String> lista = 
				new ListaDuplamenteEncadeada<String>(); 
		
		lista.imprimeLista();
		
		lista.insereValor("a", 0);
		lista.imprimeLista();
		
		lista.insereValor("a", 1);
		lista.imprimeLista();
		
		lista.insereValor("d", 2);
		lista.imprimeLista();
		
		lista.insereValor("c", 2);
		lista.imprimeLista();

		lista.insereValor("b", 2);
		lista.imprimeLista();
		
		lista.insereValor("e", 6);
		lista.imprimeLista();
		
		lista.insereValor("e", 5);
		lista.imprimeLista();
		
		
		lista.removeValor(0);
		lista.imprimeLista();
		
		lista.removeValor(6);
		lista.imprimeLista();
		
		lista.removeValor(1);
		lista.imprimeLista();
		
		lista.removeValor(4);
		lista.imprimeLista();
		
		lista.removeValor(2);
		lista.imprimeLista();
		
		lista.removeValor(2);
		lista.imprimeLista();
		
		lista.removeValor(1);
		lista.imprimeLista();
		
		lista.removeValor(1);
		
	}
	
}
