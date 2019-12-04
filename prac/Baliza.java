package prac;

import prac.Dibujo.Dibujo;
import prac.Plantillas.Dibujante;
import prac.Style.Estilos;
import prac.ManejadorArchivos.Archivo;

public interface Baliza {

    public boolean Este(String comando);

    public void Llamar(Dibujo d, Estilos es, Archivo arch, Dibujante dibujante, String comando, String args);
}
