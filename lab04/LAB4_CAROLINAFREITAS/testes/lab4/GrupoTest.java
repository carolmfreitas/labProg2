package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe que testa a classe Grupo.
 * 
 * @author Carolina Martins Freitas
 */
class GrupoTest {
	
	private Grupo grupoTeste1;
	private Grupo grupoTeste2;
	private Grupo grupoTeste3;
	private Grupo grupoTeste4;
	
	/**
	 * Método que cria os objetos da classe que serão testados.
	 */
	@BeforeEach
	void preparaGrupo() {
		this.grupoTeste1 = new Grupo("livros", "computação");
		this.grupoTeste2 = new Grupo("filmes", "");
		this.grupoTeste3 = new Grupo("anatomia", "medicina");
		this.grupoTeste4 = new Grupo("filmes", "computação");
	}
	
	/**
	 * Testa o construtor da classe criando um grupo.
	 */
	@Test
	void testGrupoStringString() {
		new Grupo("leitura", "direito");
	}
	
	/**
	 * Testa o construtor da classe criando um grupo sem restrição.
	 */
	@Test
	void testGrupoString() {
		new Grupo("arte");
	}
	
	/**
	 * Testa o construtor da classe criando um objeto Grupo, passando um nome nulo.
	 */
	@Test
	void testGrupoNomeNull() {
		Exception exception = Assertions.assertThrows(NullPointerException.class, 
				() -> new Grupo(null, "direito"));
		assertEquals("Nome nulo!\n",exception.getMessage());
	}
	
	/**
	 * Testa o construtor da classe criando um objeto Grupo, passando um nome vazio.
	 */
	@Test
	void testGrupoNomeVazio() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> new Grupo("", "direito"));
		assertEquals("Nome inválido!\n",exception.getMessage());
	}
	
	/**
	 * Testa o construtor da classe criando um objeto Grupo, passando uma restrição nula.
	 */
	@Test
	void testGrupoRestricaoNull() {
		Exception exception = Assertions.assertThrows(NullPointerException.class, 
				() -> new Grupo("literatura", null));
		assertEquals("Restrição nula!\n",exception.getMessage());
	}
	
	/**
	 * Testa o método que adiciona um aluno a um grupo de estudos.
	 */
	@Test
	void testAdicionarAluno() {
		String msg = "ALUNO ALOCADO!";
		assertEquals(grupoTeste1.adicionarAluno("200"), msg);
	}
	
	/**
	 * Testa o método que indica se um aluno está no grupo.
	 */
	@Test
	void testAlunoEstaNoGrupoTrue() {
		grupoTeste2.adicionarAluno("205");
		assertEquals(grupoTeste2.alunoEstaNoGrupo("205"),true);
	}
	
	/**
	 * Testa o método que indica se um aluno está no grupo.
	 */
	@Test
	void testAlunoEstaNoGrupoFalse() {
		assertEquals(grupoTeste3.alunoEstaNoGrupo("205"),false);
	}
	
	/**
	 * Testa o método equals da classe.Dois grupos são iguais se tiverem o mesmo nome.
	 */
	@Test
	void testEqualsObjectTrue() {
		assertEquals(grupoTeste2.equals(grupoTeste4),true);
	}
	
	/**
	 * Testa o método equals da classe.Dois grupos são iguais se tiverem o mesmo nome.
	 */
	@Test
	void testEqualsObjectFalse() {
		assertEquals(grupoTeste1.equals(grupoTeste4),false);
	}

}
