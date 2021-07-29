package ufcg.ccc.domino.estrategia;

import java.util.ArrayList;
import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;

/**
 * Classe que joga alternando as estratégias de jogo seguindo a ordem da lista de estratatégias que foi
 * passada como parâmetro para o construtor.
 * @author carolina
 *
 */
public class EstrategiaDeJogoComposta implements EstrategiaDeJogo {
	
	/**
	 * Lista com as estratégias na ordem em que devem ser usadas,
	 */
	private List<EstrategiaDeJogo> estrategias;
	
	/**
	 * Posição atual da lista de estratégias que deve ser acessada para que seja
	 * selecionada a estratégia correta. É incrementada em 1 cada vez que decideJogada é invocado.
	 */
	private int posicaoLista;
	
	/**
	 * Tamanho da lista de estratégias.
	 */
	private int tamanhoLista;
	
	/**
	 * Estratégia atual da lista.
	 */
	EstrategiaDeJogo estrategiaAtual;
	
	/**
	 * Construtor da estratégia.
	 * @param estrategias Lista com as estratégias
	 */
	public EstrategiaDeJogoComposta(List<EstrategiaDeJogo>estrategias) {
		this.estrategias = new ArrayList<>(estrategias);
		this.posicaoLista = 0;
		this.tamanhoLista = estrategias.size();
		this.estrategiaAtual = null;
	}
	
	/**
	 * Método que decide a jogada atual. A posição atual é determinada pela posicaoLista módulo tamanho da lista.
	 * Pois cada vez que o método decideJogada é invocado posicaoLista é incrementado em um.
	 * A estratégia atual é determinada por meio do acesso ao elemento "posicaoAtual" da lista de estratégias.
	 */
	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		int posicaoAtual = ((posicaoLista % tamanhoLista + tamanhoLista) % tamanhoLista);
		posicaoLista += 1;
		
		this.estrategiaAtual = estrategias.get(posicaoAtual);
		
		return estrategiaAtual.decideJogada(mao,mesa);
	}
	
	@Override
	public String toString() {
		return "Estratégia de jogo composta";
	}
	
	/**
	 * 
	 * @return to string da estratégia atual em uso da lista de estratégias.
	 */
	public String getEstrategiaAtualDaLista() {
		return estrategiaAtual.toString();
	}
}
