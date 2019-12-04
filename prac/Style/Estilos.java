package prac.Style;

public class Estilos {
    //Hay una variable por cada atributo relacionado al estilo, cada uno contiene SOLO EL VALOR, NO EL FORMATO
    private String Pencolor;
    private String Fillcolor;
    private String Width;
    private String strokeOpacity;
    private String FillOpacity;

    public Estilos() {
        //Para inicializar la clase se ponen los atributos al valor indicado como base
        this.Pencolor = "0,0,0";
        this.Fillcolor = "0,0,0";
        this.Width = "1";
        this.FillOpacity = "0";
        this.strokeOpacity = "1";
    }


    public void setPencolor(String Pencolor) {
        //Para el comando setPencolor se pasan 4 valores que hay que almacenar
        String[] datos = Pencolor.split(",");
        //Primero se divide en los componentes separados por comas
        this.Pencolor = datos[1] + "," + datos[2] + "," + datos[3]; //Se almacena el color
        this.strokeOpacity = datos[0];//Se almacena la opacidad
    }

    public void setFillcolor(String Fillcolor) {
        //Para el comando SetFillcolor se pasan 4 valores que hay que almacenar
        String[] datos = Fillcolor.split(",");
        //Primero se divide en los componentes separados por comas
        this.Fillcolor = datos[1] + "," + datos[2] + "," + datos[3];//Se almacena el color
        this.FillOpacity = datos[0];//Se almacena la opacidad
    }

    public void setWidth(String Width) {
        this.Width = Width;
    }//Para cambiar la anchura solamente hay que cambiar un valor

    public String sacarEstilo() {
        //Se devolverá el estilo del dibujo como un string SIN CIERRE, dando formato a cada valor de estilo
        String fillColor = "fill:rgb(" + this.Fillcolor + ")";
        String stroke = "stroke:rgb(" + this.Pencolor + ")";
        String ancho = "stroke-width:" + this.Width;
        String strokeOpaciy = "stroke-opacity:" + this.strokeOpacity;
        String FillOpacity = "fill-opacity:" + this.FillOpacity;
        String datos = "style=\"" + fillColor + ";" + stroke + ";" + FillOpacity + ";" + ancho + ";" + strokeOpaciy + "\" ";
        return datos;
    }
}
