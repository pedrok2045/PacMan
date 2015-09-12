package br.com.desafio;
/**
 * 
 * Classe que representa uma posi��o do mapa.
 * Cada posi��o � como se fosse uma casa de uma tabuleiro, sendo assim, elementos podem ocupar aquele espa�o.
 * cada Posi��o pode ter 2 Elementos, sendo que, por default o primeiro � um Pontu�vel e o segundo um elemento
 * que n�o seja pontu�vel.
 * 
 * Em uma das vers�es do Pacman, todos lugares em que ele pode passar tem um elemento que d� pontos a ele quando
 * passa naquele local pela primeira vez e ainda tem frutinhas que aparecem e tals. Tudo isso pode ser implementado
 * usando esta classe.
 * 
 * Obs.: Pode ser implementado, por exemplo, elementos antagonistas que ficam escondidos em alementos est�ticos
 * e quando um protagonista passar por perto, a parede � destro�da e pontos s�o retirados do jogador.
 * Esse elemento antagonista deve ser inserido na primeira posi��o do mapa, pois � um pontu�vel, no entanto, 
 * sua pontua��o � negativa.
 *
 */
public class PosicaoNoMapa implements ElementoGrafico{

	//essa vari�vel guarda os ElementosGraficos que est�o em cada uma das posi��es no mapa
	private ElementoGrafico pilhaDeElementos[];
	private Coordenada coordenada;
	private Gerenciador gerenciador;
	private Mapa mapa;
	
	public PosicaoNoMapa(Gerenciador gerenciador, Mapa mapa,
			Coordenada coordenada) {
		this.gerenciador = gerenciador;
		this.mapa = mapa;
		this.coordenada = coordenada;
		this.pilhaDeElementos = new ElementoGrafico[2];
	}

	
	//esse m�todo � usado somente pelo mapa, pois coloca um elemento na posi��o 1
	//da PosicaoNoMapa ignorando se tem algo nela, pois considera q tenha somente um null
	public void inicializa(ElementoGrafico elemento) {
		this.pilhaDeElementos[1] = elemento;
	}

	/**
	 * se tiver algum elemento na posicao 1, retorna o metodo print dela,
	 * senao verifica se tem algum elemento na posi��o 0 (somente elementos pontu�veis ficam na posicao 0)
	 * caso tenha, retorna o seu m�todo print.
	 * Caso n�o tenha nenhum elemento, ele retorna o seu pr�prio s�mbolo, que indica um espa�o vazio.
	 * 
	 * pode-se usar um for aqui e criar a interface a Pontu�vel...
	 */
	public String print() {
		if(this.pilhaDeElementos[1] != null) {
			return this.pilhaDeElementos[1].print();
		}else if(this.pilhaDeElementos[0] != null){
			return this.pilhaDeElementos[0].print();
		}
		return " . ";
	}

}