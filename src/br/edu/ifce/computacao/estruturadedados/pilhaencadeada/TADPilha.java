package br.edu.ifce.computacao.estruturadedados.pilhaencadeada;

/**
 * TAD (Tipo Abstrato de Dados) referente a Pilha
 * 
 * @author Thiago Queiroz (thiago.queiroz@ifce.edu.br)
 *
 * @since 12/08/2020
 */
public interface TADPilha<T> {

	/**
	 * Operações principais
	 */
	public void insereTopo(T valor);
	public T removeTopo();
	
	/**
	 * Operações secundárias
	 */
	public boolean pilhaVazia();
	public void imprimePilha();
	
}
