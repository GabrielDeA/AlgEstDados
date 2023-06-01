//Adriano, Artur e Gabriel Santos

public class NoLista<K, T> {
    T info;
    K chave;
    private NoLista<K, T> prox;

    public T getInfo() {
        return info;
    }
    public K getChave() {
        return chave;
    }
    
    public void setInfo(T info) {
        this.info = info;
    }
    public void setChave(K chave) {
        this.chave = chave;
    }
    public NoLista<K, T> getProx() {
        return prox;
    }
    public void setProx(NoLista<K, T> prox) {
        this.prox = prox;
    }
}
