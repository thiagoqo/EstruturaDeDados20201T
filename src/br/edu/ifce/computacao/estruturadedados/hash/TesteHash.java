package br.edu.ifce.computacao.estruturadedados.hash;



public class TesteHash {
    public static void main(String[] args) throws Exception {
		DicionarioHash teste = new DicionarioHash();
        teste.addTabela("Amazonia", "Maior floresta tropical");
		teste.addTabela("Amor", "Sentimento afetivo que faz com que a pessoa queira o bem de outra.");
		
		teste.buscaPalavra("Amor");
		teste.excluirItem("Amor");
		teste.addTabela("Amor", "Sentimento afetivo que faz com que a pessoa queira o bem de outra.");
		teste.addTabela("Amaonia", "Maior floresta tropical");
		teste.buscaPalavra("Amazonia");
		teste.buscaPalavra("Amor");
		teste.buscaPalavra("ABLUBLBE");
                
    }
}
