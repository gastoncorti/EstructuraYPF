package Estructura;


import Nodo.NodoArbB;

public class ArbolBB {
    private NodoArbB raiz;
    
    public ArbolBB() {
        this.raiz = null;
    }
    

    public boolean insertar(int nuevo) {
        boolean esCorrecto;
        if (raiz != null) {
            esCorrecto = insertarAux(raiz, nuevo);
        } else {
            raiz = new NodoArbB(nuevo);
            esCorrecto = true;
        }
        return esCorrecto;
    }

    private boolean insertarAux(NodoArbB raizActual, int nuevo) {
        boolean esCorrecto = false;
        if (raizActual != null) {
            if (raizActual.getElem() > nuevo) {
                if (raizActual.getIzq() != null) {
                    esCorrecto = insertarAux(raizActual.getIzq(), nuevo);
                } else {
                    raizActual.setIzq(new NodoArbB(nuevo));
                    esCorrecto = true;
                }
            } else if (raizActual.getElem() < nuevo) {
                if (raizActual.getDer() != null) {
                    esCorrecto = insertarAux(raizActual.getDer(), nuevo);
                } else {
                    raizActual.setDer(new NodoArbB(nuevo));
                    esCorrecto = true;
                }
            }
        }
        return esCorrecto;
    }

    public boolean pertenece(int elem) {
        return perteneceAux(elem, raiz);
    }

    public boolean perteneceAux(int elem, NodoArbB raizActual) {
        boolean pertenece = false;
        if (raizActual != null) {
            if (raizActual.getElem() != elem) {
                if (raizActual.getElem() > elem) {
                    pertenece = perteneceAux(elem, raizActual.getIzq());
                } else {
                    pertenece = perteneceAux(elem, raizActual.getDer());
                }
            } else {
                pertenece = true;
            }
        }
        return pertenece;
    }

    public boolean esVacio() {
        return (raiz == null);
    }

    public int padre(int elem) {
        return padreAux(raiz, elem);
    }

    public int padreAux(NodoArbB raizActual, int elem) {
        int padre = 0;
        if ((raizActual != null)) {
            if (raizActual.getIzq() != null) {
                if (raizActual.getIzq().getElem() != elem) {
                    padre = padreAux(raizActual.getIzq(), elem);
                    if (padre == 0) {
                        padre = padreAux(raizActual.getDer(), elem);
                    } else {
                        padre = raizActual.getElem();
                    }
                } else {
                    padre = raizActual.getElem();
                }
            } else if (raizActual.getDer() != null) {
                if (raizActual.getDer().getElem() != elem) {
                    padre = padreAux(raizActual.getDer(), elem);
                    if (padre == 0) {
                        padre = padreAux(raizActual.getIzq(), elem);
                    } else {
                        padre = raizActual.getElem();
                    }
                }
            } else {
                padre = raizActual.getElem();
            }
        }
        return padre;
    }
    public int altura() {
        return alturaAux(raiz);
    }
    
    private int alturaAux(NodoArbB raizActual) {
        int altD=0,altI=0,alt;
        if(raizActual != null) {
            if(raizActual.getIzq() != null) {
                altI = 1 + alturaAux(raizActual.getIzq());
            }
            if(raizActual.getDer() != null) {
                altD = 1 + alturaAux(raizActual.getDer());
            } 
            alt = (altI >= altD) ? altI : altD;
        } else {
            alt = 0;
        }
        return alt;
    }

    public int nivel(int elem) {
        return 0;
    }

    public void vaciar() {
        raiz = null;
    }

    public ArbolBB clonar() {
        ArbolBB clon = new ArbolBB();
        clonarAux(raiz, clon);
        return clon;
    }
    
    private void clonarAux(NodoArbB raizActual, ArbolBB clon) {
        if(raizActual != null) {
            clon.insertar(raizActual.getElem());
            if(raizActual.getIzq() != null) {
                clonarAux(raizActual.getIzq(), clon);
            }
            if(raizActual.getDer() != null) {
                clonarAux(raizActual.getDer(), clon);
            }
        }
    }

    public void listar() {
        if (raiz != null) {
            listarAux(raiz);
        } else {
            System.out.println("Sin Elem");
        }
    }

    private void listarAux(NodoArbB nActual) {
        if (nActual != null) {
            listarAux(nActual.getIzq());
            System.out.print(nActual.getElem() + ",");
            listarAux(nActual.getDer());
        }
    }

    public String listarRangp() {
        return "";
    }

    public int minimo() {
        return 0;
    }

    public int maximo() {
        return 0;
    }
}
