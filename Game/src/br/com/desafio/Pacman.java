package br.com.desafio;
/**
 * 
 * Classe que representa um elemento do jogo
 *
 */
public class Pacman extends Protagonista {

	private Mapa mapa;
	private Gerenciador gerenciador;
	private PosicaoNoMapa posicaoNoMapa;

	public Pacman(Mapa mapa, Gerenciador gerenciador) {
		this.mapa = mapa;
		this.gerenciador = gerenciador;
		
	}
	
	@Override
	public void metodoQueProvidenciaSentidoParaOMovimento() {
		super.capturaMovimento();
	}


	@Override
	public void aoEncontrarProtagonista() {
		// TODO Auto-generated method stub
	}


	@Override
	public void aoEncontrarAntagonista() {
		this.gerenciador.eliminaAntagonista();
	}


	@Override
	public void aoEncontrarPontuavel(Pontuavel elemento) {
		elemento.marcaPonto();
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
	public String print() {
		return " X ";
	}
	
	public void setGerenciador(Gerenciador gerenciador){
		this.gerenciador = gerenciador;
	}


	@Override
	public void acaoAposSeMover() {
		this.gerenciador.aoFinalizarMovimentoDoPacman();
	}


	@Override
	public void setPosicaoNoMapa(PosicaoNoMapa posicaoNoMapa) {
		this.posicaoNoMapa = posicaoNoMapa;
	}

}
