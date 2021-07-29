package lab4;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


/**
 * Interface com menus texto para manipular um sistema que controla informações de alunos e de grupos de estudo.
 * 
 * @author Carolina Martins Freitas - 120110894
 *
 */
public class MainControle {
	public static void main(String[] args) {
		
		GerenciaAlunos gerenciaAlunos = new GerenciaAlunos();
		GerenciaGrupos gerenciaGrupos = new GerenciaGrupos();
		
		
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha,gerenciaAlunos,gerenciaGrupos,scanner);
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
				"\n(C)adastrar Aluno\n"
				+ "(E)xibir Aluno\n"
				+ "(N)ovo Grupo\n"
				+ "(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n"
				+ "(R)egistrar Aluno que Respondeu\n"
				+ "(I)mprimir Alunos que Responderam\n"
				+ "(O)xe, e a contagem dos grupos com restrição de curso?\n"
				+ "(S)im, quero fechar o programa!\n"
				+ "\n"
				+ "Opção>" );
		return scanner.next().toUpperCase();
	}
	
	
	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao Opção digitada.
	 * @param gerenciaAlunos  A classe que gerencia os alunos.
	 * @param gerenciaGrupos  A classe que gerencia os grupos de estudo.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, GerenciaAlunos gerenciaAlunos, GerenciaGrupos gerenciaGrupos, Scanner scanner) {
		switch (opcao) {
		
		case "C":
			cadastraAluno(gerenciaAlunos, scanner);
			break;
			
		case "E":
			exibirAluno(gerenciaAlunos, scanner);
			break;
			
		case "N":
			novoGrupo(gerenciaGrupos, scanner);
			break;
			
		case "A":
			System.out.print("(A)locar Aluno ou (P)ertinência a Grupo? ");
			String escolha = scanner.next().toUpperCase();
			if(escolha.equals("A")) {
				alocarAluno(gerenciaAlunos, gerenciaGrupos, scanner);
			}
			else {
				pertinenciaGrupos(gerenciaGrupos, scanner);
			}
			break;
			
		case "R":
			registrarAlunoResponde(gerenciaAlunos, scanner);
			break;
		
		case "I":
			imprimirAlunosQueRespondem(gerenciaAlunos);
			break;
		
		case "O":
			contaGruposRestricao(gerenciaGrupos, scanner);
			break;
			
		case "S":
			sai();
			break;
			
		default:
			System.out.println("Opção INVÁLIDA!");
		}
	}
	
	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.exit(0);
	}
	
	/**
	 * Cadastra um aluno no sistema utilizando a matricula, nome e curso do aluno.
	 * @param gerenciaAlunos A classe que gerencia os alunos.
	 * @param scanner Objeto scanner.
	 */
	private static void cadastraAluno(GerenciaAlunos gerenciaAlunos, Scanner scanner) {
		scanner.nextLine();
		System.out.print("Matrícula: ");
		String matricula = scanner.nextLine();
		
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		
		System.out.print("Curso: ");
		String curso = scanner.nextLine().toLowerCase();
		
		try {
			System.out.print(gerenciaAlunos.cadastraAluno(nome,matricula,curso)+"\n");
		} catch(IllegalArgumentException msg) {
			System.out.print(msg.getMessage());
			System.exit(0);
		}
	}
	
	/**
	 * imprime os dados de um aluno por meio de sua matricula.
	 * @param gerenciaAlunos A classe que gerencia os alunos.
	 * @param scanner Objeto scanner.
	 */
	private static void exibirAluno(GerenciaAlunos gerenciaAlunos, Scanner scanner) {
		scanner.nextLine();
		System.out.print("Matrícula: ");
		String matricula = scanner.nextLine();
		
		try {
			System.out.println(gerenciaAlunos.exibeAluno(matricula));
		} catch(IllegalArgumentException msg) {
			System.out.print(msg.getMessage());
			System.exit(0);
		}
	}
	
	/**
	 * Cadastra um novo grupo no sistema.Maiúsculas e minúsculas são indistintas para o nome do
	 * curso e para o nome do grupo.
	 * @param gerenciaGrupos A classe que gerencia os grupos de estudo.
	 * @param scanner Objeto scanner.
	 */
	private static void novoGrupo(GerenciaGrupos gerenciaGrupos, Scanner scanner) {
		scanner.nextLine();
		System.out.print("Grupo: ");
		String nomeGrupo = scanner.nextLine().toLowerCase();
		
		System.out.print("Restrição? ");
		String restricao = scanner.nextLine().toLowerCase();
		
		try {
			System.out.println(gerenciaGrupos.criaGrupo(nomeGrupo,restricao));
		} catch(IllegalArgumentException msg) {
			System.out.print(msg.getMessage());
			System.exit(0);
		}
	}
	
	/**
	 * Aloca um aluno em um grupo de estudo.
	 * @param gerenciaAlunos A classe que gerencia os alunos.
	 * @param gerenciaGrupos A classe que gerencia os grupos de estudo.
	 * @param scanner Objeto scanner.
	 */
	private static void alocarAluno(GerenciaAlunos gerenciaAlunos, GerenciaGrupos gerenciaGrupos, Scanner scanner) {
		scanner.nextLine();
		System.out.print("Matrícula: ");
		String matricula = scanner.nextLine();
		
		System.out.print("Grupo: ");
		String nomeGrupo = scanner.nextLine().toLowerCase();
		
		try {
			System.out.println(gerenciaGrupos.alocaAluno(gerenciaAlunos,matricula,nomeGrupo));
		} catch(IllegalArgumentException msg) {
			System.out.print(msg.getMessage());
			System.exit(0);
		}
	}
	
	/**
	 * Verifica se um aluno pertence a um determinado grupo de estudo.
	 * @param gerenciaGrupos A classe que gerencia os grupos de estudo.
	 * @param scanner Objeto scanner.
	 */
	private static void pertinenciaGrupos(GerenciaGrupos gerenciaGrupos, Scanner scanner) {
		scanner.nextLine();
		System.out.print("Grupo: ");
		String nomeGrupo = scanner.nextLine().toLowerCase();
		System.out.print("Aluno: ");
		String matricula = scanner.nextLine();
		
		try {
			System.out.println(gerenciaGrupos.pertinenciaGrupos(nomeGrupo,matricula));
		} catch(IllegalArgumentException msg) {
			System.out.print(msg.getMessage());
			System.exit(0);
		}
		
	}
	
	/**
	 * Cadastra alunos que respondem questões no quadro.
	 * @param gerenciaAlunos A classe que gerencia os alunos.
	 * @param scanner Objeto scanner.
	 */
	private static void registrarAlunoResponde(GerenciaAlunos gerenciaAlunos, Scanner scanner) {
		scanner.nextLine();
		System.out.print("Matrícula: ");
		String matricula = scanner.nextLine();
		try {
			System.out.println(gerenciaAlunos.registrarAlunoQueResponde(matricula));
		} catch(IllegalArgumentException msg) {
			System.out.print(msg.getMessage());
			System.exit(0);
		}
	}
	
	/**
	 * Imprime alunos que respondem questões no quadro.
	 * @param gerenciaAlunos A classe que gerencia os alunos.
	 */
	private static void imprimirAlunosQueRespondem(GerenciaAlunos gerenciaAlunos) {
		HashSet <String> alunosRespondem = gerenciaAlunos.getAlunosRespondem();
		HashMap <String,Aluno> mapaMatriculaAlunos = gerenciaAlunos.getMapaMatriculaAlunos();
		
		System.out.println("Alunos:");
		int indice = 1;
		for(String matriculaAluno : alunosRespondem) {
			Aluno aluno = mapaMatriculaAlunos.get(matriculaAluno);
			System.out.println(indice + ". " + matriculaAluno + " - " + aluno.getNome() + " - " + aluno.getCurso());
			indice = indice + 1;
		}
	}
	
	/**
	 * Imprime o número de grupos de estudo com restrição por curso.
	 * @param gerenciaGrupos A classe que gerencia os grupos de estudo.
	 * @param scanner Objeto scanner.
	 */
	private static void contaGruposRestricao(GerenciaGrupos gerenciaGrupos, Scanner scanner) {
		scanner.nextLine();
		System.out.print("Curso: ");
		String nomeCurso = scanner.nextLine().toLowerCase();
		try {
			System.out.println(nomeCurso + " " + gerenciaGrupos.recuperaGruposRestricao(nomeCurso));
		} catch(IllegalArgumentException msg) {
			System.out.print(msg.getMessage());
			System.exit(0);
		}
	}
	
}