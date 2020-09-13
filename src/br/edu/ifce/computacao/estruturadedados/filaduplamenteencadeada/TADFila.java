package br.edu.ifce.computacao.estruturadedados.filaduplamenteencadeada;

/**
 * TAD (Tipo Abstrato de Dados) que representa a Fila
 * 
 * @author Thiago Queiroz (thiago.queiroz@ifce.edu.br)
 * 
 * @since 12/08/2020
 */
public interface TADFila<T> {

	/**
	 *  Opera��es principais
	 */
	public void insereFinal(T valor);
	public T removeInicio();
	
	/**
	 * Opera��es secund�rias
	 */
	public boolean filaVazia();
	public void imprimeFila();
}
