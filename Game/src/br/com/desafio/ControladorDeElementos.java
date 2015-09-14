package br.com.desafio;
/**
 * 
 * Classe que gerencia os elementos usados no jogo
 *
 */
public class ControladorDeElementos {
	
	private static Integer contador;
	
	private Mapa mapa;
	private Gerenciador gerenciador;
	
	public ControladorDeElementos(Mapa mapa, Gerenciador gerenciador) {
		contador = 0;
		this.mapa = mapa;
		this.gerenciador = gerenciador;
	}

	public ElementoGrafico getElemento(String simbolo){
		if(simbolo.equals("#")){
			return new Parede();
		}else if(simbolo.equals("F")){
			return new Fantasma(this.mapa, this.gerenciador);
		}else if(simbolo.equals("*")){
			return new EspacoBonus(this.gerenciador, 20);
		}else if(simbolo.equals("X")){
			return new Pacman(this.mapa, this.gerenciador);
		}
		return null;
	}
	
	public Integer getElementoId(){
		contador++;
		return contador;
	}
}