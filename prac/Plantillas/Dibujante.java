package prac.Plantillas;


import prac.Style.Estilos;

import java.util.LinkedList;

public class Dibujante {
    //El único atributo de Dibujante será una lista que almacena objetos del tipo dibujo que implementan Plantilla
    private LinkedList<Plantilla> lista;

    public Dibujante() {
        //El constructor añade a la lista de dibujos un objeto de cada tipo
        lista = new LinkedList<>();
        lista.add(new Line());
        lista.add(new Rect());
        lista.add(new Circle());
        lista.add(new Text());
        lista.add(new Ellipse());
    }

    public String dibujar(String orden, Estilos Estilo) {

        String estilo = Estilo.sacarEstilo();
        /*recorre todas las posibles plantillas y cuando encuentra la correcta
        la pinta usando el estilo indicado
         */
        for (prac.Plantillas.Plantilla Plantilla : lista) {
            if (Plantilla.Es(orden)) {//Se comprueba a qué dibujo pertenece
                return Plantilla.dibujo(orden, estilo);//Cuando termina de dibujarse se devuelve como un String el dibujo completo
            }
        }
        return null;//En caso de no existir devuelve nulo
    }
}
