package br.edu.ifce.computacao.estruturadedados.arvorerubronegra;



public class ArvoreRubroNegra {
    private NoRubro raiz;

    // método básico que retorna o nó raiz da árvore
    public NoRubro getRaiz() {
        return raiz;
    }

    // método de inserção de um valor que não esteja presente nos nós abaixo do nó passado como parâmetro
    public NoRubro insereNo(Integer valor, NoRubro noBase) {
        //Caso 1 (o nó a ser inserido é o raiz.Portanto, será da cor preta)
        if (raiz == null) {
            raiz = new NoRubro(valor, null, null, null, false);
            return raiz;
        }
        // checa se o valor é igual ao valor do nó que a função recebeu como parâmetro
        if (valor == noBase.getValor()) {
            System.out.println("Nó já inserido");
            return null;
        } else {
            // criando o objeto para ser retornado pela função, pode retornar nulo.
            NoRubro noInserido;

            // verificando se novo nó deverá ficar à direita do nó Base
            if (valor > noBase.getValor()) {
                // verifica se tem filho direito
                if (noBase.getDir() == null) {
                    //criando um novo nó que segundo a doutrina deve ser vermelho
                    NoRubro novoNo = new NoRubro(valor, noBase, null, null, true);
                    noBase.setDir(novoNo);
                    /*
                    * Atenção: caso a árvore tenha no máximo 2 nós, este retorno é válido sem a necessidade
                    * dos balanceamentos pois obrigatóriamente o nó acima dele é raiz e negro
                    * */
                    return novoNo;
                } else {
                    // chamada recursiva, pegando o filho da direita e passando como parâmetro
                    noInserido = insereNo(valor, noBase.getDir());
                }

            // situação análoga, agora o elemento está sendo inserido à esquerda do no Base
            } else {
                if (noBase.getEsq() == null) {
                    NoRubro novoNo = new NoRubro(valor, noBase, null, null, true);
                    noBase.setEsq(novoNo);
                    return novoNo;
                } else {
                    noInserido = insereNo(valor, noBase.getEsq());
                }
            }
            // checagem de segurança para evitar nullPointerException
            // noInserido pode ser nulo caso o valor passado para inserção já estiver presente na árvore
            if (noInserido != null) {
                /*
                * chamada em sequência para o rebalanceamento da árvore a partir do nó inserido
                * (caso suas propriedades sejam violadas)
                * */
                fixCaso1(noInserido);
            }

            // retornando o nó inserido após o balanceamento da árvore
            return noInserido;
        }
    }

    // esta função tem o objetivo de confirmar a cor preta da raiz
    private void fixCaso1(NoRubro n) {

        if (n.getPai() == null) {
            // a raiz vermelha viola uma das propriedades
            /*
            * caso ela seja vermelha, pintá-la de preto não violará nenhuma propriedade
            * */
            n.setRubro(false);
        } else {
            // no caso do nó inserido não ser a raiz, ocorre a chamada do caso2
            fixCaso2(n);
        }
    }

    private void fixCaso2(NoRubro n) {
        // se o pai do nó inserido é vermelho, temos a propriedade do filho de nós vermelhos violada
        if (n.getPai().isRubro()) {
            fixCaso3(n);
        }
        //se o pai do nó inserido é preto, o número de caminhos pretos não mudou e a árvore está balanceada
    }

    private void fixCaso3(NoRubro n) {
        // pegando o tio do nó
        NoRubro tio = n.getTio();
        //checando se o tio é não nulo e vermelho
        if (tio != null && tio.isRubro()) {
            NoRubro pai = n.getPai();
            pai.setRubro(false);        // podemos pintar o pai e o tio de preto. Assim, em cada lado
            tio.setRubro(false);        // a altura negra aumenta em 1
            NoRubro avo = pai.getPai();
            avo.setRubro(true);         // para concertar isso, podemos mudar o avô do nó para vermelho
            fixCaso1(avo);              // então temos que voltar "recursivamente" para o caso 1 pois há a
                                        // possibilidade do avô ser a raiz
        } else {
            // caso o tio seja nulo ou preto, serão feitas algumas rotações para balancear a árvore
            // e manter suas propriedades
            fixCaso4(n);
        }
    }

    private void fixCaso4(NoRubro n) {
        NoRubro pai = n.getPai();
        NoRubro avo = n.getAvo();
        if (n.isHigher(pai) && avo.isHigher(pai)) {
            // sistema de rotação 1: visualmente, será verificado se o conjunto {filho, pai, avo}
            // formam um "c"
            /*
             *        avo
             *       /
             *    pai
             *      \
             *      filho
             *
             * em muitos casos esta se trata apenas de uma preparação para uma futura rotação à direita
             * que será vista no fixCaso5
             * */
            rotacaoAEsquerda(n);
            /*
            *  Resultado:    Avo
            *               /
            *           "filho"
            *            /
            *         "pai"
            *
            * */
            // agora o nó julgado deverá ser o que está mais abaixo, ou seja, pai
            n = n.getEsq();
        } else if (pai.isHigher(n) && pai.isHigher(avo)) {
            // sistema de rotação 2: visualmente, será verificado se o conjunto {filho, pai, avo}
            // formam um "c" invertido
            /*
             *        avo
             *          \
             *           pai
             *          /
             *      filho
             *
             * em muitos casos esta se trata apenas de uma preparação para uma futura rotação à esquerda
             * que será vista no fixCaso5
             * */
            rotacaoADireita(n);
            /*
             *  Resultado:    Avo
             *                  \
             *                 "filho" (vermelho)
             *                     \
             *                     "pai" (vermelho)
             *
             * */
            // agora o nó julgado deverá ser o que está mais abaixo, ou seja, pai
            n = n.getDir();
        }

        // agora podemos ir para o caso 5
        fixCaso5(n);
    }

    private void fixCaso5(NoRubro n) {
        NoRubro avo = n.getAvo();
        NoRubro pai = n.getPai();

        avo.setRubro(true);       // sem se preocupar com a raiz, o avô pode ser rubro pois será rotado
                                  // e se tornará pai
        pai.setRubro(false);      // o pai (que se tornará avô) será preto para que se mantenha a altura
                                  // negra da árvore
        if (pai.isHigher(n) && avo.isHigher(pai)) {
            /*
            * como o avô é quem deverá ser jogado para baixo, a rotação é feita utilizando pai
            *
            *          avo (vermelho)
            *         /
            *       pai (preto)
            *      /
            *   filho (vermelho)
            *
            *
            * */
            rotacaoADireita(pai);
            /*
            * Resultado
            *             pai (preto)
            *            /   \
            *        filho   avo
            *   (vermelho)  (vermelho)
            * */
        } else {
            /*
             * analogamente:
             *
             *          avo (vermelho)
             *             \
             *              pai (preto)
             *                 \
             *                 filho (vermelho)
             *
             *
             * */
            rotacaoAEsquerda(pai);
            /*
             * Resultado
             *             pai (preto)
             *            /   \
             *          avo    filho
             *   (vermelho)  (vermelho)
             * */
        }
    }

    public void insereNo(Integer valor) {
        insereNo(valor, getRaiz());
    }

    private void rotacaoAEsquerda(NoRubro noFilho) {
        /*
        * A princípio, temos:
        *
        *              avo (pode ser nulo)
        *               |
        *              pai
        *             /   \
        *        irmao    filho
        *                 /
        *              neto (pode ser nulo)
        *
        * */


        NoRubro pai = noFilho.getPai();
        System.out.println("rotação à esquerda: " + pai.getValor());
        if (pai == raiz) {
            System.out.println("trocando a raiz...");
            raiz = noFilho;
        }
        pai.setDir(noFilho.getEsq());     // neto agora é filho direito de pai
        if (pai.getDir() != null) {
            pai.getDir().setPai(pai);     // caso exista, neto agora é filho de pai
        }
        noFilho.setEsq(pai);              // filho é pai de pai
        noFilho.setPai(pai.getPai());     // filho se torna filho de avo

        if (noFilho.getPai() != null) {
            if (noFilho.getPai().isHigher(noFilho)) {
                noFilho.getPai().setEsq(noFilho);
            } else {
                noFilho.getPai().setDir(noFilho);    // caso exista, avo agora é pai de filho
            }
        }
        pai.setPai(noFilho);              // pai vira filho de filho

        /*
         * Resultado
         *              avo (pode ser nulo)
         *               |
         *             filho
         *             /   \
         *           pai
         *          /   \
         *      irmao  neto
         *            (pode ser nulo)
         *
         * */
    }

    private void rotacaoADireita(NoRubro noFilho) {
        /*
         * A princípio, temos:
         *
         *              avo
         *               |
         *              pai
         *             /   \
         *        filho    irmao
         *           \
         *          neto
         *
         * */
        NoRubro pai = noFilho.getPai();
        System.out.println("rotação à direita: " + pai.getValor());
        if (pai == raiz) {
            System.out.println("trocando a raiz");
            raiz = noFilho;
        }
        pai.setEsq(noFilho.getDir());
        if (pai.getEsq() != null) {
            pai.getEsq().setPai(pai);
        }
        noFilho.setDir(pai);
        noFilho.setPai(pai.getPai());
        if (noFilho.getPai() != null) {
            if (noFilho.getPai().isHigher(noFilho)) {
                noFilho.getPai().setEsq(noFilho);
            } else {
                noFilho.getPai().setDir(noFilho);
            }
        }
        pai.setPai(noFilho);
        /*
         * Resultado
         *              avo (pode ser nulo)
         *               |
         *             filho
         *             /   \
         *                 pai
         *                /   \
         *             neto   irmão
         *
         * */
    }

    public NoRubro pesquisaValor(Integer valor, NoRubro noBase) {
        if (noBase == null) {
            return null;
        }
        if (valor == noBase.getValor()) {
            return noBase;
        }
        if (valor < noBase.getValor()) {
            return pesquisaValor(valor, noBase.getEsq());
        } else {
            return pesquisaValor(valor, noBase.getDir());
        }
    }

    public NoRubro pesquisaValor(Integer valor) {
        return pesquisaValor(valor, getRaiz());
    }

    public void imprimirInterfixado() {
        System.out.println(raiz.getValor() + " é a raiz");
        imprimirInterfixado(raiz);
    }

    public void imprimirInterfixado(NoRubro noBase) {
        if (noBase != null) {
            imprimirInterfixado(noBase.getEsq());
            System.out.print(noBase.getValor() + " " + noBase.getCor() + "\t");
            imprimirInterfixado(noBase.getDir());
        }
    }

    public NoRubro removeValor(Integer valor){
        return removeValor(valor, raiz);
    }

    public NoRubro removeValor(Integer valor, NoRubro noBase){
        NoRubro noRemovido = pesquisaValor(valor,noBase);
        if (noRemovido == null){
            System.out.println("Elemento não encontrado");
            return null;
        }
        if (noRemovido.getValor() == valor){
            if (isFolha(noRemovido)){
                return ejetaNoFolha(noRemovido);
            } else {
                NoRubro noSucessor;
                if(noRemovido.getDir() != null){
                    noSucessor = noRemovido.getDir();
                    while (noSucessor.getEsq() != null){
                        noSucessor = noSucessor.getEsq();
                    }
                }else {
                    noSucessor = noRemovido.getEsq();
                    while (noSucessor.getDir() != null){
                        noSucessor = noSucessor.getDir();
                    }
                }
                noRemovido.setValor(noSucessor.getValor());
                if (!noRemovido.isRubro() && !noSucessor.isRubro() && isFolha(noSucessor)){
                    fixRemocao(noSucessor);
                }
                removeValor(noSucessor.getValor(),noSucessor);
                return noRemovido;
            }
        }else{
            System.out.println("Erro");
            return null;
        }
    }

    private void fixRemocao(NoRubro noSucessor) {
        NoRubro pai = noSucessor.getPai();
        NoRubro irmao = noSucessor.getIrmao();
        System.out.println("Fix");
        if(isFolha(noSucessor) && irmao != null && !irmao.isRubro() && isFolha(irmao) && pai.isRubro()) {
            irmao.setRubro(true);
            pai.setRubro(false);
        } else if(!pai.isRubro() && !irmao.isRubro() && isFolha(irmao)){
            irmao.setRubro(true);
        } else if (!pai.isRubro() && !irmao.isRubro() && !isFolha(irmao)){
            pai.setRubro(true);
            rotacaoADireita(irmao);
        }
    }

    public boolean isFolha(NoRubro no){
        return no.getEsq() == null && no.getDir() == null;
    }

    public NoRubro ejetaNoFolha(NoRubro no){
        Integer valor = no.getValor();
        NoRubro noPai = no.getPai();
        if (noPai.getEsq() != null && noPai.getEsq().getValor() == valor){
            noPai.setEsq(null);
        }
        if (noPai.getDir() != null && noPai.getDir().getValor() == valor){
            noPai.setDir(null);
        }
        no.setPai(null);
        if (no == raiz){
            raiz = null;
        }
        return no;
    }

    public int alturaNegra(){
        return alturaNegra(raiz);
    }

    public int alturaNegra(NoRubro noBase){
        if (noBase == null){
            return 1;            //como nós nil também são tratados como pretos, adicionamos eles na contagem
        } else if(noBase.isRubro()){
            return Math.max(alturaNegra(noBase.getEsq()),alturaNegra(noBase.getDir()));
        } else{
            return Math.max(alturaNegra(noBase.getEsq()),alturaNegra(noBase.getDir())) + 1;
        }
    }

    public int alturaNo(NoRubro noBase){
        if (noBase == null || isFolha(noBase)){
            return 0;
        } else {
            return Math.max(alturaNo(noBase.getEsq()),alturaNo(noBase.getDir())) + 1;
        }
    }

    public int profundidade(NoRubro noBase){
        if (noBase == null || noBase.equals(raiz)){
            return 0;
        } else {
            return profundidade(noBase.getPai()) + 1;
        }
    }




    /*
    * função criada sem optimização, apenas para visualização do programador
    * NÃO RECOMENDADA
    * */
    public void imprimeGalho(){
        for(int i = 0; i <= alturaNo(raiz); i++){
            imprimeGalho(raiz, i);
            System.out.println("");

        }
    }

    private void imprimeGalho(NoRubro noBase, int profundidade) {
        if (noBase != null){
            if (profundidade(noBase) == profundidade) {
                System.out.print(noBase.getValor() + " " + noBase.getCor() + "\t");
            }
            imprimeGalho(noBase.getEsq(), profundidade);
            imprimeGalho(noBase.getDir(), profundidade);
        }
    }

    // esta função checa nó por nó e verifica se o caminho esquerdo tem o mesmo número de nós preto
    // que o caminho direito de forma recursiva caminhando em direção às folhas
    public boolean isRubroNegra(){
        return isRubroNegra(raiz);
    }

    public boolean isRubroNegra(NoRubro noRubro){
        if (noRubro != null || isFolha(noRubro)){
            return true;
        }
        System.out.println("esq "+ alturaNegra(noRubro.getEsq()));
        System.out.println("dir "+ alturaNegra(noRubro.getDir()));
        return alturaNegra(noRubro.getEsq()) == alturaNegra(noRubro.getDir())
                && isRubroNegra(noRubro.getEsq())
                && isRubroNegra(noRubro.getDir());
    }

}