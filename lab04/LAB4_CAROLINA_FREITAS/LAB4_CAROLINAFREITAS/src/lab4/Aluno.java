package lab4;

/**
 * Classe que representa um aluno e seus atributos.
 * 
 * @author Carolina Martins Freitas
 */

public class Aluno {
	
	/**
	 * Nome do aluno.
	 */
	private String nome;
	
	/**
	 * Matricula do aluno.
	 */
	private String matricula;
	
	/**
	 * Curso do aluno
	 */
	private String curso;
	
	/**
	 * Constroi um aluno a partir de seu nome, matricula e curso.
	 * @param nome Nome do aluno.
	 * @param matricula Matricula do aluno.
	 * @param curso Curso do aluno.
	 */
	public Aluno(String nome, String matricula, String curso){
		if(nome == null || matricula == null || curso == null) {
			throw new NullPointerException("Parâmetro nulo!\n");
		}
		if(nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome inválido!\n");
		}
		if (matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("Matricula inválida!\n");
		}
		if (curso.trim().isEmpty()) {
			throw new IllegalArgumentException("Curso inválido!\n");
		}
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}
	
	/**
	 * Retorna o curso do aluno.
	 * @return Curso do aluno.
	 */
	public String getCurso() {
		return curso;
	}
	
	/**
	 * Retorna o nome do aluno.
	 * @return Nome do aluno.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Retorna a matricula do aluno.
	 * @return Matricula do aluno.
	 */
	public String getMatricula() {
		return matricula;
	}
	
	/**
	 * Retorna o identificador unico do aluno.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Compara dois objetos Aluno, dois alunos são iguais apenas se tiverem a mesma matricula.
	 */
	@Override
	public boolean equals(Object o) { 
        if (o == this) {
            return true;
        }
        if (!(o instanceof Aluno)) {
            return false;
        }
        Aluno a = (Aluno) o;
        if(matricula.equals(a.matricula)){
        	return true;
        }
        return false;
    }
	
}