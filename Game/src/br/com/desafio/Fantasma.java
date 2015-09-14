package br.com.desafio;
/**
 * 
 * Classe que representa um elemento do jogo
 *
 */
public class Fantasma extends ElementoAutoMovivel {

	private Mapa mapa;
	private PosicaoNoMapa posicaoNoMapa;
	private Gerenciador gerenciador;
	
	public Fantasma(Mapa mapa, Gerenciador gerenciador) {
		this.mapa = mapa;
		this.gerenciador = gerenciador;
	}
	
	@Override
	public void aoEncontrarProtagonista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aoEncontrarAntagonista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aoEncontrarPontuavel(Pontuavel elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosicaoNoMapa(PosicaoNoMapa posicaoNoMapa) {
		this.posicaoNoMapa = posicaoNoMapa;
		
	}

	@Override
	public void metodoQueProvidenciaSentidoParaOMovimento() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PosicaoNoMapa getPosicaoNoMapaDesteElemento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mapa getMapa() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return " F ";
	}

	@Override
	public void acaoAposSeMover() {
		// TODO Auto-generated method stub
		
	}

	
}
