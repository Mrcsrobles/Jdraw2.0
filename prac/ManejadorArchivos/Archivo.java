package prac.ManejadorArchivos;
import prac.Ordenes;
import prac.Style.Estilos;

import java.io.*;


public class Archivo {
    private File f; //La clase Archivo tendrá un Archivo temporal como atributo

    public Archivo() { //El constructor unicamente crea el Archivo html temporal
        try {
            f = File.createTempFile("NombreArchivoTemporalAunqueEsteSirve", ".html");
        } catch (IOException e) {
            System.out.print("Ocurrió un error al crear el archivo temporal");
        }
    }

    public File GetF() {
        return f;
    }

    public void Guardar(String ruta, Ordenes ordenes)  {
        /*Para guardar el Archivo lo único que haremos será crear un nuevo fichero en la ruta
        y se escribe el objeto prac.Ordenes
         */
        try {
            File d = new File(ruta+".jd");//Se crea otro Archivo en el directorio indicado
            FileOutputStream f = new FileOutputStream(d);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(ordenes);
        }catch (IOException e){
            System.out.print("La ruta no es válida");
        }
    }

    public void Cargar(String ruta, Ordenes ordenes, Estilos es) {
        /*Para cargar un Archivo a nuestro tmp lo que haremos será copiar la lista de ordenes y ejecutarlas
        */
        try {
            File d = new File(ruta);//Se crea otro Archivo en el directorio indicado
            FileInputStream f = new FileInputStream(d);
            ObjectInputStream o = new ObjectInputStream(f);
            Ordenes Leidas = (Ordenes) o.readObject();
            ordenes.setOrdenes(Leidas.getOrdenes());
            es.Reset();//Para que el dibujo no se vea afectado por el estilo anterior hay que resetearlo
        }catch (IOException e){
            System.out.print("Un error ocurrió con el archivo");
        }catch (ClassNotFoundException e){
            System.out.print("Un error interno ocurrió");
        }
    }
}

