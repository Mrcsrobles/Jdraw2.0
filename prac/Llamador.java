package prac;

import prac.Dibujo.BDibujo;
import prac.Dibujo.Dibujo;
import prac.ManejadorArchivos.Archivo;
import prac.ManejadorArchivos.BArchivo;
import prac.Plantillas.BDibujante;
import prac.Plantillas.Dibujante;
import prac.Plantillas.ReconstructorComando;
import prac.Style.BEstilos;
import prac.Style.Estilos;

import java.util.LinkedList;
import java.util.Scanner;

/*Cuando se crea este objeto se crean primero los objetos necesarios del programa y sus balizas, que permiten llamarlos
y además, se leen los comandos introducidos y se procesan pasandolos por las balizas
 */


class Llamador {
    private Dibujo dibujo;
    private Estilos estilos;
    private Archivo archivo;
    private Dibujante dibujante;
    private Ordenes ordenes;
    private LinkedList<Baliza> listaBalizas;
    //se crean todos los objetos que van a ser necesarios, y que van a tener una baliza

    public Llamador() {
        archivo = new Archivo();
        dibujo = new Dibujo(archivo);
        estilos = new Estilos();
        dibujante = new Dibujante();
        ordenes = new Ordenes();
        //Primero se crean los objetos con los que se va a trabajar
        listaBalizas = new LinkedList<>();
        listaBalizas.add(new BArchivo());
        listaBalizas.add(new BDibujante());
        listaBalizas.add(new BDibujo());
        listaBalizas.add(new BEstilos());
        //Después se crean las balizas que llamarán a cierto método en base al comando introducido
        Ciclo();
        //Finalmente se itera de manera indefinida leyendo comandos
    }

    private void Ciclo() {
        /*El ciclo va a ser unicamente una iteración que se va a repetir hasta que se introduzca el comando de salida


         */
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("Buenas");

        System.out.print(">>");
        input = sc.nextLine();

        while (!input.equals("exit")) {
            Procesador(input);

            System.out.print(">>");
            input = sc.nextLine();
        }
    }

    public void Procesador(String input) {
        /*El comando introducido será leido por este método que lo dividirá en sus componentes, la orden y los
        argumentos
         */
        String[] division = input.split(" +");
        String args = ReconstructorComando.Reconstruir(division, 1);//A partir del espacio son los argumentos, que puede tener espacios
        String orden = division[0];
        //En este bucle por cada baliza que haya se mira si el comando pertenece a esa clase y si pertenece se pasan
        //todos los objetos, la orden y los argumentos
        for (Baliza i : listaBalizas) {
            if (i.Este(orden)) {
                i.Llamar(dibujo, estilos, archivo, dibujante, ordenes, orden, args);
                break;
            }
        }
        if (input.startsWith("load")) {
            Recargar(ordenes);
        }

    }

    private void Recargar(Ordenes ordenes) {

        LinkedList<String> lista = (LinkedList<String>) ordenes.getOrdenes().clone();

        for (String i : lista) {
            Procesador(i);
            ordenes.RemoveOrden();
        }
    }
}

