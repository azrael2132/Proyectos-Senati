import java.util.ArrayList;
import java.util.List;

public class MatrizEspiral {
    public static List<Integer> recorrerEspiral(int[][] matriz) {
        List<Integer> resultado = new ArrayList<>();
        if (matriz == null || matriz.length == 0) {
            return resultado;
        }

        int filas = matriz.length;
        int columnas = matriz[0].length;
        int arriba = 0, abajo = filas - 1;
        int izquierda = 0, derecha = columnas - 1;

        while (arriba <= abajo && izquierda <= derecha) {
            for (int j = izquierda; j <= derecha; j++) {
                resultado.add(matriz[arriba][j]);
            }
            arriba++;
            for (int i = arriba; i <= abajo; i++) {
                resultado.add(matriz[i][derecha]);
            }
            derecha--;
            if (arriba <= abajo) {
                for (int j = derecha; j >= izquierda; j--) {
                    resultado.add(matriz[abajo][j]);
                }
                abajo--;
            }
            if (izquierda <= derecha) {
                for (int i = abajo; i >= arriba; i--) {
                    resultado.add(matriz[i][izquierda]);
                }
                izquierda++;
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        List<Integer> resultado = recorrerEspiral(matriz);
        System.out.println("Recorrido en espiral: " + resultado);
    }
}