package br.com.desafio;

/**
 * 
 * Classe que representa uma posi��o do mapa. Cada posi��o � como se fosse uma
 * casa de uma tabuleiro, sendo assim, elementos podem ocupar aquele espa�o.
 * cada Posi��o pode ter 2 Elementos, sendo que, por default o primeiro � um
 * Pontu�vel e o segundo um elemento que n�o seja pontu�vel.
 * 
 * Em uma das vers�es do Pacman, todos lugares em que ele pode passar tem um
 * elemento que d� pontos a ele quando passa naquele local pela primeira vez e
 * ainda tem frutinhas que aparecem e tals. Tudo isso pode ser implementado
 * usando esta classe.
 * 
 * Obs.: Pode ser implementado, por exemplo, elementos antagonistas que ficam
 * escondidos em alementos est�ticos e quando um protagonista passar por perto,
 * a parede � destro�da e pontos s�o retirados do jogador. Esse elemento
 * antagonista deve ser inserido na primeira posi��o do mapa, pois � um
 * pontu�vel, no entanto, sua pontua��o � negativa.
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
	 * esse m�todo � usado somente pelo mapa, pois coloca um elemento na posi��o
	 * 1 da PosicaoNoMapa ignorando se tem algo nela, pois considera q tenha
	 * somente um null Caso o espa�o bonus esteja ativado, coloca um elemento
	 * EspacoBonus no in�cio da pilha.
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
	 * verifica se tem algum elemento na posi��o 0 (somente elementos pontu�veis
	 * ficam na posicao 0) caso tenha, retorna o seu m�todo print. Caso n�o
	 * tenha nenhum elemento, ele retorna o seu pr�prio s�mbolo, que indica um
	 * espa�o vazio.
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

	// recebe um elemento, de acordo com suas caracter�sticas
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

	/*Ap�s o elemento se mover, a representa��o dele deve ser apagada da posi��o anterior do mapa, isto que essa classe faz.*/
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