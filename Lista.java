
public interface Lista {

    void inserir(int valor);

    void retirar(int valor);

    int buscar(int valor);

    String exibir();

    Lista copiar();

    boolean EstaVazia();

    void concatenar(Lista outra);

    Lista dividir();

    int pegar(int pos);

    int getTamanho();

}
