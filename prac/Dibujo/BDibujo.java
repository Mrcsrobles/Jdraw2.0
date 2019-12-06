package prac.Dibujo;

import prac.ManejadorArchivos.Archivo;
import prac.Baliza;
import prac.Ordenes;
import prac.Plantillas.Dibujante;
import prac.Style.Estilos;

import java.util.LinkedList;

public class BDibujo implements Baliza {
    private LinkedList<String> comandos;

    public BDibujo() {
        this.comandos = new LinkedList<>();
        comandos.add("clear");
        comandos.add("undo");
        //Aquí se añadiría el inicio del nuevo comando
    }

    @Override
    public boolean Este(String comando) {
        return comandos.contains(comando);
    }

    @Override
    public void Llamar(Dibujo d, Estilos es, Archivo arch, Dibujante dibujante, Ordenes ordenes, String comando, String args) {
        switch (comando) {
            case ("clear"):
                d.clear(arch,ordenes);
                //Aquí no se almacena la orden
                break;
            case ("undo"):
                d.Undo(arch,ordenes);
                //Aquí no se almacena la orden
                break;
            //Aquí iría la llamada del nuevo comando
        }
    }
}
