public class NoLista<K, T> {
    T info;
    K chave;
    private NoLista<K, T> prox;

    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }
    public NoLista<K, T> getProx() {
        return prox;
    }
    public void setProx(NoLista<K, T> prox) {
        this.prox = prox;
    }
}
