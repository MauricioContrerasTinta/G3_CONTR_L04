package Lab04;

import java.util.*; 

public class SubconjuntoPotenciasRestringidas {

    public static boolean esPotenciaDeDos(int n) {  // Función para verificar si un número es una potencia de 2
        return n > 0 && (n & (n - 1)) == 0; 
    }
    // Función recursiva que evalúa si podemos alcanzar el objetivo con los elementos permitidos
    public static boolean puedeAlcanzarObjetivo(int[] nums, int index, int objetivo, Set<Integer> obligatorios, Set<Integer> excluidos, Map<String, Boolean> memo) {
        if (objetivo == 0) return true; // Caso base: si el objetivo llegó a cero, hemos logrado la suma deseada y retorna true
        if (index == nums.length) return false; // Si llegamos al final del arreglo sin alcanzar el objetivo, retornamos falso

        String key = index + "-" + objetivo;    // Creamos una clave única para memoización con el índice actual y el objetivo restante
        if (memo.containsKey(key)) return memo.get(key);    // Si ya evaluamos esta combinación antes, devolvemos el resultado almacenado

        int actual = nums[index];   // Tomamos el valor actual del arreglo

        // Si el índice está en la lista de excluidos, lo saltamos obligatoriamente
        if (excluidos.contains(index)) {
            return puedeAlcanzarObjetivo(nums, index + 1, objetivo, obligatorios, excluidos, memo);
        }
        
        // Si el índice es obligatorio, se debe incluir y continuar restando su valor al objetivo
        if (obligatorios.contains(index)) {
            return puedeAlcanzarObjetivo(nums, index + 1, objetivo, obligatorios, excluidos, memo);
        }

        // Caso general probamos dos caminos
        boolean sinIncluir = puedeAlcanzarObjetivo(nums, index + 1, objetivo, obligatorios, excluidos, memo);

        boolean incluir = false;
        if (actual <= objetivo) {
            incluir = puedeAlcanzarObjetivo(nums, index + 1, objetivo - actual, obligatorios, excluidos, memo);
        }

        // Guardamos el resultado en la tabla de memoización
        boolean resultado = sinIncluir || incluir;
        memo.put(key, resultado);
        return resultado;   // Retornamos si alguna de las dos opciones fue exitosa
    }
    
    
    }
}
