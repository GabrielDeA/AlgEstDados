public class PilhaVetor<T> implements Pilha<T> {

    private int tamanho;
    private T[] info;
    private int limite;

    public PilhaVetor() {
        this.info =(T[]) new Object[10];
        this.tamanho = 0;
        this.limite = 5;
    }

    public String toString(){
        String str = "[ ";
        for (int i = tamanho - 1; i <= 0; i--) {
            str += info[i] + ", ";
        }
        return str + "]";
    }

    @Override
    public void push(Object v) {
        if (limite == tamanho) {
            throw new RuntimeException("Capacidade esgotada de pilha");
        } else {
            info[tamanho] = (T) v;
            tamanho++;
        }
    }

    @Override
    public T pop() {
        T valor;
        valor = peek();
        
        info[tamanho] = null;
        tamanho--;
        
        return valor;
    }

    @Override
    public T peek() {
        if (EstaVazia() == true) {
            throw new RuntimeException("Pilha está vazia");
        } else {
            return info[tamanho - 1];
        }
    }

    @Override
    public boolean EstaVazia() {
       return(tamanho == 0);
    }

    @Override
    public void liberar() {
        for (int i = 0; i < tamanho; i++) {
            info[i] = null;
        }
        tamanho = 0;
    }
    
}
