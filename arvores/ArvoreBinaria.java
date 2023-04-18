package arvores;


public class ArvoreBinaria<T> { // contribuição do Martin
	private NoArvoreBinaria<T> raiz;

	public ArvoreBinaria() {
		super();
	}

	public void setRaiz(NoArvoreBinaria<T> raiz) {
		this.raiz = raiz;
	}

	public boolean vazia() {
		if (raiz == null) {
			return true;
		}
		return false;
	}

	public NoArvoreBinaria<T> pertence(T info) {
		if (this.vazia()) {
			return null;
		}
		return this.raiz.pertence(info);
	}

	@Override
	public String toString() {
		if (this.vazia()) {
			return "<>";
		}
		return this.raiz.imprimePre();
	}
}
