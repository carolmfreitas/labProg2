package agenda;

/**
 * Classe com dados dos contatos armazenados no array de contatos da agenda.
 * 
 * @author Carolina Martins Freitas - 120110894
 *
 */
public class Contato {
	
	/**
	 * Primeiro nome do contato.
	 */
	private String nome;
	
	/**
	 * Sobrenome do contato.
	 */
	private String sobrenome;
	
	/**
	 * Telefone prioritário do contato.
	 */
	private String prioritario;
	
	/**
	 * Telefone whatsapp do contato.
	 */
	private String whatsapp;
	
	/**
	 * Telefone adicional do contato.
	 */
	private String adicional;
	
	/**
	 * variavel que indica se o contato está favoritado ou não. Inicialmente é false pois nenhum contato foi favoritado ainda.
	 */
	private boolean favorito = false;
	
	/**
	 * Constroi um contato a partir de seus dados.
	 * @param nome Nome do contato
	 * @param sobrenome Sobrenome do contato.
	 * @param prioritario Telefone prioritário do contato.
	 * @param whatsapp Telefone whatsapp do contato.
	 * @param adicional Telefone adicional do contato.
	 */
	Contato(String nome, String sobrenome, String prioritario, String whatsapp, String adicional){
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.prioritario = prioritario;
		this.whatsapp = whatsapp;
		this.adicional = adicional;
		this.favorito = false;
	}
	
	/**
	 * Constroi um contato sem telefone adicional a partir de seus dados.
	 * @param nome Nome do contato
	 * @param sobrenome Sobrenome do contato.
	 * @param prioritario Telefone prioritário do contato.
	 * @param whatsapp Telefone whatsapp do contato.
	 */
	Contato(String nome, String sobrenome, String prioritario, String whatsapp){
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.prioritario = prioritario;
		this.whatsapp = whatsapp;
		this.favorito = false;
	}
	
	/**
	 * Retorna o nome do contato.
	 * @return Nome do Contato
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Retorna o nome completo do contato.
	 * @return Nome completo do contato
	 */
	public String getNomeCompleto() {
		return this.nome + " " + this.sobrenome;
	}
	
	/**
	 * Retorna o telefone prioritário do contato
	 * @return Telefone prioritário do contato
	 */
	public String getPrioritario() {
		return this.prioritario;
	}
	
	/**
	 * Retorna telefone whatsapp do contato.
	 * @return Telefone whatsapp do contato
	 */
	public String getWhatsapp() {
		return this.whatsapp;
	}
	
	/**
	 * Retorna telefone adicional do contato.
	 * @return Telefone adicional do contato
	 */
	public String getAdicional() {
		return this.adicional;
	}
	
	/**
	 * Retorna se o contato esta favoritado ou não.
	 * @return Status de favorito do contato
	 */
	public boolean getFavorito() {
		return this.favorito;
	}
	
	/**
	 * Método que modifica o status de favorito do contato.
	 */
	public void modificaFavorito() {
		if(this.favorito == false) {
			this.favorito =  true;
		}
		else {
			this.favorito = false;
		}
	}
	
	/**
	 * compara dois contatos.Dois contatos são iguais se tiverem o mesmo nome e sobrenome.
	 * @return Boolean verdadeiro caso os contatos sejam iguais
	 */
	public boolean equals(Object o) { 
        if (o == this) {
            return true;
        }
        if (!(o instanceof Contato)) {
            return false;
        }
        Contato c = (Contato) o;
        if(nome.equals(c.nome) && sobrenome.equals(c.sobrenome)){
        	return true;
        }
        return false;
    }
	
}