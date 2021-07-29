package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;

public class EstrategiaDeJogoCompostaTest {
	private Mesa mesa;
	private List<EstrategiaDeJogo> estrategias;

	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 1));
		estrategias = new ArrayList<>();
	}

	@Test
	void testTipoEstrategia() {
		estrategias.add(new JogaPrimeiroCarroca());
		estrategias.add(new JogaPrimeiraPossivel());
		
		EstrategiaDeJogoComposta estrategia = new EstrategiaDeJogoComposta(estrategias);
		
		List<Peca> mao1 = List.of(new Peca(4, 4), new Peca(3, 1), new Peca(2, 2));

		Jogada j1 = estrategia.decideJogada(mao1, mesa); //joga primeiro carroça

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals("Joga Primeiro Carroça", estrategia.getEstrategiaAtualDaLista());
		assertEquals("2:2", (j1.getPeca().toString()));
		
		List<Peca> mao2 = List.of(new Peca(4, 4), new Peca(3, 1), new Peca(1,1));
		
		Jogada j2 = estrategia.decideJogada(mao2, mesa); //joga primeira possivel

		assertEquals(TipoJogada.NA_ESQUERDA, j2.getTipo());
		assertEquals("Joga Primeira Possível", estrategia.getEstrategiaAtualDaLista());
		assertEquals("3:1", (j2.getPeca().toString()));
		
		List<Peca> mao3 = List.of(new Peca(5, 5));
		
		Jogada j3 = estrategia.decideJogada(mao3, mesa); //joga primeiro carroça

		assertEquals(TipoJogada.PASSA, j3.getTipo());
		assertEquals("Joga Primeiro Carroça", estrategia.getEstrategiaAtualDaLista());
	}
	
	@Test
	void testTipoEstrategia2() {
		estrategias.add(new JogaPrimeiroCarrocaMaiorValor());
		estrategias.add(new JogaPrimeiraPossivel());
		estrategias.add(new JogaPrimeiroCarroca());
		
		EstrategiaDeJogoComposta estrategia = new EstrategiaDeJogoComposta(estrategias);
		
		List<Peca> mao1 = List.of(new Peca(4, 4), new Peca(3, 1), new Peca(1, 1), new Peca(2,2));

		Jogada j1 = estrategia.decideJogada(mao1, mesa); //joga primeiro carroça maior valor

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals("Joga Primeiro Carroças de maior valor", estrategia.getEstrategiaAtualDaLista());
		assertEquals("2:2", (j1.getPeca().toString()));
		
		List<Peca> mao2 = List.of(new Peca(4, 4), new Peca(3, 1), new Peca(1, 1), new Peca(2,2));
		
		Jogada j2 = estrategia.decideJogada(mao2, mesa); //joga primeira possivel

		assertEquals(TipoJogada.NA_ESQUERDA, j2.getTipo());
		assertEquals("Joga Primeira Possível", estrategia.getEstrategiaAtualDaLista());
		assertEquals("3:1", (j2.getPeca().toString()));
		
		List<Peca> mao3 = List.of(new Peca(4, 4), new Peca(1, 1), new Peca(2,2));
		
		Jogada j3 = estrategia.decideJogada(mao3, mesa); //joga primeiro carroça

		assertEquals(TipoJogada.NA_ESQUERDA, j3.getTipo());
		assertEquals("Joga Primeiro Carroça", estrategia.getEstrategiaAtualDaLista());
		assertEquals("1:1", (j3.getPeca().toString()));
	}
	
	@Test
	void testEstrategiaUnica() {
		estrategias.add(new JogaPrimeiraPossivel());
		
		EstrategiaDeJogoComposta estrategia = new EstrategiaDeJogoComposta(estrategias);
		
		List<Peca> mao1 = List.of(new Peca(4, 4), new Peca(2, 1), new Peca(2, 2));

		Jogada j1 = estrategia.decideJogada(mao1, mesa); 

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals("Joga Primeira Possível", estrategia.getEstrategiaAtualDaLista());
		assertEquals("2:1", (j1.getPeca().toString()));
		
		List<Peca> mao2 = List.of(new Peca(4, 4), new Peca(2, 2));

		Jogada j2 = estrategia.decideJogada(mao2, mesa); 

		assertEquals(TipoJogada.NA_DIREITA, j2.getTipo());
		assertEquals("Joga Primeira Possível", estrategia.getEstrategiaAtualDaLista());
		assertEquals("2:2", (j2.getPeca().toString()));
	}
	
	@Test
	void testToString() {
		estrategias.add(new JogaPrimeiroCarroca());
		
		EstrategiaDeJogoComposta estrategia = new EstrategiaDeJogoComposta(estrategias);
		assertEquals("Estratégia de jogo composta",estrategia.toString());
	}
	
}
