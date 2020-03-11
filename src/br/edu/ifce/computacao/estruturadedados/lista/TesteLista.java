package br.edu.ifce.computacao.estruturadedados.lista;

public class TesteLista {

	public static void main(String[] args) {

		TADLista<Integer> lista = new Lista<Integer>(5);

		lista.adicionaValor(8, 0);
		lista.imprimeLista();

		lista.adicionaValor(12, 1);
		lista.imprimeLista();

		lista.adicionaValor(10, 1);
		lista.imprimeLista();

		lista.adicionaValor(14, 4);
		lista.imprimeLista();

		lista.adicionaValor(14, 3);
		lista.imprimeLista();

		lista.adicionaValor(6, -1);
		lista.imprimeLista();

		lista.adicionaValor(16, 5);
		lista.imprimeLista();

		lista.adicionaValor(6, 0);
		lista.imprimeLista();

		lista.adicionaValor(9, 2);
		lista.imprimeLista();


		lista.removeValor(0);
		lista.imprimeLista();

		lista.removeValor(-1);
		lista.imprimeLista();

		lista.removeValor(4);
		lista.imprimeLista();

		lista.removeValor(1);
		lista.imprimeLista();

		lista.removeValor(0);
		lista.imprimeLista();

		lista.removeValor(0);
		lista.imprimeLista();

		lista.removeValor(0);

	}

}
