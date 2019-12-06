package prac.ManejadorArchivos;

import prac.Baliza;
import prac.Ordenes;
import prac.Plantillas.Dibujante;
import prac.Dibujo.Dibujo;
import prac.Style.Estilos;

import java.util.LinkedList;

public class BArchivo implements Baliza {
    private LinkedList<String> comandos;

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
    public void Llamar(Dibujo d, Estilos es, Archivo arch, Dibujante dibujante, Ordenes ordenes, String comando, String args) {
        switch (comando) {
            case ("save"):
                arch.Guardar(args,ordenes);
                break;
            case ("load"):
                arch.Cargar(args,ordenes,es);
                break;
            //Aquí iría la llamada del nuevo comando
        }
    }
}
