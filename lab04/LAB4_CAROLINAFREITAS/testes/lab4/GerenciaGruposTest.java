package lab4;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe que testa a classe GerenciaGrupos
 * @author Carolina Martins Freitas
 *
 */
class GerenciaGruposTest {
	
	private GerenciaGrupos baseGerenciaGrupos;
	private GerenciaAlunos baseGerenciaAlunos;
	
	/**
	 * Método que cria os objetso da classe que serão testados.
	 */
	@BeforeEach
	void preparaGerenciaGrupos() {
		this.baseGerenciaGrupos = new GerenciaGrupos();
		this.baseGerenciaAlunos = new GerenciaAlunos();
		baseGerenciaAlunos.cadastraAluno("Gabriel Reyes","250", "computação");
		baseGerenciaAlunos.cadastraAluno("Lili Camposh","200", "computação");
		baseGerenciaAlunos.cadastraAluno("Angela Ziegler","202", "medicina");
		baseGerenciaAlunos.cadastraAluno("Torbjorn Lindholm","201", "engenharia mecânica");
	}
	
	/**
	 * Testa cadastrar um grupo sem restrição
	 */
	@Test
	void testCriaGrupoSemRestricao() { //caso 1 ponto 1
		String msg = "CADASTRO REALIZADO!";
		assertEquals(baseGerenciaGrupos.criaGrupo("programação oo", ""), msg);
	}
	
	/**
	 * Testa cadastrar um grupo com restrição.
	 */
	@Test
	void testCriaGrupoComRestricao() { //caso 2 ponto 1
		String msg = "CADASTRO REALIZADO!";
		assertEquals(baseGerenciaGrupos.criaGrupo("listas", "computação"), msg);
	}
	
	/**
	 * Testa cadastrar um grupo com nome existente.
	 */
	@Test
	void testCriaGrupoComNomeExistente() { //caso 3 ponto 1
		String msg1 = "CADASTRO REALIZADO!";
		String msg2 = "GRUPO JÁ CADASTRADO!";
		assertEquals(baseGerenciaGrupos.criaGrupo("listas", "computação"), msg1);
		assertEquals(baseGerenciaGrupos.criaGrupo("listas", ""), msg2);
	}

	/**
	 * Testa o método que recupera um grupo a partir de seu nome.
	 */
	@Test
	void testRecuperaGrupo() {
		Grupo grupo = new Grupo("livros","computação");
		baseGerenciaGrupos.criaGrupo("livros", "computação");
		assertEquals(baseGerenciaGrupos.recuperaGrupo("livros"),grupo);
	}
	
	/**
	 * Testa o método que recupera um grupo a partir de seu nome, mas com um grupo inexistente.
	 */
	@Test
	void testRecuperaGrupoInexistente() {
		assertEquals(baseGerenciaGrupos.recuperaGrupo("leitura"),null);
	}
	
	/**
	 * Testa alocar aluno a um grupo sem restrição.
	 */
	@Test
	void testAlocaAlunoGrupoSemRestricao1() { //caso 4 ponto 1
		String msg = "ALUNO ALOCADO!";
		baseGerenciaGrupos.criaGrupo("programação oo", "");
		assertEquals(baseGerenciaGrupos.alocaAluno(baseGerenciaAlunos,"200","programação oo"),msg);
	}
	
	/**
	 * Testa alocar aluno a um grupo sem restrição.
	 */
	@Test
	void testAlocaAlunoGrupoSemRestricao2() { //caso 4 ponto 2
		String msg = "ALUNO ALOCADO!";
		baseGerenciaGrupos.criaGrupo("programação oo", "");
		assertEquals(baseGerenciaGrupos.alocaAluno(baseGerenciaAlunos,"202","programação oo"),msg);
	}
	
	/**
	 * Testa alocar aluno nulo a um grupo.
	 */
	@Test
	void testAlocaAlunoGrupoSemRestricaoNull() { 
		baseGerenciaGrupos.criaGrupo("programação oo", "");
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> baseGerenciaGrupos.alocaAluno(baseGerenciaAlunos, null, "programação oo" ));
		assertEquals("Matricula inválida!\n",exception.getMessage());
	}
	
	/**
	 * Testa alocar aluno vazio a um grupo.
	 */
	@Test
	void testAlocaAlunoGrupoSemRestricaoEmpty() { 
		baseGerenciaGrupos.criaGrupo("programação oo", "");
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> baseGerenciaGrupos.alocaAluno(baseGerenciaAlunos, "" , "programação oo" ));
		assertEquals("Matricula inválida!\n",exception.getMessage());
	}
	
	/**
	 * Testa alocar aluno vazio a um grupo nulo.
	 */
	@Test
	void testAlocaAlunoGrupooNull() { 
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> baseGerenciaGrupos.alocaAluno(baseGerenciaAlunos, "230" , null ));
		assertEquals("Nome inválido!\n",exception.getMessage());
	}
	
	/**
	 * Testa alocar aluno vazio a um grupo vazio.
	 */
	@Test
	void testAlocaAlunoGrupooEmpty() { 
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> baseGerenciaGrupos.alocaAluno(baseGerenciaAlunos, "230" , "" ));
		assertEquals("Nome inválido!\n",exception.getMessage());
	}
	
	/**
	 * Testa alocar aluno a um grupo que já pertence, O sistema informa que o aluno foi alocado com sucesso, mas, não será inserido novamente no grupo.
	 */
	@Test
	void testAlocaAlunoGrupoSemRestricao3() { //caso 4 ponto 3
		String msg = "ALUNO ALOCADO!";
		baseGerenciaGrupos.criaGrupo("programação oo", "");
		baseGerenciaGrupos.alocaAluno(baseGerenciaAlunos,"200","programação oo");
		assertEquals(baseGerenciaGrupos.alocaAluno(baseGerenciaAlunos,"200","programação oo"),msg);
	}
	
	/**
	 * Testa alocar em um grupo um aluno que não está cadastrado no sistema.
	 */
	@Test
	void testAlocaAlunoNaoCadastrado() { //caso 5 ponto 1
		baseGerenciaGrupos.criaGrupo("programação oo", "");
		String msg = "Aluno não cadastrado";
		assertEquals(baseGerenciaGrupos.alocaAluno(baseGerenciaAlunos,"100","programação oo"),msg);
	}
	
	/**
	 * Testa alocar um aluno em um grupo que não está cadastrado no sistema.
	 */
	@Test
	void testAlocaAlunoGrupoNaoCadastrado() { //caso 5 ponto 2
		String msg = "Grupo não cadastrado";
		assertEquals(baseGerenciaGrupos.alocaAluno(baseGerenciaAlunos,"200","anatomia"),msg);
	}
	
	/**
	 * Testa alocar aluno a um grupo com restrição de curso.
	 */
	@Test
	void testAlocaAlunoGrupoComRestricao() { //caso 6 ponto 1
		String msg = "ALUNO ALOCADO!";
		baseGerenciaGrupos.criaGrupo("listas", "computação");
		assertEquals(baseGerenciaGrupos.alocaAluno(baseGerenciaAlunos,"250","listas"),msg);
	}
	
	/**
	 * Testa alocar aluno a um grupo com restrição de curso, mas o aluno não pertence ao curso ao qual o grupo é restrito.
	 */
	@Test
	void testAlocaAlunoGrupoComRestricao2() { //caso 6 ponto 2
		String msg = "GRUPO COM RESTRIÇÃO DE CURSO";
		baseGerenciaGrupos.criaGrupo("listas", "computação");
		assertEquals(baseGerenciaGrupos.alocaAluno(baseGerenciaAlunos,"202","listas"),msg);
	}
	
	/**
	 * Testa o método que indica se um aluno pertence a um grupo de estudos.
	 */
	@Test
	void testPertinenciaAGrupoTrue() { //caso 7 ponto 1
		baseGerenciaGrupos.criaGrupo("listas", "computação");
		baseGerenciaGrupos.alocaAluno(baseGerenciaAlunos,"250","listas");
		String msg = "ALUNO PERTENCE AO GRUPO";
		assertEquals(baseGerenciaGrupos.pertinenciaGrupos("listas", "250"), msg);
	}
	
	/**
	 * Testa o método que indica se um aluno pertence a um grupo de estudos.
	 */
	@Test
	void testPertinenciaAGrupoFalse() { //caso 7 ponto 2
		baseGerenciaGrupos.criaGrupo("listas", "computação");
		String msg = "ALUNO NÃO PERTENCE AO GRUPO";
		assertEquals(baseGerenciaGrupos.pertinenciaGrupos("listas", "202"), msg);
	}
	
	/**
	 * Testa o método que indica se um aluno pertence a um grupo de estudos, mas com um aluno não cadastrado.
	 */
	@Test
	void testPertinenciaAGrupoAlunoNaoCadastrado() { //caso 8 ponto 1
		baseGerenciaGrupos.criaGrupo("programação oo", "");
		String msg = "ALUNO NÃO PERTENCE AO GRUPO";
		assertEquals(baseGerenciaGrupos.pertinenciaGrupos("programação oo", "100"), msg);
	}
	
	/**
	 * Testa o método que indica se um aluno pertence a um grupo de estudos, mas com um grupo não cadastrado.
	 */
	@Test
	void testPertinenciaAGrupoNaoCadastrado() { //caso 8 ponto 2
		String msg = "GRUPO NÃO CADASTRADO.";
		assertEquals(baseGerenciaGrupos.pertinenciaGrupos("anatomia", "200"), msg);
	}
	
	/**
	 * Testa o método que indica se um aluno pertence a um grupo de estudos, mas com um nome de grupo nulo.
	 */
	@Test
	void testPertinenciaAGrupoNomeNulo() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> baseGerenciaGrupos.pertinenciaGrupos(null,"150"));
		assertEquals("Nome do grupo inválido!\n",exception.getMessage());
	}
	
	/**
	 * Testa o método que indica se um aluno pertence a um grupo de estudos, mas com um nome de grupo vazio.
	 */
	@Test
	void testPertinenciaAGrupoNomeVazio() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> baseGerenciaGrupos.pertinenciaGrupos("","150"));
		assertEquals("Nome do grupo inválido!\n",exception.getMessage());
	}
	
	/**
	 * Testa o método que indica se um aluno pertence a um grupo de estudos, mas com a matricula nula.
	 */
	@Test
	void testPertinenciaAGrupoMatriculaNula() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> baseGerenciaGrupos.pertinenciaGrupos("computação", null));
		assertEquals("matricula inválida!\n",exception.getMessage());
	}
	
	/**
	 * Testa o método que indica se um aluno pertence a um grupo de estudos, mas com a matricula vazia.
	 */
	@Test
	void testPertinenciaAGrupoMatriculaVazia() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> baseGerenciaGrupos.pertinenciaGrupos("computação", ""));
		assertEquals("matricula inválida!\n",exception.getMessage());
	}
	
	/**
	 * Testa o método que indica o número de grupos de estudo com restrição de um curso.
	 */
	@Test
	void testRecuperaGruposRestricao() { //caso 9 ponto 1
		baseGerenciaGrupos.criaGrupo("listas", "computação");
		assertEquals(baseGerenciaGrupos.recuperaGruposRestricao("computação"),1);
	}
	
	/**
	 * Testa o método que indica o número de grupos de estudo com restrição de um curso.
	 */
	@Test
	void testRecuperaGruposRestricao2() { //caso 9 ponto 2
		assertEquals(baseGerenciaGrupos.recuperaGruposRestricao("medicina"),0);
	}
	
	/**
	 * Testa o método que indica o número de grupos de estudo com restrição de um curso.
	 */
	@Test
	void testRecuperaGruposRestricao3() { //caso 9 ponto 3
		assertEquals(baseGerenciaGrupos.recuperaGruposRestricao("engenharia mecânica"),0);
	}
	
	/**
	 * Testa o método que indica o número de grupos de estudo com restrição de um curso,
	 * com nome do curso nulo.
	 */
	@Test
	void testRecuperaGruposRestricaoNull() { 
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> baseGerenciaGrupos.recuperaGruposRestricao(null));
		assertEquals("Curso inválido!\n",exception.getMessage());
	}
	
	/**
	 * Testa o método que indica o número de grupos de estudo com restrição de um curso,
	 * com nome do curso sendo uma string vazia.
	 */
	@Test
	void testRecuperaGruposRestricaoEmpty() { 
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> baseGerenciaGrupos.recuperaGruposRestricao(""));
		assertEquals("Curso inválido!\n",exception.getMessage());
	}
	
	/**
	 * Testa o método que incrementa em um o número de grupos de estudo com restrição de um curso.
	 */
	@Test
	void testAdicionaRestricao() {
		baseGerenciaGrupos.criaGrupo("listas", "computação");
		assertEquals(baseGerenciaGrupos.recuperaGruposRestricao("computação"),1);
		baseGerenciaGrupos.adicionaRestricao("computação");
		assertEquals(baseGerenciaGrupos.recuperaGruposRestricao("computação"),2);
	}


}
