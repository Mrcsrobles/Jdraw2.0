package prac;

import prac.ManejadorArchivos.Archivo;

import java.io.IOException;
import java.util.Scanner;

class Llamador {
    private Dibujo dib;
    private Estilos style;
    private Archivo arch;
    private Dibujante dibu;

    public Llamador() throws IOException {
        arch = new Archivo();
        dib = new Dibujo(arch);
        style = new Estilos();
        dibu = new Dibujante();
        Ciclo();
    }

    private void Ciclo() throws IOException {
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

    private void Procesador(String input) throws IOException {

        String args = input.split(" ")[1];//A partir del espacio est� la ruta, el segundo elemento
        String orden = input.split(" ")[0];

        switch (orden) {
            case ("save"):
                arch.Guardar(args);
                break;
            case ("load"):
                arch.Cargar(args);
                break;
            case ("clear"):
                dib.clear(arch);
                break;
            case ("undo"):
                dib.undo(arch);
                break;
            case ("pencolor"):
                style.setPencolor(args);
                break;
            case ("width"):
                style.setWidth(args);
                break;
            case ("fillcolor"):
                style.setFillcolor(args);
                break;
            default:
            String DibujoHecho = dibu.dibujar(input, style);
            dib.AddDib(DibujoHecho, arch);
        }
    }
}
