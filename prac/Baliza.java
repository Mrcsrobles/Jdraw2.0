package prac;

import prac.Dibujo.Dibujo;
import prac.ManejadorArchivos.Archivo;
import prac.Plantillas.Dibujante;
import prac.Style.Estilos;

public interface Baliza {

    boolean Este(String comando);

    /*Se leen los comandos que corresponden a esa clase, que están contenidos en
    una lista, y si el comando introducido está entre ellos devuelve True
    */
    void Llamar(Dibujo d, Estilos es, Archivo arch, Dibujante dibujante, String comando, String args);
    /*Este comando procesa la orden de manera más reducida y actua de manera propia para cada método*/
}
