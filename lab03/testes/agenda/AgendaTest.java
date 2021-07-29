package agenda;

/**
 * Classe que testa a classe Agenda.
 * 
 * @author Carolina Martins Freitas - 120110894
 *
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {
	
	private Agenda agendaBase;
	
	/**
	 * Método que cria o objeto da classe que será testado.
	 */
	@BeforeEach
    void preparaAgenda() {
        this.agendaBase = new Agenda();
    }
	
	/**
	 * Teste que Cadastra um novo contato em posição vazia.
	 */
	@Test
	void testCadastraContatoPosicaoVazia() {
		this.agendaBase.cadastraContato(5, "Matheus", "Gaudencio", "(83)99999-0000", "(83)99999-0001", "(83)99999-0002");
	}
	
	/**
	 * Teste que Cadastra um contato na posição de limite inferior(1).
	 */
	@Test
	void testCadastraContatoLimiteInferior() {
		this.agendaBase.cadastraContato(1, "Pedro", "Silva", "(83)99999-5555", "(83)99999-6666", "(83)99999-7777");
	}
	
	/**
	 * Teste que Cadastra um contato na posição de limite superior(100).
	 */
	@Test
	void testCadastraContatoLimiteSuperior() {
		this.agendaBase.cadastraContato(100, "João", "Santos", "(83)99999-8888", "(83)99999-9999", "(83)99999-1010");
	}
	
	/**
	 * Teste que cadastra um novo contato em posição existente.
	 */
	@Test
	void testCadastraContatoPosicaoExistente() {
		this.agendaBase.cadastraContato(70, "João", "Luiz", "(83)99999-8888", "(83)99999-9999", "(83)99999-1010");
		this.agendaBase.cadastraContato(70, "Rodrigo", "Almeida", "(83)99999-8888", "(83)99999-9999", "(83)99999-1010");
	}
	
	/**
	 * Teste que cadastra um novo contato em uma posição acima do limite(101).
	 */
	@Test
	void testCadastraContatoAcimaLimite() {
		try {
			this.agendaBase.cadastraContato(101, "Juliette", "Freire", "(83)9988-5555", "(83)9988-6666", "(83)9988-7777");
			fail("Posição acima do limite");
		} catch (IndexOutOfBoundsException re) {
			
		}
	}
	
	/**
	 * Teste que cadastra um novo contato em uma posição abaixo do limite(0).
	 */
	@Test
	void testCadastraContatoAbaixoLimite() {
		try {
			this.agendaBase.cadastraContato(0, "Gilberto", "Nogueira", "(83)9977-0000", "(83)9988-1111", "(83)9999-2222");
			fail("Posição abaixo do limite");
		} catch (IndexOutOfBoundsException re) {
			
		}	
	}
	
	/**
	 * Teste que cadastra um novo contato sem o telefone adicional.
	 * 
	 */
	@Test
	void testCadastraContatoSemUmTelefone() {
		this.agendaBase.cadastraContato(60, "Pro", "Jota", "(83)3333-0000", "(83)3333-0001");
	}
	
	/**
	 * Teste que cadastra um novo contato sem o telefone adicional em posição existente.
	 * 
	 */
	@Test
	void testCadastraContatoSemUmTelefonePosExistente() {
		this.agendaBase.cadastraContato(72, "João", "Luiz", "(83)99999-8888", "(83)99999-9999");
		this.agendaBase.cadastraContato(72, "Rodrigo", "Almeida", "(83)99799-8888", "(83)99999-9789");
	}
	
	
	/**
	 * Teste que cadastra um novo contato sem o telefone adicional na posição limite superior(100).
	 * 
	 */
	@Test
	void testCadastraContatoSemUmTelefoneLimiteSuperior() {
		this.agendaBase.cadastraContato(100, "Clarice", "Lispector", "(83)3333-5555", "(83)3333-6611");
	}
	
	
	/**
	 * Teste que cadastra um novo contato sem telefone adicional em uma posição acima do limite(101).
	 */
	@Test
	void testCadastraContatoSenUmTelefoneAcimaLimite() {
		try {
			this.agendaBase.cadastraContato(101, "Juliette", "Freire", "(83)9988-5555", "(83)9988-6666");
			fail("Posição acima do limite");
		} catch (IndexOutOfBoundsException re) {
			
		}
	}
	
	/**
	 * Teste que cadastra um novo contato sem o telefone adicional na posição limite inferior(1).
	 * 
	 */
	@Test
	void testCadastraContatoSemUmTelefoneLimiteInferior() {
		this.agendaBase.cadastraContato(1, "George", "Orwell", "(85)3333-5555", "(85)3333-6611");
	}
	
	/**
	 * Teste que cadastra um novo contato sem telefone adicional em uma posição abaixo do limite(0).
	 */
	@Test
	void testCadastraContatoSenUmTelefoneAbaixoLimite() {
		try {
			this.agendaBase.cadastraContato(0, "Carl", "Sagan", "(83)2288-5555", "(81)9988-2226");
			fail("Posição abaixo do limite");
		} catch (IndexOutOfBoundsException re) {
			
		}
	}
	
	
	/**
	 * Teste que cadastra contato vindo do arquivo CSV.
	 */
	@Test
	void testCadastraContatocsv() {
		this.agendaBase.cadastraContato(20, "Fabio", "Morais", "(83)9977-0000", "(83)9988-1111", "(83)9999-2222", 1, 1);
	}
	
	/**
	 * Teste que cadastra contato vindo do arquivo CSV em uma posição inválida.
	 */
	@Test
	void testCadastraContatocsvPosInvalida() {
		try {
			this.agendaBase.cadastraContato(0, "Fabio", "Morais", "(83)9977-0000", "(83)9988-1111", "(83)9999-2222", 2, 2);
			fail("Acesso de posição inválida");
		} catch(ArrayIndexOutOfBoundsException ae) {
			
		}
	}
	
	/**
	 * Teste que cadastra contato vindo do arquivo CSV, sem o telefone adicional.
	 */
	@Test
	void testCadastraContatocsvSemUmTelefone() {
		this.agendaBase.cadastraContato(40, "Fabio", "Morais", "(83)9977-0000", "(83)9988-1111", "", 1, 2);
	}
	
	
	/**
	 * Teste que adiciona um contato a lista de favoritos.
	 */
	@Test
	void testAdicionaFavorito() {
		this.agendaBase.cadastraContato(40, "Carolina", "Freitas", "(83)9999-0000", "(83)9999-777");
		assertEquals(this.agendaBase.adicionaFavorito(3, "Carolina Freitas", 40),true);
	}
	
	/**
	 * Teste que adiciona um contato a lista de favoritos na posição do limite inferior(1).
	 */
	@Test
	void testAdicionaFavoritoLimiteInferior() {
		this.agendaBase.cadastraContato(40, "Carolina", "Freitas", "(83)9999-0000", "(83)9999-777");
		assertEquals(this.agendaBase.adicionaFavorito(1, "Carolina Freitas", 40),true);
	}
	
	/**
	 * Teste que adiciona um contato a lista de favoritos na posição do limite superior(10)
	 */
	@Test
	void testAdicionaFavoritoLimiteSuperior() {
		this.agendaBase.cadastraContato(40, "Carolina", "Freitas", "(83)9999-0000", "(83)9999-777");
		assertEquals(this.agendaBase.adicionaFavorito(10, "Carolina Freitas", 40),true);
	}
	
	/**
	 * Teste que adiciona um contato a lista de favoritos em posição já existente.
	 */
	@Test
	void testAdicionaFavoritoPosicaoExistente() {
		this.agendaBase.cadastraContato(40, "Carol", "Martins", "(83)9999-0022", "(83)9999-777", "(83)9882-8761");
		this.agendaBase.adicionaFavorito(7, "Carol Martins", 40);
		this.agendaBase.cadastraContato(41, "Carla", "Diaz", "9997-8899", "2222-5555", "3344-7799");
		assertEquals(this.agendaBase.adicionaFavorito(7, "Carla Diaz", 41),true);
	}
	
	/**
	 * Teste que adiciona um contato a lista de favoritos em posição abaixo do limite(0).
	 */
	@Test
	void testAdicionaFavoritoAbaixoLimite() {
		this.agendaBase.cadastraContato(22, "Matheus", "Gaudencio", "(83)8877-9999", "(83)9955-2233");
		assertEquals(this.agendaBase.adicionaFavorito(0, "Matheus Gaudencio", 22),false);
	}
	
	/**
	 * Teste que adiciona um contato a lista de favoritos em posição acima do limite(11).
	 */
	@Test
	void testAdicionaFavoritoAcimaLimite() {
		this.agendaBase.cadastraContato(55, "Rita", "Lee", "(83)0077-9999", "(83)9922-2233");
		assertEquals(this.agendaBase.adicionaFavorito(11, "Rita Lee", 55),false);
	}
	
	/**
	 * Testa adicionar um mesmo contato já colocado em outra posição da lista de favoritos novamente.
	 */
	@Test
	void testAdicionaFavoritoJaCadastrado() {
		this.agendaBase.cadastraContato(9, "Camilla", "de Lucas", "(83)999-4433", "(81)7722-8899");
		this.agendaBase.adicionaFavorito(8, "Camilla de Lucas", 9);
		assertEquals(this.agendaBase.adicionaFavorito(8, "Camilla de Lucas", 4),false);
	}
	
	
	/**
	 * Testa o método que verifica se o contato já existe na agenda.
	 */
	@Test
	void testExisteContato() {
		this.agendaBase.cadastraContato(15, "Joao", "da Silva", "3355-2277", "4455-0077", "3355-1122");
		assertEquals(this.agendaBase.existeContato("Joao", "da Silva"),true);
	}
	
	/**
	 * Testa o método que verifica se o contato já existe na agenda, porém com um contato inexistente.
	 */
	@Test
	void testExisteContatoQueNaoExiste() {
		assertEquals(this.agendaBase.existeContato("Marie", "Curie"), false);
	}
	
	/**
	 * Testa o método exibir contato.
	 */
	@Test
	void testExibirContato() {
		this.agendaBase.cadastraContato(1, "Matheus", "Gaudencio", "(83)99999-0000", "(83)99999-0001", "(83)99999-0002");
		String msg = "Matheus" + " " + "Gaudencio" + "\n" + "(83)99999-0000" + " (Prioritário)\n" + "(83)99999-0001" + " (Whatsapp)\n" + "(83)99999-0002" + " (Adicional)\n";
		assertEquals(this.agendaBase.exibirContato(1), msg);
	}
	
	/**
	 * Testa o método exibir contato, mas sem o telefone adicional.
	 */
	@Test
	void testExibirContatoSemUmTelefone() {
		this.agendaBase.cadastraContato(1, "Matheus", "Gaudencio", "(83)99999-0000", "(83)99999-0001");
		String msg = "Matheus" + " " + "Gaudencio" + "\n" + "(83)99999-0000" + " (Prioritário)\n" + "(83)99999-0001" + " (Whatsapp)\n";
		assertEquals(this.agendaBase.exibirContato(1), msg);
	}
	
	/**
	 * Testa o método exibir contato de uma posição vazia
	 */
	@Test
	void testExibirContatoPosicaoSemContato() {
		try {
			this.agendaBase.exibirContato(12);
			fail("Acesso de posição inválida");
		} catch(NullPointerException ne) {
			
		}
	}
	
	/**
	 * Testa o método exibir contato de uma posição abaixo do limite(0).
	 */
	@Test
	void testExibirContatoAbaixoLimite() {
		try {
			this.agendaBase.exibirContato(0);
			fail("Acesso de posição inválida");
		} catch(ArrayIndexOutOfBoundsException ae) {
			
		}
	}
	
	/**
	 * Testa o método exibir contato de uma posição acima do limite(101).
	 */
	@Test
	void testExibirContatoAcimaLimite() {
		try {
			this.agendaBase.exibirContato(101);
			fail("Acesso de posição inválida");
		} catch(ArrayIndexOutOfBoundsException ae) {
			
		}
	}
	
	/**
	 * Testa o método exibir contato, exibindo um contato favoritado.
	 */
	@Test
	void testExibirContatoFavoritado() {
		this.agendaBase.cadastraContato(1, "Matheus", "Gaudencio", "(83)99999-0000", "(83)99999-0001", "(83)99999-0002");
		this.agendaBase.adicionaFavorito(1, "Matheus Gaudencio", 1);
		String msg = "❤️ " + "Matheus" + " " + "Gaudencio" + "\n" + "(83)99999-0000" + " (Prioritário)\n" + "(83)99999-0001" + " (Whatsapp)\n" + "(83)99999-0002" + " (Adicional)\n";
		assertEquals(this.agendaBase.exibirContato(1), msg);
	}
	
	/**
	 * Testa o método exibir contato, exibindo um contato favoritado mas sem o número adicional.
	 */
	@Test
	void testExibirContatoFavoritadoSemUmTel() {
		this.agendaBase.cadastraContato(1, "Matheus", "Gaudencio", "(83)99999-0000", "(83)99999-0001");
		this.agendaBase.adicionaFavorito(1, "Matheus Gaudencio", 1);
		String msg = "❤️ " + "Matheus" + " " + "Gaudencio" + "\n" + "(83)99999-0000" + " (Prioritário)\n" + "(83)99999-0001" + " (Whatsapp)\n";
		assertEquals(this.agendaBase.exibirContato(1), msg);
	}

}
