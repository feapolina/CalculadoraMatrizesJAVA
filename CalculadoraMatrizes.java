import java.util.Scanner;

class CalculadoraMatrizes {

    public static void preencheMatriz(int[][] matrix1, int[][] matrix2, int ordem){
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < ordem; i++){
            for (int j = 0; j < ordem; j++){
                System.out.printf("Digite o elemento [%d,%d] da matriz 1: ", i, j);
                matrix1[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < ordem; i++){
            for (int j = 0; j < ordem; j++){
                System.out.printf("Digite o elemento [%d,%d] da matriz 2: ", i, j);
                matrix2[i][j] = sc.nextInt();
            }
        }
    }
    public static void mostraMatriz(int[][] matriz, int ordem){
        for (int i = 0; i < ordem; i++){
            for (int j = 0; j < ordem; j++){
                System.out.printf("%2d ", matriz[i][j]);
            }
            System.out.println("\n");
        }
    }
    public static int[][] somarMatriz(int[][] matriz1, int[][] matriz2, int ordem) {
        int[][] matrizSomada = new int[ordem][ordem];

        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                matrizSomada[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return matrizSomada;
    }
    public static int[][] subMatriz(int[][] matriz1, int[][] matriz2, int ordem){
        int[][] matrizSub = new int[ordem][ordem];

        for (int i = 0; i < ordem; i++){
            for (int j = 0; j < ordem; j++){
                matrizSub[i][j] = matriz1[i][j] - matriz2[i][j];
            }
        }
        return matrizSub;
    }
    public static int[][] multiplicaMatrizes(int[][] matriz1, int[][] matriz2, int ordem) {
        int[][] matrizMultiplicada = new int[ordem][ordem];

        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                matrizMultiplicada[i][j] = 0;
                for (int k = 0; k < ordem; k++) {
                    matrizMultiplicada[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        return matrizMultiplicada;
    }
    public static int[][] multiplicarPorEscalar1(int[][] matriz1, int ordem, int escalar) {
        int[][] matrizEscalar1 = new int[ordem][ordem];

        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                matrizEscalar1[i][j] = escalar * matriz1[i][j];
            }
        }

        return matrizEscalar1;
    }
    public static int[][] multiplicarPorEscalar2(int[][] matriz2, int ordem, int escalar) {
        int[][] matrizEscalar2 = new int[ordem][ordem];

        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                matrizEscalar2[i][j] = escalar * matriz2[i][j];
            }
        }

        return matrizEscalar2;
    }
    public static int[][] calculaTransposta1(int[][] matriz1, int ordem){
        int[][] transpostaMatriz1 = new int[ordem][ordem];

        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                transpostaMatriz1[j][i] = matriz1[i][j];
            }
        }
        return transpostaMatriz1;
    }
    public static int[][] calculaTransposta2(int[][] matriz2, int ordem){
        int[][] transpostaMatriz2 = new int[ordem][ordem];

        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                transpostaMatriz2[j][i] = matriz2[i][j];
            }
        }
        return transpostaMatriz2;
    }
    public static int calcularDeterminante(int[][] matriz, int ordem) {
        if (ordem == 2) {
            return (matriz[0][0] * matriz[1][1]) - (matriz[0][1] * matriz[1][0]);
        } else if (ordem == 3) {
            int det = 0;
            det += matriz[0][0] * ((matriz[1][1] * matriz[2][2]) - (matriz[1][2] * matriz[2][1]));
            det -= matriz[0][1] * ((matriz[1][0] * matriz[2][2]) - (matriz[1][2] * matriz[2][0]));
            det += matriz[0][2] * ((matriz[1][0] * matriz[2][1]) - (matriz[1][1] * matriz[2][0]));
            return det;
        } else {
            System.out.println("Apenas matrizes de ordem 2x2 ou 3x3 são suportadas para cálculo de determinante.");
            return 0;
        }
    }
    public static void calcularSomaElementosMatrizes(int[][] matriz1, int[][] matriz2, int ordem) {
        int somaMatrix1 = 0;
        int somaMatrix2 = 0;

        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                somaMatrix1 += matriz1[i][j];
                somaMatrix2 += matriz2[i][j];
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
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcao;
        int determinanteMatriz1, determinanteMatriz2;
        int ordem;

        do{
            System.out.println("Qual a ordem da matriz quadrada?");
            ordem = sc.nextInt();
        }while(ordem < 1);

        int[][] matrix1 = new int[ordem][ordem];
        int[][] matrix2 = new int[ordem][ordem];
        int[][] matrizSomada;
        int[][] matrizSub;
        int[][] matrizMultiplicada;
        int[][] matrizEscalar1;
        int[][] matrizEscalar2;
        int[][] transpostaMatriz1;
        int[][] transpostaMatriz2;

        preencheMatriz(matrix1, matrix2, ordem);

        do{
            System.out.println("Escolha uma opção: \n" +
                    "1. SOMA DAS MATRIZES\n" +
                    "2. MULTIPLICAR AMBAS AS MATRIZES POR UM ESCALAR\n" +
                    "3. DETERMINANTE DAS MATRIZES\n" +
                    "4. SOMA DOS ELEMENTOS DAS MATRIZES E DETERMINAR A MAIOR SOMA\n" +
                    "5. SUBTRAÇÃO DOS ELEMENTOS DAS DUAS MATRIZES\n" +
                    "6. MULTIPLICAÇÃO DOS ELEMENTOS DAS MATRIZES\n" +
                    "7. MOSTRAR A TRANSPOSTA DAS MATRIZES\n" +
                    "0. SAIR");

            opcao = sc.nextInt();

            switch (opcao){
                case 0:
                    break;
                case 1:
                    matrizSomada = somarMatriz(matrix1, matrix2, ordem);
                    System.out.println("Soma das matrizes:");
                    mostraMatriz(matrizSomada, ordem);
                    break;

                case 2:
                    System.out.println("Digite o valor de um escalar: ");
                    int escalar = sc.nextInt();

                    matrizEscalar1 = multiplicarPorEscalar1(matrix1, ordem, escalar);
                    matrizEscalar2 = multiplicarPorEscalar2(matrix2, ordem, escalar);

                    System.out.println("Multiplicação por um escalar (Matriz1): ");
                    mostraMatriz(matrizEscalar1, ordem);
                    System.out.println("Multiplicação por um escalar (Matriz2): ");
                    mostraMatriz(matrizEscalar2, ordem);
                    break;

                case 3:
                    determinanteMatriz1 = calcularDeterminante(matrix1, ordem);
                    determinanteMatriz2 = calcularDeterminante(matrix2, ordem);
                    System.out.println("Determinante da matriz1: " + determinanteMatriz1);
                    System.out.println("Determinante da matriz2: " + determinanteMatriz2);
                    break;

                case 4:
                    calcularSomaElementosMatrizes(matrix1, matrix2, ordem);
                    break;
                case 5:
                    matrizSub = subMatriz(matrix1, matrix2, ordem);
                    System.out.println("Subtração das matrizes:");
                    mostraMatriz(matrizSub, ordem);
                    break;
                case 6:
                    matrizMultiplicada = multiplicaMatrizes(matrix1, matrix2, ordem);
                    System.out.println("Matrizes multiplicadas:");
                    mostraMatriz(matrizMultiplicada, ordem);
                    break;
                case 7:
                    transpostaMatriz1 = calculaTransposta1(matrix1,ordem);
                    transpostaMatriz2 = calculaTransposta2(matrix2, ordem);
                    System.out.println("Matriz transposta 1: ");
                    mostraMatriz(transpostaMatriz1, ordem);
                    System.out.println("Matriz transposta 2: ");
                    mostraMatriz(transpostaMatriz2, ordem);
                    break;
                default:
                    System.out.println("Opção Inválida.");

            }

        }while(opcao != 0);
        sc.close();
    }
}
