package br.com.desafio;
/**
 * 
 * Interface que representa os elementos que se movem e cont�m os m�todos que
 * todos eles devem implementar
 *
 */
public interface ElementoMovel extends ElementoGrafico{

	//para ter acesso � PosicaoNoMapa onde este elemento est� no momento
	void recebeMotorista(PosicaoNoMapa posicaoNoMapa);

}
