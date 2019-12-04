package prac.Plantillas;

public class Text implements Plantilla {
    public Text() {
    }

    @Override
    public boolean Es(String comando) {
        return comando.startsWith("text");
    }

    @Override
    public String dibujo(String comando, String estilo) {
        String[] partes = comando.split(" ");
        String[] args = partes[1].split(",");
        String resultado = "<text x=\"" + args[0] + "\" y=\"" + args[1] + "\"" + estilo + ">" + args[2] + "</text>";
        return resultado;
    }
    //recuerda que el color de relleno inicial que se usa es el blanco,por lo que no se verá
}