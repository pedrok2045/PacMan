package br.com.desafio;
/**
 * 
 * Classe respons�vel por receber os dados do gerenciador e controlar o fluxo do programa,
 * o iniciando e finalizando de acordo com oque acontece no jogo, bem como guardar a pontua��o do jogador,
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
		this.iniciaTurno();
		return this;
	}
	
	public void iniciaTurno(){
		this.gerenciador.proximoTurno();
	}
	
	public void marcarPonto(int pontos){
		this.pontos += pontos;
		System.out.println("+"+pontos+"\n"+"Total de pontos: "+this.pontos);
	}
	
	public void finalizaJogo(String resultadoFinal){
		System.out.println("Fim de jogo!");
		switch(resultadoFinal){
		case "venceu":
			System.out.println("Parab�ns, jogador!");
			break;
		case "perdeu":
			System.out.println("N�o foi dessa vez, mas n�o desista!");
			break;
		}
		System.out.println("Sua pontua��o total foi de "+this.pontos+" pontos.");
		System.exit(0);
	}
	
	public void verificaQuantidadeDeAntagonistas(){
		if(this.gerenciador.getTotalAntagonistas() == 0){
			this.finalizaJogo("venceu");
		}
	}
}
