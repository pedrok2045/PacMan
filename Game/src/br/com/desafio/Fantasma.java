package br.com.desafio;
/**
 * 
 * Classe que representa um elemento do jogo
 *
 */
public class Fantasma extends Antagonista implements Pontuavel {

	private Mapa mapa;
	private PosicaoNoMapa posicaoNoMapa;
	private Gerenciador gerenciador;
	private int id;
	private int pontos;
	
	public Fantasma(Mapa mapa, Gerenciador gerenciador) {
		this.mapa = mapa;
		this.gerenciador = gerenciador;
		this.pontos = 50;
	}

	@Override
	public String print() {
		return " F ";
	}

	@Override
	public void aoEncontrarProtagonista() {
		this.gerenciador.finalizaJogo("perdeu");
	}

	@Override
	public void acaoAposSeMover() {
		this.gerenciador.pegaAutomovivel();
	}
	@Override
	public void setPosicaoNoMapa(PosicaoNoMapa posicaoNoMapa) {
		this.posicaoNoMapa = posicaoNoMapa;
	}

	@Override
	public void metodoQueProvidenciaSentidoParaOMovimento() {
		this.definaNovaPosicao();
	}

	@Override
	public PosicaoNoMapa getPosicaoNoMapaDesteElemento() {
		return this.posicaoNoMapa;
	}

	@Override
	public Mapa getMapa() {
		return this.mapa;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public Gerenciador getGerenciador() {
		return this.gerenciador;
	}

	@Override
	public int getPontuacao() {
		return this.pontos;
	}
}
