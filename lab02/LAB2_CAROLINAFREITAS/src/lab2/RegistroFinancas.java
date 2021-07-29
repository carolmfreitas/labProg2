package lab2;
import java.util.ArrayList;
import java.util.Arrays;

/**
* Organiza a situação financeira do aluno monitorando sua receita que vem 
* de diferentes fontes de renda e as despesas desse estudante. 
* 
* @author Carolina Martins Freitas
*/
public class RegistroFinancas {
	
	/**
	* Valor atual da receita
	*/
	private int receita;
	
	/**
	* Valor da receita acumulado.
	*/
	private int receitaTotal;
	
	/**
	* valor das despesas acumulado
	*/
	private int despesa;
	
	/**
	* Array que armazena o histórico(valor total) recebido de todas as quatro 
	* fontes de renda.
	*/
	private int[] fontesRenda = new int[4];
	
	/**
	 * ArrayList com os detalhes das últimas despesas do aluno.
	 */
	private ArrayList<String> arrayDetalhes = new ArrayList<String>();
	
	
	/**
	* Constrói um objeto para monitorar as finanças do aluno por meio do valor inicial da fonte de renda do tipo 1, 
	* adicionando esse valor à receita atual e ao histórico do valor total da receita do aluno.
	*
	* @param receitaInicialDoTipo1 valor inicial da fonte de renda 1
	*/
	public RegistroFinancas(int receitaInicialDoTipo1) {
		
		this.fontesRenda[0] = receitaInicialDoTipo1;
		this.receita = this.fontesRenda[0];
		this.receitaTotal = this.fontesRenda[0];
	}
	
	
	/**
	* Método que adiciona o novo valor recebido de uma das fontes de renda ao 
	* histórico do valor desse tipo de fonte de renda, à receita atual e ao 
	* histórico do valor total da receita do aluno.
	*
	* @param valorCentavos valor em centavos recebido de uma das fontes de renda
	* @param tipoFonte tipo da fonte de renda
	* 
	*/
	public void aumentaReceita(int valorCentavos, int tipoFonte) {
		
		this.fontesRenda[tipoFonte-1] += valorCentavos;
		this.receita += valorCentavos;
		this.receitaTotal += valorCentavos;
	}
	
	
	/**
	* Subtrai o valor gasto pelo aluno da sua receita atual e adiciona esse 
	* valor ao seu histórico de despesas.
	*
	* @param valorCentavos valor gasto pelo aluno
	* 
	*/
	public void pagaDespesa(int valorCentavos) {
		this.receita -= valorCentavos;
		this.despesa += valorCentavos;
	}
	
	
	/**
	* Subtrai o valor gasto pelo aluno da sua receita atual, adiciona esse 
	* valor ao seu histórico de despesas e possibilita registrar detalhes sobre esse gasto.
	*
	* @param valorCentavos valor gasto pelo aluno
	* @param detalhes string com detalhes da despesa
	* 
	*/
	public void pagaDespesa(int valorCentavos, String detalhes) {
		this.receita -= valorCentavos;
		this.despesa += valorCentavos;
		arrayDetalhes.add(detalhes);
	}
	

	/**
	* Informa o histórico de quanto foi recebido de cada um dos tipos de fonte.
	*
	* @return string com o histórico dos valores que foram recebidos de cada 
	* fonte
	*/
	public String exibeFontes() {
		return "1 - " + this.fontesRenda[0] + "\n" + "2 - " + this.fontesRenda[1] + "\n" + "3 - " + this.fontesRenda[2] + "\n" + "4 - " + this.fontesRenda[3];
	}
	
	
	/**
	* Gera uma String que contém o valor da receita atual, o valor das despesas acumulado e o valor da receita acumulado. 
	*
	* @return string com o valor da receita atual, o valor total das despesas 
	* e o valor da receita acumulado. 
	*/
	public String toString() {
		return "Receita total: " + this.receitaTotal + ", " + "Receita atual: " + this.receita + ", " + "Despesas totais: " + this.despesa;
	}
	
	
	/**
	 * Gera uma string detalhando as ultimas despesas do aluno.
	 * 
	 * @return string com detalhamento das ultimas cinco despesas do aluno
	 */
	public String listarDetalhes() {
		return arrayDetalhes.get(arrayDetalhes.size()-1) + "\n" + arrayDetalhes.get(arrayDetalhes.size()-2) + "\n" + arrayDetalhes.get(arrayDetalhes.size()-3) + "\n" + arrayDetalhes.get(arrayDetalhes.size()-4) + "\n" + arrayDetalhes.get(arrayDetalhes.size()-5);
	}

	
}
