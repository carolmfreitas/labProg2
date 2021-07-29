package lab4;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Classe que gerencia alunos.
 * 
 * @author Carolina Martins Freitas
 */
public class GerenciaAlunos {
	
	/**
	 * HashSet com matriculas dos alunos cadastrados no sistema.
	 */
	private HashSet <String> matriculas;
	
	/**
	 * HashSet com matriculas dos alunos que respondem questões no quadro.
	 */
	private HashSet <String> alunosRespondem;
	
	/**
	 * Mapa em que as chaves são as matriculas dos alunos e os valores são objetos da classe Aluno.
	 */
	private HashMap <String,Aluno> mapaMatriculaAlunos;
	
	/**
	 * Construtor da classe.
	 */
	public GerenciaAlunos() {
		this.matriculas = new HashSet<String>();
		this.mapaMatriculaAlunos = new HashMap<String,Aluno>();
		this.alunosRespondem = new HashSet<String>();
	}
	
	/**
	 * Cadastra um aluno no sistema.
	 * @param nome Nome do aluno.
	 * @param matricula Matricula do aluno.
	 * @param curso Curso do aluno.
	 * @return String de mensagem com erro ou sucesso da operação.
	 */
	public String cadastraAluno(String nome, String matricula, String curso) {
		if(this.matriculas.contains(matricula)){
			return "MATRÍCULA JÁ CADASTRADA!";
		}
		
		Aluno aluno = new Aluno(nome,matricula,curso);
		
		this.mapaMatriculaAlunos.put(matricula,aluno);
		this.matriculas.add(matricula);
		return "CADASTRO REALIZADO!";
		
	}
	
	/**
	 * Recupera um aluno por meio de sua matricula.
	 * @param matricula Matricula do aluno.
	 * @return O aluno.
	 */
	public Aluno recuperaAluno(String matricula) {
		if(this.mapaMatriculaAlunos.containsKey(matricula)) {
			return this.mapaMatriculaAlunos.get(matricula);
		}
		else {
			return null;
		}
	}
	
	/**
	 * Exibe os dados de um aluno.
	 * @param matricula Matricula do aluno.
	 * @return String com dados do aluno.
	 */
	public String exibeAluno(String matricula) {
		if(matricula == null || matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("Matricula inválida!\n");
		}
		if(!this.matriculas.contains(matricula)) {
			return "Aluno não cadastrado.";
		}
		Aluno aluno = recuperaAluno(matricula);
		return "Aluno: " + matricula + " - " + aluno.getNome() + " - " + aluno.getCurso() ;
	}
	
	/**
	 * Verifica se um aluno está cadastrado no sistema.
	 * @param matricula Matricula do aluno.
	 * @return Boolean indicando se o aluno está cadastrado ou não.
	 */
	public Boolean verificaCadastroAluno(String matricula) {
		if(this.matriculas.contains(matricula)){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Registra no sistema um aluno que responde questões no quadro.
	 * @param matricula Matricula do aluno.
	 * @return String que indica sucesso ou erro da operação.
	 */
	public String registrarAlunoQueResponde(String matricula) {
		if(matricula == null || matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("Matricula inválida!\n");
		}
		if(!verificaCadastroAluno(matricula)) {
			return "Aluno não cadastrado.";
		}
		else {
			this.alunosRespondem.add(matricula);
			return "ALUNO REGISTRADO!";
		}
	}
	
	/**
	 * Acessa o HashSet de matriculas dos alunos que respondem questões no quadro.
	 * @return O HashSet com matriculas dos alunos que respondem questões no quadro.
	 */
	public HashSet<String> getAlunosRespondem() {
		return (HashSet<String>) this.alunosRespondem.clone();
	}
	
	/**
	 * Acessa o mapa em que as chaves são as matriculas dos alunos e os valores são objetos da classe Aluno.
	 * @return O mapa em que as chaves são as matriculas dos alunos e os valores são objetos da classe Aluno.
	 */
	public HashMap<String,Aluno> getMapaMatriculaAlunos() {
		return (HashMap<String,Aluno>) this.mapaMatriculaAlunos.clone();
	}
	
}