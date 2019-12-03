package prac.ManejadorArchivos;

import java.io.*;
import java.util.LinkedList;

public class LEArchivos {
    public static void EscribirArchivo(LinkedList<String> S, File d) {
        try {
            //Para escribir un Archivo con una lista se crea una string
            //que será escrita al Archivo temporal
            RandomAccessFile r = new RandomAccessFile(d, "rw");//Se abre el Archivo como  escritura
            StringBuilder sb = new StringBuilder();
            for (String i : S) {
                sb.append(i);
            }//Por cada linea de la lista se añade al string a escribir
            String s = sb.toString();
            r.setLength(s.length());//Se consigue la longitud para que no se corte
            r.write(s.getBytes());//Hay que escribir en bytes
            r.close();//se cierrra el Archivo
        } catch (IOException e) {
            System.out.print("Un error ocurrió al acceder al archivo");
        }
    }

    public static LinkedList<String> LeerArchivo(File d) {

        try {
            String ruta = d.getAbsolutePath();
            FileReader fr = null;
            fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            LinkedList lista = new LinkedList();
            String linea;
            while (((linea = br.readLine()) != null)) {
                lista.add(linea);
            }
            br.close();
            return lista;
        } catch (IOException e) {
            System.out.print("Un error ocurrió al acceder al archivo");
            return null;
        }
    }
}
