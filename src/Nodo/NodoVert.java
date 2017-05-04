package Nodo;

public class NodoVert {
    private int elem;
    private NodoVert sigVertice;
    private NodoAdy primerAdy;

    public NodoVert(int elem) {
        this.elem = elem;
        this.sigVertice = null;
        this.primerAdy = null;
    }

    public NodoVert(int elem, NodoVert sigVertice) {
        this.elem = elem;
        this.sigVertice = sigVertice;
        this.primerAdy = null;
    }
    

    public int getElem() {
        return elem;
    }

    public void setElem(int elem) {
        this.elem = elem;
    }

    public NodoVert getSigVertice() {
        return sigVertice;
    }

    public void setSigVertice(NodoVert sigVertice) {
        this.sigVertice = sigVertice;
    }

    public NodoAdy getPrimerAdy() {
        return primerAdy;
    }

    public void setPrimerAdy(NodoAdy primerAdy) {
        this.primerAdy = primerAdy;
    }
    
}