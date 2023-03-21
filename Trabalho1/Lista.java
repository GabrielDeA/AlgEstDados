
public interface Lista<T> {

    void inserir(T valor);

    void retirar(T valor);

    int buscar(T valor);

    String exibir();

    Lista<T> copiar();

    boolean EstaVazia();

    void concatenar(Lista<T> outra);

    Lista<T> dividir();

    T pegar(int pos);

    int getTamanho();

}