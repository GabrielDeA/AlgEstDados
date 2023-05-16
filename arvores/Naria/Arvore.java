package arvores;

public class Arvore<T> {

    private NoArvore<T> raiz;

    //de outras classes
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

    //autoral

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
}