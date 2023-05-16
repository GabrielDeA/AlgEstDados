package arvores;

public class NoArvore<T> {

    private T info;
    private NoArvore<T> filho;
    private NoArvore<T> irmao;

    public T getInfo() {
        return this.info;
    }

    public NoArvore<T> getFilho() {
        return this.filho;
    }

    public NoArvore<T> getIrmao() {
        return this.irmao;
    }

    public NoArvore(T info) {
        super();
        this.info = info;
        filho = null;
        irmao = null;
    }

    public void inserirFilho(NoArvore<T> sa) {
        sa.irmao = this.filho;
        this.filho = sa;
    }

    public NoArvore<T> pertence(T info) {

        if (this.info.equals(info)) {
            return this;
        } else {
            NoArvore<T> no = null;
            if (this.getFilho() != null) {
                no = this.filho.pertence(info);
            }
            if (no == null && this.irmao != null) {
                no = this.irmao.pertence(info);
            }
            return no;
        }

    }

    public String imprimePre() {
        String str = "<" + this.info.toString();
        if (this.filho != null) {
            str += this.filho.imprimePre();
        }
        str += ">";
        if (this.irmao != null) {
            str += this.irmao.imprimePre();
        }
        return str;
    }

    // trabalho 2

    public int getAltura(NoArvore<T> no) {

        int altura = 0;
        if (no.filho == null) {
            return 1;
        } else {
            int alturaMAX = 0;
            
        }

        return 0;
    }
}
