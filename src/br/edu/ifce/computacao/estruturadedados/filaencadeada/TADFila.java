package br.edu.ifce.computacao.estruturadedados.filaencadeada;

/**
 * TAD (Tipo Abstrato de Dados) que representa a Fila
 * 
 * @author Thiago Queiroz (thiago.queiroz@ifce.edu.br)
 * 
 * @since 12/08/2020
 */
public interface TADFila<T> {

	/**
	 *  Operações principais
	 */
	public void insereFinal(T valor);
	public T removeInicio();
	
	/**
	 * Operações secundárias
	 */
	public boolean filaVazia();
	public void imprimeFila();
}
