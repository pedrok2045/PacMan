package br.com.desafio;
/**
 * 
 * Classe que representa um elemento do jogo
 *
 */
public class Parede implements ElementoEstatico, ElementoSolido {

	@Override
	public String print() {
		return " # ";
	}
}
