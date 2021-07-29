package ufcg.ccc.domino.estrategia;

import java.util.ArrayList;
import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Peca;


/**
 * Joga primeiro as carroças antes das peças normais.Tenta primeiro no lado direito e
 * depois no lado esquerdo caso a peça se encaixe em ambos.
 * @author carolina
 */
public class JogaPrimeiroCarroca implements EstrategiaDeJogo {
	
	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		ArrayList<Peca> carrocas = new ArrayList<Peca>();
		ArrayList<Peca> pecasNormais = new ArrayList<Peca>();
		
		for(Peca peca : mao) {
			if(peca.getNumDireito() == peca.getNumEsquerdo()) {
				carrocas.add(peca);
			}
			else {
				pecasNormais.add(peca);
			}
		}
		
		if (mesa.getNumPecas() == 0) {
			if(carrocas.size() > 0) {
				return new Jogada(carrocas.get(0), TipoJogada.NA_DIREITA);
			}
			else {
				return new Jogada(pecasNormais.get(0), TipoJogada.NA_DIREITA);
			}
		}

		for (Peca peca : carrocas) {
			if (peca.encaixa(mesa.getNumNaDireita())) {
				return new Jogada(peca, TipoJogada.NA_DIREITA);
			}
			if (peca.encaixa(mesa.getNumNaEsquerda())) {
				return new Jogada(peca, TipoJogada.NA_ESQUERDA);
			}
		}
		
		for (Peca peca : pecasNormais) {
			if (peca.encaixa(mesa.getNumNaDireita())) {
				return new Jogada(peca, TipoJogada.NA_DIREITA);
			}
			if (peca.encaixa(mesa.getNumNaEsquerda())) {
				return new Jogada(peca, TipoJogada.NA_ESQUERDA);
			}
		}

		return new Jogada();
	}

	@Override
	public String toString() {
		return "Joga Primeiro Carroça";
	}
	
}
