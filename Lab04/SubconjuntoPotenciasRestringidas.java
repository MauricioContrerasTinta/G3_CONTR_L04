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
    
    public static boolean verificar(int[] entrada) {
        int n = entrada[0];


        int[] nums = Arrays.copyOfRange(entrada, 1, 1 + n);
        
        int objetivo = entrada[1 + n];

        Set<Integer> obligatorios = new HashSet<>();
        Set<Integer> excluidos = new HashSet<>();


        for (int i = 0; i < nums.length; i++) {
            if (esPotenciaDeDos(nums[i])) {
                obligatorios.add(i);
            }
            if (nums[i] % 5 == 0 && i + 1 < nums.length && nums[i + 1] % 2 == 1) {
                excluidos.add(i);
            }
         }   

        int sumaObligatorios = 0;
        for (int idx : obligatorios) {
        if (excluidos.contains(idx)) return false; // Conflicto: obligatorio pero excluido
            sumaObligatorios += nums[idx];
    }

    int nuevoObjetivo = objetivo - sumaObligatorios;
    if (nuevoObjetivo < 0) return false;

    Map<String, Boolean> memo = new HashMap<>();
    return puedeAlcanzarObjetivo(nums, 0, nuevoObjetivo, obligatorios, excluidos, memo);

    }

    public static void main(String[] args) {
        int[][] entradas = {
            {5, 2, 4, 8, 10, 3, 14},  //true
            {5, 4, 8, 10, 3, 5, 27},    //false
            {5, 4, 8, 10, 3, 6, 27},   //false
            {5, 2, 16, 5, 7, 10, 33},   //false
            {5, 2, 16, 5, 3, 10, 33},   //false
            {4, 2, 5, 1, 6, 13}        //false
        };

        for (int[] entrada : entradas) {
            System.out.println(verificar(entrada));
        }
    }
}
