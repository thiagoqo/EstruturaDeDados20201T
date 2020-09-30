package br.edu.ifce.computacao.estruturadedados.hash;

public interface TADLista<T> {
    	
	//Metodos principais
	
	public void insereValor(T valor, T descricao);
	public T removeValor(T valor);
	public No<T> buscarValor(T valor);
	
	//Metodos secundarios
	
	public boolean listaVazia();
	public void imprimeLista();
	
}
