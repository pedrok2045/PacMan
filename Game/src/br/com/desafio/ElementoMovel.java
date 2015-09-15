package br.com.desafio;

/**
 * 
 * Interface que representa os elementos que se movem e contém os métodos que
 * todos eles devem implementar
 *
 */
public interface ElementoMovel extends ElementoGrafico {

	/*
	 * Método para ser usado pela classe abstrata que comando o elemento, sendo
	 * até o momento as classes ElementoControlavel e ElementoAutoMovivel Este
	 * método analisa se o elemento pode se mover para a casa de destino.
	 */
	default void analisaMovimento(int linha, int coluna) {
		Coordenada posicaoFinal = this.getPosicaoNoMapaDesteElemento().getCoordenada().adicionaPosicao(linha, coluna);
		if (this.getMapa().ehPosicaoValida(posicaoFinal)) {
			if (this.validaSentidoDoMovimento(posicaoFinal)) {
				this.executaMovimento(posicaoFinal);
			} else {
				this.metodoQueProvidenciaSentidoParaOMovimento();
			}
		} else {
			this.metodoQueProvidenciaSentidoParaOMovimento();
		}
	}

	default boolean validaSentidoDoMovimento(Coordenada posicaoFinal) {
		if (this.getMapa().getPosicaoNoMapa(posicaoFinal).getElemento() instanceof ElementoSolido) {
			return false;
		}
		return true;
	}

	/*
	 * método que compara o elemento atual com o elemento da posicao final e
	 * aplica as penalidades/bonificações apropriadas de acordo com a relacao
	 * entre os elemento
	 */
	default void executaMovimento(Coordenada posicaoFinal) {
		ElementoGrafico elementoDaPosicaoFinal = this.getMapa().getPosicaoNoMapa(posicaoFinal).getElemento();
		this.getMapa().getPosicaoNoMapa(posicaoFinal)
		.recebeElemento(this.getPosicaoNoMapaDesteElemento());
		
		if (elementoDaPosicaoFinal instanceof Pontuavel) {
			this.aoEncontrarPontuavel((Pontuavel) elementoDaPosicaoFinal);
		}
		
		
		if (elementoDaPosicaoFinal instanceof Protagonista) {
			this.aoEncontrarProtagonista();
		} else if (elementoDaPosicaoFinal instanceof Antagonista) {
			this.aoEncontrarAntagonista(elementoDaPosicaoFinal);
		}
		
		
		this.acaoAposSeMover();
	}

	void aoEncontrarProtagonista();

	void aoEncontrarAntagonista(ElementoGrafico elemento);

	void aoEncontrarPontuavel(Pontuavel elemento);

	void acaoAposSeMover();

	// para ter acesso à PosicaoNoMapa onde o elemento que implementa esta
	// interface se localiza no momento
	void setPosicaoNoMapa(PosicaoNoMapa posicaoNoMapa);

	/*
	 * Chama o método que normalmente será uma classe que implementa essa para
	 * que reinicie o processo que obteve como resultado um sentido para o
	 * movimento.
	 */
	void metodoQueProvidenciaSentidoParaOMovimento();

	// para dar acesso à PosicaoNoMapa atual
	PosicaoNoMapa getPosicaoNoMapaDesteElemento();

	// para ter acesso ao mapa do jogo
	Mapa getMapa();
}
