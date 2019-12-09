package prac.Plantillas;

public class Text implements Plantilla {
    public Text() {
    }

    @Override
    public boolean Es(String comando) {
        return comando.startsWith("text");
    }

    @Override
    public String Dibujo(String comando, String estilo) {
        String[] partes = comando.split(" +");

        String[] args = partes[1].split(",");

        //Para que se acepten espacios hay que recuperar lo separado
        String frase = ReconstructorComando.Reconstruir(partes, 2);//pos0=orden;pos1=args;pos2=primerComandoExtra

        String resultado = "<text x=\"" + args[0] + "\" y=\"" + args[1] + "\"" + estilo + ">" + args[2] + frase + "</text>";
        return resultado;
    }
    //recuerda que el color de relleno inicial que se usa es transparente,por lo que no se verá
}