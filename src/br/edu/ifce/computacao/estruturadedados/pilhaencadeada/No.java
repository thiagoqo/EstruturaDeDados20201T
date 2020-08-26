package br.edu.ifce.computacao.estruturadedados.pilhaencadeada;

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
