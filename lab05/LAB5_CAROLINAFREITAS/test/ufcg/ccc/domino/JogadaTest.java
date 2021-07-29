package ufcg.ccc.domino;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada.TipoJogada;

class JogadaTest {

	@Test
	void testJogadaPassa() {
		Jogada j1 = new Jogada();
		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}

	@Test
	void testJogadaComPecaNaEsquerda() {
		Jogada j1 = new Jogada(new Peca(1, 1), TipoJogada.NA_ESQUERDA);
		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
	}
	
	@Test
	void testJogadaComPecaNaDireita() {
		Jogada j1 = new Jogada(new Peca(2, 3), TipoJogada.NA_DIREITA);
		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
	}
	
	@Test
	void testGetPecaDaJogada() {
		Peca peca = new Peca(1, 6);
		Jogada j1 = new Jogada(peca,TipoJogada.NA_DIREITA);
		assertEquals(peca,j1.getPeca());
	}
}
