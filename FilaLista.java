public class FilaLista<T> implements Fila<T> {
    private ListaEncadeada<T> lista;

    public FilaLista() {
        this.lista = new ListaEncadeada<>();
    }

    @Override
    public void inserir(T valor) {
        lista.inserir(valor);
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new RuntimeException("Lista esta vazia");
        }
        return lista.pegar(0);
    }

    @Override
    public T retirar() {
        T valor;
        valor = peek();
        lista.retirar(valor);
        return valor;
    }

    @Override
    public boolean estaVazia() {
       return lista.EstaVazia();
    }

    @Override
    public void liberar() {
        this.lista = new ListaEncadeada<>();
    }

}
