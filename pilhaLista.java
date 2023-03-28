public class pilhaLista<T> implements Pilha<T>{

    private ListaEncadeada<T> lista;

    public String toString() {
        return lista.exibir();
    }

    public pilhaLista() {
        lista = new ListaEncadeada<>();
    }

    @Override
    public void push(T v) {
        lista.inserir(v);
    }

    @Override
    public T pop() {
        T valor;
         valor = peek();
         lista.retirar(valor);
         return valor;
    }

    @Override
    public T peek() {
        if(EstaVazia() == true) {
            throw new RuntimeException("Pilha está vazia");
        } else {
            return lista.ultimo.info;
        }
    }

    @Override
    public boolean EstaVazia() {
        if (lista.qtdeElementos == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void liberar() {
        while(EstaVazia() == false) {
            lista.retirar(peek());
        }
    }
    
}
