package prac.ManejadorArchivos;

import prac.Baliza;
import prac.Plantillas.Dibujante;
import prac.Dibujo.Dibujo;
import prac.Style.Estilos;

import java.util.LinkedList;

public class BArchivo implements Baliza {
    LinkedList<String> comandos;

    public BArchivo() {
        this.comandos = new LinkedList<>();
        comandos.add("load");
        comandos.add("save");
        //Aquí se añadiría el inicio del nuevo comando
    }

    @Override
    public boolean Este(String comando) {
        return comandos.contains(comando);
    }

    @Override
    public void Llamar(Dibujo d, Estilos es, Archivo arch, Dibujante dibujante, String comando,String args) {
        switch (comando) {
            case ("save"):
                arch.Guardar(args);
                break;
            case ("load"):
                arch.Cargar(args);
                break;
            //Aquí iría la llamada del nuevo comando
        }
    }
}
