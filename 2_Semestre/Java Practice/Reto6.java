import java.util.Random;
import java.util.Scanner;

public class Reto6 {
    
    //Funcion para verficicar si el String es un numero.
    static public boolean isNumber(String c) {
        for (int i = 0; i < c.length(); i++) {
            if (Character.isDigit(c.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    //Funcion para el ahorcado
    static public void ahorcado(int dificultad) {   
        //Declaramos la variable scanner.
        //Lo dejamos abierto para que el menú se siga ciclando
        Scanner scanner = new Scanner(System.in);

        //Declaramos la variable random.
        Random random = new Random();
            
        //Asignamos la Dificultad
        //Declaramos y asignamos un valor al azar para que agarre 1 palabra del array.
        //Declaramos un StringBuilder para poder reemplazar e igualar con la palabra con más facilidad.

        int azar = 0;
        StringBuilder incognito = new StringBuilder(" ");

        if(dificultad == 1) {
            azar = random.nextInt(5);
            incognito = new StringBuilder("XXXX");
            System.out.println("> Dificultad Facil <");
        }

        if(dificultad == 2) {
            azar = random.nextInt(5) + 5;
            incognito = new StringBuilder("XXXXXXXX");
            System.out.println("> Dificultad Intermedio <");
        } 

        if(dificultad == 3) {
            azar = random.nextInt(5) + 10;
            incognito = new StringBuilder("XXXXXXXXXXXX");
            System.out.println("> Dificultad Avanzado <");
        }
        
        //Declaramos el arreglo con las palabras que pueden aparecer.
        String[] palabra = {"casa", "pato", "lago", "vino", "foca",
                          "mariposa", "estrella", "caminata", "pastilla", "conectar", 
                          "combustibles", "experiencias", "confidencial", "descabellado", "justificante"};

        //Declaramos nuestro caracter.
        String c = " ";

        //Loop para seguir jugando hasta que encontremos la palabra.
        while(true) {
            //Pedimos el caracter        
            System.out.print("Introduce la letra: ");
            c = scanner.nextLine();
            c = c.toLowerCase();

            //Hacemos un try catch para verificar que no acepte números.
            try {
                //Validamos si pone 0 para salir del bucle.
                if(c.equals("0")) {                
                    break;
                }
                //Arrojamos la excepcion en caso de que sea número.
                if (isNumber(c)) {
                    throw new NumberFormatException();
                }                

            } catch (NumberFormatException e) {                
                System.out.println("Debe ingresar solo caracteres, sin números.");
            }
                    
            //Declaramos booleano para decirle que siga intentadolo.
            boolean fallo = false;

            //Usamos un for para checar si la letra coincide con una de la palabra. 
            for(int i = 0; i < palabra[azar].length(); i++) {            
                if(palabra[azar].charAt(i) == c.charAt(0)) {
                    incognito.setCharAt(i, c.charAt(0));
                    fallo = true;
                }
            }            
                        
            //Validamos para decirle que siga intentandolo
            if(!fallo) {                    
                System.out.println("> Intentalo de nuevo! :(");                                       
            } 
            else {
                System.out.println("> " + incognito);
            }
            
            //Para poder ver mejor en la consola
            System.out.println();

            //Validamos si ya encontro la palabra.
            if(incognito.toString().equals(palabra[azar])) {
                System.out.println("> FELICIDADES! Has adivinado la palabra");                
                break;
            }
        }                  
    }

    static public void main(String[] args) {     
        //Declaramos scanner   
        Scanner scanner = new Scanner(System.in);        
        
        //Loop para imprimir el menu
        while(true) {
            //Imprimimos el menu
            System.out.println();
            System.out.println("Bienvenido al Ahorcado");
            System.out.println("1.- Facil (4 Letras)");
            System.out.println("2.- Intermedio (8 Letras)");
            System.out.println("3.- Avanzado (12 Letras)");
            System.out.println("0. Salir");
            System.out.print("> Opcion: ");

            //Pedimos la dificultad
            String ops = scanner.nextLine();
                        
            //Hacemos un try catch para verificar que no acepte letras.  
            try { 
                //Verificamos las opciones
                int op = Integer.parseInt(ops);

                if (op >= 1 && op <= 3) {
                    System.out.println();
                    ahorcado(op);
                }
                if (op == 0) {
                    System.out.println();
                    System.out.println("> Vuelva pronto!");
                    scanner.close();
                    System.exit(0);
                }

            } catch (NumberFormatException e) {
                System.out.println("Has ingresado una letra en lugar de un número. Intentalo de nuevo");
            }
        }        
    }
}