package prac.ManejadorArchivos;

import java.io.*;
import java.util.LinkedList;

public class Archivo {
    private File f; //La clase Archivo tendrá un Archivo temporal como atributo

    public Archivo() throws IOException { //El builder unicamente crea el Archivo html temporal
        f = File.createTempFile("NombreArchivoTemporalAunqueEsteSirve", ".html");
    }

    public File getF() {
        return f;
    }

    public void Guardar(String ruta) throws IOException {
        //Para guardar el Archivo lo único que haremos será mover el Archivo temporal
        //de la carpeta tmp a la ruta indicada, esto lo haremos con el método renameTo
        File d = new File(ruta);//Se crea otro Archivo en el directorio indicado
        LEArchivos.EscribirArchivo(LEArchivos.LeerArchivo(f), d);
        f.renameTo(new File("ruta" + ".html"));

    }

    public void Cargar(String ruta) {
        //Para cargar un Archivo a nuestro tmp lo que haremos será linea a linea leerlo
        //y pasar lo leido a una lista que escribiremos en el tmp con el primer método

        LinkedList<String> lista = LEArchivos.LeerArchivo(new File(ruta));//Se lee el Archivo indicado
        LEArchivos.EscribirArchivo(lista, this.f);//Se escriben las lineas leidas en el Archivo indicado


    }

}

