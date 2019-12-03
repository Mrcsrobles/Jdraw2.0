package prac.Plantillas;

public class Rect implements Plantilla {

    public Rect() {
    }

    @Override
    public boolean Es(String comando) {
        return comando.startsWith("rect");
    }

    @Override
    public String dibujo(String comando,String estilo) {
        String[] partes = comando.split(" ");
        String[] args = partes[1].split(",");
        String resultado = "<rect x=\""+args[0]+"\" y=\"" +args[1]+ "\" width=\""+args[2]+"\" height=\"" + args[3] + "\"" +estilo;
        return resultado;
    }

}