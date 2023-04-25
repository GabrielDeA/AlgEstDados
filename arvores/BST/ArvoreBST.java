package arvores;

public class ArvoreBST<T extends Comparable> extends ArvoreBinariaAbstract<T> {

    public void inserir(T info) {
        if (this.vazia()) {
            this.setRaiz(new NoArvoreBST<T>(info));
        } else {
            ((NoArvoreBST<T>) this.getRaiz()).inserir(info);
        }
    }

    public NoArvoreBST<T> buscar(T info) {
        if (this.vazia()) {
            return null;
        }
        return ((NoArvoreBST<T>) this.getRaiz()).buscar(info);
    }

    public void retirar(T info) {
        NoArvoreBST<T> noARemover = this.buscar(info);
        if (noARemover != null) {
            this.removerNo(noARemover);
        }
    }

    private void removerNo(NoArvoreBST<T> noARemover) {
        NoArvoreBST<T> noPai = this.buscarPai(noARemover);

        if (noARemover.ehFolha()) {
            // caso 1
            if (this.getRaiz() == noARemover) {
                this.setRaiz(null);
            } else {
                if (noPai.getEsq() == noARemover) {
                    noPai.setEsq(null);
                } else {
                    noPai.setDir(null);
                }
            }
        } else {
            if (noARemover.temUmFilho()) {
                // caso 2
                NoArvoreBST<T> noFilho = noARemover.buscarUnicoFilho();
                if (this.getRaiz() == noARemover) {
                    this.setRaiz(noFilho);
                } else {
                    if (noPai.getEsq() == noARemover) {
                        noPai.setEsq(noFilho);
                    } else {
                        noPai.setDir(noFilho);
                    }
                }
            } else {
                // caso 3
                NoArvoreBST<T> noSucessor = this.buscarSucessor(noARemover);
                T info = (T) noSucessor.getInfo(); // prof
                this.removerNo(noSucessor);
                noARemover.setInfo(info);

            }
        }
    }

    private NoArvoreBST<T> buscarPai(NoArvoreBST<T> no) {
        if (no == this.getRaiz()) {
            return null;
        }
        NoArvoreBST<T> noPai = (NoArvoreBST<T>) this.getRaiz();
        while (noPai.getEsq() != no && noPai.getDir() != no) {
            if (((Comparable) no.getInfo()).compareTo(noPai.getInfo()) < 0) {
                noPai = (NoArvoreBST<T>) noPai.getEsq();
            } else {
                noPai = (NoArvoreBST<T>) noPai.getDir();
            }
        }
        return noPai;
    }

    public NoArvoreBST<T> getSucessor(T info) {
        NoArvoreBST<T> no = this.buscar(info);
        if(no == null || info.equals(this.maiorValor())) {
            return null;
        }
        if(no.getDir() != null) {
            return this.buscarSucessor(no);
        } else {
            NoArvoreBST<T> NoPai = this.buscarPai(no);
            while(NoPai.getDir() == no) {
                no = NoPai;
                NoPai = this.buscarPai(no);
            }
            return NoPai;
        }
    }

    private NoArvoreBST<T> buscarSucessor(NoArvoreBST<T> no) {
        NoArvoreBST<T> noSucessor = (NoArvoreBST) no.getDir();
        while (noSucessor.getEsq() != null) {
            noSucessor = (NoArvoreBST<T>) noSucessor.getEsq();
        }
        return noSucessor;
    }

    public NoArvoreBST<T> menorValor() {
        if(this.vazia()) {
            return null;
        }
        NoArvoreBST<T> noMenor = (NoArvoreBST<T>) this.getRaiz();
        while(noMenor.getEsq() != null) {
            noMenor = (NoArvoreBST<T>) noMenor.getEsq();
        }
        return noMenor;
    }

    public NoArvoreBST<T> maiorValor() {
        NoArvoreBST noMaior = (NoArvoreBST<T>) this.getRaiz();
        while(noMaior.getDir() != null) {
            noMaior = (NoArvoreBST<T>) noMaior.getDir();
        }
        return noMaior;
    }

    public NoArvoreBST<T> getAntecessor(T info) {
        NoArvoreBST<T> no = this.buscar(info);
        if(no == null || info.equals(this.menorValor())) {
            return null;
        }
        if(no.getEsq() != null) {
            return this.buscarAntecessor(no);
        } else {
            NoArvoreBST<T> NoPai = this.buscarPai(no);
            while(NoPai.getEsq() == no) {
                no = NoPai;
                NoPai = this.buscarPai(no);
            }
            return NoPai;
        }
    }

    private NoArvoreBST<T> buscarAntecessor(NoArvoreBST<T> no) {
        NoArvoreBST<T> noAntecessor = (NoArvoreBST) no.getEsq();
        while (noAntecessor.getEsq() != null) {
            noAntecessor = (NoArvoreBST<T>) noAntecessor.getDir();
        }
        return noAntecessor;
    }


/*
    public NoArvoreBST<T> buscarAntecessor(NoArvoreBST<T> no) {
        // caso sem esquerda e à direita do pai
        if(no.getEsq() == null && this.buscarPai(no).getDir() == no) {
            return this.buscarPai(no);
        }
        //caso sem esquerda e à esquerda do pai
        if(no.getEsq() == null && this.buscarPai(no).getEsq() == no) {
            NoArvoreBST<T> noAntecessor = this.buscarPai(no);
            if(this.buscarPai(noAntecessor).getEsq() == noAntecessor) {
                return noAntecessor;
            } else {
                if(this.buscarPai(noAntecessor).getDir() == noAntecessor) {
                    return this.buscarPai(noAntecessor);
                }
            }
        }
        //caso com filhos à esquerda
        NoArvoreBST<T> noAntecessor = (NoArvoreBST<T>) no.getEsq();
        while(noAntecessor.getDir() != null) {
            noAntecessor = (NoArvoreBST<T>) noAntecessor.getDir();
        }
        return noAntecessor;
    }
    */

}

