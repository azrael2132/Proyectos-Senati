import java.util.Scanner;

public class MatrizSimetrica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño de la matriz cuadrada: ");
        int valor = scanner.nextInt();

        int[][] matriz = new int[valor][valor];
        boolean esSimetrica = true;

        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < valor; i++) {
            for (int j = 0; j < valor; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < valor && esSimetrica; i++) {
            for (int j = i + 1; j < valor; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    esSimetrica = false;
                    break;
                }
            }
        }

        System.out.println(esSimetrica ? "La matriz es simétrica." : "La matriz no es simétrica.");

        scanner.close();
    }
}
