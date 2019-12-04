package prac.Plantillas;

public class Line implements Plantilla {

    public Line() {
    }

    @Override
    public boolean Es(String comando) {
        return comando.startsWith("line");
    }

    @Override
    public String dibujo(String comando, String estilo) {
        String[] partes = comando.split(" ");
        String[] args = partes[1].split(",");
        String resultado = "<line x1=\"" + args[0] + "\" y1=\"" + args[1] + "\" x2=\"" + args[2] + "\" y2=\"" + args[3] + "\"" + estilo + "/>";
        return resultado;

    }

}