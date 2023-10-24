public class Reto4 {
    public static void main(String[] args) {
        //Declaramos la tabla
        int[][] tabla = { {111, 483, 471, 427},
                          {192, 500, 355, 158},
                          {289, 470, 474, 160},
                          {415, 114, 161, 308} }; 

        //Imprimimos la tabla
        //Empezamos imprimiendo los trimestres
        System.out.print("          | Ene - Mar |");                            
        System.out.print(" Abr - Jun |");                      
        System.out.print(" Jul - Sep |");                                               
        System.out.println(" Oct - Dic |");                            
        
        //Imprimimos las filas de la tabla
        for (int i = 0; i < tabla.length; i++) {
            if (i == 0) {
                System.out.print("Chocolate |");    
            }
            if (i == 1) {
                System.out.print("Vainilla  |");            
            }            
            if (i == 2) {
                System.out.print("Fresa     |");            
            }            
            if (i == 3) {
                System.out.print("Oreo      |");            
            }
            
            //Imprimimos las columnas de la tabla
            for (int j = 0; j < tabla.length; j++) {                
                System.out.print("    " + tabla[i][j] + "    |");            
            }        
            System.out.println();
        }   
        
        System.out.println();

        //Calculamos el trimestre que más vende por sabor.
        for (int i = 0; i < tabla.length; i++) {
            //Asignamos valores
            int triMaximo = 0;
            int ventasMaximas = tabla[i][0];
            String sabor = " ";            
            String tri = " ";
                 
            //Hacemos el calculo para saber que trimestre vende más.
            for (int j = 0; j < tabla[i].length; j++) {
                if (tabla[i][j] > ventasMaximas) {
                    triMaximo = j;                    

                    ventasMaximas = tabla[i][j];
                }
            }

            //Dado que no usamos tantas columnas uso if para verificar.
            //Asignamos el valor para imprimir cada sabor.
            if (i == 0) {
                sabor = "Chocolate";
            }
            if (i == 1) {
                sabor = "Vainilla";
            }            
            if (i == 2) {
                sabor = "Fresa";
            }            
            if (i == 3) {
                sabor = "Oreo";
            }

            //Asignamos el valor para imprimir que trimestre es el que más vende.
            if (triMaximo == 0) {
                tri = "Ene - Mar";
            }
            if (triMaximo == 1) {
                tri = "Abr - Jun";
            }            
            if (triMaximo == 2) {
                tri = "Jul - Sep";
            }            
            if (triMaximo == 3) {
                tri = "Oct - Dic";
            }
            
            //Imprimimos los resultados.
            System.out.println("El sabor " + (sabor) + " se vende más en el trimestre " + (tri));
        }       

        System.out.println();

        //Asignamos valores para calcular el trimestre que más vende.
        String trimestre = " ";
        int triTotal = 0;
        
        //Calularemos que trimestre es el que más vende de todos.
        for(int i = 0; i < tabla.length; i++) {
            int triVentas = 0;    

            //Hacemos la suma del trimestre
            for(int j = 0; j < tabla.length; j++) {
                triVentas += tabla[j][i];
            }

            //Dado que no usamos tantas columnas uso if para verificar.
            //Comparamos con los otros trimestres
            if(triVentas > triTotal ) { 
                if (i == 0) {
                    trimestre = "Ene - Mar";
                }
                if (i == 1) {
                    trimestre = "Abr - Jun";
                }            
                if (i == 2) {
                    trimestre = "Jul - Sep";
                }            
                if (i == 3) {
                    trimestre = "Oct - Dic";
                }

                triTotal = triVentas;
            }
        }
        System.out.println("El trimestre que más vende es: " + trimestre);

    }
}
