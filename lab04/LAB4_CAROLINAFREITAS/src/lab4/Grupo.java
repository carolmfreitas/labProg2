package lab4;

import java.util.HashSet;

/**
 * Classe que representa um grupo de estudo.
 * @author Carolina Martins Freitas
 */
public class Grupo {
	
	/**
	 * Nome do grupo de estudo.
	 */
	private String nome;
	
	/**
	 * Curso ao qual o grupo é restrito.
	 */
	private String restricao;
	
	/**
	 * HashSet com as matriculas dos alunos que fazem parte do grupo.
	 */
	private HashSet<String> matriculaAlunos;

	/**
	 * Constroi um grupo a partir de seu nome e restrição.
	 * @param nome Nome do grupo.
	 * @param restricao Restrição do grupo.
	 */
	public Grupo(String nome, String restricao) {
		if (nome == null) {
			throw new NullPointerException("Nome nulo!\n");
		}
		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome inválido!\n");
		}
		if (restricao == null) {
			throw new NullPointerException("Restrição nula!\n");
		}
		this.nome = nome;
		this.restricao = restricao;
		this.matriculaAlunos = new HashSet<String>();
	}
	
	/**
	 * Constroi um grupo a partir de seu nome.
	 * @param nome Nome do grupo.
	 */
	public Grupo(String nome) {
		if (nome == null) {
			throw new NullPointerException("Nome nulo\n");
		}
		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome inválido\n");
		}
		this.nome = nome;
		this.matriculaAlunos = new HashSet<String>();
	}
	
	/**
	 * Retorna o nome do grupo.
	 * @return Nome do grupo.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Retorna a restrição do grupo.
	 * @return Restrição do grupo.
	 */
	public String getRestricao() {
		return restricao;
	}
	
	/**
	 * Adiciona um aluno ao grupo de estudos.
	 * @param matricula Matricula do aluno.
	 * @return mensagem que indica que o aluno foi adicionado.
	 */
	public String adicionarAluno(String matricula) {
		matriculaAlunos.add(matricula);
		return "ALUNO ALOCADO!";
	}
	
	/**
	 * Indica se um aluno faz parte do grupo de estudos.
	 * @param matricula Matricula do aluno.
	 * @return Boolean que indica se o aluno está no grupo ou não.
	 */
	public Boolean alunoEstaNoGrupo(String matricula) {
		return matriculaAlunos.contains(matricula);
	}
	
	/**
	 * Retorna o identificador unico do grupo
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	/**
	 * Compara dois objetos Grupo.Dois grupos são iguais apenas se tiverem o mesmo nome.
	 */
	@Override
	public boolean equals(Object o) { 
        if (o == this) {
            return true;
        }
        if (!(o instanceof Grupo)) {
            return false;
        }
        Grupo g = (Grupo) o;
        if(nome.equals(g.nome)){
        	return true;
        }
        return false;
    }
}