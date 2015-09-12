package br.com.desafio;
/**
 * 
 * Classe responsável por receber os dados do gerenciador e controlar o fluxo do programa,
 * o iniciando e finalizando de acordo com oque acontece no jogo, bem como guardar a pontuação do jogador,
 * e todo o seu desempenho no jogo.
 * 
 * Somente esta classe deve ser acessada pelo programa principal do jogo, a classe Main.
 *
 */
public class Jogo{

	private Gerenciador gerenciador;
	
	public Jogo inicializar(){
		this.gerenciador = new Gerenciador();
		gerenciador.carregarMapaInicial();
		return this;
	}

}
