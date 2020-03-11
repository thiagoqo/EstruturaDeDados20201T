package br.edu.ifce.computacao.estruturadedados.pilha;

public interface Pilha {
	
	/**
	 * Operações principais
	 */
	public void adicionaTopo(Integer valor);
	public Integer removeTopo();
	
	/**
	 * Operações secundárias
	 */
	public boolean pilhaCheia();
	public boolean pilhaVazia();
	public void imprime();

}
