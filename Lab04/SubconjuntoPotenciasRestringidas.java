package Lab04;

import java.util.*; 

public class SubconjuntoPotenciasRestringidas {

    public static boolean esPotenciaDeDos(int n) {  // Función para verificar si un número es una potencia de 2
        return n > 0 && (n & (n - 1)) == 0; 
    }


}
