package arvores;

public abstract class ArvoreBinariaAbstract<T> { // contribuição do Martin
	private NoArvoreBinaria<T> raiz;

	public NoArvoreBinaria<T> getRaiz() {
		return raiz;
	}

	public ArvoreBinariaAbstract() {
		super();
	}

	protected void setRaiz(NoArvoreBinaria<T> raiz) {
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