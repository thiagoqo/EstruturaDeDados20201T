package br.edu.ifce.computacao.estruturadedados.arvorebinaria;

public class TesteArvoreBinaria {

	public static void main(String[] args) {
		
		
		ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();
		
		arvore.insereRaiz(30);
		
		arvore.insereEsquerda(20, arvore.getRaiz());
		arvore.insereDireita(40, arvore.getRaiz());
		
		arvore.insereEsquerda(15, arvore.getRaiz().getEsq());
		arvore.insereDireita(25, arvore.getRaiz().getEsq());
		
		arvore.insereEsquerda(33, arvore.getRaiz().getDir());
		arvore.insereDireita(44, arvore.getRaiz().getDir());
		
		System.out.println("Caminhamento interfixado: ");
		arvore.imprimirInterfixado(arvore.getRaiz());
		
		System.out.println();
		System.out.println("Caminhamento pré-fixado:");
		arvore.imprimirPrefixado(arvore.getRaiz());
		
		System.out.println();
		System.out.println("Caminhamento pós-fixado:");
		arvore.imprimirPosfixado(arvore.getRaiz());
		System.out.println();
		
	}
}
