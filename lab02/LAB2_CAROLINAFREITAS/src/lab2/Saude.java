package lab2;

/**
* Registra e monitora o estado de saúde mental e física do aluno.
* 
* @author Carolina Martins Freitas
*/
public class Saude {
	
	/**
	* Estado da saúde física do aluno.
	*/
	private String saudeFisica;
	
	/**
	* Estado da saúde mental do aluno.
	*/
	private String saudeMental;
	
	/**
	 * Sentimento atual do aluno.
	 */
	private String emojiSentimento;
	
	/**
	 * Indica se houve mudança na saúde física ou mental do aluno
	 */
	private boolean teveMudancaSaude;
	
	/**
	 * Indica se algum emoji foi cadastrado
	 */
	private boolean foiCadastradoEmoji;
	
	
	/**
	* Construtor inicial que define a saúde mental e a 
	* saúde física do aluno como “boa”.
	*/
	public Saude() {
		this.saudeFisica = "boa";
		this.saudeMental = "boa";
	}
	
	
	/**
	* Método que define o estado atual da saúde mental do aluno.
	*
	* @param valor valor que representa o estado da saúde mental atual
	* 
	*/
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
		teveMudancaSaude = true;
	}
	
	
	/**
	* Método que define o estado atual da saúde física do aluno.
	*
	* @param valor valor que representa o estado da saúde física atual
	* 
	*/
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
		teveMudancaSaude = true;
	}
	
	
	/**
	 * Registra um emoji que descreve sua última sensação em geral.
	 * 
	 * @param valor estado atual de saude do aluno, representado por um emoji
	 * 
	 */
	public void definirEmoji(String valor) {
		this.emojiSentimento = valor;
		teveMudancaSaude = false;
		foiCadastradoEmoji = true;
	}

	
	/**
	* Método que define o estado geral de saúde do aluno tomando como base os 
	* estados de saúde física e mental, além de retornar um emoji caso tenha sido cadastrado.
	*
	* @return string com estado geral de saúde do aluno
	*/
	public String getStatusGeral() {
		String estadoSaude; //estado geral de saúde do aluno
		
		if(this.saudeMental.equals("fraca") && this.saudeFisica.equals("fraca")) {
			estadoSaude = "fraca";
		}
		else if(this.saudeMental.equals("boa") && this.saudeFisica.equals("boa")) {
			estadoSaude = "boa";
		}
		else {
			estadoSaude = "ok";
		}
		
		if(foiCadastradoEmoji == true && teveMudancaSaude == false) {
			return estadoSaude + " " + this.emojiSentimento;
		}
		else {
			return estadoSaude;
		}
	}
	
}