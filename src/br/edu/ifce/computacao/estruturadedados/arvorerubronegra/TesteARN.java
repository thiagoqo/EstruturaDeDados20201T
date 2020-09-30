package br.edu.ifce.computacao.estruturadedados.arvorerubronegra;

public class TesteARN {
    public static void main(String[] args) {
        teste1();

    }

    public static void teste1() {
        ArvoreRubroNegra arvoreRubroNegra = new ArvoreRubroNegra();

        arvoreRubroNegra.insereNo(30);
        arvoreRubroNegra.imprimirInterfixado();
        System.out.println("");
        arvoreRubroNegra.insereNo(10);
        arvoreRubroNegra.imprimirInterfixado();
        System.out.println("");
        arvoreRubroNegra.insereNo(30);
        arvoreRubroNegra.imprimirInterfixado();
        System.out.println("");
        arvoreRubroNegra.insereNo(70);
        arvoreRubroNegra.imprimirInterfixado();
        System.out.println("");
        arvoreRubroNegra.insereNo(90);
        arvoreRubroNegra.imprimirInterfixado();
        System.out.println("\n");
//        arvoreRubroNegra.insereNo(30);
//        arvoreRubroNegra.imprimirInterfixado();
//        System.out.println("");
//        arvoreRubroNegra.insereNo(40);
//        arvoreRubroNegra.imprimirInterfixado();
//        System.out.println("");
//        arvoreRubroNegra.insereNo(45);
//        arvoreRubroNegra.imprimirInterfixado();
//        System.out.println("");
//        arvoreRubroNegra.insereNo(50);
//        arvoreRubroNegra.imprimirInterfixado();
//        System.out.println("");
//        arvoreRubroNegra.insereNo(7);
//        arvoreRubroNegra.imprimirInterfixado();
//        System.out.println("");
        //arvoreRubroNegra.imprimeGalho();

        arvoreRubroNegra.removeValor(30);
        arvoreRubroNegra.imprimirInterfixado();
        System.out.println("");
        arvoreRubroNegra.removeValor(70);
        arvoreRubroNegra.imprimirInterfixado();
        System.out.println("");

        arvoreRubroNegra.removeValor(90);
        arvoreRubroNegra.imprimirInterfixado();
        System.out.println("");
        System.out.println("Rubro Negra?: " + arvoreRubroNegra.isRubroNegra());

    }

    public static void teste2() {
        ArvoreRubroNegra arvoreRubroNegra2 = new ArvoreRubroNegra();
        arvoreRubroNegra2.insereNo(70);
        arvoreRubroNegra2.imprimirInterfixado();
        System.out.println("\n");
        arvoreRubroNegra2.insereNo(50);
        arvoreRubroNegra2.imprimirInterfixado();
        System.out.println("\n");
        arvoreRubroNegra2.insereNo(40);
        arvoreRubroNegra2.imprimirInterfixado();
        System.out.println("\n");
        arvoreRubroNegra2.insereNo(45);
        arvoreRubroNegra2.imprimirInterfixado();
        System.out.println("\n");
        arvoreRubroNegra2.insereNo(60);
        arvoreRubroNegra2.imprimirInterfixado();
        System.out.println("\n");
        arvoreRubroNegra2.insereNo(75);
        arvoreRubroNegra2.imprimirInterfixado();
        System.out.println("\n");
        arvoreRubroNegra2.insereNo(20);
        arvoreRubroNegra2.imprimirInterfixado();
        System.out.println("\n");
        arvoreRubroNegra2.insereNo(25);
        arvoreRubroNegra2.imprimirInterfixado();
        System.out.println("\n");
        arvoreRubroNegra2.insereNo(35);
        arvoreRubroNegra2.imprimirInterfixado();
        System.out.println("\n");
        arvoreRubroNegra2.insereNo(30);
        arvoreRubroNegra2.imprimirInterfixado();
        System.out.println("\n");

        System.out.println("Rubro Negra?: " + arvoreRubroNegra2.isRubroNegra());
        System.out.println("\nAltura negra: " + arvoreRubroNegra2.alturaNegra()+ "\n\n");

        arvoreRubroNegra2.imprimeGalho();
        System.out.println("\n");

        arvoreRubroNegra2.removeValor(40);
        arvoreRubroNegra2.imprimirInterfixado();
        System.out.println("");
        arvoreRubroNegra2.removeValor(30);
        arvoreRubroNegra2.imprimirInterfixado();
        System.out.println("");
        arvoreRubroNegra2.removeValor(70);
        arvoreRubroNegra2.imprimirInterfixado();
        System.out.println("");
        System.out.println("Rubro Negra?: " + arvoreRubroNegra2.isRubroNegra());
        arvoreRubroNegra2.imprimeGalho();

    }
}