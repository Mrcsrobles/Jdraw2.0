package prac.Plantillas;

public class ReconstructorComando {
    //Para que se acepten espacios hay que recuperar lo separado
    public static String Reconstruir(String[] partes, int posInicial,String separador) {
        StringBuilder sb = new StringBuilder();
        for (int i = posInicial; i < partes.length; i++) {
            sb.append(partes[i]);
                if(i < partes.length-1){
                    sb.append(separador);
                }
        }
        String frase = sb.toString();
        return frase;
    }
}
