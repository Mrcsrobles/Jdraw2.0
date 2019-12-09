package prac;

import java.io.Serializable;
import java.util.LinkedList;

public class Ordenes implements Serializable {
    //En esta clase unicamente se almacenan las ordenes que se van ejecutando y permite manipularlas
    private LinkedList<String> ordenes;

    public Ordenes() {
        ordenes= new LinkedList<>();
    }

    public void AddOrden(String orden){
        ordenes.add(orden);
    }

    public LinkedList<String> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(LinkedList<String> ordenes) {
        this.ordenes = ordenes;
    }

    public void RemoveOrden(){
        ordenes.removeLast();
    }
}
