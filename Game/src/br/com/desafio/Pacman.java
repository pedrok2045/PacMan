package br.com.desafio;
/**
 * 
 * Classe que representa um elemento do jogo
 *
 */
public class Pacman extends Protagonista {

	private PosicaoNoMapa motorista;
	
	@Override
	public String print() {
		return " X ";
	}

	@Override
	public void recebeMotorista(PosicaoNoMapa motorista) {
		this.motorista = motorista;
		
	}

	@Override
	public boolean validaSentidoDoMovimento() {
		return false;
	}
}
