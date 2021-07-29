package ufcg.ccc.domino;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;

class JogoTest {

	@Test
	void testRodadaInicial() throws JogadaInvalidaException, EstrategiaInvalidaException {
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), 14);

		assertEquals(0, j.getNumRodadas());
		assertEquals(14, j.getNumPecasJ1());
		assertEquals(14, j.getNumPecasJ2());

		j.rodada();

		assertEquals(1, j.getNumRodadas());
		assertEquals(13, j.getNumPecasJ1());
		assertEquals(13, j.getNumPecasJ2());
	}
	
	@Test
	void testJogoAleatorio() throws JogadaInvalidaException, EstrategiaInvalidaException {
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), 10, new Random(1));

		HistoricoDeJogo historico = j.jogaJogoCompleto();

		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		
		System.out.println(historico.toString());
	}

	@Test
	void testVencedorJ1Simples() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(0, 1));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		assertFalse(j.isFinalizado());
		assertEquals(null, j.getVencedor());

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
	}
	
	@Test
	void testEmpate() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertNull(j.getVencedor());
	}
	
	@Test
	void testVitoriaJ2() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(6, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(1, 2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
	}
	
	@Test
	void testDesempateMenosPecasNaMao() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 6), new Peca(1,3));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(5, 5), new Peca(2,2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals(j.getVencedor(),"J1");
	}
	
	@Test
	void testDesempateMenosPecasNaMao2() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 6), new Peca(1,3), new Peca(6,6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(2, 2), new Peca(3,2), new Peca(5,5));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals(j.getVencedor(),"J2");
	}
	
	@Test
	void testDesempateSomaPecasNaMao() throws Exception {
		List<Peca> mao1 = List.of(new Peca(3, 4), new Peca(0, 0), new Peca(1, 1));
		List<Peca> mao2 = List.of(new Peca(4, 4), new Peca(5, 5), new Peca(6, 6));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals(j.getVencedor(),"J1");
	}
	
	@Test
	void testDesempateSomaPecasNaMao2() throws Exception {
		List<Peca> mao1 = List.of(new Peca(2, 3), new Peca(5, 5), new Peca(6, 6));
		List<Peca> mao2 = List.of(new Peca(3, 4), new Peca(1, 0), new Peca(0, 0));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals(j.getVencedor(),"J2");
	}
	
	@Test
	void testPontuacaoVitoriaLaELoDeCarroca() throws Exception {
		List<Peca> mao1 = List.of(new Peca(3, 4), new Peca(4, 3), new Peca(3, 3));
		List<Peca> mao2 = List.of(new Peca(4, 4), new Peca(5, 5), new Peca(6, 6));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals(j.getVencedor(),"J1");
		assertEquals(j.getPontosVencedor(),6); //lá e ló de carroça
	}
	
	@Test
	void testPontuacaoVitoriaCarroca() throws Exception {
		List<Peca> mao1 = List.of(new Peca(1, 4), new Peca(4, 3), new Peca(3, 3));
		List<Peca> mao2 = List.of(new Peca(4, 4), new Peca(5, 5), new Peca(6, 6));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals(j.getVencedor(),"J1");
		assertEquals(j.getPontosVencedor(),2); //carroça
	}
	
	@Test
	void testPontuacaoVitoriaLaELo() throws Exception {
		List<Peca> mao1 = List.of(new Peca(2, 4), new Peca(4, 3), new Peca(2, 3));
		List<Peca> mao2 = List.of(new Peca(4, 4), new Peca(5, 5), new Peca(6, 6));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals(j.getVencedor(),"J1");
		assertEquals(j.getPontosVencedor(),3); //lá e ló 
	}
	
	@Test
	void testPontuacaoVitoriaBatidaNormal() throws Exception {
		List<Peca> mao1 = List.of(new Peca(2, 4), new Peca(4, 3), new Peca(1, 3));
		List<Peca> mao2 = List.of(new Peca(4, 4), new Peca(5, 5), new Peca(6, 6));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals(j.getVencedor(),"J1");
		assertEquals(j.getPontosVencedor(),1); //batida normal
	}
	
	@Test
	void testPontuacaoVitoriaDesempateMenosPecasNaMao() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 6), new Peca(1,0));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(5, 5), new Peca(2,2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals(j.getVencedor(),"J1");
		assertTrue(j.getDesempate());
		assertEquals(j.getPontosVencedor(),1); //a pontuação é zero 1 o vencedor ganhou por desempate
	}
	
	@Test
	void testPontuacaoVitoriaDesempateSomaPecasNaMao() throws Exception {
		List<Peca> mao1 = List.of(new Peca(6, 6), new Peca(1, 0), new Peca(0,0));
		List<Peca> mao2 = List.of(new Peca(6, 5), new Peca(4, 4), new Peca(2,2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals(j.getVencedor(),"J1");
		assertTrue(j.getDesempate());
		assertEquals(j.getPontosVencedor(),1); //a pontuação é 1 pois o vencedor ganhou por desempate
	}
	
	@Test
	void testToString() throws Exception {
		List<Peca> mao1 = List.of(new Peca(6, 6), new Peca(1, 0), new Peca(0,0));
		List<Peca> mao2 = List.of(new Peca(6, 5), new Peca(4, 4), new Peca(2,2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);
		
		j.jogaJogoCompleto();
		
		assertEquals("J1, joga: Passou, mão: [1:0, 0:0]\n"
				+ "J2, joga: Passou, mão: [4:4, 2:2]\n"
				+ "Mesa:  6:6 6:5",j.toString());
	}
}
