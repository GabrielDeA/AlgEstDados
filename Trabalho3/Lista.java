//Adriano, Artur e Gabriel Santos

public interface Lista<K, T> {

    void inserir(T valor, K chave);

    void retirar(K chave);

    int buscar(T valor);

    T buscaPorChave(K chave);

    String exibir();

    Lista<K, T> copiar();

    boolean EstaVazia();

    void concatenar(Lista<K, T> outra);

    Lista<K, T> dividir();

    NoLista<K, T> pegar(int pos);

    int getTamanho();

}
