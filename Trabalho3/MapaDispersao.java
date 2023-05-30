package Trabalho3;

public class MapaDispersao<K, T> {
    public Lista<K, T> tabela;

    public void MapaDispersao(int quantidade) {
        this.tabela = new ListaEstatica(quantidade);
    }

}
