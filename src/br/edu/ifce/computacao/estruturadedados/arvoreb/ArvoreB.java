package br.edu.ifce.computacao.estruturadedados.arvoreb;




public class ArvoreB {

	private int T; //ordem da arvore dividido por 2 ->OBS: A ordem e 2T

	// *INICIO DA CLASSE NODE *
	public class Node {
		int n;							// Numero atual de chaves
		int key[] = new int[2 * T - 1]; //tamanho (NUMERO) max de chaves  baseado na ordem
		Node child[] = new Node[2 * T]; // tamanho (NUMERO) max de filhos baseado na ordem
		boolean leaf = true;  // se e ou nao folha

		public int Find(int k) {		// Metodo para encontrar uma chave dentro da sequencia
			for (int i = 0; i < this.n; i++) { // de chaves do no. "n" serve como controle para
				if (this.key[i] == k) {			 // a iteracao
					return i;			// o laco retorna a chave passada como parametro 
				}
			}
			return -1;
		};
	}
	// *FIM DA CLASSE NODE *

	private Node root;  // NO RAIZ

	public ArvoreB(int t) { 
		T = t; //	ORDEM/2
		root = new Node(); 	// INSTANCIACAO DA RAIZ DA ARVORE
		root.n = 0;			// inicia com zero chaves
		root.leaf = true; // INICIALMENTE A RAIZ E UMA FOLHA POR AINDA NAO TER FILHOS
	}

	//					 * METODOS PRINCIPAIS *

	// METODO DE BUSCA
	private Node Search(Node x, int key) {
		int i = 0;
		if (x == null)		// SE FOR NULO ENCERRA A FUNCAO
			return x;

		// O LADO ABAIXO ITERA SOBRE AS CHAVES EXISTENTES DE X E
		// VERIFICA SE A CHAVE PASSADA COMO PARAMETRO
		// E MENOR A PARTIR DA	PRIMEIRA CHAVE DO NO
		for (i = 0; i < x.n; i++) {   
			if (key < x.key[i]) {	 
				break;				 
			}
			if (key == x.key[i]) {
				return x;
			}
		}
		if (x.leaf) {
			return null;
		} else {
			return Search(x.child[i], key);
		}
	}

	// split
	private void split(Node x, int pos, Node y) { //no pai e no filho
		Node z = new Node();
		z.leaf = y.leaf; 
		z.n = T - 1; 
		for (int j = 0; j < T - 1; j++) {
			z.key[j] = y.key[j + T];	// ARMAZENA EM Z DA POSICAO "T" PRA FRENTE
		}
		if (!y.leaf) {
			for (int j = 0; j < T; j++) {
				z.child[j] = y.child[j + T];
			}
		}
		y.n = T - 1;  //diminui o tamanho em um pela chave transferida para z
		for (int j = x.n; j >= pos + 1; j--) { // 
			x.child[j + 1] = x.child[j];		// O no filho e deslocado para o lado
		}
		x.child[pos + 1] = z;  // o no z toma o lugar antigo do no filho

		for (int j = x.n - 1; j >= pos; j--) {
			x.key[j + 1] = x.key[j];  //desloca a chave de x para abrir um espaco
		}
		x.key[pos] = y.key[T - 1]; // recebe a chave do filho a ser deslocada para a posicao que se abriu
		x.n = x.n + 1; // a quantidade de chaves de x aumenta
	}


	// insert 2
	final private void insert2(Node x, int k) { //x e o pai do inserido

		if (x.leaf) {
			int i = 0;
			for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
				x.key[i + 1] = x.key[i];
			}
			x.key[i  + 1] = k;
			x.n = x.n + 1;
		} else {
			int i = 0;
			for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
			}
			;
			i++;
			Node tmp = x.child[i];   //no temporario
			if (tmp.n == 2 * T - 1) { //verifica se esta cheio
				split(x, i, tmp);
				if (k > x.key[i]) {
					i++;
				}
			}
			insert2(x.child[i], k);  // chama recursivamente indo ate a raiz
		}							  // se necessario

	}

	// insert 1
	public void insert1(final int key) { 
		Node r = root;
		if (r.n == 2 * T - 1) { //caso da raiz cheia
			Node s = new Node();
			root = s;
			s.leaf = false;
			s.n = 0;
			s.child[0] = r;
			split(s, 0, r);
			insert2(s, key);
		} else {
			insert2(r, key);
		}
	}

	public void display() {
		display(root);
	}

	//metodo de remocao
	private void Remove(Node x, int key) {
		// * primeiro caso *
		int pos = x.Find(key);  // procura e armazena a pos. de key
		if (pos != -1) {
			if (x.leaf) {
				int i = 0;
				for (i = 0; i < x.n && x.key[i] != key; i++) {
				}
				;
				for (; i < x.n; i++) {
					if (i != 2 * T - 2) {
						x.key[i] = x.key[i + 1];   //remove key caso X seja folha
					}
				}
				x.n--;
				return;
			}
			//* segundo caso *
			if (!x.leaf) {

				Node pred = x.child[pos];
				int predKey = 0;
				if (pred.n >= T) { //verifica se tem >= 50% de ocupacao
					for (;;) {
						if (pred.leaf) {
							System.out.println(pred.n);
							predKey = pred.key[pred.n - 1];
							break;
						} else {
							pred = pred.child[pred.n];
						}
					}
					Remove(pred, predKey);
					x.key[pos] = predKey;
					return;
				}
				//* terceiro caso

				Node nextNode = x.child[pos + 1];
				if (nextNode.n >= T) { //verifica se tem >= 50% de ocupacao
					int nextKey = nextNode.key[0];
					if (!nextNode.leaf) {
						nextNode = nextNode.child[0];
						for (;;) {
							if (nextNode.leaf) {
								nextKey = nextNode.key[nextNode.n - 1];
								break;
							} else {
								nextNode = nextNode.child[nextNode.n];
							}
						}
					}
					Remove(nextNode, nextKey);
					x.key[pos] = nextKey;
					return;
				}
				// * quarto caso *
				int temp = pred.n + 1;
				pred.key[pred.n++] = x.key[pos];
				for (int i = 0, j = pred.n; i < nextNode.n; i++) {
					pred.key[j++] = nextNode.key[i];
					pred.n++;
				}
				for (int i = 0; i < nextNode.n + 1; i++) {
					pred.child[temp++] = nextNode.child[i];
				}

				x.child[pos] = pred;
				for (int i = pos; i < x.n; i++) {
					if (i != 2 * T - 2) {
						x.key[i] = x.key[i + 1];
					}
				}
				for (int i = pos + 1; i < x.n + 1; i++) {
					if (i != 2 * T - 1) {
						x.child[i] = x.child[i + 1];
					}
				}
				x.n--;
				if (x.n == 0) {
					if (x == root) {
						root = x.child[0];
					}
					x = x.child[0];
				}
				Remove(pred, key);
				return;
			}

			//* quinto caso */
		} else {
			for (pos = 0; pos < x.n; pos++) {
				if (x.key[pos] > key) {
					break;
				}
			}
			Node tmp = x.child[pos];
			if (tmp.n >= T) {
				Remove(tmp, key);
				return;
			}
			if (true) {
				Node nb = null;
				int devider = -1;

				if (pos != x.n && x.child[pos + 1].n >= T) {
					devider = x.key[pos];
					nb = x.child[pos + 1];
					x.key[pos] = nb.key[0];
					tmp.key[tmp.n++] = devider;
					tmp.child[tmp.n] = nb.child[0];
					for (int i = 1; i < nb.n; i++) {
						nb.key[i - 1] = nb.key[i];
					}
					for (int i = 1; i <= nb.n; i++) {
						nb.child[i - 1] = nb.child[i];
					}
					nb.n--;
					Remove(tmp, key);
					return;
				} else if (pos != 0 && x.child[pos - 1].n >= T) {

					devider = x.key[pos - 1];
					nb = x.child[pos - 1];
					x.key[pos - 1] = nb.key[nb.n - 1];
					Node child = nb.child[nb.n];
					nb.n--;

					for (int i = tmp.n; i > 0; i--) {
						tmp.key[i] = tmp.key[i - 1];
					}
					tmp.key[0] = devider;
					for (int i = tmp.n + 1; i > 0; i--) {
						tmp.child[i] = tmp.child[i - 1];
					}
					tmp.child[0] = child;
					tmp.n++;
					Remove(tmp, key);
					return;
				} else {
					Node lt = null;
					Node rt = null;
					boolean last = false;
					if (pos != x.n) {
						devider = x.key[pos];
						lt = x.child[pos];
						rt = x.child[pos + 1];
					} else {
						devider = x.key[pos - 1];
						rt = x.child[pos];
						lt = x.child[pos - 1];
						last = true;
						pos--;
					}
					for (int i = pos; i < x.n - 1; i++) {
						x.key[i] = x.key[i + 1];
					}
					for (int i = pos + 1; i < x.n; i++) {
						x.child[i] = x.child[i + 1];
					}
					x.n--;
					lt.key[lt.n++] = devider;

					for (int i = 0, j = lt.n; i < rt.n + 1; i++, j++) {
						if (i < rt.n) {
							lt.key[j] = rt.key[i];
						}
						lt.child[j] = rt.child[i];
					}
					lt.n += rt.n;
					if (x.n == 0) {
						if (x == root) {
							root = x.child[0];
						}
						x = x.child[0];
					}
					Remove(lt, key);
					return;
				}
			}
		}
	}

	public void Remove(int key) {
		Node x = Search(root, key);
		if (x == null) {
			return;
		}
		Remove(root, key);
	}

	public boolean Contain(int k) {
		if (this.Search(root, k) != null) {
			return true;
		} else {
			return false;
		}
	}

	// Show the node
	private void Show(Node x) {
		assert (x == null);
		for (int i = 0; i < x.n; i++) {
			System.out.print(x.key[i] + " ");
		}
		if (!x.leaf) {
			for (int i = 0; i < x.n + 1; i++) {
				Show(x.child[i]);
			}
		}
	}

	// Display the tree
	private void display(Node x) {
		assert (x == null);
		for (int i = 0; i < x.n; i++) {
			System.out.print(x.key[i] + " ");
		}
		if (!x.leaf) {
			for (int i = 0; i < x.n + 1; i++) {
				display(x.child[i]);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArvoreB b = new ArvoreB(3);
		b.insert1(8);
		b.insert1(9);
		b.insert1(10);
		b.insert1(11);
		b.insert1(15);
		b.insert1(20);
		b.insert1(17);
		b.display();
		System.out.println("\nRemovendo...");

		b.Remove(20);
		b.Remove(17);
		b.display();


	}
}
