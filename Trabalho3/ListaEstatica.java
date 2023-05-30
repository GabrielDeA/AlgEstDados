package Trabalho3;

public class ListaEstatica<K, T> implements Lista<K,T> {
    private int tamanho;
    private T[] info;

    public ListaEstatica(int quantidade) {
        this.info =(T[]) new Object[quantidade]; //coloquei parametro quantidade
        this.tamanho = 0;
    }

    @Override
    public void inserir(T valor) {
        if (tamanho == info.length) {
            this.redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    private void redimensionar() {
        T[] novo =(T[]) new Object[tamanho + 10];
        for (int i = 0; i < tamanho; i++) {
            novo[i] = info[i];
        }
        info = novo;
    }

    @Override
    public void retirar(T valor) {
        int pos = this.buscar(valor);
        if (pos != -1) {
            for (int i = pos; i < tamanho - 1; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }

    @Override
    public int buscar(T valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String exibir() {
        String str = "[";
        for (int i = 0; i < tamanho; i++) {
            if (i == tamanho - 1) {
                str += info[i];
            } else {
                str += info[i] + ", ";
            }
        }
        return str + "]";
    }

    @Override
    public Lista<K, T> copiar() {
        Lista<K, T> outra = new ListaEstatica<>(10);
        for (int i = 0; i < tamanho; i++) {
            outra.inserir(info[i]);
        }
        return outra;
    }

    @Override
    public boolean EstaVazia() {
       return (tamanho == 0);
    }

    @Override
    public void concatenar (Lista<K, T> outra) {
        for (int i = 0; i < outra.getTamanho(); i++) {
           this.inserir(outra.pegar(i));
        }
    }

    @Override
    public Lista<K, T> dividir() {
        Lista<K, T> dividida = new ListaEstatica<>(10);
        int metade = this.tamanho/2;
        for (int i = metade; i < tamanho; i++) {
            dividida.inserir(info[i]);
        }  
       this.tamanho = metade;
        return dividida;
    }

    @Override
    public T pegar(int pos) {
        if(pos<0 || pos >= tamanho) {
            throw new IndexOutOfBoundsException("Pos = " + pos);
        }
        return info[pos];
    }

    @Override
    public int getTamanho() {
        return this.tamanho;
    }
}