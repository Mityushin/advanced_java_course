package edu.technopolis.homework;

/**
 * Matrix multiplication home task.
 * <br/>
 * Matrix dimension and elements are passed as CLI arguments.
 */
public class MatrixMultiplication {
    protected static void setArray(int[][] arr, int N, int M, int carriage, String... args) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(args[carriage + i + j * N]);
            }
        }
    }
    protected static void getArray(int[][] arr, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
    protected static int[][] multiplication(int[][] arr1NM, int N, int M, int[][] arr2XY, int X, int Y) {
        int[][] arr = new int[N][Y];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < Y; j++) {
                int sum = 0;
                for (int k = 0; k < M; k++) {
                    sum += arr1NM[i][k] * arr2XY[k][j];
                }
                arr[i][j] = sum;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        /**
         * check input errors
         */
        if (args.length < 4) {
            System.err.println("Invalid line arguments");
            return;
        }

        /**
         *input control options
         */
        int N = Integer.parseInt(args[0]),
                M = Integer.parseInt(args[1]),
                X = Integer.parseInt(args[2]),
                Y = Integer.parseInt(args[3]);
        /**
         * carriage - carriage shift relative to controls and read options, like N, M, X, Y
         */
        int carriage = 4;

        /**
         * check input errors
         */
        if (args.length != 4 + N * M + X * Y || N < 1 || M < 1 || X < 1 || Y < 1) {
            System.err.println("Invalid line arguments");
            return;
        }
        if (M != X) {
            System.err.println("Matrix is not possible to multiply");
            return;
        }

        /**
         * input arrays
         */
        int[][] arr1NM = new int[N][M];
        setArray(arr1NM, N, M, carriage, args);
        carriage += N * M;

        int arr2XY[][] = new int[X][Y];
        setArray(arr2XY, X, Y, carriage, args);
        carriage += X * Y;

        /*
         * input check
         */
        //getArray(arr1NM, N, M);
        //getArray(arr2XY, X, Y);

        /**
         * execution
         */
        int[][] arrResult = multiplication(arr1NM, N, M, arr2XY, X, Y);

        getArray(arrResult, N, Y);

    }
}
