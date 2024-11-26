import java.util.Scanner;

public class Matriz_Multidimensional {

    private int[][][] matrices;
    private int numMatrices;

    public Matriz_Multidimensional() {
        matrices = new int[10][][]; // Un máximo de 10 matrices por ahora
        numMatrices = 0;
    }

    public void agregarMatriz(int filas, int columnas) {
        if (numMatrices < matrices.length) {
            matrices[numMatrices] = new int[filas][columnas];
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese los valores para la matriz de tamaño " + filas + "x" + columnas + ":");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.println("Ingrese el valor para la celda [" + i + "][" + j + "]:");
                    matrices[numMatrices][i][j] = scanner.nextInt();
                }
            }
            numMatrices++;
            System.out.println("Matriz de tamaño " + filas + "x" + columnas + " agregada.");
        } else {
            System.out.println("No se pueden agregar más matrices.");
        }
    }

    public void eliminarMatriz(int indice) {
        if (indice >= 0 && indice < numMatrices) {
            for (int i = indice; i < numMatrices - 1; i++) {
                matrices[i] = matrices[i + 1];
            }
            matrices[numMatrices - 1] = null;
            numMatrices--;
            System.out.println("Matriz en índice " + indice + " eliminada.");
        } else {
            System.out.println("Índice no válido.");
        }
    }

    public void agregarFila(int indiceMatriz) {
        if (indiceMatriz >= 0 && indiceMatriz < numMatrices) {
            int[][] matriz = matrices[indiceMatriz];
            int columnas = matriz[0].length;
            int[][] nuevaMatriz = new int[matriz.length + 1][columnas];
            for (int i = 0; i < matriz.length; i++) {
                System.arraycopy(matriz[i], 0, nuevaMatriz[i], 0, matriz[i].length);
            }
            matrices[indiceMatriz] = nuevaMatriz;
            System.out.println("Fila agregada a la matriz en índice " + indiceMatriz);
        } else {
            System.out.println("Índice de matriz no válido.");
        }
    }

    public void agregarColumna(int indiceMatriz) {
        if (indiceMatriz >= 0 && indiceMatriz < numMatrices) {
            int[][] matriz = matrices[indiceMatriz];
            int filas = matriz.length;
            int[][] nuevaMatriz = new int[filas][matriz[0].length + 1];
            for (int i = 0; i < filas; i++) {
                System.arraycopy(matriz[i], 0, nuevaMatriz[i], 0, matriz[i].length);
            }
            matrices[indiceMatriz] = nuevaMatriz;
            System.out.println("Columna agregada a la matriz en índice " + indiceMatriz);
        } else {
            System.out.println("Índice de matriz no válido.");
        }
    }

    public void eliminarFila(int indiceMatriz, int indiceFila) {
        if (indiceMatriz >= 0 && indiceMatriz < numMatrices) {
            int[][] matriz = matrices[indiceMatriz];
            if (indiceFila >= 0 && indiceFila < matriz.length) {
                int[][] nuevaMatriz = new int[matriz.length - 1][matriz[0].length];
                for (int i = 0, j = 0; i < matriz.length; i++) {
                    if (i != indiceFila) {
                        nuevaMatriz[j++] = matriz[i];
                    }
                }
                matrices[indiceMatriz] = nuevaMatriz;
                System.out.println("Fila en índice " + indiceFila + " eliminada de la matriz en índice " + indiceMatriz);
            } else {
                System.out.println("Índice de fila no válido.");
            }
        } else {
            System.out.println("Índice de matriz no válido.");
        }
    }

    public void eliminarColumna(int indiceMatriz, int indiceColumna) {
        if (indiceMatriz >= 0 && indiceMatriz < numMatrices) {
            int[][] matriz = matrices[indiceMatriz];
            if (indiceColumna >= 0 && indiceColumna < matriz[0].length) {
                int[][] nuevaMatriz = new int[matriz.length][matriz[0].length - 1];
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0, k = 0; j < matriz[i].length; j++) {
                        if (j != indiceColumna) {
                            nuevaMatriz[i][k++] = matriz[i][j];
                        }
                    }
                }
                matrices[indiceMatriz] = nuevaMatriz;
                System.out.println("Columna en índice " + indiceColumna + " eliminada de la matriz en índice " + indiceMatriz);
            } else {
                System.out.println("Índice de columna no válido.");
            }
        } else {
            System.out.println("Índice de matriz no válido.");
        }
    }

    public void verMatriz(int indice) {
        if (indice >= 0 && indice < numMatrices) {
            int[][] matriz = matrices[indice];
            System.out.println("Matriz en índice " + indice + ":");
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Índice de matriz no válido.");
        }
    }

    public void editarDatoMatriz(int indiceMatriz, int fila, int columna, int nuevoValor) {
        if (indiceMatriz >= 0 && indiceMatriz < numMatrices) {
            int[][] matriz = matrices[indiceMatriz];
            if (fila >= 0 && fila < matriz.length && columna >= 0 && columna < matriz[0].length) {
                matriz[fila][columna] = nuevoValor;
                System.out.println("Dato actualizado en matriz " + indiceMatriz + " en fila " + fila + ", columna " + columna + " a " + nuevoValor);
            } else {
                System.out.println("Índices de fila o columna no válidos.");
            }
        } else {
            System.out.println("Índice de matriz no válido.");
        }
    }

    public void eliminarDatoMatriz(int indiceMatriz, int fila, int columna) {
        if (indiceMatriz >= 0 && indiceMatriz < numMatrices) {
            int[][] matriz = matrices[indiceMatriz];
            if (fila >= 0 && fila < matriz.length && columna >= 0 && columna < matriz[0].length) {
                matriz[fila][columna] = 0; // Se elimina el dato poniéndolo a 0
                System.out.println("Dato eliminado en matriz " + indiceMatriz + " en fila " + fila + ", columna " + columna);
            } else {
                System.out.println("Índices de fila o columna no válidos.");
            }
        } else {
            System.out.println("Índice de matriz no válido.");
        }
    }

    public void sumarValoresMatriz(int indiceMatriz) {
        if (indiceMatriz >= 0 && indiceMatriz < numMatrices) {
            int[][] matriz = matrices[indiceMatriz];
            int suma = 0;
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    suma += matriz[i][j];
                }
            }
            System.out.println("La suma de los valores de la matriz en el índice " + indiceMatriz + " es: " + suma);
        } else {
            System.out.println("Índice de matriz no válido.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matriz_Multidimensional mm = new Matriz_Multidimensional();

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar matriz");
            System.out.println("2. Eliminar matriz");
            System.out.println("3. Agregar fila");
            System.out.println("4. Agregar columna");
            System.out.println("5. Eliminar fila");
            System.out.println("6. Eliminar columna");
            System.out.println("7. Ver matrices");
            System.out.println("8. Editar dato de matriz");
            System.out.println("9. Eliminar dato de matriz");
            System.out.println("10. Sumar valores de matriz");
            System.out.println("11. Salir");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el número de filas de la matriz:");
                    int filas = scanner.nextInt();
                    System.out.println("Ingrese el número de columnas de la matriz:");
                    int columnas = scanner.nextInt();
                    mm.agregarMatriz(filas, columnas);
                    break;
                case 2:
                    System.out.println("Ingrese el índice de la matriz a eliminar:");
                    int indiceEliminar = scanner.nextInt();
                    mm.eliminarMatriz(indiceEliminar);
                    break;
                case 3:
                    System.out.println("Ingrese el índice de la matriz a la que agregar fila:");
                    int indiceFila = scanner.nextInt();
                    mm.agregarFila(indiceFila);
                    break;
                case 4:
                    System.out.println("Ingrese el índice de la matriz a la que agregar columna:");
                    int indiceColumna = scanner.nextInt();
                    mm.agregarColumna(indiceColumna);
                    break;
                case 5:
                    System.out.println("Ingrese el índice de la matriz:");
                    int indiceMatrizEliminarFila = scanner.nextInt();
                    System.out.println("Ingrese el índice de la fila a eliminar:");
                    int filaEliminar = scanner.nextInt();
                    mm.eliminarFila(indiceMatrizEliminarFila, filaEliminar);
                    break;
                case 6:
                    System.out.println("Ingrese el índice de la matriz:");
                    int indiceMatrizEliminarColumna = scanner.nextInt();
                    System.out.println("Ingrese el índice de la columna a eliminar:");
                    int columnaEliminar = scanner.nextInt();
                    mm.eliminarColumna(indiceMatrizEliminarColumna, columnaEliminar);
                    break;
                case 7:
                    System.out.println("Ingrese el índice de la matriz a ver:");
                    int indiceVer = scanner.nextInt();
                    mm.verMatriz(indiceVer);
                    break;
                case 8:
                    System.out.println("Ingrese el índice de la matriz, fila, columna y nuevo valor:");
                    int indiceEdit = scanner.nextInt();
                    int filaEdit = scanner.nextInt();
                    int columnaEdit = scanner.nextInt();
                    int nuevoValor = scanner.nextInt();
                    mm.editarDatoMatriz(indiceEdit, filaEdit, columnaEdit, nuevoValor);
                    break;
                case 9:
                    System.out.println("Ingrese el índice de la matriz, fila y columna para eliminar el dato:");
                    int indiceDel = scanner.nextInt();
                    int filaDel = scanner.nextInt();
                    int columnaDel = scanner.nextInt();
                    mm.eliminarDatoMatriz(indiceDel, filaDel, columnaDel);
                    break;
                case 10:
                    System.out.println("Ingrese el índice de la matriz para sumar los valores:");
                    int indiceSumar = scanner.nextInt();
                    mm.sumarValoresMatriz(indiceSumar);
                    break;
                case 11:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
