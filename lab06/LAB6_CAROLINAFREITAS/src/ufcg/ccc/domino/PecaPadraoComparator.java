package ufcg.ccc.domino;

import java.util.Comparator;

/**
 * Compara dois peças,primeiro pelo número esquerdo, depois pelo número da direita.
 * @author carolina
 *
 */
public class PecaPadraoComparator implements Comparator<Peca> {

	@Override
	public int compare(Peca peca1, Peca peca2) {
		
        int NumDireitaCompare = peca1.getNumDireito() - peca2.getNumDireito();
        int NumEsquerdaCompare = peca1.getNumEsquerdo() - peca2.getNumEsquerdo();
        
        return (NumEsquerdaCompare == 0) ? NumDireitaCompare : NumEsquerdaCompare;
       
	}

}
