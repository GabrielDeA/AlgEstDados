//Adriano, Artur e Gabriel Santos
public class ListaEncadeada<K, T> implements Lista<K, T> {

    NoLista<K, T> primeiro;
    private NoLista<K, T> ultimo;
    int qtdeElementos;

    @Override
    public void inserir(T valor, K chave) {
        NoLista<K, T> novo = new NoLista<>();
        novo.setInfo(valor);
        novo.setChave(chave);
        if (this.EstaVazia()) {
            primeiro = novo;
        } else {
            ultimo.setProx(novo);
        }
        ultimo = novo;
        qtdeElementos++;
    }

    @Override
    public void retirar(K chave) {
        NoLista<K, T> p = this.primeiro;
        NoLista<K, T> anterior = null;
        while (p != null && p.getChave() != chave) {
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
    public int buscar(T valor) {
        NoLista<K, T> p = primeiro;
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

    public T buscaPorChave(K chave) {
        NoLista<K, T> p = primeiro;
        while(p != null) {
            if(p.getChave() == chave) {
                return p.getInfo();
            } else {
                p = p.getProx();
            }
        }
        return null;
    }

    @Override
    public String exibir() {
        NoLista<K, T> p = primeiro;
        String str = "[";
        while (p != null) {
            str += p.getInfo() + ", ";
            p = p.getProx();
        }
        return str + "]";
    }

    @Override
    public Lista<K, T> copiar() {
       ListaEncadeada<K, T> nova = new ListaEncadeada<>();

        NoLista<K, T> p = this.primeiro;
        while( p != null) {
            nova.inserir(p.getInfo(), p.getChave());
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

    public void concatenar(Lista<K, T> outra) {
        for (int i = 0; i < outra.getTamanho(); i++) {
            
         //   this.inserir(outra.pegar(i), this.primeiro.getChave() );
        }
    }

    @Override
    public Lista<K, T> dividir() {
        ListaEncadeada<K, T> dividida = new ListaEncadeada<>();
        if(this.qtdeElementos < 2) {
            return dividida;
        }

        int metade = qtdeElementos/2;
        int pos = 0;
        NoLista<K, T> p = new NoLista<K, T>();
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
    public NoLista<K, T> pegar(int pos) { //retornar o objeto, não apenas sua info
        if(pos<0 || pos >= qtdeElementos) {
            throw new IndexOutOfBoundsException("Pos = " + pos);
        }
        NoLista<K, T> p = this.primeiro;
        for (int i = 0; i < pos; i++) {
           p = p.getProx(); 
        }
        return p;
    }

    @Override
    public int getTamanho() {
        return qtdeElementos;
    }

}
