package br.edu.ifce.computacao.estruturadedados.heap;

public class Heap<T> implements TADHeaps<T> {

	private T[] heap;
	private int tamanhoHeap;

	public Heap(int tamanho) {
		this.tamanhoHeap = 0;
		heap = (T[]) new Object[tamanho];
	}


	@Override
	public void insereValor(T valor) {
		if(heapCheia()){
			System.out.println("Impossivel inserir valor");
			return;
		}

		heap[tamanhoHeap] = valor;
		int pos = tamanhoHeap;

		T auxiliar = heap[tamanhoHeap];

		while (pos > 0 && auxiliar.toString().compareTo(heap[posicaoPai(pos)].toString()) > 0)
		{
			heap[pos] = heap[posicaoPai(pos)];
			pos = posicaoPai(pos);
		}
		heap[pos] = auxiliar;
		tamanhoHeap++;
	}

	@Override
	public T deletePosicao(int posicao) {
		if(heapVazia()){
			System.out.println("Impossivel deletar valor");
			return null;
		}

		T deletar = heap[posicao];
		heap[posicao] = heap[tamanhoHeap -1];
		tamanhoHeap--;

		int filho;
		T auxiliar = heap[posicao];

		while(posicaoFilhoEsquerdo(posicao) < tamanhoHeap){
			filho = posicaoFilhoMaximo(posicao);

			if(auxiliar.toString().compareTo(heap[filho].toString()) < 0 ){
				heap[posicao] = heap[filho];
			} else {
				break;
			}
			posicao = filho;
		}

		heap[posicao] = auxiliar;
		return deletar;
	}

	private int posicaoFilhoMaximo(int i) {
		int filhoEsquerda = posicaoFilhoEsquerdo(i);
		int filhoDireita = posicaoFilhoDireito(i);
		return heap[filhoEsquerda].toString().compareTo(heap[filhoDireita].toString()) < 0 ? filhoEsquerda : filhoDireita;
	}

	@Override
	public int posicaoPai(int i) {
		return (i - 1) / 2;
	}

	@Override
	public int posicaoFilhoDireito(int i) {
		return (i * 2 + 1) + 1;
	}

	@Override
	public int posicaoFilhoEsquerdo(int i) {
		return (i * 2 + 1);
	}

	@Override
	public boolean heapVazia() {
		return tamanhoHeap == 0;
	}

	@Override
	public boolean heapCheia() {
		return tamanhoHeap == heap.length;
	}

	@Override
	public void imprimeHeap() {
		if(heapVazia()){
			System.out.println("Impossivel imprimir valores");
			return;
		}

		System.out.print("Heap = ");
		for (int i = 0; i < tamanhoHeap; i++)
			System.out.print(heap[i] +" ");
		System.out.println();
	}
}