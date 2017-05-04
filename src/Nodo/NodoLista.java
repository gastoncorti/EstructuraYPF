package Nodo;

public class NodoLista {

    private int elem;
    private NodoLista enlace;

    public NodoLista(int elem) {
        this.elem = elem;
        this.enlace = null;
    }

    public NodoLista(int elem, NodoLista enlace) {
        this.elem = elem;
        this.enlace = enlace;
    }

    public int getElem() {
        return elem;
    }

    public void setElem(int elem) {
        this.elem = elem;
    }

    public NodoLista getEnlace() {
        return enlace;
    }

    public void setEnlace(NodoLista enlace) {
        this.enlace = enlace;
    }
}