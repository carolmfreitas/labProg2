package ufcg.ccc.domino;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;

public class HistoricoDeJogoTest {
	
	private Jogador jogador1;
	private Jogador jogador2;
	private Mesa mesa;
	private Jogada jogada1;
	private Jogada jogada2;
	
	@BeforeEach
	void preparaHistorico(){
		List<Peca> mao1 = List.of(new Peca(0, 2), new Peca(2, 3), new Peca(0,5));
		List<Peca> mao2 = List.of(new Peca(2, 2), new Peca(3, 4), new Peca(6,6));
		this.jogador1 = new Jogador("j1", new JogaPrimeiraPossivel(), mao1);
		this.jogador2 = new Jogador("j2", new JogaPrimeiraPossivel(), mao2);
		this.jogada1 = new Jogada();
		this.jogada2 = new Jogada(new Peca(1, 1), TipoJogada.NA_ESQUERDA);
		this.mesa = new Mesa();
	}
	
	@Test
	void testHistoricoDeJogo() {
		new HistoricoDeJogo(jogador1,jogador2);
	}
	
	@Test
	void testAddRodada() {
		HistoricoDeJogo historico = new HistoricoDeJogo(jogador1,jogador2);
		assertEquals(0,historico.getNumeroDeRodadas());
		historico.addRodada(jogada1, jogada2, mesa);
		assertEquals(1,historico.getNumeroDeRodadas());
	}
	
	@Test
	void testSetResultadoEmpate() {
		HistoricoDeJogo historico = new HistoricoDeJogo(jogador1,jogador2);
		historico.setResultadoEmpate();
		assertEquals(true,historico.isEmpate());
	}
	
	@Test
	void testVencedor() {
		HistoricoDeJogo historico = new HistoricoDeJogo(jogador1,jogador2);
		historico.setVencedor("j1");
		assertEquals("j1",historico.getVencedor());
	}
	
	@Test
	void testPontos() {
		HistoricoDeJogo historico = new HistoricoDeJogo(jogador1,jogador2);
		historico.setPontosVencedor(6);
		assertEquals(6,historico.getPontosVencedor());
	}
}