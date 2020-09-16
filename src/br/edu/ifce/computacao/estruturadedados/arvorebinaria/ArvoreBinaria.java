package br.edu.ifce.computacao.estruturadedados.arvorebinaria;

public class ArvoreBinaria<T> {

	private No<T> raiz;

	public ArvoreBinaria() {
		raiz = null;
	}

	/**
	 * Opera��es Principais
	 */
	public No<T> insereRaiz(T valor){

		if (raiz != null) {
			System.out.println("No raiz j� existe. Elemento n�o inserido.");
			return null;
		}
		raiz = new No<T>(valor, null, null, null);

		return raiz;
	}

	public No<T> insereEsquerda(T valor, No<T> noBase){
		
		if (noBase == null) {
			System.out.println("N� de refer�ncia n�o existe. Elemento n�o inserido.");
			return null;
		}
		
		if (noBase.getEsq() != null) {
			System.out.println("N� esquerda j� existe. Elemento n�o inserido.");
			return null;
		}
		
		No<T> novoNo = new No<T>(valor, noBase, null, null);
		noBase.setEsq(novoNo);
		
		return novoNo;
	}
	
	public No<T> insereDireita(T valor, No<T> noBase){
		
		if (noBase == null) {
			System.out.println("N� de refer�ncia n�o existe. Elemento n�o inserido.");
			return null;
		}
		
		if (noBase.getDir() != null) {
			System.out.println("N� direita j� existe. Elemento n�o inserido.");
			return null;
		}
		
		No<T> novoNo = new No<T>(valor, noBase, null, null);
		noBase.setDir(novoNo);
		
		return novoNo;
	}
	
	public void imprimirPrefixado(No<T> noBase) {
		if (noBase != null) {
			System.out.print(noBase.getValor() + "\t");
			imprimirPrefixado(noBase.getEsq());
			imprimirPrefixado(noBase.getDir());
		}
		
	}
	
	public void imprimirInterfixado(No<T> noBase) {
		if (noBase != null) {
			imprimirInterfixado(noBase.getEsq());
			System.out.print(noBase.getValor() + "\t");
			imprimirInterfixado(noBase.getDir());
		}
	}
	
	public void imprimirPosfixado(No<T> noBase) {
		if (noBase != null) {
			imprimirPosfixado(noBase.getEsq());
			imprimirPosfixado(noBase.getDir());
			System.out.print(noBase.getValor() + "\t");
		}
	}

	public No<T> getRaiz() {
		return raiz;
	}

	
	

}
