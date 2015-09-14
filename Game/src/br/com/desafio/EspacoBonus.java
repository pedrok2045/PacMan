package br.com.desafio;
/**
 * 
 * Classe que representa um elemento do jogo
 *
 */
public class EspacoBonus implements ElementoEstatico, Pontuavel {

	private int pontuacao;
	private Gerenciador gerenciador;
	
	public EspacoBonus(Gerenciador gerenciador, int pontuacao) {
		this.gerenciador = gerenciador;
		this.pontuacao = pontuacao;
		
	}
	
	@Override
	public String print() {
		return " * ";
	}


	@Override
	public Gerenciador getGerenciador() {
		return this.gerenciador;
	}

	@Override
	public int getPontuacao() {
		return this.pontuacao;
	}

}
