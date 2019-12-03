package prac;

import prac.ManejadorArchivos.Archivo;
import prac.ManejadorArchivos.LEArchivos;

import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;

public class Dibujo {
    private LinkedList<String> texto;
    //El dibujo en sí es una sucesión de lineas
    //Hasta la 7 son etiquetas de formato
    //Las 3 úlimas son etiquetas de cierre
    public Dibujo(Archivo Arch) throws IOException {
        clear(Arch);
        Desktop.getDesktop().browse(Arch.getF().toURI());
    }

    public void AddDib(String dato, Archivo Arch) throws IOException {
        //cada vez que se añada un dibujo habrá que pasar todo el string para que se escriba con los cambios
        texto.add(7,dato+"\n");
        LEArchivos.EscribirArchivo(texto, Arch.getF());

    }
    public void undo(Archivo Arch) throws IOException {
        //Siempre que se haga undo el número de elementos debe ser mayor que 10 para garantizar que hay mínimo un elemento svg
        if (texto.size() > 10) {
            texto.remove(7);
            LEArchivos.EscribirArchivo(texto, Arch.getF());//Hay que realizar los cambios en el Archivo
        }

    }


    public void clear(Archivo Arch) throws IOException {
        //El método clear lo que hace es borrar todos los svg y restablecer las etiquetas básicas
        texto = new LinkedList<>();
        texto.add("<html>\n");
        texto.add("<head>\n");
        texto.add("<meta charset=\"UTF-8\"/>\n");
        texto.add("<meta http-equiv=\"refresh\" content=\"2\"/>\n");
        texto.add("</head>\n");
        texto.add("<body>\n");
        texto.add("<svg width=\"1024\" height=\"1024\">\n");
        //Aqui van los dibujos
        texto.add("</svg>\n");
        texto.add("</body>\n");
        texto.add("</html>");
        LEArchivos.EscribirArchivo(texto, Arch.getF());//Hay que realizar los cambios en el Archivo
    }
}
