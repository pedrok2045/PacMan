package br.com.desafio;
/**
 * 
 * Classe que representa um elemento do jogo
 *
 */
public class Pacman extends Protagonista {

	@Override
	public String print() {
		return " X ";
	}

	@Override
	public void recebeMotorista(PosicaoNoMapa posicaoNoMapa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validaSentidoDoMovimento() {
		return false;
		
	}
}
