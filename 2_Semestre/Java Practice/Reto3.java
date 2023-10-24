import java.util.Scanner;

public class Reto3 {
    //Declaramos funcion para convertir a Binario
    public static String decimalABinario(int decimal) {
        return Integer.toBinaryString(decimal); 
    }

    //Declaramos funcion para convertir a Octal
    public static String decimalAOctal(int decimal) {
        return Integer.toOctalString(decimal);
    }

    //Declaramos funcion para convertir a Hexadecimal
    public static String decimalAHexa(int decimal) {
        return Integer.toHexString(decimal);     
    }

    //Declaramos funcion para convertir a Decimal
    public static int binarioADecimal(String binario) {
        return Integer.parseInt(binario, 2);
    }

    //Declaramos funcion para convertir a Decimal
    public static int octalADecimal(String octal) {
        return Integer.parseInt(octal, 8);
    }

    //Declaramos funcion para convertir a Decimal
    public static int hexaADecimal(String hexa) {
        return Integer.parseInt(hexa, 16);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Declaramos Variables        
        String menu = " ";
        String convertir = " ";

        //Menu 
        System.out.println("- Programa Conversiones -");
        System.out.println("1. Convertir de Decimal a Binario");
        System.out.println("2. Convertir de Decimal a Octal");
        System.out.println("3. Convertir de Decimal a Hexadecimal");
        System.out.println("4. Convertir de Binario a Decimal");
        System.out.println("5. Convertir de Octal a Decimal");
        System.out.println("6. Convertir de Hexadecimal a Decimal");

        //Loop por si quieren convertir otro número
        while(!menu.equals("n")) {  
            //Tipo de Conversión
            System.out.print("Tipo de Conversion? ");
            int op = scanner.nextInt();
            scanner.nextLine();
            
            //Perdimos el Numero
            System.out.print("Numero a convertir? ");
            convertir = scanner.nextLine();
            
            //Convertir de Decimal a Binario  
            if (op == 1) {                           
                System.out.println("El numero " + convertir + " en base Binario es: " + decimalABinario(Integer.parseInt(convertir)));
            }
            //Convertir de Decimal a Octal 
            if (op == 2) {                     
                System.out.println("El numero " + convertir + " en base Octal es: " + decimalAOctal(Integer.parseInt(convertir)));
            }
            //Convertir de Decimal a Hexadecimal   
            if (op == 3) {                                              
                System.out.println("El numero " + convertir + " en base Hexadecimal es: " + decimalAHexa(Integer.parseInt(convertir)));
            }
            //Convertir de Binario a Decimal   
            if (op == 4) {            
                System.out.println("El numero " + convertir + " en base Decimal es: " + binarioADecimal(convertir));                    
            }
            //Convertir de Octal a Decimal 
            if (op == 5) {        
                System.out.println("El numero " + convertir + " en base Decimal es: " + octalADecimal(convertir));
            }
            //Convertir de Hexadecimal a Decimal
            if (op == 6) { 
                System.out.println("El numero " + convertir + " en base Decimal es: " + hexaADecimal(convertir));
            }          
            System.out.print("Otra conversión (s / n)? ");
            menu = scanner.nextLine(); 
        }
        System.out.println("Fin del programa");

        scanner.close();
    }
}
