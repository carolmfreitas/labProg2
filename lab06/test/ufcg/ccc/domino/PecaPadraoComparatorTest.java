package ufcg.ccc.domino;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PecaPadraoComparatorTest {
	
	PecaPadraoComparator pecaComparator;
	
	@BeforeEach
	void setUp() {
		pecaComparator = new PecaPadraoComparator();
	}
	
	@Test
	public void testComparatorNeg() { //peca1 vem antes de peca2
		Peca peca1 = new Peca(1,3);
		Peca peca2 = new Peca(2,2);
		
		assertEquals(-1,pecaComparator.compare(peca1, peca2));
	}
	
	@Test
	public void testComparatorZero() { //peca1 é igual a peça 2
		Peca peca1 = new Peca(1,3);
		Peca peca2 = new Peca(1,3);
		
		assertEquals(0,pecaComparator.compare(peca1, peca2));
	}
	
	@Test
	public void testComparatorPos() { //peca2 vem antes de peca1
		Peca peca1 = new Peca(2,4);
		Peca peca2 = new Peca(1,1);
		
		assertEquals(1,pecaComparator.compare(peca1, peca2));
	}
}
