package Estructuras.Main;

import Estructura.Grafo;
import Estructura.Lista;

public class Main {

    public static void main(String[] args) {
        Lista l;
        Grafo g = new Grafo();
        
        g.insertarVertice(1);//A
        g.insertarVertice(2);//B
        g.insertarVertice(3);//C
        g.insertarVertice(4);//D
        g.insertarVertice(5);//E
        g.insertarVertice(6);//F
        g.insertarVertice(7);//G
        g.insertarVertice(8);//H
        
        g.insertarArco(1, 2);
        g.insertarArco(2, 4);
        g.insertarArco(4, 7);
        g.insertarArco(7, 5);
        g.insertarArco(2, 6);
        g.insertarArco(3, 7);
        g.insertarArco(3, 8);
        g.insertarArco(3, 1);
        g.insertarArco(3, 6);
        
        l = g.listarProfundidad();
        System.out.println(l.toString());
        l = g.listarAnchura();
        System.out.println("");
        System.out.println(l.toString());
        System.out.println(g.existeCamino(1,5));
    }
}