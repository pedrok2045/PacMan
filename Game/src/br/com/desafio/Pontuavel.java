package br.com.desafio;
/**
 * 
 * Classe que representa os elementos que tem uma pontuação ao serem terem sua
 * posição ocupada pelo Pacman
 *
 */
public interface Pontuavel {
	
	default public void marcaPonto(){
		this.getGerenciador().marcaPonto(this.getPontuacao());
	}
	
	Gerenciador getGerenciador();
	int getPontuacao();
}
