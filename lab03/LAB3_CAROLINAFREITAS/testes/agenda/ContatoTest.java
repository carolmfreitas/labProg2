package agenda;

/**
 * Classe que testa a classe Contato.
 * 
 * @author Carolina Martins Freitas - 120110894
 *
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContatoTest {
	
	private Contato contatoBase1;
	private Contato contatoBase2;
	private Contato contatoBase3;
	private Contato contatoBase4;
	
	/**
	 * Método que cria objetos da classe que serão testados.
	 */
	@BeforeEach
    void preparaContato() {
        this.contatoBase1 = new Contato("Carolina","Freitas","(83)99999-1111","(83)99999-2222","(83)99999-3333");
        this.contatoBase2 = new Contato("Carolina","Freitas", "(11)9973-1999", "(11)9973-1998", "(11)9973-1994");
        this.contatoBase3 = new Contato("Livia", "Campos", "(81)9973-2999", "(83)9973-2998", "(16)9973-2994");
        this.contatoBase4 = new Contato("José","Pereira","(83)99999-1111","(83)99999-2222","(83)99999-3333");
    }
	
	/**
	 * Testa o construtor da classe Contato
	 */
	@Test
	void testContatoStringStringStringStringString() {
		new Contato("Matheus","Gaudencio","(83)99999-0000","(83)99999-0001","(83)99999-0002");
	}
	
	/**
	 * Testa o construtor da classe Contato, porém sem o número adicional
	 */
	@Test
	void testContatoStringStringStringString() {
		new Contato("Matheus","Gaudencio","(83)99999-0000","(83)99999-0001");
	}
	
	/**
	 * Testa o método equals. Dois contatos são iguais apenas se tiverem o mesmo nome.
	 */
	@Test
	void testEqualsTrue() {
		assertEquals(contatoBase1.equals(contatoBase2),true);
	}
	
	/**
	 * Testa o método equals. Dois contatos são iguais apenas se tiverem o mesmo nome.
	 */
	@Test
	void testEqualsFalse() {
		assertEquals(contatoBase1.equals(contatoBase3),false);
	}
	
	/**
	 * Testa o método equals. Dois contatos são iguais apenas se tiverem o mesmo nome.
	 */
	@Test
	void testEqualsFalse2() {
		assertEquals(contatoBase1.equals(contatoBase4),false);
	}

}