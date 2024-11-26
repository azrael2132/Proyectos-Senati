import java.util.Scanner;

public class RotacionMatriz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la dimensión de la matriz cuadrada: ");
        int n = scanner.nextInt();

        int[][] matriz = new int[n][n];
        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        System.out.println("La matriz ingresada es:");
        imprimirMatriz(matriz);

        int[][] matrizRotada = rotarMatriz90(matriz);

        System.out.println("La matriz rotada 90° en sentido horario es:");
        imprimirMatriz(matrizRotada);

        scanner.close();
    }

    public static int[][] rotarMatriz90(int[][] matriz) {
        int n = matriz.length;
        int[][] matrizRotada = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizRotada[j][n - 1 - i] = matriz[i][j];
            }
        }
        return matrizRotada;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }
}
