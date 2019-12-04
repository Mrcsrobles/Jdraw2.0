package prac;

import prac.Dibujo.Dibujo;
import prac.Plantillas.Dibujante;
import prac.Style.Estilos;
import prac.ManejadorArchivos.Archivo;

public interface Baliza {

    public boolean Este(String comando);
    /*Se leen los comandos que corresponden a esa clase, que están contenidos en
    una lista, y si el comando introducido está entre ellos devuelve True
    */
    public void Llamar(Dibujo d, Estilos es, Archivo arch, Dibujante dibujante, String comando, String args);
    /*Este comando procesa la orden de manera más reducida y actua de manera propia para cada método*/
}
