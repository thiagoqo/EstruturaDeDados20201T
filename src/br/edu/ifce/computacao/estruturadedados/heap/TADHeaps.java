package br.edu.ifce.computacao.estruturadedados.heap;

public interface TADHeaps<T> {

    public void insereValor(T valor);
    public T deletePosicao(int posicao);
    public int posicaoPai(int i);
    public int posicaoFilhoDireito(int i);
    public int posicaoFilhoEsquerdo(int i);
    public boolean heapVazia();
    public boolean heapCheia();
    public void imprimeHeap();

}
