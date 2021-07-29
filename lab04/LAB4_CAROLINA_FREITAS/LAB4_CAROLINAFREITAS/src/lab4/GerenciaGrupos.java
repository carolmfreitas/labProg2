package lab4;

import java.util.HashMap;

/**
 * Classe que gerencia os grupos de estudo.
 * @author Carolina Martins Freitas
 */
public class GerenciaGrupos {
	
	/**
	 * Mapa em que a chave é o nome do grupo e o valor é a restrição do grupo.
	 */
	private HashMap <String,String> mapaGrupoRestricao;
	
	/**
	 * Mapa em que a chave é o nome do grupo e o valor é o objeto grupo.
	 */
	private HashMap <String,Grupo> mapaNomegrupos;
	
	/**
	 * Mapa em que a chave é a restrição do grupo e o valor é o numero de grupos com essa restrição.
	 */
	private HashMap <String, Integer> mapaRestricaoNumGrupos;
	
	/**
	 * Construtor da classe.
	 */
	public GerenciaGrupos() {
		this.mapaGrupoRestricao = new HashMap<String,String>();
		this.mapaNomegrupos = new HashMap<String,Grupo>();
		this.mapaRestricaoNumGrupos = new HashMap<String,Integer>();
	}
	
	/**
	 * Método que cria um grupo.
	 * @param nome Nome do grupo.
	 * @param restricao Restrição do grupo.
	 * @return String com mensagem sobre a operação que foi realizada.
	 */
	public String criaGrupo(String nome, String restricao) {
		adicionaRestricao(restricao);
		if(mapaGrupoRestricao.containsKey(nome)) {
			return "GRUPO JÁ CADASTRADO!";
		}
		Grupo grupo;
		if(restricao == null || restricao.trim().isEmpty()) {
			grupo = new Grupo(nome);
		}
		else {
			grupo = new Grupo(nome,restricao);
		}
		
		this.mapaGrupoRestricao.put(nome,restricao);
		this.mapaNomegrupos.put(nome,grupo);
		
		return "CADASTRO REALIZADO!";
	}
	
	/**
	 * Recupera um grupo a partir de seu nome.
	 * @param nomeGrupo Nome do grupo.
	 * @return O grupo, ou caso o grupo não exista retorna null.
	 */
	public Grupo recuperaGrupo(String nomeGrupo) {
		if(this.mapaNomegrupos.containsKey(nomeGrupo)) {
			return this.mapaNomegrupos.get(nomeGrupo);
		}
		else {
			return null;
		}
	}
	
	/**
	 * Aloca um aluno em um grupo de estudos.
	 * @param gerenciaAlunos Objeto da classe que gerencia alunos.
	 * @param matricula Matricula de um aluno.
	 * @param nomeGrupo Nome do grupo.
	 * @return String com mensagem de erro ou de sucesso da operação.
	 */
	public String alocaAluno(GerenciaAlunos gerenciaAlunos, String matricula, String nomeGrupo) {
		if(matricula == null || matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("Matricula inválida!\n");
		}
		if (nomeGrupo == null || nomeGrupo.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome inválido!\n");
		}
		if(!this.mapaGrupoRestricao.containsKey(nomeGrupo)){
			return "Grupo não cadastrado";
		}
		if(!gerenciaAlunos.verificaCadastroAluno(matricula)) {
			return "Aluno não cadastrado";
		}
		
		String restricao = this.mapaGrupoRestricao.get(nomeGrupo);
		
		Aluno aluno = gerenciaAlunos.recuperaAluno(matricula);
		String curso = aluno.getCurso();
			
		if(!curso.equals(restricao) && !restricao.isEmpty()) {
			return "GRUPO COM RESTRIÇÃO DE CURSO";
		}
		
		Grupo grupo = this.mapaNomegrupos.get(nomeGrupo);
		return grupo.adicionarAluno(matricula);
	}
	
	/**
	 * Indica o número de grupos de estudo com restrição de um curso.
	 * @param nomeCurso Nome do curso.
	 * @return Inteiro com número de grupos com restrição de um curso.
	 */
	public int recuperaGruposRestricao(String nomeCurso) {
		if (nomeCurso == null || nomeCurso.trim().isEmpty()) {
			throw new IllegalArgumentException("Curso inválido!\n");
		}
		if(this.mapaRestricaoNumGrupos.containsKey(nomeCurso)) {
			return this.mapaRestricaoNumGrupos.get(nomeCurso);
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Incrementa em um o número de grupos de estudo com restrição de um curso.
	 * @param restricao Restrição de um grupo de estudos.
	 */
	public void adicionaRestricao(String restricao) {
		if(!this.mapaRestricaoNumGrupos.containsKey(restricao)) {
			this.mapaRestricaoNumGrupos.put(restricao,0);
		}
		int numAtualGrupos = this.mapaRestricaoNumGrupos.get(restricao);
		this.mapaRestricaoNumGrupos.put(restricao, numAtualGrupos+1);
	}
	
	/**
	 * Indica se um aluno pertence a um grupo de estudos.
	 * @param nomeGrupo Nome do grupo
	 * @param matricula Matricula do aluno
	 * @return String com mensagem que indica se um aluno pertence ou não a um grupo.
	 */
	public String pertinenciaGrupos(String nomeGrupo, String matricula) {
		if(matricula == null || matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("matricula inválida!\n");
		}
		if (nomeGrupo == null || nomeGrupo.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome do grupo inválido!\n");
		}
		
		Grupo grupo = recuperaGrupo(nomeGrupo);
		if(grupo == null) {
			return "GRUPO NÃO CADASTRADO.";
		}
		if(grupo.alunoEstaNoGrupo(matricula)) {
			return "ALUNO PERTENCE AO GRUPO";
		}
		else {
			return "ALUNO NÃO PERTENCE AO GRUPO";
		}	
	}

}