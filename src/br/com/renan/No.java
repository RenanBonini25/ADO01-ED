package br.com.renan;

public class No {

    private Carros c;
    private No prox;

    public No(Carros car) {
        this.c = car;
        this.prox = null;
    }

    public Carros getC() {
        return c;
    }

    public void setC(Carros c) {
        this.c = c;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

}
