package Estructura;

import Nodo.NodoArbB;
import java.util.LinkedList;
import java.util.Queue;

public class ABB {

    private NodoArbB raiz;

    public ABB() {
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

    public boolean eliminar(int elem) {
        boolean seElimino = false;
        if (raiz != null) {
            seElimino = eliminarAux(raiz, null, elem);
        }
        return seElimino;
    }

    private boolean eliminarAux(NodoArbB raizActual, NodoArbB padre, int elem) {
        boolean seElimino = false;
        if (raizActual != null) {
            if (raizActual.getElem() != elem) {
                if (raizActual.getElem() > elem) { //por izq
                    seElimino = eliminarAux(raizActual.getIzq(), raizActual, elem);
                } else {// por der
                    seElimino = eliminarAux(raizActual.getDer(), raizActual, elem);
                }
            } else { //encontre el elemento a eliminar
                switch (casoEliminacion(raizActual)) {
                    case 1:
                        NodoArbB sustituto = new NodoArbB(buscarSustituto(raizActual));
                        sustituto.setIzq(raizActual.getIzq());
                        sustituto.setDer(raizActual.getDer());
                        if (eliminar(sustituto.getElem())) {
                            if (padre == null) { // quiere borrar raiz
                                raiz = sustituto;
                            } else {
                                if (padre.getElem() > elem) {
                                    padre.setIzq(sustituto);
                                } else {
                                    padre.setDer(sustituto);
                                }
                            }
                        }
                        break;
                    case 2:
                        if (padre.getElem() > elem) {
                            padre.setIzq(raizActual.getIzq());
                        } else {
                            padre.setDer(raizActual.getIzq());
                        }
                        break;
                    case 3:
                        //tiene hder
                        if (padre.getElem() > elem) {
                            padre.setIzq(raizActual.getDer());
                        } else {
                            padre.setIzq(raizActual.getDer());
                        }
                        break;
                    case 4:
                        if (padre.getElem() > elem) {
                            padre.setIzq(null);
                        } else {
                            padre.setDer(null);
                        }
                        break;
                }
                seElimino = true;
            }
        }

        return seElimino;
    }
    private int casoEliminacion(NodoArbB nodoEliminar) {
        int caso = -1;
        if (nodoEliminar != null) {
            if (nodoEliminar.getIzq() != null) {
                if (nodoEliminar.getDer() != null) {
                    caso = 1;
                } else {
                    caso = 2;
                }
            } else {
                if (nodoEliminar.getDer() != null) {
                    caso = 3;
                } else {
                    caso = 4;
                }
            }
        }
        return caso;
    }

    private int buscarSustituto(NodoArbB nodoEliminar) {
        int sustituto = nodoEliminar.getDer().getElem();
        NodoArbB nodoAux = nodoEliminar.getDer();
        while (nodoAux.getIzq() != null) {
            sustituto = nodoAux.getIzq().getElem();
            nodoAux = nodoAux.getIzq();
        }
        return sustituto;
    }

    public int padre(int elem) {
        int padre = 0;

        if (raiz != null) {
            if (raiz.getElem() != elem) {
                NodoArbB nodo = getPadre(raiz, elem);
                padre = (nodo != null) ? nodo.getElem() : 0;
            } else {
                padre = raiz.getElem();
            }
        }
        return padre;
    }

    private NodoArbB getPadre(NodoArbB raizActual, int elem) {
        NodoArbB padre = null;
        if (raizActual != null) {
            if (raizActual.getElem() > elem) {//busco por izq
                if (raizActual.getIzq().getElem() != elem) {
                    padre = getPadre(raizActual.getIzq(), elem);
                } else {
                    padre = raizActual;
                }
            } else { //busco por derecha
                if (raizActual.getDer().getElem() != elem) {
                    padre = getPadre(raizActual.getDer(), elem);
                } else {
                    padre = raizActual;
                }
            }
        }
        return padre;
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

    public int altura() {
        return alturaAux(raiz);
    }

    private int alturaAux(NodoArbB raizActual) {
        int altD = 0, altI = 0, alt;
        if (raizActual != null) {
            if (raizActual.getIzq() != null) {
                altI = 1 + alturaAux(raizActual.getIzq());
            }
            if (raizActual.getDer() != null) {
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
        if (raizActual != null) {
            clon.insertar(raizActual.getElem());
            if (raizActual.getIzq() != null) {
                clonarAux(raizActual.getIzq(), clon);
            }
            if (raizActual.getDer() != null) {
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

    public void listarNivel() {
        if (raiz != null) {
            listarNivelAux(raiz);
        } else {
            System.out.println("Sin Elem");
        }
    }

    private void listarNivelAux(NodoArbB raizActual) {
        Queue cola = new LinkedList();
        cola.add(raizActual);
        while (!cola.isEmpty()) {
            NodoArbB nodoAux = (NodoArbB) cola.poll();
            System.out.print(nodoAux.getElem());
            if (nodoAux.getIzq() != null) {
                cola.add(nodoAux.getIzq());
            }
            if (nodoAux.getDer() != null) {
                cola.add(nodoAux.getDer());
            }
        }
    }
}