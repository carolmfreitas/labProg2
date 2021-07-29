package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.PecaPadraoComparator;
import ufcg.ccc.domino.Jogada.TipoJogada;

public class JogaPrimeiraPossivelComparadoraTest {
	private Mesa mesa;
	private Comparator<Peca>cmp;

	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 1));
		cmp = new PecaPadraoComparator();
	}

	@Test
	void testSortMao1() {
		JogaPrimeiraPossivelComparadora estrategia = new JogaPrimeiraPossivelComparadora(cmp);
		
		List<Peca> mao = new ArrayList<>();
		mao.add(new Peca(2,4));
		mao.add(new Peca(1,2));
		mao.add(new Peca(1,1));
		mao.add(new Peca(1,3));
		mao.add(new Peca(1,4));
		mao.add(new Peca(1,5));
		mao.add(new Peca(1,6));
		mao.add(new Peca(2,2));
		mao.add(new Peca(2,3));
		
		List<Peca> maoOrdenada = Arrays.asList(new Peca(1,1), new Peca(1,2), new Peca(1,3), 
				                                new Peca(1,4), new Peca(1,5), new Peca(1,6), 
				                                new Peca(2,2), new Peca(2,3), new Peca(2,4));

		Jogada j1 = estrategia.decideJogada(mao, mesa);
		
		assertEquals(maoOrdenada,mao);
		
		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals("1:1", (j1.getPeca().toString()));
	}
	
	@Test
	void testSortMao2() {
		JogaPrimeiraPossivelComparadora estrategia = new JogaPrimeiraPossivelComparadora(cmp);
		
		List<Peca> mao = new ArrayList<>();
		mao.add(new Peca(2,4));
		mao.add(new Peca(1,3));
		mao.add(new Peca(1,4));
		mao.add(new Peca(1,5));
		mao.add(new Peca(1,6));
		mao.add(new Peca(2,2));
		mao.add(new Peca(2,3));
		
		List<Peca> maoOrdenada = Arrays.asList( new Peca(1,3), new Peca(1,4), new Peca(1,5), new Peca(1,6), 
				                                new Peca(2,2), new Peca(2,3), new Peca(2,4));

		Jogada j1 = estrategia.decideJogada(mao, mesa);
		
		assertEquals(maoOrdenada,mao);
		
		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals("1:3", (j1.getPeca().toString()));
	}
	
	@Test
	void testSortMao3() {
		JogaPrimeiraPossivelComparadora estrategia = new JogaPrimeiraPossivelComparadora(cmp);
		
		List<Peca> mao = new ArrayList<>();
		mao.add(new Peca(3,3));
		mao.add(new Peca(6,5));
		mao.add(new Peca(5,6));
		mao.add(new Peca(2,2));
		mao.add(new Peca(4,1));
		
		List<Peca> maoOrdenada = Arrays.asList( new Peca(2,2), new Peca(3,3), new Peca(4,1), 
				                                new Peca(5,6), new Peca(6,5));

		Jogada j1 = estrategia.decideJogada(mao, mesa);
		
		assertEquals(maoOrdenada,mao);
		
		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals("2:2", (j1.getPeca().toString()));
	}
	
	@Test
	void testToString() {
		JogaPrimeiraPossivelComparadora estrategia = new JogaPrimeiraPossivelComparadora(cmp);
		assertEquals("Joga Primeira Possível Comparadora",estrategia.toString());
	}
}
