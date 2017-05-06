package Nodo;

public class Nodo {

    private String elem;
    private Nodo enlace;

    public Nodo(String elem) {
        this.elem = elem;
        this.enlace = null;
    }

    public Nodo(String elem, Nodo enlace) {
        this.elem = elem;
        this.enlace = enlace;
    }

    public String getElem() {
        return elem;
    }

    public void setElem(String elem) {
        this.elem = elem;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
}