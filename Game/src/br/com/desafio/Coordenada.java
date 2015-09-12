package br.com.desafio;
/**
 * Classe que guarda e manipula as posições em linha e coluna do mapa
 *
 */
public class Coordenada {
	private int linha;
	private int coluna;
	
	public Coordenada(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public int getLinha() {
		return linha;
	}
	
	public int getColuna() {
		return coluna;
	}
	/**
	 * 
	 * @return a coordenada do objeto atual como um novo objeto Coordenada.
	 */
	public Coordenada getCoordenada(){
		return new Coordenada(this.linha, this.coluna);
	}
	
	/**
	 * Se acrescimoDaLinha/acrescimoDaColuna for positivo
	 * indica movimento para direita/cima, respectivamente
	 * Se acrescimoDaLinha/acrescimoDaColuna for negativo
	 * indica movimento para esquerda/baixo, respectivamente
	 * 
	 * @param acrescimoDaLinha
	 * @param acrescimoDaColuna
	 * @return a nova posicao no mapa resultante da posição atual
	 * deste objeto somado ao deslocamento informado em seus parâmetros.
	 *
	 */
	public Coordenada adicionaPosicao(int acrescimoDaLinha, int acrescimoDaColuna){
		return new Coordenada(this.getLinha()+acrescimoDaLinha, this.getColuna()+acrescimoDaColuna);
	}
	
}
