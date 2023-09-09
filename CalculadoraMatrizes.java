/* ALUNO: FELIPE CAVALCANTI APOLINÁRIO*/

import java.util.Scanner;

class CalculadoraMatrizes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao, somaDiagonalPrincipal = 0, somaDiagonalPrincipal2 = 0, somaDiagonalSecundaria = 0, somaDiagonalSecundaria2 = 0;
        int determinanteMatriz1, determinanteMatriz2;

        // Pedindo a ordem da matriz (2x2, 3x3, etc).
        System.out.println("Qual a ordem da matriz quadrada?");
        int ordem = sc.nextInt();

        // Variáveis das matrizes
        int[][] matrix1 = new int[ordem][ordem];
        int[][] matrix2 = new int[ordem][ordem];
        int[][] matrizSomada = new int[ordem][ordem];
        int[][] matrizEscalar1 = new int[ordem][ordem];
        int[][] matrizEscalar2 = new int[ordem][ordem];
        int[][] matrizSubtraida = new int[ordem][ordem];
        int[][] matrizMultiplicada = new int[ordem][ordem];
        int[][] transpostaMatriz1 = new int[ordem][ordem];
        int[][] transpostaMatriz2 = new int[ordem][ordem];


        /* Preenchendo a matriz 1 */
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                System.out.printf("Digite o elemento [%d,%d] da matriz 1: ", i, j);
                matrix1[i][j] = sc.nextInt();
            }
        }

        /* Preenchendo a matriz 2 */
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                System.out.printf("Digite o elemento [%d,%d] da matriz 2: ", i, j);
                matrix2[i][j] = sc.nextInt();
            }
        }

        // MENU DE OPÇÕES
        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("1. SOMA DAS MATRIZES\n" +
                    "2. MULTIPLICAR AMBAS AS MATRIZES POR UM ESCALAR\n" +
                    "3. DETERMINANTE DAS MATRIZES\n" +
                    "4. SOMA DOS ELEMENTOS DAS MATRIZES E DETERMINAR A MAIOR SOMA\n" +
                    "5. SUBTRAÇÃO DAS MATRIZES\n" +
                    "6. MULTIPLICAÇÃO DAS MATRIZES\n" +
                    "7. TRANSPOSIÇÃO DAS MATRIZES\n" +
                    "0. SAIR");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    // soma de matrizes

                    for (int i = 0; i < ordem; i++) {
                        for (int j = 0; j < ordem; j++) {
                            matrizSomada[i][j] = matrix1[i][j] + matrix2[i][j];
                        }
                    }

                    /* Mostrando a matriz: */
                    System.out.println("Soma das matrizes:");
                    for (int i = 0; i < ordem; i++) {
                        for (int j = 0; j < ordem; j++) {
                            System.out.printf("%2d ", matrizSomada[i][j]);

                        }
                        System.out.println("\n");
                    }
                    break;
                case 2:
                    // multiplicação por um escalar (ambas as matrizes)

                    System.out.println("Digite o valor de um escalar: ");
                    int escalar = sc.nextInt();

                    //calculando escalar da matriz 1 e 2:
                    for (int i = 0; i < ordem; i++) {
                        for (int j = 0; j < ordem; j++) {
                            matrizEscalar1[i][j] = escalar * matrix1[i][j];
                            matrizEscalar2[i][j] = escalar * matrix2[i][j];
                        }
                    }

                    //mostrando:
                    System.out.println("Multiplicação por um escalar (Matriz1): ");
                    for (int i = 0; i < ordem; i++) {
                        for (int j = 0; j < ordem; j++) {
                            System.out.printf("%2d ", matrizEscalar1[i][j]);
                        }
                        System.out.println("\n");
                    }
                    System.out.println("Multiplicação por um escalar (Matriz2): ");
                    for (int i = 0; i < ordem; i++) {
                        for (int j = 0; j < ordem; j++) {
                            System.out.printf("%2d ", matrizEscalar2[i][j]);
                        }
                        System.out.println("\n");
                    }
                    break;
                case 3:
                    // determinante das matrizes

                    if (ordem == 2) {
                        for (int i = 0; i < ordem; i++) {
                            for (int j = 0; j < ordem; j++) {
                                if (i == j) {
                                    somaDiagonalPrincipal += matrix1[i][j];
                                    somaDiagonalPrincipal2 += matrix2[i][j];
                                } else {
                                    somaDiagonalSecundaria += matrix1[i][j];
                                    somaDiagonalSecundaria2 += matrix2[i][j];
                                }

                            }
                        }
                        determinanteMatriz1 = somaDiagonalPrincipal - somaDiagonalSecundaria;
                        determinanteMatriz2 = somaDiagonalPrincipal2 - somaDiagonalSecundaria2;
                        System.out.println("Determinante da matriz1: " + determinanteMatriz1);
                        System.out.println("Determinante da matriz2: " + determinanteMatriz2);
                    }
                    break;

                case 4:
                    // soma dos elementos de cada matriz indicando qual a de maior soma
                    int somaMatrix1 = 0;
                    int somaMatrix2 = 0;

                    // Calculando a soma dos elementos da matriz 1
                    for (int i = 0; i < ordem; i++) {
                        for (int j = 0; j < ordem; j++) {
                            somaMatrix1 += matrix1[i][j];
                        }
                    }

                    // Calculando a soma dos elementos da matriz 2
                    for (int i = 0; i < ordem; i++) {
                        for (int j = 0; j < ordem; j++) {
                            somaMatrix2 += matrix2[i][j];
                        }
                    }

                    System.out.println("Soma dos elementos da matriz 1: " + somaMatrix1);
                    System.out.println("Soma dos elementos da matriz 2: " + somaMatrix2);

                    if (somaMatrix1 > somaMatrix2) {
                        System.out.println("A matriz 1 possui a maior soma");
                    } else if (somaMatrix2 > somaMatrix1) {
                        System.out.println("A matriz 2 possui a maior soma");
                    } else {
                        System.out.println("As matrizes têm a mesma soma");
                    }
                    break;
                case 5:
                    // Subtração de matrizes:

                    for (int i = 0; i < ordem; i++) {
                        for (int j = 0; j < ordem; j++) {
                            matrizSubtraida[i][j] = matrix1[i][j] - matrix2[i][j];
                        }
                    }

                    // Mostrando a matriz subtraída:
                    for (int i = 0; i < ordem; i++) {
                        for (int j = 0; j < ordem; j++) {
                            System.out.printf("%3d ", matrizSubtraida[i][j]);
                        }
                        System.out.println("\n");
                    }
                    break;
                case 6:
                    // Multiplicação de matrizes
                    for (int i = 0; i < ordem; i++) {
                        for (int j = 0; j < ordem; j++) {
                            matrizMultiplicada[i][j] = 0;
                            for (int x = 0; x < ordem; x++) {
                                matrizMultiplicada[i][j] += matrix1[i][x] * matrix2[x][j];
                            }
                        }
                    }

                    // mostrando a multiplicação das matrizes:

                    for (int i = 0; i < ordem; i++) {
                        for (int j = 0; j < ordem; j++) {
                            System.out.printf("%3d ", matrizMultiplicada[i][j]);
                        }
                        System.out.println("\n");
                    }

                    break;
                case 7:
                    // Transposta da matriz 1 e 2:
                    for (int i = 0; i < ordem; i++) {
                        for (int j = 0; j < ordem; j++) {
                            transpostaMatriz1[j][i] = matrix1[i][j];
                            transpostaMatriz2[j][i] = matrix2[i][j];
                        }
                    }

                    //mostrando a transposta da matriz 1 e 2:
                    System.out.println("Transposta da matriz 1:");
                    for (int i = 0; i < ordem; i++) {
                        for (int j = 0; j < ordem; j++) {
                            System.out.printf("%3d ", transpostaMatriz1[i][j]);
                        }
                        System.out.println("\n");
                    }
                    System.out.println("Transposta da matriz 2:");
                    for (int i = 0; i < ordem; i++) {
                        for (int j = 0; j < ordem; j++) {
                            System.out.printf("%3d ", transpostaMatriz2[i][j]);
                        }
                        System.out.println("\n");
                    }


                    break;

                default:
                    System.out.println("Você escolheu sair.");

            }

        } while (opcao != 0);
        sc.close();
    }
}

