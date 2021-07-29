package ufcg.ccc.domino.estrategia;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;

/**
 * Recebe um Comparator<Peca> como parâmetro e quando decideJogada é invocado ordena 
 * a lista de peças da mão de acordo com a ordem recebida pelo Comparator. No mais, 
 * joga da mesma forma que o JogaPrimeiraPossivel funciona
 * @author carolina
 *
 */
public class JogaPrimeiraPossivelComparadora implements EstrategiaDeJogo {
	
	/**
	 * Comparator que compara as peças, primeiro pelo número esquerdo, depois pelo número da direita
	 */
	Comparator<Peca> cmp;
	
	/**
	 * Construtor da classe.
	 * @param cmp comparator das peças
	 */
	public JogaPrimeiraPossivelComparadora(Comparator<Peca> cmp) {
		this.cmp = cmp;
	}
	
	/**
	 * Ordena a mão do jogador utilizando o Comparator e depois realiza jogada
	 * utilizando a estratégia JogaPrimeiraPossivel.
	 */
	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		
		Collections.sort(mao, cmp);
		
		EstrategiaDeJogo estrategia = new JogaPrimeiraPossivel();
		
		return estrategia.decideJogada(mao,mesa);
	}

	@Override
	public String toString() {
		return "Joga Primeira Possível Comparadora";
	}

}
