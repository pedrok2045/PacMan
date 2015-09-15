package br.com.desafio;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 
 * Classe abstrata que conter� o algoritmo usado para mover um elemento via
 * Scanner.
 *
 */
public abstract class ElementoControlavel implements ElementoMovel {

	private Scanner scan;
	
	/**
	 * Este m�todo captura o movimento pelo scanner e de acordo com o sentido
	 * escolhido pelo jogador, o analisa para ver se pode se mover para aquela dire��o
	 * ent�o executa o movimento.
	 */
	public void capturaMovimento() {
		try{
			String sentido;
			boolean comandoValido = false;
			scan  = new Scanner(System.in);
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
		}catch(NoSuchElementException e){
			System.err.println("No such element error");
		}finally{
			this.scan.close();
		}
	}
}
