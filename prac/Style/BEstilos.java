package prac.Style;

import prac.Baliza;
import prac.Plantillas.Dibujante;
import prac.Dibujo.Dibujo;
import prac.ManejadorArchivos.Archivo;

import java.util.LinkedList;

public class BEstilos implements Baliza {

    LinkedList<String> comandos;

    public BEstilos() {
        this.comandos = new LinkedList<>();
        comandos.add("fillcolor");
        comandos.add("width");
        comandos.add("pencolor");
    }
    @Override
    public boolean Este(String comando) {
        return comandos.contains(comando);
    }

    @Override
    public void Llamar(Dibujo d, Estilos es, Archivo arch, Dibujante dibujante, String comando, String args) {
        switch (comando) {
            case ("pencolor"):
                es.setPencolor(args);
                break;
            case ("width"):
                es.setWidth(args);
                break;
            case ("fillcolor"):
                es.setFillcolor(args);
                break;
        }
    }
}
