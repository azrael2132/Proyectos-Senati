import java.util.Scanner;

public class PerimetroMatriz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el número de columnas: ");
        int columnas = scanner.nextInt();

        int[][] matriz = new int[filas][columnas];
        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        int sumaPerimetro = 0;
        for (int j = 0; j < columnas; j++) {
            sumaPerimetro += matriz[0][j];
            if (filas > 1) sumaPerimetro += matriz[filas - 1][j];
        }
        for (int i = 1; i < filas - 1; i++) {
            sumaPerimetro += matriz[i][0] + matriz[i][columnas - 1];
        }

        System.out.println("La suma del perímetro es: " + sumaPerimetro);

        System.out.println("La matriz es:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
