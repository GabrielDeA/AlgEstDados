package arvores;

public class NoArvoreBinaria<T> {
    private T info;
    private NoArvoreBinaria<T> esq;
    private NoArvoreBinaria<T> dir;

    public NoArvoreBinaria<T> pertence(T info) {
        if (this.info.equals(info)) {
            return this;
        }
        NoArvoreBinaria<T> noPesquisado = null;
        if (this.esq != null) {
            noPesquisado = this.esq.pertence(info);
        }
        if (noPesquisado == null && this.dir != null) {
            noPesquisado = this.dir.pertence(info);
        }
        return noPesquisado;
    }

    public String imprimePre() {
        String str = "<" + this.info.toString();
        if (this.esq != null) {
            str += this.esq.imprimePre();
        }
        if (this.dir != null) {
            str += this.dir.imprimePre();
        }

        return str + ">";
    }

}
