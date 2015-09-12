package br.com.desafio;
/**
 * Classe que cria um mapa gráfico e atribui às suas posições os elementos em seus devidos lugares,
 * sendo ainda esta classe a resonsável por imprimir os elementos na tela.
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mapa {
	private List<ArrayList<PosicaoNoMapa>> mapa;
	private int linhas;
	private Gerenciador gerenciador;

	public Mapa(Gerenciador gerenciador) {
		this.gerenciador = gerenciador;
		this.mapa = new ArrayList<>();
		this.linhas = 15;
	}

	public Mapa carregaMapaInicial() {
		try (InputStream in = new FileInputStream("mapas/mapaInicial.txt")) {

			try (Scanner scan = new Scanner(in)) {

				int linhaSendoComposta = 0;

				// adiciona uma linha à lista de posições no mapa
				while (scan.hasNextLine()) {

					this.mapa.add(new ArrayList<PosicaoNoMapa>());

					String linha = scan.nextLine().trim().replaceAll(" ", "");

					// atribui àquela linha objetos PosicaoNoMapa
					for (int i = 0; i < this.linhas; i++) {

						this.mapa.get(linhaSendoComposta).add(
								new PosicaoNoMapa(this.gerenciador, this,
										new Coordenada(linhaSendoComposta, i)));

						// Para cada objeto Posição no Mapa, atribui um
						// elemento, de acordo com o mapa carregado
						ElementoGrafico elemento = ControladorDeElementos
								.getElemento(linha.substring(i, i + 1));
						if (elemento instanceof ElementoMovel) {
							((ElementoMovel) elemento).recebeMotorista(this
									.getPosicaoNoMapa(new Coordenada(
											linhaSendoComposta, i)));
							if (elemento instanceof ElementoAutoMovivel) {
								this.gerenciador.adicionaElementoAutoMovivel();
							}else if(elemento instanceof Pacman){
								this.gerenciador.setPacman((Pacman)elemento);
							}
						}
						if(elemento instanceof Antagonista){
							this.gerenciador.adicionaAntagonista();
						}
						this.getPosicaoNoMapa(
								new Coordenada(linhaSendoComposta, i))
								.inicializa(elemento);
					}

					linhaSendoComposta++;
				}

			}
		} catch (IOException e) {
			System.err
					.println("O arquivo .txt do mapa não foi encontrado.\nCaso seja necessário, você pode usar o método gerarMapaEmBranco da classe Mapa,\n"
							+ "depois copiar o mapa em branco do console para um arquivo de texto e editar o mapa novamente.");
			System.exit(0);
		}
		
		return this;
	}

	public void imprimir() {

		for (int i = 0; i < linhas; i++) {
			this.mapa.get(i).forEach(elemento -> {
				System.out.print(elemento.print());
			});

			if (i < linhas - 1) {
				System.out.println();
			}
		}
		System.out.println("\n");
	}

	public List<ArrayList<PosicaoNoMapa>> getMapa() {
		return this.mapa;
	}

	public PosicaoNoMapa getPosicaoNoMapa(Coordenada posicao) {
		return this.mapa.get(posicao.getLinha()).get(posicao.getColuna());
	}

	public int getLinhas() {
		return this.linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	/**
	 * Método que verifica se uma Coordenada está dentro do mapa.
	 * 
	 * @param posicao
	 * @return boolean
	 */
	public boolean ehPosicaoValida(Coordenada posicao) {
		if (this.ehValido(posicao.getLinha(), 0, this.linhas - 1)
				&& this.ehValido(posicao.getColuna(), 0, this.linhas - 1)) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * Método que verifica se um número está dentro dos seus limites à esquerda
	 * e à direita. Somente para auxiliar o método ehPosicaoValida
	 * 
	 * @param posicao
	 * @param limiteAEsquerda
	 * @param limiteADireita
	 * @return true se for uma posicao válida e false caso não seja
	 */
	private boolean ehValido(int posicao, int limiteAEsquerda,
			int limiteADireita) {
		if (posicao >= limiteADireita && posicao <= limiteADireita)
			return true;
		return false;
	}

	public PosicaoNoMapa getProximaPosicao(Coordenada coordenada) {
		if (this.ehPosicaoValida(coordenada.adicionaPosicao(0, 1))) {
			Coordenada posicaoFinal = coordenada.adicionaPosicao(0, 1);
			return this.getPosicaoNoMapa(posicaoFinal);
		} else if (coordenada.getLinha() <= this.linhas - 1
				&& coordenada.getColuna() + 1 <= this.linhas - 1) {
			Coordenada posicaoFinal = new Coordenada(coordenada.getLinha() + 1,
					0);
			return this.getPosicaoNoMapa(posicaoFinal);
		} else {
			return null;
		}
	}
}
