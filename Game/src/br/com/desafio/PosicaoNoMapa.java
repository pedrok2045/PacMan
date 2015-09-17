package br.com.desafio;

/**
 * 
 * Classe que representa uma posição do mapa. Cada posição é como se fosse uma
 * casa de uma tabuleiro, sendo assim, elementos podem ocupar aquele espaço.
 * cada Posição pode ter 2 Elementos, sendo que, por default o primeiro é um
 * Pontuável e o segundo um elemento que não seja pontuável.
 * 
 * Em uma das versões do Pacman, todos lugares em que ele pode passar tem um
 * elemento que dá pontos a ele quando passa naquele local pela primeira vez e
 * ainda tem frutinhas que aparecem e tals. Tudo isso pode ser implementado
 * usando esta classe.
 * 
 * Obs.: Pode ser implementado, por exemplo, elementos antagonistas que ficam
 * escondidos em alementos estáticos e quando um protagonista passar por perto,
 * a parede é destroída e pontos são retirados do jogador. Esse elemento
 * antagonista deve ser inserido na primeira posição do mapa, pois é um
 * pontuável, no entanto, sua pontuação é negativa.
 *
 */
public class PosicaoNoMapa {

	private ElementoGrafico pilhaDeElementos[];
	private Coordenada coordenada;
	private Gerenciador gerenciador;
	private ControladorDeElementos controlador;

	public PosicaoNoMapa(Gerenciador gerenciador, ControladorDeElementos controlador, Coordenada coordenada) {
		this.gerenciador = gerenciador;
		this.controlador = controlador;
		this.setCoordenada(coordenada);
		this.pilhaDeElementos = new ElementoGrafico[2];
	}

	/*
	 * esse método é usado somente pelo mapa, pois coloca um elemento na posição
	 * 1 da PosicaoNoMapa ignorando se tem algo nela, pois considera q tenha
	 * somente um null Caso o espaço bonus esteja ativado, coloca um elemento
	 * EspacoBonus no início da pilha.
	 */
	public void inicializa(ElementoGrafico elemento) {
		if (this.gerenciador.isEspacoBonusAtivado()) {
			if (elemento instanceof Protagonista || elemento instanceof ElementoEstatico) {
				this.pilhaDeElementos[0] = null;
				this.pilhaDeElementos[1] = elemento;
			} else {
				this.pilhaDeElementos[0] = controlador.getElemento("*");
				this.pilhaDeElementos[1] = elemento;
			}
		} else {
			this.pilhaDeElementos[1] = elemento;
		}
	}

	/**
	 * se tiver algum elemento na posicao 1, retorna o metodo print dela, senao
	 * verifica se tem algum elemento na posição 0 (somente elementos pontuáveis
	 * ficam na posicao 0) caso tenha, retorna o seu método print. Caso não
	 * tenha nenhum elemento, ele retorna o seu próprio símbolo, que indica um
	 * espaço vazio.
	 * 
	 */
	public String print() {
		if (this.pilhaDeElementos[1] != null) {
			return this.pilhaDeElementos[1].print();
		} else if (this.pilhaDeElementos[0] != null) {
			return this.pilhaDeElementos[0].print();
		} else {
			return " . ";
		}

	}

	public ElementoGrafico getElemento() {
		return this.pilhaDeElementos[1];
	}

	// recebe um elemento, de acordo com suas características
	public void recebeElemento(PosicaoNoMapa posicao) {
		if ((!(posicao.getElemento() instanceof Protagonista)) && this.pilhaDeElementos[1] instanceof Pontuavel) {
			this.pilhaDeElementos[0] = this.pilhaDeElementos[1];
			this.pilhaDeElementos[1] = posicao.getElemento();
		} else {
			this.pilhaDeElementos[1] = posicao.getElemento();

		}
		((ElementoMovel) this.pilhaDeElementos[1]).setPosicaoNoMapa(this);
		this.liberaEspacoNaPilha(posicao);
	}

	/*Após o elemento se mover, a representação dele deve ser apagada da posição anterior do mapa, isto que essa classe faz.*/
	public void liberaEspacoNaPilha(PosicaoNoMapa elemento) {
		if (elemento.pilhaDeElementos[0] != null) {
			elemento.pilhaDeElementos[1] = elemento.pilhaDeElementos[0];
			elemento.pilhaDeElementos[0] = null;
		} else {
			elemento.pilhaDeElementos[1] = null;
		}

	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
}