//Gabriel Santos e Adriano Girardi

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
        if (no == null) {
            return 0;
        } else {
            int alturaFilhos = 0;
            NoArvore<T> filho = no.filho;

            while (filho != null) {
                int alturaFilho = getAltura(filho);
                alturaFilhos = Math.max(alturaFilhos, alturaFilho);
                filho = filho.irmao;
            }
            return alturaFilhos + 1;
        }
    }

    public int getNivel(T info, NoArvore<T> no, int nivelAtual) {
        if (no == null) {
            return -1;
        } else {
            if (no.info.equals(info)) {
                return nivelAtual;
            } else {
                NoArvore<T> filho = no.filho;

                while (filho != null) {
                    int nivelFilho = getNivel(info, filho, nivelAtual+1);
                    if (nivelFilho != -1) {
                        return nivelFilho;
                    }
                    filho = filho.irmao;
                }
                return -1;
            }
        }
    }

    
    public int calcularAltura(NoArvore<T> no) {
        if (no == null) {
            return 0;
        }

        int alturaMaxima = -1;
        NoArvore<T> filho = no.filho;
        while (filho != null) {
            int alturaFilho = calcularAltura(filho);
            if (alturaFilho == -1) {
                return -1;
            }
            if (alturaMaxima == -1) {
                alturaMaxima = alturaFilho;
            } else if (Math.abs(alturaFilho - alturaMaxima) > 1) {
                return -1;
            } else {
                alturaMaxima = Math.max(alturaMaxima, alturaFilho);
            }
            filho = filho.irmao;
        }

        return alturaMaxima;
    }

}

