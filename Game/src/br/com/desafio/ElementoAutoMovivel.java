package br.com.desafio;

import java.util.ArrayList;

/**
 * 
 * Classe abstrata que conterá o algoritmo que todos os elementos que se movem
 * randomicamente usaram para se mover pelo mapa
 *
 */
public abstract class ElementoAutoMovivel implements ElementoMovel{
	private ArrayList<Integer> selecionados;
	
	private void iniciar(){
		this.selecionados = new ArrayList<>();
		definaNovaPosicao();
	}

	public void definaNovaPosicao() {
		int random;

		do {
			random = (int) Math.ceil(Math.random() * 4) - 1;
			//selecionados.forEach(System.out::println);
		} while (selecionados.indexOf(random) >= 0);
		selecionados.add(random);
		switch (selecionados.get(selecionados.size()-1)) {
		
		case 0:// frente
			this.analisaMovimento(-1, 0);
			break;
		case 1:// direita
			this.analisaMovimento(0, 1);
			break;
		case 2:// baixo
			this.analisaMovimento(1, 0);
			break;
		case 3:// esquerda
			this.analisaMovimento(0, -1);
			break;
		}
		
	}

	public void move() {
		this.iniciar();
	}
	
	public abstract void setId(int id);
	public abstract int getId();
}
