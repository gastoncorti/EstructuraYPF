package Estructura;

import Nodo.Nodo;

public class ListaStr {

    private Nodo cabecera;

    public ListaStr() {
        this.cabecera = null;
    }

    public boolean insertar(String elem) {
       boolean seInserto = false;
       Nodo aux = cabecera;
       while(aux.getEnlace() != null) {
           aux = aux.getEnlace();
       }
       aux.setEnlace(new Nodo(elem, null));
       return seInserto;
    }
    public boolean insertar(String elem, int pos) {
        boolean seInserto = false;
        if (pos >= 1 || pos <= this.longitud() + 1) {
            if (pos != 1) {
                Nodo aux = cabecera;
                int i = 1;
                while (i < pos - 1) {
                    i++;
                    aux = aux.getEnlace();
                }
                aux.setEnlace(new Nodo(elem, aux.getEnlace()));
                seInserto = true;
            } else {
                cabecera = new Nodo(elem, this.cabecera);
                seInserto = true;
            }
        }
        return seInserto;
    }

    public boolean eliminar(int pos) {
        boolean seElimino = false;
        if (pos >= 1 || pos <= this.longitud()) {
            if (pos != 1) {
                Nodo aux = cabecera;
                int i = 1;
                while (i < pos - 1) {
                    i++;
                    aux = aux.getEnlace();
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
                seElimino = true;
            } else {
                cabecera = cabecera.getEnlace();
                seElimino = true;
            }
        }
        return seElimino;
    }

    public String recuperar(int pos) {
        String elem = "";
        if(cabecera != null && (pos > 0 || pos <= this.longitud())) {
            if(pos == 1) {
                elem = cabecera.getElem();
            } else {
                Nodo aux = cabecera;
                int cont = 1;
                while(aux != null) {
                    if(cont != pos) {
                        aux = aux.getEnlace();
                        cont++;
                    } else {
                        elem = aux.getElem();
                        aux = null;
                    }
                }
            }
        }
        return elem;
    }

    public boolean pertenece(String elem) {
        boolean pertenece = false;
        Nodo aux = cabecera;
        while (aux != null && !pertenece) {
            if (!aux.getElem().equals(elem)) {
                aux = aux.getEnlace();
            } else {
                pertenece = true;
            }
        }
        return pertenece;
    }

    public void vaciar() {
        cabecera = null;
    }

    public boolean esVacia() {
        return cabecera == null;
    }

    public ListaStr clonar() {
        ListaStr clon = new ListaStr();

        return clon;
    }

    public int longitud() {
        Nodo aux = cabecera;
        int longitud = 0;

        if (!esVacia()) {
            longitud++;
            while (aux.getEnlace() != null) {
                longitud++;
                aux = aux.getEnlace();
            }
        }

        return longitud;
    }

    @Override
    public String toString() {
        String cad = "";
        if (!esVacia()) {
            Nodo aux = cabecera;
            for (int i = 1; i <= this.longitud(); i++) {
                cad = cad + aux.getElem() + ",";
                aux = aux.getEnlace();
            }
        } else {
            cad = "Vacia!";
        }

        return cad;
    }
}