package prac;

import prac.Dibujo.BDibujo;
import prac.Dibujo.Dibujo;
import prac.ManejadorArchivos.Archivo;
import prac.ManejadorArchivos.BArchivo;
import prac.Plantillas.BDibujante;
import prac.Plantillas.Dibujante;
import prac.Style.BEstilos;
import prac.Style.Estilos;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

class Llamador {
    //Esta clase llama a las otras comprobando cual se llama
    private Dibujo dibujo;
    private Estilos estilos;
    private Archivo archivo;
    private Dibujante dibujante;
    private LinkedList<Baliza> listaBalizas;
    //se crean todos los objetos que van a ser necesarios, y que van a tener una baliza

    public Llamador() throws IOException {
        archivo = new Archivo();
        dibujo = new Dibujo(archivo);
        estilos = new Estilos();
        dibujante = new Dibujante();
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
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.print("Buenas");

        System.out.print(">>");
        input = sc.nextLine();

        while (!input.equals("exit")) {
            Procesador(input);

            System.out.print(">>");
            input = sc.nextLine();
        }
    }

    private void Procesador(String input) {

        String args = input.split(" ")[1];//A partir del espacio est� la ruta, el segundo elemento
        String orden = input.split(" ")[0];

        for (Baliza i : listaBalizas) {
            if (i.Este(orden)) {
                i.Llamar(dibujo, estilos, archivo, dibujante, orden, args);
            }
        }
    }
}

