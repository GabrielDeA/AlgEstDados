public class ListaEncadeada implements Lista {

    private NoLista primeiro;
    private NoLista ultimo;
    private int qtdeElementos;

    @Override
    public void inserir(int valor) {
        NoLista novo = new NoLista();
        novo.setInfo(valor);
        if (this.EstaVazia()) {
            primeiro = novo;
        } else {
            ultimo.setProx(novo);
        }
        ultimo = novo;
        qtdeElementos++;
    }

    @Override
    public void retirar(int valor) {
        NoLista p = this.primeiro;
        NoLista anterior = null;
        while (p != null && p.getInfo() != valor) {
            anterior = p;
            p = p.getProx();
        }
            if(p != null) {
                if (anterior == null) {
                   this.primeiro = p.getProx(); 
                } else {
              anterior.setProx(p.getProx());
            }
            if(this.ultimo == p) {
                this.ultimo = anterior;
            }
            qtdeElementos--;
        }
           
        
    }

    @Override
    public int buscar(int valor) {
        NoLista p = primeiro;
        int pos = 0;
        while ( p != null) {
            if(p.getInfo() == valor) {
                return pos;
            }
            p = p.getProx();
            pos++;
        }
        return -1;

    }

    @Override
    public String exibir() {
        NoLista p = primeiro;
        String str = "[";
        while (p != null) {
            str += p.getInfo() + ", ";
            p = p.getProx();
        }
        return str + "]";
    }

    @Override
    public Lista copiar() {
       ListaEncadeada nova = new ListaEncadeada();

        NoLista p = this.primeiro;
        while( p != null) {
            nova.inserir(p.getInfo());
            p = p.getProx();
        }
        return nova;

    }

    @Override
    public boolean EstaVazia() {
        if (primeiro == null) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void concatenar(Lista outra) {
        for (int i = 0; i < outra.getTamanho(); i++) {
            this.inserir(outra.pegar(i));
        }
    }

    @Override
    public Lista dividir() {
        ListaEncadeada dividida = new ListaEncadeada();
        if(this.qtdeElementos < 2) {
            return dividida;
        }
        
        int metade = qtdeElementos/2;
        int pos = 0;
        NoLista p = new NoLista();
        p = this.primeiro;
        while (pos < metade) {
            p = p.getProx();
            pos++;
        }
        dividida.primeiro = p.getProx();
        dividida.ultimo = this.ultimo;
        dividida.qtdeElementos = this.qtdeElementos - metade;
        p.setProx(null);
        this.ultimo = p;
        this.qtdeElementos = metade;
        return dividida;
    }

    @Override
    public int pegar(int pos) {
        if(pos<0 || pos >= qtdeElementos) {
            throw new IndexOutOfBoundsException("Pos = " + pos);
        }
        NoLista p = this.primeiro;
        for (int i = 0; i < pos; i++) {
           p = p.getProx(); 
        }
        return p.getInfo();

    }

    @Override
    public int getTamanho() {
        return qtdeElementos;
    }

}

