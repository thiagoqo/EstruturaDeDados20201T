package br.edu.ifce.computacao.estruturadedados.filaduplamenteencadeada;

/**
 * Classe que representa os elementos da minha fila
 * 
 * @author Thiago Queiroz (thiago.queiroz@ifce.edu.br)
 *
 * @since 31/08/2020
 */
public class No<T> {

	private T valor;
	private No<T> proximo;
	private No<T> anterior;
	
	public No(T valor, No<T> anterior, No<T> proximo) {
		this.valor = valor;
		this.anterior = anterior;
		this.proximo = proximo;
	}
	
	public T getValor() {
		return valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	
	

	public No<T> getProximo() {
		return proximo;
	}

	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}

	public No<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(No<T> anterior) {
		this.anterior = anterior;
	}
	
	
	
	
	
}
