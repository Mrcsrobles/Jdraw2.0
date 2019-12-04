package prac.Plantillas;

import prac.Plantillas.*;
import prac.Style.Estilos;

import java.util.LinkedList;

/**
 * @author marcos
 */
public class Dibujante {

    private LinkedList<Plantilla> lista;

    public Dibujante() {
        lista = new LinkedList<>();
        lista.add(new Line());
        lista.add(new Rect());
        lista.add(new Circle());
        lista.add(new Text());
        lista.add(new Ellipse());


    }

    public String dibujar(String orden, Estilos Estilo) {

        String estilo = Estilo.sacarEstilo();
        //recorre todas las posibles plantillas y cuando encuentra la correcta
        //la pinta usando el estilo indicado
        for (prac.Plantillas.Plantilla Plantilla : lista) {
            if (Plantilla.Es(orden)) {
                return Plantilla.dibujo(orden, estilo);
            }
        }
        return null;//En caso de no existir devuelve nulo
    }
}
