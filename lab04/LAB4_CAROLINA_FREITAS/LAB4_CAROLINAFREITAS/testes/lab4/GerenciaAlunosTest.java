package lab4;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe que testa a classe GerenciaAlunos
 * @author Carolina Martins Freitas
 *
 */
class GerenciaAlunosTest {
	
	private GerenciaAlunos baseGerenciaAlunos;
	
	/**
	 * Método que cria o objeto da classe que será testado.
	 */
	@BeforeEach
	void preparaGerenciaAlunos() {
		this.baseGerenciaAlunos = new GerenciaAlunos();
	}
	
	/**
	 * Testa o método que cadastra um aluno no sistema.
	 */
	@Test
	void testCadastraAluno() {
		assertEquals(baseGerenciaAlunos.cadastraAluno("Carolina","200","computação"), "CADASTRO REALIZADO!");
	}
	
	/**
	 * Testa o método que cadastra um aluno no sistema, mas com uma matricula que já foi cadastrada.
	 */
	@Test
	void testCadastraAlunoMatriculaJaCadastrada() {
		assertEquals(baseGerenciaAlunos.cadastraAluno("Carolina","200","computação"), "CADASTRO REALIZADO!");
		assertEquals(baseGerenciaAlunos.cadastraAluno("Lili Camposh","200","Medicina"), "MATRÍCULA JÁ CADASTRADA!");
	}
	
	/**
	 * Testa o método que recupera um aluno por meio de sua matricula.
	 */
	@Test
	void testRecuperaAluno() {
		Aluno aluno;
		aluno = new Aluno("Torbjorn Lindholm","201","medicina");
		baseGerenciaAlunos.cadastraAluno("Torbjorn Lindholm","201","medicina");
		assertEquals(baseGerenciaAlunos.recuperaAluno("201"), aluno);
	}
	
	/**
	 * Testa o método que recupera um aluno por meio de sua matricula, mas com uma matricula não cadastrada.
	 */
	@Test
	void testRecuperaAlunoInexistente() {
		assertEquals(baseGerenciaAlunos.recuperaAluno("200"), null);
	}
	
	/**
	 * Testa o método que exibe os dados de um aluno.
	 */
	@Test
	void testExibeAluno() {
		baseGerenciaAlunos.cadastraAluno("Lili Camposh","200","medicina");
		String msg = "Aluno: 200 - Lili Camposh - medicina";
		assertEquals(baseGerenciaAlunos.exibeAluno("200"),msg);
	}
	
	/**
	 * Testa o método que exibe os dados de um aluno, mas com um aluno inexistente.
	 */
	@Test
	void testExibeAlunoInexistente() {
		String msg = "Aluno não cadastrado.";
		assertEquals(baseGerenciaAlunos.exibeAluno("300"),msg);
	}
	
	/**
	 * Testa o método que exibe os dados de um aluno nulo.
	 */
	@Test
	void testExibeAlunoNull() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> baseGerenciaAlunos.exibeAluno(null));
		assertEquals("Matricula inválida!\n",exception.getMessage());
	}
	
	/**
	 * Testa o método que exibe os dados de um aluno inválido.
	 */
	@Test
	void testExibeAlunoInvalido() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> baseGerenciaAlunos.exibeAluno(""));
		assertEquals("Matricula inválida!\n",exception.getMessage());
	}
	
	/**
	 * Testa o método que verifica se um aluno está cadastrado no sistema.
	 */
	@Test
	void testVerificaCadastroAluno() {
		baseGerenciaAlunos.cadastraAluno("Lili Camposh","200","medicina");
		assertEquals(baseGerenciaAlunos.verificaCadastroAluno("200"),true);
	}
	
	/**
	 * Testa o método que verifica se um aluno está cadastrado no sistema, mas com um aluno inexistente.
	 */
	@Test
	void testVerificaCadastroAlunoInexistente() {
		assertEquals(baseGerenciaAlunos.verificaCadastroAluno("500"),false);
	}
	
	/**
	 * Testa o método que registra no sistema um aluno que responde questões no quadro.
	 */
	@Test
	void testRegistrarAlunoQueResponde() {
		baseGerenciaAlunos.cadastraAluno("Gabriel Reyes","250","computação");
		String msg = "ALUNO REGISTRADO!";
		assertEquals(baseGerenciaAlunos.registrarAlunoQueResponde("250"), msg);
	}
	
	/**
	 * Testa o método que registra no sistema um aluno que responde questões no quadro, mas com um aluno inexistente.
	 */
	@Test
	void testRegistrarAlunoQueRespondeInexistente() {
		String msg = "Aluno não cadastrado.";
		assertEquals(baseGerenciaAlunos.registrarAlunoQueResponde("700"), msg);
	}
	
	/**
	 * Testa o método que registra no sistema um aluno que responde questões no quadro, mas com um aluno inexistente(string vazia).
	 */
	@Test
	void testRegistrarAlunoQueRespondeVazio() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> baseGerenciaAlunos.registrarAlunoQueResponde(""));
		assertEquals("Matricula inválida!\n",exception.getMessage());
	}
	
	/**
	 * Testa o método que registra no sistema um aluno que responde questões no quadro, mas com um aluno Nulo.
	 */
	@Test
	void testRegistrarAlunoQueRespondeNulo() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> baseGerenciaAlunos.registrarAlunoQueResponde(null));
		assertEquals("Matricula inválida!\n",exception.getMessage());
	}

}
