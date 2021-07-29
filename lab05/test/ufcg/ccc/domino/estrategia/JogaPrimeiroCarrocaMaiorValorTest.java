package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.JogadaInvalidaException;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;

public class JogaPrimeiroCarrocaMaiorValorTest {
	
	private Mesa mesa;
	private Mesa mesa2;

	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		mesa2 = new Mesa();
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 1));
	}
	
	@Test
	void testPassa() {
		JogaPrimeiroCarrocaMaiorValor estrategia = new JogaPrimeiroCarrocaMaiorValor();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(4, 4), new Peca(0, 3)), mesa);

		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}
	
	@Test
	void testJogaCarrocaADireita() {
		JogaPrimeiroCarrocaMaiorValor estrategia = new JogaPrimeiroCarrocaMaiorValor();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 1), new Peca(2, 2), new Peca(2, 6)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaCarrocaAEsquerda() throws Exception {
		JogaPrimeiroCarrocaMaiorValor estrategia = new JogaPrimeiroCarrocaMaiorValor();
		
		mesa.jogaNaEsquerda(new Peca(3, 1));
		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 3), new Peca(2, 2), new Peca(3, 3)), mesa);

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(3, j1.getPeca().getNumEsquerdo());
		assertEquals(3, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaADireita() {
		JogaPrimeiroCarrocaMaiorValor estrategia = new JogaPrimeiroCarrocaMaiorValor();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(2, 1), new Peca(2, 6), new Peca(3, 6)), mesa);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(6, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaAEsquerda() throws Exception {
		JogaPrimeiroCarrocaMaiorValor estrategia = new JogaPrimeiroCarrocaMaiorValor();
	
		Jogada j1 = estrategia.decideJogada(List.of(new Peca(4, 1), new Peca(4, 4), new Peca(5, 1)), mesa);

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(5, j1.getPeca().getNumEsquerdo());
		assertEquals(1, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testToString() {
		JogaPrimeiroCarrocaMaiorValor estrategia = new JogaPrimeiroCarrocaMaiorValor();
		assertEquals("Joga Primeiro Carroças de maior valor",estrategia.toString());
	}
	
	@Test
	void testJogaMesaVazia() {
		JogaPrimeiroCarrocaMaiorValor estrategia = new JogaPrimeiroCarrocaMaiorValor();
		
		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 1), new Peca(5, 5)), mesa2);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(5, j1.getPeca().getNumEsquerdo());
		assertEquals(5, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaMesaVaziaSemCarrocas() {
		JogaPrimeiroCarrocaMaiorValor estrategia = new JogaPrimeiroCarrocaMaiorValor();
		
		Jogada j1 = estrategia.decideJogada(List.of(new Peca(0, 1), new Peca(5, 3)), mesa2);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(5, j1.getPeca().getNumEsquerdo());
		assertEquals(3, j1.getPeca().getNumDireito());
	}
	
}
