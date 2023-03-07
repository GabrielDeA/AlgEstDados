public class ListaEncadeada implements Lista {

    private NoLista primeiro;
    private NoLista ultimo;
    private int qtdeElementos;

    @Override
    public void inserir(int valor) {
        NoLista novo = new NoLista();
        novo.setInfo(valor);
        if(this.EstaVazia()) {
            primeiro = novo;
        } else {
        ultimo.setProx(novo);
        }
        ultimo = novo;
        qtdeElementos++;
    }

    @Override
    public void retirar(int valor) {
    }

    @Override
    public int buscar(int valor) {

        return valor;

    }

    @Override
    public String exibir() {
        return null;

    }

    @Override
    public Lista copiar() {
        return null;

    }

    @Override
    public boolean EstaVazia() {
        if (primeiro == null) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void concatenar(Lista outra) {

    }

    @Override
    public Lista dividir() {
        return null;

    }

    @Override
    public int pegar(int pos) {
        return pos;

    }

    @Override
    public int getTamanho() {
        return 0;

    }

}
