package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author Carolina Martins Freitas - 120110894
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			listaFavoritos(agenda);
			break;
		case "A":
			adicionaFavorito(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção INVÁLIDA!");
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i+1, contatos[i].getNomeCompleto()));
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int posicao = scanner.nextInt();
		if(posicao > 100 || posicao < 1) {
			System.out.print("POSIÇÃO INVÁLIDA!");
			return;
		}
		Contato contato = agenda.getContato(posicao);
		if(contato != null) {
			System.out.print(agenda.exibirContato(posicao));
		}
		else {
			System.out.print("POSIÇÃO INVÁLIDA!");
			return;
		}
	}
	
	
	/**
	 * Formata um contato para impressão na interface. 
	 * 
	 * @param posicao A posição do contato (que é exibida)
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, String contato) {
		return posicao + " - " + contato;
	}
	

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição: ");
		int posicao = scanner.nextInt();
		if(posicao > 100 || posicao < 1) {
			System.out.println("POSIÇÃO INVÁLIDA");
			return;
		}
		
		System.out.print("Nome: ");
		String nome = scanner.next();
		scanner.nextLine();
		
		System.out.print("Sobrenome: ");
		String sobrenome = scanner.nextLine();
		
		System.out.print("Prioritario: ");
		String prioritario = scanner.nextLine();
		
		System.out.print("Whatsapp: ");
		String whatsapp = scanner.nextLine();
		
		System.out.print("Adicional: ");
		String adicional = scanner.nextLine();
		
		if(agenda.existeContato(nome,sobrenome)) {
			System.out.print("CONTATO JA CADASTRADO");
			return;
		}
		
		if(adicional != null && !adicional.trim().isEmpty()) {
			agenda.cadastraContato(posicao, nome, sobrenome, prioritario, whatsapp, adicional);
		}
		
		else {
			agenda.cadastraContato(posicao, nome, sobrenome, prioritario, whatsapp);
		}
		
		System.out.println("CADASTRO REALIZADO");
		
	}
	
	
	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}
	
	/**
	 * Adiciona um contato a lista de favoritos.
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato deve ser favoritado.
	 */
	private static void adicionaFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int posicaoContato = scanner.nextInt();
		System.out.print("Posicao> ");
		int posicaoFavorito = scanner.nextInt();
		
		Contato contato = agenda.getContato(posicaoContato);
		String nome = contato.getNomeCompleto();
		
		if(agenda.adicionaFavorito(posicaoFavorito, nome, posicaoContato)) {
			System.out.println("CONTATO FAVORITADO NA POSIÇÃO " + posicaoFavorito + "!");
		}
		
	}
	
	/**
	 * Imprime lista de contatos favoritos.
	 * @param agenda A agenda.
	 */
	private static void listaFavoritos(Agenda agenda) {
		String[] favoritos = agenda.getFavoritos();
		for(int i = 0; i < favoritos.length; i++) {
			if(favoritos[i] != null) {
				System.out.println(i+1 + " - " + favoritos[i]);
			}
		}
	}
	

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}

}