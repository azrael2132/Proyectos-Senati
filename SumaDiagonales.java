import java.util.Scanner;

public class SumaDiagonales {
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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        int sumaTotal = sumaDiagonales(matriz);
        System.out.println("La suma de las diagonales es: " + sumaTotal);
        scanner.close();
    }

    public static int sumaDiagonales(int[][] matriz) {
        int n = matriz.length;
        int sumaPrincipal = 0;
        int sumaSecundaria = 0;

        for (int i = 0; i < n; i++) {
            sumaPrincipal += matriz[i][i];
            sumaSecundaria += matriz[i][n - 1 - i];
        }

        return sumaPrincipal + sumaSecundaria;
    }
}