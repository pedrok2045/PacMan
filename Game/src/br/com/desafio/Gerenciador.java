package br.com.desafio;
/**
 * Classe que envia e recebe informações dos elementos do jogo.
 * Somente esta classe tem comunicação direta com o a classe Jogo.
 *
 */
public class Gerenciador {
	
	private Mapa mapa;
	private int totalAntagonistas;
	private int totalElementosAutoMoviveis;
	private boolean espacoBonusAtivado = true;
	private Pacman pacman;
	private Jogo jogo;
	
	public Gerenciador carregarMapaInicial(){
		this.mapa = new Mapa(this);
		this.mapa.carregaMapaInicial().imprimir();
		return this;
	}
	
	public void setJogo(Jogo jogo){
		this.jogo = jogo;
	}

	public int getTotalAntagonistas() {
		return totalAntagonistas;
	}

	public void setTotalAntagonistas(int totalAntagonistas) {
		this.totalAntagonistas = totalAntagonistas;
	}

	public int getTotalElementosAutoMoviveis() {
		return totalElementosAutoMoviveis;
	}

	public void setTotalElementosAutoMoviveis(int totalElementosAutoMoviveis) {
		this.totalElementosAutoMoviveis = totalElementosAutoMoviveis;
	}

	public void adicionaElementoAutoMovivel() {
		this.totalElementosAutoMoviveis++;
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
		this.pacman.metodoQueProvidenciaSentidoParaOMovimento();
	}

	public void marcaPonto(int pontuacao) {
		this.jogo.marcarPonto(pontuacao);
		
	}
	
	public void aoFinalizarMovimentoDoPacman(){
		this.mapa.imprimir();
		this.iniciarAutoMoviveis();
	}

	public void iniciarAutoMoviveis() {
		System.out.println("iniciando movimento dos automoviveis");
	}
}
