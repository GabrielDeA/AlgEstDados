//Adriano, Artur e Gabriel Santos
public class MapaDispersao<K, T> {
    public Lista<K, T> tabela[];
    private int qtdeElementos;

    public void MapaDispersao(int quantidade) {
        this.tabela = new ListaEncadeada[quantidade];
    }

    public boolean inserir(K chave, T dado) {
        int indice = this.calcularHash(chave);
        if(tabela[indice] != null) {
            tabela[indice].inserir(dado, chave);
              qtdeElementos++;
        return true;
        } else {
            tabela[indice] = new ListaEncadeada<>();
            tabela[indice].inserir(dado, chave);
            qtdeElementos++;
            return true;
        }

      //   return false;
        /*  experimento falho 
        if (tabela[indice] == null) {
            tabela[indice].inserir(dado, chave);
            qtdeElementos--;
            return true;
        } else {
            NoLista<K, T> no = tabela[indice].pegar(1);
            while (no.getProx() != null) {
                if (no.chave.equals(chave)) {
                    no.info = dado;
                    qtdeElementos++;
                    return true;
                }
                no = no.getProx();
            }

            return false;
       
    }
    */
}


    private int calcularHash(K chave) {
        int hash = chave.hashCode();

        int compactado = hash % this.tabela.length;

        return compactado;
    }

    public T remover(K chave) {
        int indice = this.calcularHash(chave);
        if (tabela[indice] != null) {
            T retorno = (T) tabela[indice];
            tabela[indice].retirar(chave);
            qtdeElementos--;
                return retorno;
        } else {
            return null;
        }
    }

    public T buscar(K chave) {
        int indice = this.calcularHash(chave);
        if(tabela[indice] != null) {
            return tabela[indice].buscaPorChave(chave);
        } else {
            return null;
        }
    }

    public int quantosElementos() {
        return this.qtdeElementos;
    }

}
