public interface Pilha<T> {
    void push(T v);

    T pop();

    T peek();

    boolean EstaVazia();

    void liberar();
}
