package arvores;

public class ArvoreBinaria<T> {

    private NoArvoreBinaria<T> raiz;

    private void setRaiz(NoArvoreBinaria no) {
        this.raiz = no;
    }

    public boolean vazia() {
        if(raiz == null) {
            return true;
        }
        return false;
    }

    public NoArvoreBinaria<T> pertence(T info) {
        if(this.vazia() == true) {
            return null;
        }
        return this.raiz.pertence(info);
    }

    public String toString() {
        if(vazia()) {
            return "<>";
        }
        return this.raiz.imprimePre();
    }
    
}
