package lab4;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe que testa a classe Aluno.
 * 
 * @author Carolina Martins Freitas
 */
class AlunoTest {
	
	private Aluno alunoTeste1;
	private Aluno alunoTeste2;
	private Aluno alunoTeste3;
	
	/**
	 * Método que cria os objetos da classe que serão testados.
	 */
	@BeforeEach
	void preparaAluno() {
		this.alunoTeste1 = new Aluno("Carolina Freitas", "450", "computação");
		this.alunoTeste2 = new Aluno("Carolina Freitas", "100", "computação");
		this.alunoTeste3 = new Aluno("Angela Ziegler", "450", "medicina");
	}
	
	/**
	 * Testa o construtor da classe criando um objeto Aluno.
	 */
	@Test
	void testAluno1() {
		new Aluno("Gabriel Reyes", "250", "computação");
	}
	
	/**
	 * Testa o construtor da classe criando um objeto Aluno, passando um nome nulo.
	 */
	@Test
	void testAlunoNomeNull() {
		Exception exception = Assertions.assertThrows(NullPointerException.class, 
				() -> new Aluno(null, "300", "direito"));
		assertEquals("Parâmetro nulo!\n",exception.getMessage());
	}
	
	/**
	 * Testa o construtor da classe criando um objeto Aluno, passando uma matricula nula.
	 */
	@Test
	void testAlunoMatriculaNull() {
		Exception exception = Assertions.assertThrows(NullPointerException.class, 
				() -> new Aluno("Carolina Freitas", null , "direito"));
		assertEquals("Parâmetro nulo!\n",exception.getMessage());
	}
	
	/**
	 * Testa o construtor da classe criando um objeto Aluno, passando um curso nulo.
	 */
	@Test
	void testAlunoCursoNull() {
		Exception exception = Assertions.assertThrows(NullPointerException.class, 
				() -> new Aluno("Carolina Freitas", "150" , null));
		assertEquals("Parâmetro nulo!\n",exception.getMessage());
	}
	
	/**
	 * Testa o construtor da classe criando um objeto Aluno, passando um nome inválido.
	 */
	@Test
	void testAlunoNomeInvalido() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> new Aluno("", "304", "direito"));
		assertEquals("Nome inválido!\n",exception.getMessage());
	}
	
	/**
	 * Testa o construtor da classe criando um objeto Aluno, passando uma matricula inválida.
	 */
	@Test
	void testAlunoMatriculaInvalida() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> new Aluno("Ana Silva", "", "direito"));
		assertEquals("Matricula inválida!\n",exception.getMessage());
	}
	
	/**
	 * Testa o construtor da classe criando um objeto Aluno, passando um curso inválido.
	 */
	@Test
	void testAlunoCursoInvalido() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> new Aluno("Gabriela Freitas", "302", ""));
		assertEquals("Curso inválido!\n",exception.getMessage());
	}
	
	/**
	 * Testa o método equals da classe.Dois alunos são iguais se tiverem a mesma matricula.
	 */
	@Test
	void testEqualsTrue() {
		assertEquals(alunoTeste1.equals(alunoTeste3), true);
	}
	
	/**
	 * Testa o método equals da classe.Dois alunos são iguais se tiverem a mesma matricula.
	 */
	@Test
	void testEqualsFalse() {
		assertEquals(alunoTeste1.equals(alunoTeste2), false);
	}
	
	/**
	 * Testa o método equals da classe com um objeto null.
	 */
	@Test
	void testEqualsNull() {
		Aluno alunoTeste = null;
		assertEquals(alunoTeste1.equals(alunoTeste), false);
	}
	
	/**
	 * Testa o método equals da classe.Dois alunos são iguais se tiverem a mesma matricula.
	 */
	@Test
	void testEqualsObjIguais() {
		assertEquals(alunoTeste1.equals(alunoTeste1), true);
	}

}
