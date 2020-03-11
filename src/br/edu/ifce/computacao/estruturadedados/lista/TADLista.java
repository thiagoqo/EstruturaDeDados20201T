package br.edu.ifce.computacao.estruturadedados.lista;

/**
 * TAD Lista
 */
public interface TADLista<T> {
	
	//Metodos principais
	public void adicionaValor(T valor, int indice);
	public T removeValor(int indice);
	
	//Metodos secundarios
	public boolean listaCheia();
	public boolean listaVazia();
	public void imprimeLista();
	
}
