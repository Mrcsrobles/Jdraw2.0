package prac.Plantillas;

public class ReconstructorComando {
    //Para que se acepten espacios hay que recuperar lo separado
    public static String Reconstruir(String[] partes,int posInicial) {
        StringBuilder sb = new StringBuilder();
        for (int i = posInicial; i < partes.length; i++) {
            sb.append(" "+partes[i]);
        }
        String frase = sb.toString();
        return frase;
    }
}
