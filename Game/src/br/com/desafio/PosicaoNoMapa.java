package br.com.desafio;
/**
 * 
 * Classe que representa uma posição do mapa.
 * Cada posição é como se fosse uma casa de uma tabuleiro, sendo assim, elementos podem ocupar aquele espaço.
 * cada Posição pode ter 2 Elementos, sendo que, por default o primeiro é um Pontuável e o segundo um elemento
 * que não seja pontuável.
 * 
 * Em uma das versões do Pacman, todos lugares em que ele pode passar tem um elemento que dá pontos a ele quando
 * passa naquele local pela primeira vez e ainda tem frutinhas que aparecem e tals. Tudo isso pode ser implementado
 * usando esta classe.
 * 
 * Obs.: Pode ser implementado, por exemplo, elementos antagonistas que ficam escondidos em alementos estáticos
 * e quando um protagonista passar por perto, a parede é destroída e pontos são retirados do jogador.
 * Esse elemento antagonista deve ser inserido na primeira posição do mapa, pois é um pontuável, no entanto, 
 * sua pontuação é negativa.
 *
 */
public class PosicaoNoMapa implements ElementoGrafico{

	//essa variável guarda os ElementosGraficos que estão em cada uma das posições no mapa
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

	
	//esse método é usado somente pelo mapa, pois coloca um elemento na posição 1
	//da PosicaoNoMapa ignorando se tem algo nela, pois considera q tenha somente um null
	//Caso o espaço bonus esteja ativado, coloca um elemento EspacoBonus início da pilha.
	public void inicializa(ElementoGrafico elemento) {
		if(this.gerenciador.isEspacoBonusAtivado()){
			if(elemento instanceof Pontuavel){
				this.pilhaDeElementos[0] = elemento;
			}else{
				this.pilhaDeElementos[0] = new EspacoBonus();
				this.pilhaDeElementos[1] = elemento;
			}
		}else{
			this.pilhaDeElementos[1] = elemento;
		}
	}

	/**
	 * se tiver algum elemento na posicao 1, retorna o metodo print dela,
	 * senao verifica se tem algum elemento na posição 0 (somente elementos pontuáveis ficam na posicao 0)
	 * caso tenha, retorna o seu método print.
	 * Caso não tenha nenhum elemento, ele retorna o seu próprio símbolo, que indica um espaço vazio.
	 * 
	 * pode-se usar um for aqui e criar a interface a Pontuável...
	 */
	public String print() {
		if(this.pilhaDeElementos[1] != null) {
			return this.pilhaDeElementos[1].print();
		}else if(this.pilhaDeElementos[0] != null){
			return this.pilhaDeElementos[0].print();
		}
		return " . ";
	}
	
	//retorna o elemento gráfico que está no topo da pilha de elementos
	public ElementoGrafico getElemento() {
		return this.pilhaDeElementos[1];
	}

	//recebe um elemento, de acordo com suas características
	public void recebeElemento(ElementoGrafico elemento) {
		
	}

	//após o elemento se mover, este método é invocado pelo mapa
	//para liberar espaço na pilha de elementos.
	public void liberaEspacoNaPilha() {
		this.pilhaDeElementos[1] = null;
	}

}
