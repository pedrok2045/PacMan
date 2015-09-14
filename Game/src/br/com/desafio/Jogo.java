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
	private int pontos;
	
	public Jogo inicializar(){
		
		this.pontos = 0;
		
		this.gerenciador = new Gerenciador();
		this.gerenciador.setJogo(this);
		gerenciador.carregarMapaInicial();
		gerenciador.iniciarMovimento();
		return this;
	}
	
	public void marcarPonto(int pontos){
		this.pontos += pontos;
	}
	
	public void finalizaJogo(String resultadoFinal){
		System.out.println("Fim de jogo!");
		switch(resultadoFinal){
		case "venceu":
			System.out.println("Parabéns, jogador!");
			break;
		case "perdeu":
			System.out.println("Não foi dessa vez, mas não desista!");
			break;
		default:
				System.out.println("Sua pontuação foi de "+this.pontos+" pontos.");
			break;
		}
		
	}

}
