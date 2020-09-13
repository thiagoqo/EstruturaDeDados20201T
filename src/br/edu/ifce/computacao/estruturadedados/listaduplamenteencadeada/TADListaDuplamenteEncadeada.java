package br.edu.ifce.computacao.estruturadedados.listaduplamenteencadeada;

public interface TADListaDuplamenteEncadeada<T> {
	
	/**
	 * Operações principais
	 */
	public void insereValor(T valor, int posicao);
	public T removeValor(int posicao);
	
	/**
	 * Operações secundárias
	 */
	public boolean listaVazia();
	public void imprimeLista();
	
}
