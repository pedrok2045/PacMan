package br.com.desafio;

import java.util.Scanner;

/**
 * 
 * Classe abstrata que conterá o algoritmo usado para mover um elemento via
 * Scanner.
 *
 */
public abstract class ElementoControlavel implements ElementoMovel {

	/**
	 * Este método captura o movimento pelo scanner e de acordo com o sentido
	 * escolhido pelo jogador, o analisa para ver se pode se mover para aquela direção
	 * então executa o movimento.
	 */
	public void capturarMovimento() {
		try (Scanner scan = new Scanner(System.in)) {
			String sentido;
			boolean comandoValido = false;
			do {
				sentido = scan.next();
				switch (sentido) {
				case "a":
					comandoValido = true;
					this.analisaMovimento(0, -1);
					break;
				case "w":
					comandoValido = true;
					this.analisaMovimento(-1, 0);
					break;
				case "d":
					comandoValido = true;
					this.analisaMovimento(0, 1);
					break;
				case "s":
					comandoValido = true;
					this.analisaMovimento(1, 0);
					break;
				}

			} while (comandoValido == false);

		}
	}

	//após confirma que pode mover o elemento naquela posição, inicializa
	//o processo.
	private void analisaMovimento(int linha, int coluna) {
		if(this.validaSentidoDoMovimento()){
			//implementar
		}
	}

	//valida que naquela direcao haja um espaço ou que o elemento pode
	//se mover para aquela direcao.
	public abstract boolean validaSentidoDoMovimento();
}
