package br.com.desafio;
/**
 * 
 * Interface que representa os elementos que se movem e contém os métodos que
 * todos eles devem implementar
 *
 */
public interface ElementoMovel extends ElementoGrafico{

	//para ter acesso à PosicaoNoMapa onde este elemento está no momento
	void recebeMotorista(PosicaoNoMapa posicaoNoMapa);

}
