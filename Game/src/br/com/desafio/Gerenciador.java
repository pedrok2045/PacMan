package br.com.desafio;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que envia e recebe informações dos elementos do jogo. Somente esta
 * classe tem comunicação direta com o a classe Jogo.
 *
 */
public class Gerenciador {

	private Mapa mapa;
	private int totalAntagonistas;
	private boolean espacoBonusAtivado;
	private Pacman pacman;
	private Jogo jogo;
	private List<ElementoAutoMovivel> automoviveis;
	private List<Integer> elementosMovidos;
	private Coordenada posicaoDoPacman;

	public Gerenciador carregarMapaInicial() {
		this.mapa = new Mapa(this);
		this.automoviveis = new ArrayList<>();
		this.mapa.carregaMapaInicial();
		this.espacoBonusAtivado = true;
		return this;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public int getTotalAntagonistas() {
		return this.totalAntagonistas;
	}

	public void setTotalAntagonistas(int totalAntagonistas) {
		this.totalAntagonistas = totalAntagonistas;
	}

	public void setPacman(Pacman pacman) {
		this.pacman = pacman;
	}

	public void adicionaAntagonista() {
		this.totalAntagonistas++;
	}

	public void eliminaAntagonista(ElementoGrafico elemento) {
		this.totalAntagonistas--;
		this.automoviveis.remove(((ElementoAutoMovivel) elemento));
	}

	public boolean isEspacoBonusAtivado() {
		return espacoBonusAtivado;
	}

	public void setEspacoBonusAtivado(boolean espacoBonusAtivado) {
		this.espacoBonusAtivado = espacoBonusAtivado;
	}

	public void iniciarMovimento() {
		ElementoGrafico elemento = this.mapa.getPosicaoNoMapa(this.posicaoDoPacman).getElemento();
		if (elemento instanceof Pacman) {
			((Pacman) elemento).metodoQueProvidenciaSentidoParaOMovimento();
		} else {
			System.out.println("nao é um Pacman");
		}
	}

	public void marcaPonto(int pontuacao) {
		this.jogo.marcarPonto(pontuacao);

	}

	public void iniciarAutoMoviveis() {
		this.elementosMovidos = new ArrayList<>();
		this.pegaAutomovivel();
	}

	public void moverAutomoviveis(ElementoAutoMovivel elemento) {
		this.elementosMovidos.add(elemento.getId());
		elemento.move();
	}

	public void adicionaAutomovivel(ElementoAutoMovivel elemento) {
		this.automoviveis.add(elemento);
	}

	public void finalizaJogo(String resultadoFinal) {
		this.jogo.finalizaJogo(resultadoFinal);
	}

	public void verificaQuantidadeDeAntagonistas() {
		this.jogo.verificaQuantidadeDeAntagonistas();
	}

	public void proximoTurno() {
		this.pegaPacman();
		this.mapa.imprimir();
		this.iniciarMovimento();
	}

	public void pegaPacman() {
		for (int i = 0; i < this.mapa.getMapa().size() - 1; i++) {
			for (int j = 0; j < this.mapa.getMapa().size() - 1; j++) {
				if (this.mapa.getMapa().get(i).get(j).getElemento() instanceof Pacman) {
					this.posicaoDoPacman = new Coordenada(i, j);
					return;
				}
			}
		}
	}

	public void pegaAutomovivel() {
		if (this.elementosMovidos.size() <= this.automoviveis.size()) {
			for (int i = 0; i < this.mapa.getMapa().size() - 1; i++) {
				for (int j = 0; j < this.mapa.getMapa().size() - 1; j++) {
					ElementoGrafico elemento = this.mapa.getMapa().get(i).get(j).getElemento();
					if (elemento instanceof ElementoAutoMovivel) {
						if (this.elementosMovidos.indexOf(((ElementoAutoMovivel) elemento).getId()) < 0) {
							this.moverAutomoviveis(((ElementoAutoMovivel) elemento));
							this.proximoTurno();
						}
					}
				}
			}
		} 
	}
}
