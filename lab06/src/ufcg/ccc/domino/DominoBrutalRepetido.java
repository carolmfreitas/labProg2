package ufcg.ccc.domino;

import java.util.ArrayList;
import java.util.List;

import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;
import ufcg.ccc.domino.estrategia.EstrategiaDeJogoComposta;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;
import ufcg.ccc.domino.estrategia.JogaPrimeiroCarroca;
import ufcg.ccc.domino.estrategia.JogaPrimeiroCarrocaMaiorValor;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivelComparadora;

/**
 * Exemplo de como fazer um um main com uma disputa de muuuitos jogos entre duas
 * estratégias.
 * 
 */
public class DominoBrutalRepetido {
	
	private static final int NUM_PECAS_INICIAL = 12;
	private static final int REPETICOES = 50000;

	public static void main(String[] args) throws EstrategiaInvalidaException, JogadaInvalidaException {
		float vitoriasJ1 = 0, vitoriasJ2 = 0, empates = 0;
		float pontosJ1 = 0, pontosJ2 = 0;
		int[] tiposVitoriaJ1 = {0,0,0,0,0}; //array com tipos de vitoria, na ordem: batida normal, carroça, lá e ló, lá, ló de carroça e por desempate
		int[] tiposVitoriaJ2 = {0,0,0,0,0};
		ArrayList<EstrategiaDeJogo> estrategias = new ArrayList<EstrategiaDeJogo>();
		estrategias.add(new JogaPrimeiroCarrocaMaiorValor());
		estrategias.add(new JogaPrimeiraPossivel());
		estrategias.add(new JogaPrimeiroCarroca());

		EstrategiaDeJogo estrategia1 = new EstrategiaDeJogoComposta(estrategias), estrategia2 = new JogaPrimeiraPossivelComparadora(new PecaPadraoComparator()); 
		
		for (int i = 0; i < REPETICOES; i++) {
			
			Jogo j;
			
			// Cada estratégia começa jogando metade das partidas.
			if( i < REPETICOES / 2) {
				j = new Jogo("J1", estrategia1, "J2", estrategia2, NUM_PECAS_INICIAL);
			} else {
				j = new Jogo("J2", estrategia2, "J1", estrategia1, NUM_PECAS_INICIAL);
			}
			
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.isEmpate()) {
				empates++;
			} else if (historico.getVencedor() == "J1") {
				vitoriasJ1++;
				float pontos = historico.getPontosVencedor();
				pontosJ1 += pontos;
				if(pontos == 1.0) {
					if(historico.getDesempate() == true) {
						tiposVitoriaJ1[4]++;
					}
					else {
						tiposVitoriaJ1[0]++;
					}
				}
				else if(pontos == 2.0) {
					tiposVitoriaJ1[1]++;
				}
				else if(pontos == 3.0) {
					tiposVitoriaJ1[2]++;
				}
				else if(pontos == 6.0) {
					tiposVitoriaJ1[3]++;
				}
			} else if (historico.getVencedor() == "J2") {
				vitoriasJ2++;
				float pontos = historico.getPontosVencedor();
				pontosJ2 += pontos;
				if(pontos == 1.0) {
					if(historico.getDesempate() == true) {
						tiposVitoriaJ2[4]++;
					}
					else {
						tiposVitoriaJ2[0]++;
					}
				}
				else if(pontos == 2.0) {
					tiposVitoriaJ2[1]++;
				}
				else if(pontos == 3.0) {
					tiposVitoriaJ2[2]++;
				}
				else if(pontos == 6.0) {
					tiposVitoriaJ2[3]++;
				}
			}
		}

		System.out.println(
				"E1: " + estrategia1.toString() 
				+ "\nE2: " + estrategia2.toString()
				+ "\nJogos:\t" + (REPETICOES) 
				+ "\n- Vitórias E1:\t" + vitoriasJ1 + " vitórias (" + Math.round(vitoriasJ1 / REPETICOES * 100) + "%)" 
				+ "\n- Vitórias E2:\t" + vitoriasJ2 + " vitórias (" + Math.round(vitoriasJ2 / REPETICOES * 100) + "%)"
				+ "\n- Empates:\t" + empates + "\t\t(" + Math.round(empates / REPETICOES * 100) + "%)"
				+ "\n\nPontuações"
				+ "\n- Pontos E1:\t" + pontosJ1
				+ "\nTipos de vitória Jogador1:"
				+ "\n\tBatida normal:\t\t" + tiposVitoriaJ1[0] + " vitórias"
				+ "\n\tBatida de carroça:\t" + tiposVitoriaJ1[1] + " vitórias"
				+ "\n\tLá e ló:\t\t" + tiposVitoriaJ1[2] + " vitórias"
				+ "\n\tLá e ló de carroça:\t" + tiposVitoriaJ1[3] + " vitórias"
				+ "\n\tPor desempate:\t\t" + tiposVitoriaJ1[4] + " vitórias"
				+ "\n\n- Pontos E2:\t" + pontosJ2
				+ "\nTipos de vitória Jogador2:"
				+ "\n\tBatida normal:\t\t" + tiposVitoriaJ2[0] + " vitórias"
				+ "\n\tBatida de carroça:\t" + tiposVitoriaJ2[1] + " vitórias"
				+ "\n\tLá e ló:\t\t" + tiposVitoriaJ2[2] + " vitórias"
				+ "\n\tLá e ló de carroça:\t" + tiposVitoriaJ2[3] + " vitórias"
				+ "\n\tPor desempate:\t\t" + tiposVitoriaJ2[4] + " vitórias");
	}
}
