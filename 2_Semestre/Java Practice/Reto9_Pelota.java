public class Reto9_Pelota {
    public String color;
    private int rapidez = 10;
    private int poder;

    //Funcion para disminuir rapidez
    public void dismiminuirRapidez() {
        if(rapidez > 0) {
            rapidez--;
        }        
    }

    //Función para aumentar poder
    public void aumentarPoder() {
        poder++;
    }

    void setColor(String color) { this.color = color; }

    public static void main(String[] args) {
        Reto9_Pelota p1 = new Reto9_Pelota();
        Reto9_Pelota p2 = new Reto9_Pelota();
        Reto9_Pelota p3 = new Reto9_Pelota();

        //Aumentamos el Poder de Pelota 1
        for(int i = 0; i < 5; i++) {            
            p1.aumentarPoder();
        }

        //Mostramos el poder de pelota 1
        System.out.println("Pelota 1 poder: " + p1.poder);

        //Disminuimos la rapidez de la pelota 2
        p2.dismiminuirRapidez();

        System.out.println("Pelota 2 rapidez: " + p2.rapidez);

        //Asignamos color a la Pelota 3
        p3.setColor("Amarillo");

        System.out.println("Pelota 3 color: " + p3.color);
    }
}
