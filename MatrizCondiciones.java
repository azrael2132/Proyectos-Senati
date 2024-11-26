import java.util.Scanner;

public class MatrizCondiciones {

    private int[][] matriz;
    private int sumar;
    private int multiplicar;

    public MatrizCondiciones(int filas, int columnas) {
        matriz = new int[filas][columnas];
        sumar = 0;
        multiplicar = 1;
    }

    public void ingresarDatos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los valores para la matriz de tamaño " + matriz.length + "x" + matriz[0].length + ":");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Ingrese el valor para la celda [" + i + "][" + j + "]:");
                matriz[i][j] = scanner.nextInt();
            }
        }
    }

    public void verificarCondicionesYActualizarValores() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                boolean condicion1 = matriz[i][j] < 0;
                boolean condicion2 = matriz[i][j] % 2 == 0;

                if (!condicion1 || !condicion2) {
                    multiplicar *= matriz[i][j];
                    System.out.println("El valor " + matriz[i][j] + " en la posición [" + i + "][" + j + "] no cumple ambas condiciones.");
                    System.out.println("Se multiplica, nuevo valor de multiplicación: " + multiplicar);
                } else {
                    sumar += matriz[i][j];
                    System.out.println("El valor " + matriz[i][j] + " en la posición [" + i + "][" + j + "] cumple ambas condiciones.");
                    System.out.println("Se suma, nuevo valor de suma: " + sumar);
                }
            }
        }
    }

    public void verMatriz() {
        System.out.println("Matriz actual:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de filas de la matriz:");
        int filas = scanner.nextInt();
        System.out.println("Ingrese el número de columnas de la matriz:");
        int columnas = scanner.nextInt();

        MatrizCondiciones matrizCondiciones = new MatrizCondiciones(filas, columnas);

        matrizCondiciones.ingresarDatos();

        matrizCondiciones.verificarCondicionesYActualizarValores();

        matrizCondiciones.verMatriz();

        scanner.close();
    }
}