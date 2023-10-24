import java.util.Scanner;

public class Reto2_Boletos {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Inicializamos Variables
        double precio = 0;
        double total = 0;
        String menu = " ";
        
        //Para que siga preguntando si quiere boletos
        while(!menu.equals("n")) {

            //Pedimos tipo de boleto
            System.out.print("Tipo de Boleto? ");
            String boleto = scanner.nextLine();
            
            //Verificamps que indique un boleto aceptable.
            if (boleto.length() >= 2 ||  
            !boleto.equals("A") && 
            !boleto.equals("N") && 
            !boleto.equals("I") && 
            !boleto.equals("B")) {
                System.out.println("Escoge un boleto valido");
            } 
            else {    
                //Asignamos precio al boleto.     
                if (boleto.equals("A")) {
                        precio = 100;                
                }
                else if (boleto.equals("N")) {
                        precio = 70;
                }
                else if (boleto.equals("I")) {
                        precio = 50;
                }
                else if (boleto.equals("B")) {
                        precio = 70;
                }   
                System.out.println("El boleto cuesta $" + precio);   
                System.out.println(); 
            }
            //Sacamos total de los boletos.
            total += precio;

            //Preguntamos si quiere otro boleto.
            System.out.print("Otro boleto (s / n)? ");
            menu = scanner.nextLine();
        }
        //Fin del Programa y le decimos el total.
        System.out.println("Tu total es: " + total);
        System.out.println("Fin del Programa");

        scanner.close();
    }
}
