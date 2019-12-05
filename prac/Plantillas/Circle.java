package prac.Plantillas;

public class Circle implements Plantilla {

    public Circle() {
    }

    @Override
    public boolean Es(String comando) {
        return comando.startsWith("circle");
    }

    @Override
    public String Dibujo(String comando, String estilo) {
        String[] partes = comando.split(" ");
        String[] args = partes[2].split(",");
        return "<circle cx=\"" + args[0] + "\" cy=\"" + args[1] + "\" r=\"" + args[2] + "\"" + estilo + "/>";

    }
}
