package prac.Plantillas;

import prac.Baliza;
import prac.Dibujo.Dibujo;
import prac.ManejadorArchivos.Archivo;
import prac.Ordenes;
import prac.Style.Estilos;

import java.util.LinkedList;

public class BDibujante implements Baliza {

    private LinkedList<String> comandos;

    public BDibujante() {
        this.comandos = new LinkedList<>();
        comandos.add("line");
        comandos.add("circle");
        comandos.add("rect");
        comandos.add("text");
        comandos.add("ellipse");
        //Aquí se añadiría el inicio del nuevo comando
    }

    @Override
    public boolean Este(String comando) {
        return comandos.contains(comando);
    }

    @Override
    public void Llamar(Dibujo d, Estilos es, Archivo arch, Dibujante dibujante, Ordenes ordenes, String comando, String args) {
        ordenes.AddOrden(comando + " " + args);
        String dibujo = dibujante.Dibujar(comando + " " + args, es);//se tiene que pasar el comando original
        d.AddDib(dibujo, arch);
        //Aquí hay que añadir el comando en la clase Dibujante
    }
}
