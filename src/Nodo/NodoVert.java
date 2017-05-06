package Nodo;

public class NodoVert {
    private String elem;
    private NodoVert sigVertice;
    private NodoAdy primerAdy;

    public NodoVert(String elem) {
        this.elem = elem;
        this.sigVertice = null;
        this.primerAdy = null;
    }

    public NodoVert(String elem, NodoVert sigVertice) {
        this.elem = elem;
        this.sigVertice = sigVertice;
        this.primerAdy = null;
    }
    

    public String getElem() {
        return elem;
    }

    public void setElem(String elem) {
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