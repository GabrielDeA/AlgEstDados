package Trabalho3;


public interface Lista<K, T> {

    void inserir(T valor);

    void retirar(T valor);

    int buscar(T valor);

    String exibir();

    Lista<K, T> copiar();

    boolean EstaVazia();

    void concatenar(Lista<K, T> outra);

    Lista<K, T> dividir();

    T pegar(int pos);

    int getTamanho();

}