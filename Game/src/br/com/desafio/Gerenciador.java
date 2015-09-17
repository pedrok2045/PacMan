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
		this.espacoBonusAtivado = true;
		this.mapa.carregaMapaInicial();
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

	/*
	 * remove um objeto Antagonista da contagem e caso seja um
	 * ElementoAutoMovivel, retira esse elemento da lista para o mesmo não seja
	 * chamado a se mover.
	 */
	public void eliminaAntagonista(ElementoGrafico elemento) {
		this.totalAntagonistas--;
		if (elemento instanceof ElementoAutoMovivel)
			this.automoviveis.remove(((ElementoAutoMovivel) elemento));
	}

	public boolean isEspacoBonusAtivado() {
		return espacoBonusAtivado;
	}

	public void setEspacoBonusAtivado(boolean espacoBonusAtivado) {
		this.espacoBonusAtivado = espacoBonusAtivado;
	}

	/*
	 * Inicia o movimento dos ElementoMovel, começando pelo Pacman e depois os
	 * ElementoAutoMovivel
	 */
	public void iniciarMovimento() {
		ElementoGrafico elemento = this.mapa.getPosicaoNoMapa(this.posicaoDoPacman).getElemento();
		if (elemento instanceof Pacman) {
			((Pacman) elemento).metodoQueProvidenciaSentidoParaOMovimento();
		}
	}

	public void marcaPonto(int pontuacao) {
		this.jogo.marcarPonto(pontuacao);

	}

	/*
	 * Inicializa a lista que guarda os elementos que já foram movidos e começa
	 * a pegar um por um dos ElementoAutoMovivel do mapa.
	 */
	public void iniciarAutoMoviveis() {
		this.elementosMovidos = new ArrayList<>();
		this.pegaAutomovivel();
	}

	/*
	 * Depois que um ElementoAutoMovivel foi pego no mapa, este método é
	 * invocado para registrar que o mesmo será movido e inicia o processo de
	 * mover o Elemento.
	 */
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

	/*
	 * percorre o mapa para pegar o Pacman, resedesenha o mapa no console e,
	 * após pegar o pacman, reinicia o movimento dos ElementoMovel
	 */
	public void proximoTurno() {
		this.pegaPacman();
		this.mapa.imprimir();
		this.iniciarMovimento();
	}

	/*
	 * percorre o mapa para pegar o pacman, então registra a posição do mesmo em
	 * uma variável do tipo Coordenada.
	 */
	public void pegaPacman() {
		for (int i = 0; i < this.mapa.getMapa().size(); i++) {
			for (int j = 0; j < this.mapa.getMapa().size(); j++) {
				if (this.mapa.getMapa().get(i).get(j).getElemento() instanceof Pacman) {
					this.posicaoDoPacman = new Coordenada(i, j);
					return;
				}
			}
		}
	}

	/*
	 * percorre o mapa para pegar cada um dos ElementoAutoMovivel que estiverem
	 * no jogo, então chama o método que move este elemento e em seguida, chama
	 * o próximo turno.
	 */
	public void pegaAutomovivel() {
		if (this.elementosMovidos.size() <= this.automoviveis.size()) {
			for (int i = 0; i < this.mapa.getMapa().size(); i++) {
				for (int j = 0; j < this.mapa.getMapa().size(); j++) {
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
