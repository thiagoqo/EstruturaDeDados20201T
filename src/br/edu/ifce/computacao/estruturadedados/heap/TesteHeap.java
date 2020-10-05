package br.edu.ifce.computacao.estruturadedados.heap;

public class TesteHeap {
	public static void main(String[] args) {

		TADHeaps<Integer> heap = new Heap<Integer>(10);

		heap.imprimeHeap();

		heap.insereValor(40);
		heap.imprimeHeap();

		heap.insereValor(50);
		heap.imprimeHeap();

		heap.insereValor(30);
		heap.imprimeHeap();

		heap.insereValor(35);
		heap.imprimeHeap();

		heap.insereValor(38);
		heap.imprimeHeap();

		heap.insereValor(45);
		heap.imprimeHeap();

		heap.deletePosicao(3);
		heap.imprimeHeap();

		heap.insereValor(60);
		heap.imprimeHeap();

		heap.deletePosicao(2);
		heap.imprimeHeap();

	}

}
