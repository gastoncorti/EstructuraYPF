package Estructura;

import Nodo.Nodo;

public class Cola {

    private Nodo frente, fin;

    public Cola() {
        frente = fin = null;
    }

    public boolean poner(String elem) {
        boolean sePuso = false;
        if (!esVacia()) {
            Nodo nuevo = new Nodo(elem);
            fin.setEnlace(nuevo);
            fin = nuevo;
            sePuso = true;
        } else {
            frente = new Nodo(elem, fin);
            fin = frente;
        }
        return sePuso;
    }

    public String sacar() {
        String elem = "";
        if (!esVacia()) {
            elem = frente.getElem();
            frente = frente.getEnlace();
            if(frente == null) {
                fin = null;
            }
        }
        return elem;
    }

    public String getFrente() {
        return (frente == null) ? null : frente.getElem();
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
            Nodo aux = frente;
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