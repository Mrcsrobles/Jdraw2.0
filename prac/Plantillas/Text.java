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
        String argsS = ReconstructorComando.Reconstruir(partes,1," ");
        String[] argsA = argsS.split(",");
        String frase = ReconstructorComando.Reconstruir(argsA,2,",");//pos0=orden;pos1=args;pos2=primerComandoExtra
        //Para que se acepten espacios hay que recuperar lo separado


        String resultado = "<text x=\"" + argsA[0] + "\" y=\"" + argsA[1] + "\"" + estilo + ">" +  frase + "</text>";
        return resultado;
    }
    //recuerda que el color de relleno inicial que se usa es transparente,por lo que no se verá
}