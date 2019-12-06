package prac.Style;

import prac.Baliza;
import prac.Dibujo.Dibujo;
import prac.ManejadorArchivos.Archivo;
import prac.Ordenes;
import prac.Plantillas.Dibujante;

import java.util.LinkedList;

public class BEstilos implements Baliza {

    private LinkedList<String> comandos;

    public BEstilos() {
        this.comandos = new LinkedList<>();
        comandos.add("fillcolor");
        comandos.add("width");
        comandos.add("pencolor");
        //Aquí se añadiría el inicio del nuevo comando
    }

    @Override
    public boolean Este(String comando) {
        return comandos.contains(comando);
    }

    @Override
    public void Llamar(Dibujo d, Estilos es, Archivo arch, Dibujante dibujante, Ordenes ordenes, String comando, String args) {
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
            //Aquí iría la llamada del nuevo comando


        }
        d.AddDib("<!--CambioDeEstilo-->",arch);
        ordenes.AddOrden(comando + " " + args);
    }
}
