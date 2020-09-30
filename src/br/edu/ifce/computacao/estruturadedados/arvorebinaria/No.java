package br.edu.ifce.computacao.estruturadedados.arvorebinaria;

public class No<T> {

	private T valor;
	private No<T> pai, esq, dir;
	
	
	public No(T valor, No<T> pai, No<T> esq, No<T> dir) {
		this.valor = valor;
		this.pai = pai;
		this.esq = esq;
		this.dir = dir;
	}
	
	
	public T getValor() {
		return valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	public No<T> getPai() {
		return pai;
	}
	public void setPai(No<T> pai) {
		this.pai = pai;
	}
	public No<T> getEsq() {
		return esq;
	}
	public void setEsq(No<T> esq) {
		this.esq = esq;
	}
	public No<T> getDir() {
		return dir;
	}
	public void setDir(No<T> dir) {
		this.dir = dir;
	}
	
	
	
	
}
