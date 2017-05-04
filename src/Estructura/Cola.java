package Estructura;

import Nodo.NodoLista;

public class Cola {

    private NodoLista frente, fin;

    public Cola() {
        frente = fin = null;
    }

    public boolean poner(int elem) {
        boolean sePuso = false;
        if (!esVacia()) {
            NodoLista nuevo = new NodoLista(elem);
            fin.setEnlace(nuevo);
            fin = nuevo;
            sePuso = true;
        } else {
            frente = new NodoLista(elem, fin);
            fin = frente;
        }
        return sePuso;
    }

    public int sacar() {
        int elem = -1;
        if (!esVacia()) {
            elem = frente.getElem();
            frente = frente.getEnlace();
            if(frente == null) {
                fin = null;
            }
        }
        return elem;
    }

    public int getFrente() {
        return (frente == null) ? -1 : frente.getElem();
    }

    public boolean esVacia() {
        return frente == null;
    }

    public void vaciar() {
        frente = fin = null;
    }

    public Cola clonar() {
        return null;
    }

    @Override
    public String toString() {
        String cad = "";
        if (!esVacia()) {
            NodoLista aux = frente;
            while (aux != null) {
                cad = cad + aux.getElem() + ",";
                aux = aux.getEnlace();
            }
        } else {
            cad = "Vacia!";
        }

        return cad;
    }
}