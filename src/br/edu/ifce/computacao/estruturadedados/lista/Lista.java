package br.edu.ifce.computacao.estruturadedados.lista;

public class Lista<T> implements TADLista<T> {

	private T[] lista;
	private int posicao;
	
	public Lista(int tamanho) {
		lista = (T[]) new Object[tamanho];
		posicao = -1;
	}
	
	@Override
	public void adicionaValor(T valor, int indice) {
		//Realiza validacoes - verifica se tem espaço disponivel
		if (listaCheia()) {
			System.out.println("Lista Cheia. Elemento " + valor + " não adicionado.");
			return;
		}
		//Verifica se o indice é válido
		if (indice < 0 || indice > posicao + 1) {
			System.out.println("Elemento não adicionado. Posicao " + indice + " inválida.");
			return;
		}
		
		//Desloca os elementos posteriores ao indice uma posição a direita 
		for (int i = posicao; i >= indice; i--) {
			lista[i + 1] = lista[i];
		}
		lista[indice] = valor;
		posicao++;
	}

	public T removeValor(int indice) {
		// Realiza validações 
		if (listaVazia()) {
			System.out.println("Lista vazia. Não há elementos para remoção");
			return null;
		}
		if (indice < 0 || indice > posicao) {
			System.out.println("Indice inválido. Elemento não removido.");
			return null;
		}
		
		T valorRemovido = lista[indice];
		
		// Desloca os elementos posteriores ao indice a esquerda
		for (int i = indice; i < posicao; i++) {
			lista[i] = lista[i + 1];
		}
		lista[posicao--] = null;
		
		return valorRemovido;
	}

	public boolean listaCheia() {
		if (posicao == lista.length - 1) {
			return true;
		}
		return false;
	}

	public boolean listaVazia() {
		if (posicao == -1) {
			return true;
		}
		return false;
	}

	
	public void imprimeLista() {
		
		for (int i = 0; i <= posicao; i++) {
			System.out.print(lista[i] + "\t");
		}
		System.out.println();
	
	}

}
