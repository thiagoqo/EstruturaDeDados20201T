package br.edu.ifce.computacao.estruturadedados.filaduplamenteencadeada;


public class FilaDuplamenteEncadeada<T> implements TADFila<T> {

	private No<T> header;
	private No<T> trailer;
	private int tamanho;
	
	public FilaDuplamenteEncadeada() {
		header = new No<T>(null, null, null); 
		trailer = new No<T>(null, header, null);
		header.setProximo(trailer);
		tamanho = 0;
	}
	
	
	@Override
	public void insereFinal(T valor) {
		
		No<T> novoNo = new No<T>(valor, null, null);
		
		trailer.getAnterior().setProximo(novoNo);
		novoNo.setAnterior(trailer.getAnterior());
		
		novoNo.setProximo(trailer);
		trailer.setAnterior(novoNo);
		
		tamanho++;
	}
	
	@Override
	public T removeInicio() {
		
		No<T> noRemovido = header.getProximo();
		
		header.setProximo(noRemovido.getProximo());
		noRemovido.getProximo().setAnterior(header);
		
		noRemovido.setProximo(null);
		noRemovido.setAnterior(null);
		
		tamanho--;
		
		return noRemovido.getValor();
	}
	
	@Override
	public boolean filaVazia() {
		if (tamanho == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public void imprimeFila() {
		if (filaVazia()) {
			System.out.println("Fila Vazia. Não há elementos para impressão.");
			return;
		}
		
		No<T> auxiliar = header;
		while(auxiliar != null) {
			System.out.print(auxiliar.getValor() + " <=> ");
			auxiliar = auxiliar.getProximo();
		}
		System.out.println();
		
	}
	
}
