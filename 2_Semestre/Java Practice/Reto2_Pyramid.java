import java.util.Scanner;

public class Reto2_Pyramid{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Pedimos tamaño.
        System.out.print("Tamaño de la piramide: ");   
        int size = scanner.nextInt();

        //Condicion para saber que el tamaño pase de 3.
        if(size >= 3) {
            for(int i = 0; i <= size - 1; i++) {
                //Imprimo el spacio vació
                for(int j = 0; j <= size - i; j++) { 
                    System.out.print(" ");
                }

                //Imprimo los asteristicos
                for(int k = 0; k <= i * 2; k++) {
                    System.out.print("*");
                }

                //Imprimo el salto de linea.
                System.out.println();
            }
        } 
        else {
            System.out.println("Tiene que ser igual o mayor a 3 de altura.");
        }
        scanner.close();
    }
}