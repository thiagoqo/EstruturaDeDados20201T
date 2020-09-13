package br.edu.ifce.computacao.estruturadedados.listaduplamenteencadeada;

public class No<T> {

	private No<T> anterior;
	private T valor;
	private No<T> posterior;
	
	public No(No<T> anterior, T valor, No<T> posterior) {
		this.anterior = anterior;
		this.valor = valor;
		this.posterior = posterior;
	}
	
	public No<T> getAnterior() {
		return anterior;
	}
	public void setAnterior(No<T> anterior) {
		this.anterior = anterior;
	}
	public T getValor() {
		return valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	public No<T> getPosterior() {
		return posterior;
	}
	public void setPosterior(No<T> posterior) {
		this.posterior = posterior;
	}
	
	
	
}
