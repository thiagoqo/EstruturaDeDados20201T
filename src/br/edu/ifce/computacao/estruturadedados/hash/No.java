package br.edu.ifce.computacao.estruturadedados.hash;

public class No<T> {
    private T valor;
	private T descricao;
	private No<T> anterior;
	private No<T> proximo;
	
	public No(No<T> anterior, T valor, T descricao, No<T> proximo ) {
		this.anterior = anterior;
		this.valor = valor;
		this.proximo = proximo;
		this.descricao = descricao;
	}
	
	public T getValor() {
		return valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	public T getDescricao() {
		return descricao;
	}
	public void setDescricao(T descricao) {
		this.descricao = descricao;
	}
	public No<T> getAnterior() {
		return anterior;
	}
	public void setAnterior(No<T> anterior) {
		this.anterior = anterior;
	}
	public No<T> getProximo() {
		return proximo;
	}
	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}
}
