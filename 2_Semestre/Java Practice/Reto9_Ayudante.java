import java.util.Random;

public class Reto9_Ayudante {
    private int numeroOjos;
    private String colorPiel;
    private String altura;
    private int nivelCrear;
    private int nivelArreglar;
    private int nivelDestructivo;

    //Constructor para crear un ayudante
    public Reto9_Ayudante() {
        Random random = new Random();

        //Generamos características aleatorias
        numeroOjos = random.nextInt(2) + 1;
        colorPiel = (random.nextBoolean()) ? "amarilla" : "morada";
        altura = (random.nextBoolean()) ? "mediano" : "alto";
        nivelCrear = random.nextInt(5) + 1; 
        nivelArreglar = random.nextInt(5) + 1; 
        nivelDestructivo = random.nextInt(5) + 1; 
    }

    //Función para mostrar las información del ayudante para comprobar si se randomizaron los datos
    public void mostrarInfo() {
        System.out.println("Número de ojos: " + numeroOjos);
        System.out.println("Color de piel: " + colorPiel);
        System.out.println("Altura: " + altura);
        System.out.println("Nivel de creación: " + nivelCrear);
        System.out.println("Nivel de arreglo: " + nivelArreglar);
        System.out.println("Nivel destructivo: " + nivelDestructivo);
    }

    public static void main(String[] args) {
        // Crear cinco ayudantes con características aleatorias
        Reto9_Ayudante[] ayudantes = new Reto9_Ayudante[5];
        for (int i = 0; i < 5; i++) {
            ayudantes[i] = new Reto9_Ayudante();
        }

        //Mostrar información de los ayudante.
        for (int i = 0; i < 5; i++) {
            System.out.println("Ayudante " + (i + 1) + ":");
            ayudantes[i].mostrarInfo();
            System.out.println();
        }
    }
}
