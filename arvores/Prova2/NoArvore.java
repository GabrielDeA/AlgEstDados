//Gabriel De Antoni Santos

public class NoArvore<T> {
    private T info;
    private NoArvore<T> filho;
    private NoArvore<T> irmao;

    public NoArvore(T info) {
        super();
        this.info = info;
        this.filho = null;
        this.irmao = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
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

    public void inserirFilho(NoArvore<T> sa) {
        sa.irmao = this.filho;
        this.filho = sa;
    }

    public NoArvore<T> pertence(T info) {
        if (this.info.equals(info)) {
            return this;
        }
        NoArvore<T> no = null;
        if (this.filho != null) {
            no = this.filho.pertence(info);
        }
        if (no == null && this.irmao != null) {
            no = this.irmao.pertence(info);
        }
        return no;
    }
    // prova1

    public String Caminho(T procurado) {

        if (this.info.equals(procurado)) {
            return " Achou  " + this.info;
        }
        String str = "";
        if (this.filho != null && !this.info.equals(procurado)) {
            return " " + this.info + this.filho.Caminho(procurado);
        }
        if (this.irmao != null && !this.info.equals(procurado)) {
            return " " + this.info + this.irmao.Caminho(procurado);
        }
        // if(this.irmao == null && this.filho == null && !this.info.equals(procurado))
        // {
        // return str;
        // }

        return str + " " + this.info;
    }

    public int getGrau() {
        int grau = 0;
        int grauMax = 0;
        if (this.filho != null && this.filho.irmao != null) {
            if (this.filho.getIrmaos() > grauMax) {
                grauMax = this.filho.getIrmaos() + 1;
            }
        }
        if (this.filho != null && this.filho.irmao != null) {
            grau = this.filho.getGrau() + 1;
        }
        if (this.irmao != null) {
            grau = this.irmao.getGrau() + 1;
        }
        return grauMax;

    }

    public int getIrmaos() {
        int numeroIrmaos = 0;
        NoArvore<T> no = this;
        if (no.irmao != null) {
            while (no.irmao != null) {
                numeroIrmaos++;
                no = no.irmao;

            }
        }
        return numeroIrmaos;
    }

}
