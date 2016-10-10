package edu.technopolis.homework;

import java.util.Scanner;

/**
 * Matrix multiplication home task.
 * <br/>
 * Matrix dimension and elements are passed as CLI arguments.
 */
public class MatrixMultiplication {
    public static void main(String... args) {

        Scanner s = new Scanner(System.in);

        try {

            int n = s.nextInt();
            int m = s.nextInt();
            int x = s.nextInt();
            int y = s.nextInt();

            if ( n <= 0 )
                throw new Exception("n <= 0, n = " + n);
            if ( m <= 0 )
                throw new Exception("m <= 0, m = " + n);
            if ( x <= 0 )
                throw new Exception("x <= 0, x = " + n);
            if ( y <= 0 )
                throw new Exception("y <= 0, y = " + n);
            if (Integer.compare(m, x) != 0)
                throw new Exception("m != x, m = " + m + ", x = " + x);

            int[][] matrixA = new int[n][m];
            int[][] matrixB = new int[x][y];
            int[][] matrixC = new int[n][y];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrixA[i][j] = s.nextInt();
                }
            }

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    matrixB[i][j] = s.nextInt();
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
            e.printStackTrace();
        }
    }
}
