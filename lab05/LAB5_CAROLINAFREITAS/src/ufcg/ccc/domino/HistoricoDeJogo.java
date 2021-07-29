package ufcg.ccc.domino;

import java.util.LinkedList;
import java.util.List;

/**
 * Guarda o histórico de um jogo, com as posições da mesa jogada a jogada e o
 * resultado, para usarmos em interfaces.
 *
 */
public class HistoricoDeJogo {
	
	/**
	 * Lista com as rodadas do jogo.
	 */
	private List<SituacaoNoJogo> rodadas;
	/**
	 * Primeiro jogador.
	 */
	private Jogador jogador1;
	/**
	 * Segundo jogador.
	 */
	private Jogador jogador2;
	/**
	 * Boolean que indica se a partida foi empatada.
	 */
	private boolean empate;
	/**
	 * Nome do vencedor.
	 */
	private String vencedor;
	/**
	 * Pontos da batida do vencedor. O valor padrão é 1, caso o jogador faça uma
	 * batida que vale mais pontos o valor é alterado.
	 */
	private int pontosVencedor; //pontos da batida do vencedor
	
	/**
	 * Indica se foi necessário o desempate
	 */
	private boolean desempate;

	/**
	 * Cria um novo histórico.
	 * 
	 * @param jogador1 Um jogador.
	 * @param jogador2 O outro.
	 */
	public HistoricoDeJogo(Jogador jogador1, Jogador jogador2) {
		this.rodadas = new LinkedList<SituacaoNoJogo>();
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.empate = false;
		this.vencedor = null;
		this.pontosVencedor = 1;
		this.desempate = false;
	}
	
	/**
	 * Adiciona uma rodada ao jogo.
	 * @param ultimaJogadaJ1 Ultima jogada do jogador1.
	 * @param ultimaJogadaJ2 Ultima jogada do jogador2.
	 * @param mesa A mesa do jogo.
	 */
	public void addRodada(Jogada ultimaJogadaJ1, Jogada ultimaJogadaJ2, Mesa mesa) {
		SituacaoNoJogo novaSituacao = new SituacaoNoJogo(jogador1, ultimaJogadaJ1, jogador2, ultimaJogadaJ2,
				jogador1.getMao(), jogador2.getMao(), mesa.getPecasNaMesa());
		this.rodadas.add(novaSituacao);
	}

	/**
	 * Informa que o resultado da partida nesse histórico foi empate.
	 */
	public void setResultadoEmpate() {
		this.empate = true;
		this.vencedor = null;
	}

	/**
	 * Informa o vencedor.
	 * 
	 * @param vencedor o nome do vencedor.
	 */
	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
		this.empate = false;
	}
	
	/**
	 * Informa se o jogo deu empate.
	 * @return valor booleano que indica se a partida empatou
	 */
	public boolean isEmpate() {
		return empate;
	}
	
	/**
	 * Retorna o vencedor
	 * @return nome do vencedor.
	 */
	public String getVencedor() {
		return vencedor;
	}
	
	/**
	 * Informa os pontos da batida do vencedor.
	 * @return pontos do vencedor.
	 */
	public int getPontosVencedor() {
		return pontosVencedor;
	}
	
	/**
	 * muda valor dos pontos da batida feita pelo vencedor.
	 * @param pontos valor dos pontos da batida
	 */
	public void setPontosVencedor(int pontos) {
		this.pontosVencedor = pontos;
	}
	
	/**
	 * Para testes.Retorna o número de rodadas já jogadas.
	 * @return o número de rodadas já jogadas.
	 */
	public int getNumeroDeRodadas() {
		return rodadas.size();
	}

	@Override
	public String toString() {
		String o = "==\n== Novo Jogo \n==";
		for (int i = 0; i < rodadas.size(); i++) {
			o += "\nRodada " + i + "\n" + rodadas.get(i).toString();
		}

		o += "\n--RESULTADO: " + (this.isEmpate() ? "EMPATE\n" : ("VITÓRIA DE " + getVencedor()) + "\n");
		return o;
	}

	/**
	 * Classe privada para encapsular o estado da partida depois de uma rodada.
	 *
	 */
	private class SituacaoNoJogo {
		private Jogada jogadaJ1;
		private Jogada jogadaJ2;
		private List<Peca> maoJ1;
		private List<Peca> maoJ2;
		private List<Peca> mesa;
		private Jogador jogador1;
		private Jogador jogador2;

		public SituacaoNoJogo(Jogador j1, Jogada jogadaJ1, Jogador j2, Jogada jogadaJ2, List<Peca> maoJ1,
				List<Peca> maoJ2, List<Peca> naMesa) {
			this.jogador1 = j1;
			this.jogadaJ1 = jogadaJ1;
			this.jogador2 = j2;
			this.jogadaJ2 = jogadaJ2;
			this.maoJ1 = maoJ1;
			this.maoJ2 = maoJ2;
			this.mesa = naMesa;
		}

		@Override
		public String toString() {
			return "  " + this.jogador1.getNome() + " : " + jogadaJ1.toString() + ", mão: " + maoJ1.toString() + "\n  "
					+ this.jogador2.getNome() + " : " + jogadaJ2.toString() + ", mão: " + maoJ2.toString() + "\n  "
					+ "MESA: " + mesa.toString();
		}
	}
	
	/**
	 * Altera do valor da variavel que informa se foi necessário desempate do jogo.
	 * @param valor
	 */
	public void setDesempate(boolean valor) {
		this.desempate = valor;
	}
	
	/**
	 * Retorna variavel que informa se foi necessário desempate do jogo.
	 * @return a variavél desempate
	 */
	public boolean getDesempate() {
		return desempate;
	}
}
