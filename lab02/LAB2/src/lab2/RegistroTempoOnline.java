package lab2;

/**
* Registra e monitora a quantidade de horas online que o aluno
* tem dedicado a uma determinada disciplina.
* 
* @author Carolina Martins Freitas
*/
public class RegistroTempoOnline {
	
	/**
	* Nome da disciplina que será monitorada.
	*/
	private String nomeDisciplina;
	
	/**
	* Tempo de dedicação online, em horas, esperado para uma disciplina.
	*/
	private int tempoOnlineEsperado;
	
	/**
	* Tempo online já gasto para uma disciplina, em horas.
	*/
	private int tempoGasto;
	
	
	/**
	* Constrói um objeto para o registro do tempo online de um aluno a 
	* partir do nome da disciplina, o tempo esperado é inicializado como o 
	* tempo padrão, que é de 120 horas.
	*
	* @param nomeDisciplina nome da disciplina
	*/
	public RegistroTempoOnline(String nomeDisciplina) { 
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = 120; 
	}
	
	
	/**
	* Constrói um objeto para o registro do tempo online de um aluno a 
	* partir do nome da disciplina e do tempo esperado para ela.
	*
	* @param nomeDisciplina nome da disciplina
	* @param tempoOnlineEsperado tempo online esperado para a disciplina
	*/
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}
	
	
	/**
	* Método que contabiliza o tempo online gasto, em horas, com uma 
	* disciplina.
	*  
	* @param tempo tempo gasto em horas
	* 
	*/
	public void adicionaTempoOnline(int tempo) {
		this.tempoGasto += tempo;
	}
	
	
	/**
	* Método que verifica o tempo online e indica se o usuário atingiu o 
	* tempo esperado para aquela disciplina por meio de um booleano.
	* 
	* @return booleano que indica se o aluno já atingiu o tempo online esperado
	*/
	public boolean atingiuMetaTempoOnline() {
		if(this.tempoGasto >= this.tempoOnlineEsperado) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/**
	* Gera uma String que contém o nome da disciplina, o tempo online gasto e o 
	* tempo online esperado.
	*
	* @return string que contém o nome da disciplina, o tempo online já gasto e 
	* o tempo online esperado.
	*/
	public String toString() {
		return this.nomeDisciplina + " " + this.tempoGasto + "/" + this.tempoOnlineEsperado;
	}
	
}