package br.edu.ifce.computacao.estruturadedados.filaencadeada;

/**
 * Classe que representa os elementos da minha fila
 * 
 * @author Thiago Queiroz (thiago.queiroz@ifce.edu.br)
 *
 * @since 12/08/2020
 */
public class No<T> {

	private T valor;
	private No proximo;
	
	public No(T valor, No proximo) {
		this.valor = valor;
		this.proximo = proximo;
	}
	
	public T getValor() {
		return valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	public No getProximo() {
		return proximo;
	}
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	
	
	
}
