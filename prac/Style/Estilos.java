package prac.Style;

public class Estilos {
    //Hay una variable por cada atributo relacionado al estilo, cada uno contiene SOLO EL VALOR, NO EL FORMATO
    private String pencolor;
    private String fillcolor;
    private String width;
    private String strokeOpacity;
    private String fillOpacity;

    public Estilos() {
        //Para inicializar la clase se ponen los atributos al valor indicado como base
        this.pencolor = "0,0,0";
        this.fillcolor = "0,0,0";
        this.width = "1";
        this.fillOpacity = "0";
        this.strokeOpacity = "1";
    }


    public void setPencolor(String Pencolor) {
        //Para el comando setPencolor se pasan 4 valores que hay que almacenar
        String[] datos = Pencolor.split(",");
        //Primero se divide en los componentes separados por comas
        this.pencolor = datos[1] + "," + datos[2] + "," + datos[3]; //Se almacena el color
        this.strokeOpacity = datos[0];//Se almacena la opacidad
    }

    public void setFillcolor(String Fillcolor) {
        //Para el comando SetFillcolor se pasan 4 valores que hay que almacenar
        String[] datos = Fillcolor.split(",");
        //Primero se divide en los componentes separados por comas
        this.fillcolor = datos[1] + "," + datos[2] + "," + datos[3];//Se almacena el color
        this.fillOpacity = datos[0];//Se almacena la opacidad
    }

    public void setWidth(String Width) {
        this.width = Width;
    }//Para cambiar la anchura solamente hay que cambiar un valor

    public String sacarEstilo() {
        //Se devolverá el estilo del dibujo como un string SIN CIERRE, dando formato a cada valor de estilo
        String fillColor = "fill:rgb(" + this.fillcolor + ")";
        String stroke = "stroke:rgb(" + this.pencolor + ")";
        String ancho = "stroke-width:" + this.width;
        String strokeOpaciy = "stroke-opacity:" + this.strokeOpacity;
        String FillOpacity = "fill-opacity:" + this.fillOpacity;
        String datos = "style=\"" + fillColor + ";" + stroke + ";" + FillOpacity + ";" + ancho + ";" + strokeOpaciy + "\" ";
        return datos;
    }

    public void Reset(){
        this.pencolor = "0,0,0";
        this.fillcolor = "0,0,0";
        this.width = "1";
        this.fillOpacity = "0";
        this.strokeOpacity = "1";
    }
}
