package Nodo;

public class NodoAdy {
    private NodoVert vertice;
    private NodoAdy sigAdyacente;

    public NodoAdy(NodoVert vertice, NodoAdy sigAdyacente) {
        this.vertice = vertice;
        this.sigAdyacente = sigAdyacente;
    }

    public NodoVert getVertice() {
        return vertice;
    }

    public void setVertice(NodoVert vertice) {
        this.vertice = vertice;
    }

    public NodoAdy getSigAdyacente() {
        return sigAdyacente;
    }

    public void setSigAdyacente(NodoAdy sigAdyacente) {
        this.sigAdyacente = sigAdyacente;
    }
}
