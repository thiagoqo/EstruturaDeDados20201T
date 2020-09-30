package br.edu.ifce.computacao.estruturadedados.hash;


public class Lista<T> implements TADLista<T> {
	
	private No<T> header;
	private No<T> trailer;
	private int tamanho;
	
	public Lista() {
		header  = new No(null, null, null, null);
		trailer = new No(header, null, null, null);
		
		header.setProximo(trailer);
		tamanho = 0;
	}

	@Override
	public void insereValor(T valor, T descricao) {
		
		No<T> novoNo = new No<T>(null, valor, descricao, null);
		
		trailer.getAnterior().setProximo(novoNo);
		novoNo.setAnterior(trailer.getAnterior());
		novoNo.setProximo(trailer);
		trailer.setAnterior(novoNo);
		
		tamanho ++;
	}

	@Override
	public T removeValor(T valor) {
		
		if(listaVazia()) {
			System.out.println("Lista vazia");
			return null;
		}
		
		No<T> noRemovido;
		No<T> noAuxiliar = header;
		
		for (int i = 0; i < tamanho; i ++) {
			noAuxiliar = noAuxiliar.getProximo();
			if(noAuxiliar.getValor() == valor) {
				break;
			}
		}
		
		noAuxiliar.getAnterior().setProximo(noAuxiliar.getProximo());
		noAuxiliar.getProximo().setAnterior(noAuxiliar.getAnterior());
		noAuxiliar.setAnterior(null);
		noAuxiliar.setProximo(null);
		
		noRemovido = noAuxiliar;
		
		tamanho --;
		
		
		return noRemovido.getValor();
	}

	public No<T> buscarValor(T valor){
		No<T> noAuxiliar = header;
		if(listaVazia()){
			return null;
		}

		while(noAuxiliar.getProximo() != null){
			if(noAuxiliar.getValor() == valor){
				return noAuxiliar;
			}
			noAuxiliar = noAuxiliar.getProximo();
		}
		return null;
	}

	@Override
	public boolean listaVazia() {
		if(header.getProximo().equals(trailer)) {
			return true;
		}
		return false;
	}

	@Override
	public void imprimeLista() {
		
		if (listaVazia()) {
			System.out.println("lista estar vazia");
			return;
		}
		
		No<T> auxiliar = header;
		while (auxiliar != null) {
			System.out.println(auxiliar.getValor() + ": " +  auxiliar.getDescricao());
			auxiliar = auxiliar.getProximo();
		}
		
		System.out.println();
		
		
	}

}
