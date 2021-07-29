package lab2;
import java.util.ArrayList;

/**
* Registra as notas, o tempo de estudo, a média de um aluno e se ele está 
* aprovado ou não em uma determinada disciplina.
* 
* @author Carolina Martins Freitas
*/
public class Disciplina {
	
	/**
	* Nome da disciplina que será monitorada.
	*/
	private String nomeDisciplina;
	

	/**
	* Horas de estudo para a disciplina.
	*/
	private int horasEstudo;
	
	/**
	 * Número de notas que a disciplina possui, por padrão tem valor 4.
	 */
	private int numeroNotas = 4;

	/**
	* ArrayList que armazena as notas da disciplina.
	*/
	private ArrayList<Double> arrayNotas = new ArrayList<Double>();
	
	/**
	* Array que armazena o peso de cada nota da disciplina.
	*/
	private ArrayList<Integer> pesosNotas = new ArrayList<Integer>();
	
	/**
	 * Confere se foi passado um array com os pesos, inicialmente seu valor é falso,
	 * caso se tenha um array com pesos, seu valor passa a ser verdadeiro.
	 */
	private boolean temArrayPesos;
	
	
	
	/**
	* Constrói uma disciplina a partir de seu nome e inicializa o ArrayList com todas as notas inicialmente como zero.
	*
	* @param nomeDisciplina nome da disciplina
	*/
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		for(int i = 0; i < numeroNotas; i++) {
			this.arrayNotas.add(0.0);
		}
	}
	
	
	/**
	 *  Constrói a disciplina a partir do número de notas e do nome da disciplina
	 *  e inicializa o ArrayList com todas as notas inicialmente como zero.
	 *  
	 *  @param nomeDisciplina nome da disciplina
	 *  @param numeroNotas numero de notas da disciplina
	 */
	public Disciplina(String nomeDisciplina, int numeroNotas) {
		this.nomeDisciplina = nomeDisciplina;
		this.numeroNotas = numeroNotas;
		for(int i = 0; i < numeroNotas; i++) {
			this.arrayNotas.add(i, 0.0);
		}
	}
	
	
	/**
	 *  Constroi a disciplina tomando como parâmetros o nome da disciplina, o número de notas
	 *  e o peso de cada nota e inicializa o ArrayList com todas as notas inicialmente como zero.
	 *  
	 *  @param nomeDisciplina nome da disciplina
	 *  @param numeroNotas número de notas 
	 *  @param pesosNotasDado array com o peso de cada nota
	 */
	public Disciplina(String nomeDisciplina, int numeroNotas, int [] pesosNotasDado) {
		
		this.nomeDisciplina = nomeDisciplina;
		this.numeroNotas = numeroNotas;
		
		for(int i = 0; i < numeroNotas; i++) {
			this.arrayNotas.add(i, 0.0);
		}
		for(int i = 0; i < numeroNotas; i++) {
			this.pesosNotas.add(pesosNotasDado[i]);
		}
		
		this.temArrayPesos = true;
	}
	
	
	
	/**
	* Cadastra horas de estudo de forma cumulativa para determinada disciplina.
	*
	* @param horas horas de estudo
	* 
	*/
	public void cadastraHoras(int horas) {
		this.horasEstudo += horas;
	}
	
	
	/**
	* Cadastra uma das notas possíveis e considera a última nota 
	* cadastrada.
	*
	* @param nota número da nota
	* @param valorNota valor da nota
	* 
	*/
	public void cadastraNota(int nota, double valorNota) {
		this.arrayNotas.set(nota-1, valorNota);
	}
	
	
	/**
	* Método que realiza a soma das notas da disciplina, levando em conta seus respectivos pesos
	* caso tenham sido dados.
	* 
	* @return soma das notas da disciplina
	*/
	public double getSomaNotas() {
		double somaNotas = 0;
		
		if(temArrayPesos) {
			for(int i = 0; i < numeroNotas; i++) {
				somaNotas += arrayNotas.get(i) * pesosNotas.get(i);
			}
		}
		else {
			for(int i = 0; i < numeroNotas; i++) {
				somaNotas += arrayNotas.get(i);
			}
		}
		
		
		return somaNotas;
	}
	
	
	/**
	* Método que realiza a soma dos pesos das notas da disciplina.
	*
	* @return soma dos pesos das notas da disciplina
	*/
	public int getSomaPesos() {
		int somaPesos = 0;
		
		for(int i = 0; i < numeroNotas; i++) {
			somaPesos += pesosNotas.get(i);
		}
		
		return somaPesos;
	}
	
	
	/**
	* Método que calcula a média entre as notas da disciplina, realizando a média aritmética 
	* ou média ponderada caso tenha sido dado um array com pesos
	* 
	* @return média das notas da disciplina
	*/
	public double getMedia() {
		if(temArrayPesos) {
			return (getSomaNotas()) / getSomaPesos();
		}
		else {
			return (getSomaNotas()) / this.numeroNotas;
		}
	}
	
	
	/**
	* Verifica se a média do aluno é maior ou igual a 7.0, caso seja o aluno está aprovado na disciplina. 
	* Se a nota do aluno for menor que 7.0 o aluno está reprovado.
	*
	* @return retorna verdadeiro caso o aluno esteja aprovado e falso 
	* caso o aluno esteja reprovado na disciplina.
	*/
	public boolean aprovado() {
		double media = getMedia();
		
		if(media >= 7.0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/**
	* Gera uma String que contém o nome da disciplina, o número de horas de 
	* estudo, a média do aluno e as notas de cada uma das provas.
	*
	* @return String que contém o nome da disciplina, o número de horas de 
	* estudo para a disciplina, a média do aluno e as notas de cada uma das 
	* provas.
	*/
	public String toString() {
		return this.nomeDisciplina + " " + this.horasEstudo + " " + getMedia() + " " + arrayNotas;
	}
	
}