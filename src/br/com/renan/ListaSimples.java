package br.com.renan;

public class ListaSimples {

    private No prim;
    private No ult;
    private int qtdNo;

    public ListaSimples() {
        this.prim = null;
        this.ult = null;
        this.qtdNo = 0;
    }

    public boolean isEmpty() {
        return (this.prim == null);
    }

    public void inserirPrimeiro(Carros c) {
        No novoNo = new No(c);
        if (this.isEmpty()) {
            this.ult = novoNo;
        }
        novoNo.setProx(this.prim);
        this.prim = novoNo;
        this.qtdNo++;
    }

    public void inserirUltimo(Carros c) {
        No novoNo = new No(c);
        if (this.isEmpty()) {
            this.prim = novoNo;
        } else {
            this.ult.setProx(novoNo);
        }
        this.ult = novoNo;
        this.qtdNo++;

    }

    public boolean removerTudo() {
        No atual = this.prim;
        if (this.isEmpty()) {
            return false;
        } else {
            while (atual != null) {
                atual = atual.getProx();
                this.prim = atual;
                this.prim = null;
            }
            if (atual == prim) {
                if (this.prim == this.ult) {
                    this.ult = null;
                }
            } else {
                if (atual == ult) {
                    this.ult = null;
                }
            }
        }
        return true;
    }

    public boolean removerNo(String modelo) {
        No atual = this.prim;
        No anterior = null;
        if (this.isEmpty()) {
            return false;
        } else {
            while (atual != null && (!atual.getC().getModelo().equals(modelo))) {
                anterior = atual;
                atual = atual.getProx();
            }
            if (atual == prim) {
                if (this.prim == this.ult) {
                    this.ult = null;
                }
                this.prim = this.prim.getProx();
            } else {
                if (atual == ult) {
                    this.ult = anterior;
                }
                anterior.setProx(atual.getProx());
            }
        }
        this.qtdNo--;
        return true;
    }

    public String pesquisarNo(String modelo) {
        String msg = "";
        No atual = this.prim;
        while (atual != null && (!atual.getC().getModelo().equals(modelo))) {
            atual = atual.getProx();
        }
        return msg = "Modelo: " + atual.getC().getModelo() + "\n"
                + "Marca: " + atual.getC().getMarca() + "\n"
                + "Ano: " + atual.getC().getAno();
    }

    public String imprimirLista() {
        String msg = "";
        if (this.isEmpty()) {
            msg = "Lista vazia!";
        } else {
            No atual = this.prim;
            while (atual != null) {
                msg += "-> " + atual.getC().getModelo() + "\n";
                atual = atual.getProx();
            }
        }
        return msg;
    }

    public No getPrim() {
        return prim;
    }

    public void setPrim(No prim) {
        this.prim = prim;
    }

    public No getUlt() {
        return ult;
    }

    public void setUlt(No ult) {
        this.ult = ult;
    }

    public int getQtdNo() {
        return qtdNo;
    }

    public void setQtdNo(int qtdNo) {
        this.qtdNo = qtdNo;
    }

}
