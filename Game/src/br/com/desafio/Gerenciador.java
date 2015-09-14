package br.com.desafio;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que envia e recebe informações dos elementos do jogo.
 * Somente esta classe tem comunicação direta com o a classe Jogo.
 *
 */
public class Gerenciador {
	
	private Mapa mapa;
	private int totalAntagonistas;
	private boolean espacoBonusAtivado;
	private Pacman pacman;
	private Jogo jogo;
	private List<ElementoAutoMovivel> automoviveis;
	private int ultimoIndiceMovido;
	private Coordenada posicaoDoPacman;
	
	public Gerenciador carregarMapaInicial(){
		this.mapa = new Mapa(this);
		this.automoviveis = new ArrayList<>();		
		this.mapa.carregaMapaInicial();
		this.espacoBonusAtivado = true;
		return this;
	}
	
	public void setJogo(Jogo jogo){
		this.jogo = jogo;
	}

	public int getTotalAntagonistas() {
		return this.totalAntagonistas;
	}

	public void setTotalAntagonistas(int totalAntagonistas) {
		this.totalAntagonistas = totalAntagonistas;
	}
	
	public void setPacman(Pacman pacman){
		this.pacman = pacman;
	}

	public void adicionaAntagonista() {
		this.totalAntagonistas++;
	}
	
	public void eliminaAntagonista(){
		this.totalAntagonistas--;
	}

	public boolean isEspacoBonusAtivado() {
		return espacoBonusAtivado;
	}

	public void setEspacoBonusAtivado(boolean espacoBonusAtivado) {
		this.espacoBonusAtivado = espacoBonusAtivado;
	}

	public void iniciarMovimento() {
		ElementoGrafico elemento = this.mapa.getPosicaoNoMapa(this.posicaoDoPacman).getElemento();
		if(elemento instanceof Pacman){
			((Pacman)elemento).metodoQueProvidenciaSentidoParaOMovimento();
		}else{
			System.out.println("nao é um Pacman");
		}
	}

	public void marcaPonto(int pontuacao) {
		this.jogo.marcarPonto(pontuacao);
		
	}
	
	public void aoFinalizarMovimentoDoPacman(){
		//this.iniciarAutoMoviveis();
	}

	public void iniciarAutoMoviveis() {
		this.ultimoIndiceMovido = -1;
		this.moverAutomoviveis();
	}

	public void moverAutomoviveis() {
		if(this.ultimoIndiceMovido < this.automoviveis.size()-1){
			this.ultimoIndiceMovido++;
			this.automoviveis.get(this.ultimoIndiceMovido).move();
		}else{
			this.proximoTurno();
		}
	}

	public void adicionaAutomovivel(ElementoAutoMovivel elemento) {
		this.automoviveis.add(elemento);
	}

	public void finalizaJogo(String resultadoFinal) {
		this.jogo.finalizaJogo(resultadoFinal);
	}
	
	public void verificaQuantidadeDeAntagonistas(){
		this.jogo.verificaQuantidadeDeAntagonistas();
	}

	public void proximoTurno() {
		this.pegaPacman();
		this.mapa.imprimir();
		this.iniciarMovimento();
	}
	
	public void setPosicaoDoPacman(int linha, int coluna){
		this.posicaoDoPacman = this.posicaoDoPacman.adicionaPosicao(linha, coluna);
	}
	public void setPosicaoDoPacman(Coordenada posicao){
		this.posicaoDoPacman = posicao;
	}
	
	public void pegaPacman(){
		for(int i = 0 ; i < this.mapa.getMapa().size()-1 ; i++){
			for(int j = 0 ; j < this.mapa.getMapa().size()-1 ; j++){
				if(this.mapa.getMapa().get(i).get(j).getElemento() instanceof Pacman){
					this.posicaoDoPacman = new Coordenada(i, j);
					System.out.println("pacman pego: "+i+" "+j);
					return;
				}
			}
		}
	}
}
