package prac.Plantillas;

public interface Plantilla {
    boolean Es(String comando);
    //Si el comando introducido se corresponde con el nombre del dibujo devuelve True

    String dibujo(String comando, String estilo);
    /*Toma el comando COMPLETO(orden+argumentos) y el string de estilo y los une creando el dibujo,
    que se devuelve como un String
    */

}
