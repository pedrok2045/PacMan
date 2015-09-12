package br.com.desafio;
/**
 * Classe que envia e redebe informa��es dos elementos do jogo.
 * Somente esta classe tem comunica��o direta com o a classe Jogo.
 *
 */
public class Gerenciador {
	
	private Mapa mapa;
	
	public Gerenciador carregarMapaInicial(){
		this.mapa = new Mapa(this);
		this.mapa.carregaMapaInicial().imprimir();;
		return this;
	}
	
}
