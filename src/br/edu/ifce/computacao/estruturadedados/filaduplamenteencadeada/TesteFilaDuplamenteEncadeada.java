package br.edu.ifce.computacao.estruturadedados.filaduplamenteencadeada;

public class TesteFilaDuplamenteEncadeada {

	public static void main(String[] args) {
		
		TADFila<String> fila = new FilaDuplamenteEncadeada<String>();
		
		fila.imprimeFila();
		
		fila.insereFinal("a");
		fila.imprimeFila();
		
		fila.insereFinal("b");
		fila.imprimeFila();
		
		fila.insereFinal("c");
		fila.imprimeFila();
		
		fila.removeInicio();
		fila.imprimeFila();
		
		fila.insereFinal("d");
		fila.imprimeFila();
		
		fila.removeInicio();
		fila.imprimeFila();
		
		fila.removeInicio();
		fila.imprimeFila();
		
		fila.removeInicio();
		fila.imprimeFila();
		
	}
}
