import java.util.Scanner;

public class MatrizTranspuesta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de filas de la matriz: ");
        int m = scanner.nextInt();

        System.out.print("Ingrese el número de columnas de la matriz: ");
        int n = scanner.nextInt();

        int[][] matriz = new int[m][n];
        int[][] transpuesta = new int[n][m];

        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nMatriz original:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }

        System.out.println("\nMatriz transpuesta:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(transpuesta[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
