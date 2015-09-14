package br.com.desafio;

/**
 * 
 * Classe que serve para diferenciar os elementos que tem comportamento oposto
 * dentro do jogo, no caso default, os fantasmas do pacman
 *
 */
public abstract class Protagonista extends ElementoControlavel {
	public void aoEncontrarProtagonista() {};//para protagonistas interagirem, implementar este método.
}
