package prac.Plantillas;

public class Ellipse implements Plantilla {

    public Ellipse() {
    }

    @Override
    public boolean Es(String comando) {
        return comando.startsWith("ellipse");
    }

    @Override
    public String dibujo(String comando, String estilo) {
        String[] partes = comando.split(" ");
        String[] args = partes[1].split(",");
        String resultado = "<ellipse cx=\"" + args[0] + "\" cy=\"" + args[1] + "\" rx=\"" + args[2] + "\" ry=\"" + args[3] + "\"" + estilo + "/>";
        return resultado;

    }

}