package br.edu.ifce.computacao.estruturadedados.listaduplamenteencadeada;

public interface TADListaDuplamenteEncadeada<T> {
	
	/**
	 * Opera��es principais
	 */
	public void insereValor(T valor, int posicao);
	public T removeValor(int posicao);
	
	/**
	 * Opera��es secund�rias
	 */
	public boolean listaVazia();
	public void imprimeLista();
	
}
