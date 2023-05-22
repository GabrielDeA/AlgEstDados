//Gabriel Santos e Adriano Girardi

public class Arvore<T> {

    private NoArvore<T> raiz;

    public Arvore() {
		super();
        raiz = null;
	}

    protected void setRaiz(NoArvore<T> raiz) {
		this.raiz = raiz;
	}
    public NoArvore<T> getRaiz() {
        return this.raiz;
    }

    public boolean vazia() {
		if (raiz == null) {
			return true;
		}
		return false;
	}


    public NoArvore<T> pertence(T info) {
        if(this.vazia()) {
            return null;
        }
        return this.raiz.pertence(info);
    }

    public String toString() {
        if(this.vazia()) {
            return "<>";
        } 
        return this.raiz.imprimePre();
    }

    //trabalho 2
    public int getAltura() {
        if(this.vazia()) {
            return -1;
        } else {
            return raiz.getAltura(raiz);
        }
    }

    public int getNivel(T info) {
        if(this.vazia()) {
            return -1;
        } else {
            return raiz.getNivel(info, raiz, 0);   
             }
    }

    public boolean isBalanceada() {
        int alturaMaxima = raiz.calcularAltura(raiz);
        return alturaMaxima != -1;
    }
}
