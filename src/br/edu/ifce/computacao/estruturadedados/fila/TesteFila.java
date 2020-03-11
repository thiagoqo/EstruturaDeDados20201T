package br.edu.ifce.computacao.estruturadedados.fila;

public class TesteFila {

	public static void main(String[] args) {
		
		Fila fila = new FilaImpl(5);
		
		fila.imprimeFila();
		
		fila.insereFinal(10);
		fila.imprimeFila();
		
		fila.insereFinal(12);
		fila.imprimeFila();
		
		fila.insereFinal(14);
		fila.imprimeFila();
		
		fila.insereFinal(16);
		fila.imprimeFila();
		
		fila.insereFinal(18);
		fila.imprimeFila();
		
		fila.insereFinal(20);
		fila.imprimeFila();
		
		fila.removeInicio();
		fila.imprimeFila();
		
		fila.removeInicio();
		fila.imprimeFila();
		
		fila.removeInicio();
		fila.imprimeFila();
		
		fila.removeInicio();
		fila.imprimeFila();
		
		fila.removeInicio();
		fila.imprimeFila();
		
		fila.removeInicio();
		fila.imprimeFila();
		
		
	}
	
}
