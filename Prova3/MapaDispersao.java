//Gabriel De Antoni Santos
import java.math.BigInteger;

/*
 * Esta implementacao de MapaDispersao nao realiza o tratamento de colisao.
 * @author Marcel Hugo
 * 
 * Alteracao feita por: 
 * 
 */

public class MapaDispersao<K, T> {

	private ObjetoMapa<K, T>[] tabela;

	public MapaDispersao(int quantidade) {
		BigInteger bi = BigInteger.valueOf(quantidade * 2);
		this.tabela = new ObjetoMapa[bi.nextProbablePrime().intValue()];
	}

	private int calcularHash(K chave) {
		// calcula indice do vetor
		return (chave.hashCode() & 0x7fffffff) % tabela.length;
		// & 0x7fffffff : esta opera��o bin�ria garante que o valor sera positivo
	}

	public boolean inserir(K chave, T valor) {
		int index = calcularHash(chave);
       
        if(this.buscar(chave) != null) { //buscar se a chave ja está inserida
            return false;
        }
		if (tabela[index] == null) { // se posicao estiver vazia, guarda o par<chave,valor>
			ObjetoMapa<K, T> om = new ObjetoMapa<K, T>();
			om.setChave(chave);
			om.setValor(valor);
			tabela[index] = om;
			return true;
		} else { // ja possui um objeto na posicao (colisao)
			while(tabela[index] != null) {
                index++;
            }
            if (tabela[index] == null) {
                ObjetoMapa<K, T> om = new ObjetoMapa<K, T>();
                om.setChave(chave);
                om.setValor(valor);
                tabela[index] = om;
                return true;
		}
	}
    return false;
}

	public T buscar(K chave) {
		int index = calcularHash(chave);
		if (tabela[index] == null) {
			return null;
		} else {
            while(tabela[index] != null) {
                if(tabela[index].getChave().equals(chave)) {
                    return tabela[index].getValor();
                } 
                index++;
            }
        }

		return null;
	}

	public T remover(K chave) {
		int index = calcularHash(chave);
		if (tabela[index] == null) {
			return null;
		}
		T temp = tabela[index].getValor();
		tabela[index] = null;
		return temp;
	}
}