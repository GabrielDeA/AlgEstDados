public class MapaDispersao<K, T> {
    public ListaEncadeada<K, T> tabela[];

    public void MapaDispersao(int quantidade) {
        this.tabela = new ListaEncadeada[quantidade];
    }

    public boolean inserir(K chave, T dado) {
        int indice = this.calcularHash(chave);

        if(tabela[indice] == null) {
            tabela[indice].inserir(dado);
            return true;
        } else {
            NoLista<K, T> no = tabela[indice].primeiro;
            while(no.getProx() != null) {
                if (no.chave.equals(chave)) {
                    no.info = dado;
                    return true;
                }
                no = no.getProx();
            } 
            
        }
        return false;
    }

    private int calcularHash(K chave) {
        int hash = chave.hashCode();

        int compactado = hash % this.tabela.length;
        
        return compactado;
    }

    public T remover(K chave) { 
        int indice = this.calcularHash(chave);
        if(tabela[indice] != null) {
            T retorno = (T) tabela[indice];
            tabela[indice] = null;
            return retorno;
        } else {
            return null;
        }
    }

}
