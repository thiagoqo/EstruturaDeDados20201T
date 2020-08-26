package br.edu.ifce.computacao.estruturadedados.listaencadeada;

import br.edu.ifce.computacao.estruturadedados.pilhaencadeada.No;

public class ListaEncadeada<T> implements TADListaEncadeada<T> {

	private No<T> cabeca;
	private int tamanho;

	public ListaEncadeada() {
		cabeca = null;
		tamanho = 0;
	}


	@Override
	public void insereInicio(T valor) {
		No<T> novoNo = new No<T>(valor, null);

		if (cabeca == null) {
			cabeca = novoNo;
		} else {
			novoNo.setProximo(cabeca);
			cabeca = novoNo;
		}
		tamanho++;

	}

	@Override
	public void inserePosicao(T valor, int posicao) {

		//Verifica se a posição é válida
		if (posicao == 0) {
			insereInicio(valor);
			return;
		} else if (posicao == tamanho) {
			insereFinal(valor);
			return;
		} else if (posicao < 0 || posicao > tamanho) {
			System.out.println("Posição inválida " + posicao + " para inserção.");
			return;
		}

		//Inserir no meio da lista
		No<T> novoNo = new No<T>(valor, null);

		No<T> noAnteriorInsercao = cabeca;
		for (int i = 0; i < posicao - 1; i++) {
			noAnteriorInsercao = noAnteriorInsercao.getProximo();
		}

		No<T> noPosteriorInsercao = noAnteriorInsercao.getProximo();
		noAnteriorInsercao.setProximo(novoNo);
		novoNo.setProximo(noPosteriorInsercao);

		tamanho++;
	}

	@Override
	public void insereFinal(T valor) {

		No<T> novoNo = new No<T>(valor, null);

		if (cabeca == null) {
			cabeca = novoNo;
		} else {
			getCauda().setProximo(novoNo);
		}
		tamanho++;
	}

	@Override
	public T removePosicao(int posicao) {

		//Verifica se a posição é válida
		if (posicao < 0 || posicao >= tamanho) {
			System.out.println("Nó não removido. Posição inválida para remoção");
			return null;
		}

		No<T> noAnteriorRemocao = cabeca;

		//Encontra o nó anterior ao nó que será removido
		for(int i = 0; i < posicao - 1; i++) {
			noAnteriorRemocao = noAnteriorRemocao.getProximo();
		}

		No<T> noRemovido = noAnteriorRemocao.getProximo();

		//Remove do inicio
		if (posicao == 0) {
			noRemovido = cabeca;
			cabeca = noRemovido.getProximo();
		} else {
			noAnteriorRemocao.setProximo(noRemovido.getProximo());
			noRemovido.setProximo(null);
		}
		tamanho--;

		return noRemovido.getValor();
	}

	@Override
	public boolean listaVazia() {
		if (cabeca == null) {
			return true;
		}
		return false;
	}

	@Override
	public void imprimeLista() {
		//Realiza validações
		if(listaVazia()) {
			System.out.println("Lista Vazia. Não há elementos para impressão");
			return;
		}

		No<T> auxiliar = cabeca;

		while(auxiliar != null) {
			System.out.print(" => " + auxiliar.getValor());
			auxiliar = auxiliar.getProximo();
		}
		System.out.println();

	}

	public No<T> getCauda(){

		No<T> aux = cabeca;

		if (aux == null) {
			return null;
		}
		while (aux.getProximo() != null) {
			aux = aux.getProximo();
		}
		return aux;

	}

}
