package prac.Plantillas;

import prac.Baliza;
import prac.Dibujo.Dibujo;
import prac.ManejadorArchivos.Archivo;
import prac.Style.Estilos;

import java.util.LinkedList;

public class BDibujante implements Baliza {

    LinkedList<String> comandos;

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
    public void Llamar(Dibujo d, Estilos es, Archivo arch, Dibujante dibujante, String comando, String args) {
            String[] orden = {comando,args};
            String dibujo = dibujante.dibujar(comando +" " +args, es);//se tiene que pasar el comando original
            d.AddDib(dibujo,arch);
            //Aquí hay que añadir el comando en la clase Dibujante
    }
}
