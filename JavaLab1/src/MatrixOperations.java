import java.util.Random;
public class MatrixOperations{
    private static final int ROWS = 3;
    private static final int COLS = 3;

    public void execute() {

        float[][] matrixA = generateMatrix(ROWS, COLS);
        float[][] matrixB = generateMatrix(ROWS, COLS);

        System.out.println("Matrix A:");
        printMatrix(matrixA);
        System.out.println("Matrix B:");
        printMatrix(matrixB);

        float[][] matrixC = firstTask(matrixA, matrixB);

       secondTask(matrixC);
    }

    private float[][] firstTask(float[][] matrixA,float[][] matrixB) {
        float[][] matrixC = new float[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                matrixC[i][j] = Float.floatToIntBits(matrixA[i][j]) ^ Float.floatToIntBits(matrixB[i][j]);
            }
        }

        System.out.println("matrixC after XOR:");
        printMatrix(matrixC);
        return matrixC;
    }

    private void secondTask(float[][] matrix){
        float sumMaxCols = 0;
        for (int j = 0; j < COLS; j++) {
            float max = matrix[0][j];
            for (int i = 1; i < ROWS; i++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            sumMaxCols += max;
        }
        String text= String.format("\"Sum of max elements of each column of matrixC\"\n %f", sumMaxCols);
        System.out.println(text);
    }

    private float[][] generateMatrix(int rows, int cols) {
        float[][] matrix = new float[rows][cols];
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(100);
            }
        }
        return matrix;
    }

    private void printMatrix(float[][] matrix) {
        for (float[] row : matrix) {
            for (float val : row) {
                System.out.printf("%.2f  ", val);
            }
            System.out.println();
        }
        System.out.println();
    }
}