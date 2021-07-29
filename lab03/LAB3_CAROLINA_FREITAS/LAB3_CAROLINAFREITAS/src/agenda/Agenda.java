package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições.Podem existir 100 contatos. 
 * 
 * @author Carolina Martins Freitas - 120110894
 *
 */
public class Agenda {
	
	/**
	 * tamanho do array que armazena os contatos
	 */
	private static final int TAMANHO_AGENDA = 100;
	
	/**
	 * array que armazena os contatos
	 */
	private Contato[] contatos;
	
	/**
	 * array que armazena os contatos favoritos
	 */
	private String[] favoritos;

	
	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new String[10];
	}
	
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}
	
	
	/**
	 * Acessa a lista de contatos favoritos mantida.
	 * @return O array de favoritos.
	 */
	public String[] getFavoritos() {
		return this.favoritos.clone();
	}
	

	/**
	 * Acessa os dados de um contato específico.
	 * 
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao-1];
	}
	

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * 
	 * @param posicao Posição do contato na agenda
	 * @param nome Primeiro nome do contato
	 * @param sobrenome Sobrenome do contato
	 * @param prioritario Número prioritário
	 * @param whatsapp Número de whatsapp
	 * @param adicional Número adicional
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String prioritario, String whatsapp, String adicional) {
		this.contatos[posicao-1] = new Contato(nome,sobrenome,prioritario,whatsapp,adicional);
	}
	
	
	/**
	 * Cadastra um contato sem número adicional em uma posição.Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * 
	 * @param posicao Posição do contato na agenda
	 * @param nome Primeiro nome do contato
	 * @param sobrenome Sobrenome do contato
	 * @param prioritario Número prioritário
	 * @param whatsapp Número de whatsapp
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String prioritario, String whatsapp) {
		this.contatos[posicao-1] = new Contato(nome,sobrenome,prioritario,whatsapp);
	}
	
	
	/**
	 * Cadastra os os contatos vindos de um arquivo CSV com dados dos contatos.
	 * 
	 * @param posicao Posição do contato na agenda
	 * @param nome Primeiro nome do contato
	 * @param sobrenome Sobrenome do contato
	 * @param telefone1 Primeiro número do contato
	 * @param telefone2 Segundo número do contato
	 * @param telefone3 Terceiro número do contato(adicional)
	 * @param qualPrioritario Indica qual dos dois primeiros telefones é o prioritário
	 * @param qualZap Indica qual dos dois primeiros telefones é o do whatsapp
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone1, String telefone2, String telefone3, int qualPrioritario, int qualZap) {
		String prioritario;
		String whatsapp;
		
		if(qualPrioritario == 1) {
			prioritario = telefone1;
		}
		else {
			prioritario = telefone2;
		}
		if(qualZap == 1) {
			whatsapp = telefone1;
		}
		else {
			whatsapp = telefone2;
		}
		
		if(telefone3 == null) {
			this.contatos[posicao-1] = new Contato(nome,sobrenome,prioritario,whatsapp);
		}
		else {
			this.contatos[posicao-1] = new Contato(nome,sobrenome,prioritario,whatsapp,telefone3);
		}
		
	}
	
	/**
	 * Adiciona um contato na lista de favoritos.
	 * 
	 * @param posicaoFavorito Posição em que o contato será salvo na lista de favoritos
	 * @param nome Nome do contato
	 * @param posicaoContato Posição do contato na lista de contatos
	 * @return true caso o contato tenha sido favoritado e false caso não tenha sido possivel realizar essa operação
	 */
	public boolean adicionaFavorito(int posicaoFavorito, String nome, int posicaoContato) {
		for(int i = 0; i < 10; i++) {
			if(this.favoritos[i] != null && this.favoritos[i].equals(nome)) {
				return false;
			}
		}
		
		if(posicaoFavorito < 1 || posicaoFavorito > 10 || posicaoContato < 1 || posicaoContato > 100) {
			return false;
		}
		
		if(favoritos[posicaoFavorito-1] != null) {
			String nomeAntigo = favoritos[posicaoFavorito-1];
			int posicaoContatoAntigo = getPosicaoPeloNome(nomeAntigo); 
			this.contatos[posicaoContatoAntigo].modificaFavorito();
		}
		
		this.contatos[posicaoContato-1].modificaFavorito();
		this.favoritos[posicaoFavorito-1] = nome;
		return true;
	}
	
	
	/**
	 * Encontra a posição do contato na lista de contatos por meio do nome do contato.
	 * 
	 * @param nome Nome do contato
	 * @return A posição do contato, retorna 0 como valor padrão
	 */
	public int getPosicaoPeloNome(String nome) {
		for(int i = 0; i < 100; i++) {
			if(this.contatos[i] != null && this.contatos[i].getNomeCompleto().equals(nome)) {
				return i;
			}
		}
		return 0;
	}
	
	/**
	 * Retorna String com dados do contato a serem exibidos.
	 * 
	 * @param posicao Posição do contato na lista de contatos
	 * @return String formatada com dados do contato
	 */
	public String exibirContato(int posicao) {
		Contato contato = this.contatos[posicao-1];
		String adicional = contato.getAdicional();
		
		if(contato.getFavorito() && adicional != null && !adicional.trim().isEmpty()) {
			return("❤️ " + contato.getNomeCompleto() + "\n" + contato.getPrioritario() + " (Prioritário)\n" + contato.getWhatsapp() + " (Whatsapp)\n" + adicional + " (Adicional)\n");
		}
		else if(contato.getFavorito() && adicional == null) {
			return("❤️ " + contato.getNomeCompleto() + "\n" + contato.getPrioritario() + " (Prioritário)\n" + contato.getWhatsapp() + " (Whatsapp)\n");
		}
		else if(!contato.getFavorito() && adicional != null && !adicional.trim().isEmpty()) {
			return(contato.getNomeCompleto() + "\n" + contato.getPrioritario() + " (Prioritário)\n" + contato.getWhatsapp() + " (Whatsapp)\n" + adicional + " (Adicional)\n");
		}
		else{
			return(contato.getNomeCompleto() + "\n" + contato.getPrioritario() + " (Prioritário)\n" + contato.getWhatsapp() + " (Whatsapp)\n");
		}
		
	}
	
	
	/**
	 * verifica se o contato já existe na agenda 
	 * 
	 * @param nome Nome do contato
	 * @param sobrenome Sobrenome do contato
	 * @return boolean Retorna true caso o contato exista e false caso o contato não exista
	 */
	public boolean existeContato(String nome, String sobrenome) {
		for(int i = 0; i < 100; i++) {
			if(this.contatos[i] != null && contatos[i].getNomeCompleto().equals(nome + " " + sobrenome)) {
				return true;
			}
		}
		return false;
	}

}