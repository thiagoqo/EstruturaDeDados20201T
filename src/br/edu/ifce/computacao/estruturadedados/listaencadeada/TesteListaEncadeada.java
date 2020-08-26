package br.edu.ifce.computacao.estruturadedados.listaencadeada;

public class TesteListaEncadeada {
	
	public static void main(String[] args) {
		
		TADListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<Integer>();
		
		listaEncadeada.imprimeLista();
		
		listaEncadeada.insereInicio(10);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.insereFinal(20);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.inserePosicao(12, 1);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.inserePosicao(14, 2);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.inserePosicao(18, 3);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.inserePosicao(16, 3);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.inserePosicao(22, 6);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.inserePosicao(22, 8);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.inserePosicao(22, -1);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.inserePosicao(8, 0);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.removePosicao(0);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.removePosicao(0);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.removePosicao(6);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.removePosicao(5);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.removePosicao(2);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.removePosicao(-1);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.removePosicao(4);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.removePosicao(3);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.removePosicao(1);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.removePosicao(0);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.removePosicao(0);
		listaEncadeada.imprimeLista();
		
		listaEncadeada.removePosicao(0);
		listaEncadeada.imprimeLista();
	}
	
}
