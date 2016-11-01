package edu.technopolis.homework;

/**
 * Matrix multiplication home task.
 * <br/>
 * Matrix dimension and elements are passed as CLI arguments.
 */
public class MatrixMultiplication {
    public static void main(String... args) {

        try {

            if ( args.length < 4 )
                throw new NumArgumentExeption();

            int n = Integer.valueOf(args[0]);
            int m = Integer.valueOf(args[1]);
            int x = Integer.valueOf(args[2]);
            int y = Integer.valueOf(args[3]);

            if ( n <= 0 || m <= 0 || x <= 0 || y <=0 || Integer.compare(m, x) != 0 )
                throw new ArraySizeExaption();

            if ( args.length != (4 + (n * m) + (x * y)) )
                throw new NumArgumentExeption();

            int[][] matrixA = new int[n][m];
            int[][] matrixB = new int[x][y];
            int[][] matrixC = new int[n][y];

            int currentIndex = 4;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrixA[i][j] = Integer.valueOf( args[currentIndex] );
                    currentIndex++;
                }
            }

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    matrixB[i][j] = Integer.valueOf( args[currentIndex] );
                    currentIndex++;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < m; k++) {
                        matrixC[i][j]  += matrixA[i][k] * matrixB[k][j];
                    }
                    System.out.print(matrixC[i][j] + "\t");
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static class ArraySizeExaption extends Exception{
        @Override
        public String getMessage(){
            return "Неверно задан размер одного из массивов.\n" +
                    "Проверьте, что размеры массивов больше нуля," +
                    " а также, что данные размеры удовлетворяют условию " +
                    "перемножения матриц:\n\n" +
                    "A(N x M) * B(X x Y), где M = X";
        }
    }

    public static class NumArgumentExeption extends Exception{
        @Override
        public String getMessage(){
            return "Неверное количество аргументов.\n" +
                    "Проверьте, что ввод соответствует следующему формату:\n\n" +
                    "N M X Y A_1_1 ... A_N_M B_1_1 ... B_X_Y\n\n" +
                    "N и M\t\t\t- размерность первой матрицы A (количество строк и столбцов),\n" +
                    "A_1_1 ... A_N_M\t- элементы матрицы A,\n" +
                    "X и Y\t\t\t- размерность второй матрицы B,\n" +
                    "B_1_1 ... B_X_Y\t- элементы матрицы B.";
        }
    }
}
