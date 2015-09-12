package br.com.desafio;
/**
 * 
 * Classe que gerencia os elementos usados no jogo
 *
 */
public class ControladorDeElementos {
	public static ElementoGrafico getElemento(String simbolo){
		if(simbolo.equals("#")){
			return new Parede();
		}else if(simbolo.equals("F")){
			return new Fantasma(null);
		}else if(simbolo.equals("*")){
			return new EspacoBonus();
		}else if(simbolo.equals("X")){
			return new Pacman();
		}
		return null;
	}
}
