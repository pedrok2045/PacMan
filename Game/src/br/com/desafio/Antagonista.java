package br.com.desafio;
/**
 * 
 * Classe que representa os elementos que interagem com os elementos
 * que s�o os protagonistas, como o Pacman.
 * Por exemplo, os Fantasmas s�o Antagonistas e caso quizessemos criar um boss
 * bastaria ele implementar esta interface para ter os efeitos negativos contra o protagonista
 * que � por default o Pacman, mas podem ter outros, bastando que implementem a interface Protagonista.
 *
 */
public abstract class Antagonista extends ElementoAutoMovivel{
	@Override
	public void aoEncontrarAntagonista() {};
	@Override
	public void aoEncontrarPontuavel(Pontuavel elemento) {};
}
