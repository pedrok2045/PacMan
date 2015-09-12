package br.com.desafio;
/**
 * 
 * Classe que representa um elemento do jogo
 *
 */
public class EspacoBonus implements ElementoEstatico, Pontuavel {

	@Override
	public String print() {
		return " * ";
	}

}
