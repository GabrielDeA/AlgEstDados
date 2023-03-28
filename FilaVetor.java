import java.util.Arrays;

public class FilaVetor<T> implements Fila<T> {

    private T[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        super();
        this.limite = limite;
        this.info = (T[]) new Object[limite];
        this.tamanho = 0;
        this.inicio = 0;
    }

    @Override
    public void inserir(T valor) {
        if (tamanho == limite) {
            throw new RuntimeException("Fila esta cheia");
        }
        int posicaoInserir;
        posicaoInserir = (inicio + tamanho) % limite;
        info[posicaoInserir] = valor;
        this.tamanho++;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new RuntimeException("Fila esta vazia");
        }
        return info[inicio];
    }

    @Override
    public T retirar() {
        T valor = peek();
        this.info[inicio] = null;
        inicio = (inicio + 1) % limite;
        tamanho--;
        return valor;
    }

    @Override
    public boolean estaVazia() {
        if (tamanho == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void liberar() {
        while (estaVazia() == false) {
            retirar();
        }
    }

    public String toString() {
        String str = "[ ";
       for (int i = 0; i < this.tamanho; i++) {
        str += this.info[ (inicio + 1) % limite];
       }
        return str + "]";
    }

    public FilaVetor<T> concatenar(FilaVetor<T> f2) {
        FilaVetor<T> f3 = new FilaVetor<>(this.limite + f2.limite);
        int i = this.inicio;
        while (i != (this.inicio + this.tamanho) % this.limite) {
            if (i == this.limite - 1) {
                i = 0;
            }
            f3.inserir(this.info[i]);
            i++;
        }
        int j = f2.inicio;
        while (j != (f2.inicio + f2.tamanho) % f2.limite) {
            if (j == f2.limite - 1) {
                j = 0;
            }
            f3.inserir(f2.info[j]);
            j++;
        }
        return f3;
    }

}
