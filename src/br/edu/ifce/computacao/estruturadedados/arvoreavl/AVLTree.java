package br.edu.ifce.computacao.estruturadedados.arvoreavl;

/**
 *
 * @author User
 */
public class AVLTree {

    public class AVLNode {
        int valor;
        int altura;
        AVLNode esquerda;
        AVLNode direita;

        AVLNode(int key) {
            this.valor = key;
        }
    }

    private AVLNode raiz;

    public AVLNode encontrarNo(int v) {
        AVLNode noAtual = raiz;
        while (noAtual != null) {
            if (noAtual.valor == v) {
               break;
            }
            if (noAtual.valor < v){
                noAtual = noAtual.direita;
            }else{
                noAtual = noAtual.esquerda;
            }
        }
        return noAtual;
    }

    public void inserirNo(int v) {
        raiz = inserirNo(raiz, v);
    }

    public void removerNo(int v) {
        raiz = removerNo(raiz, v);
    }
    
    private AVLNode inserirNo(AVLNode no, int v) {
        if (no == null) {
            return new AVLNode(v);
        } else if (no.valor > v) {
            no.esquerda = inserirNo(no.esquerda, v);
        } else if (no.valor < v) {
            no.direita = inserirNo(no.direita, v);
        } else {
            throw new RuntimeException("Valor duplicado!");
        }
        return reequilibrar(no);
    }
    
    private AVLNode removerNo(AVLNode no, int v){  
        if (no == null){
            return no;
        }
        if (v < no.valor){
            no.esquerda = removerNo(no.esquerda, v);
        }else if (v > no.valor){
            no.direita = removerNo(no.direita, v);
        }else{
            if ((no.esquerda == null) || (no.direita == null)){
                AVLNode temp = null;
                if (no.esquerda == null){
                    temp = no.direita;
                }else{
                    temp = no.esquerda;
                }
                if (temp == null){  
                    temp = no;
                    no = null;
                }else{
                    no = temp;
                }
            }else{
                AVLNode temp = noMenorValor(no.direita);
                no.valor = temp.valor;
                no.direita = removerNo(no.direita, temp.valor);
            }
        }
        if (no == null){
            return no;
        }
        no = reequilibrar(no);
        return no;
    }

    private AVLNode noMenorValor(AVLNode node) {
        AVLNode atual = node;
        /* loop down to find the leftmost leaf */
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual;
    }

    private AVLNode reequilibrar(AVLNode z) {
        atualizarAltura(z);
        int equilibrio = getEquilibrio(z);
        if (equilibrio > 1) {
            if (altura(z.direita.direita) > altura(z.direita.esquerda)) {
                z = rotacionarEsquerda(z);
            } else {
                z.direita = rotacionarDireita(z.direita);
                z = rotacionarEsquerda(z);
            }
        } else if (equilibrio < -1) {
            if (altura(z.esquerda.esquerda) > altura(z.esquerda.direita)) {
                z = rotacionarDireita(z);
            } else {
                z.esquerda = rotacionarEsquerda(z.esquerda);
                z = rotacionarDireita(z);
            }
        }
        return z;
    }

    private AVLNode rotacionarDireita(AVLNode y) {
        AVLNode x = y.esquerda;
        AVLNode z = x.direita;
        x.direita = y;
        y.esquerda = z;
        atualizarAltura(y);
        atualizarAltura(x);
        return x;
    }

    private AVLNode rotacionarEsquerda(AVLNode y) {
        AVLNode x = y.direita;
        AVLNode z = x.esquerda;
        x.esquerda = y;
        y.direita = z;
        atualizarAltura(y);
        atualizarAltura(x);
        return x;
    }

    private void atualizarAltura(AVLNode n) {
        n.altura = 1 + Math.max(altura(n.esquerda), altura(n.direita));
    }

    private int altura(AVLNode n) {
        if(n != null){
            return n.altura;
        }
        return -1;
    }

    public int getEquilibrio(AVLNode n) {
        return (n == null) ? 0 : altura(n.direita) - altura(n.esquerda);
    }
    
    public void imprimirArvore(){
        imprimirArvore(raiz);
    }
    private void imprimirArvore(AVLNode n){
        if(n != null){
            imprimirArvore(n.esquerda);
            System.out.print(n.valor + "\t");
            imprimirArvore(n.direita);
        }
    }
}
