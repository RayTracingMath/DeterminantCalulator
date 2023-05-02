import java.util.Scanner;  // Import the Scanner class


public class App {
    static Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    public static void main(String[] args) throws Exception {
        System.out.print("ordine matrice: ");
        int n = scanner.nextInt();  // Read user input
        System.out.println();
        int[][] matrice = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.format("matrice[%d][%d] = ", i, j);
                matrice[i][j] = scanner.nextInt();
            }
        }

        System.out.println();
        printMatrice(matrice);

        System.out.println();
        System.out.println("det(matrice) = " + new App().laplace(matrice));





    }


    public static void printMatrice(int[][] matrice) {
        for (int[] row : matrice) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public int laplace(int[][] matrice) {
        int result = 0;
        int n = matrice.length;
        if (n == 1) {
            return matrice[0][0];
        }
        for (int i = 0; i < n; i++) {
            result += Math.pow(-1, i) * matrice[0][i] * laplace(minor(matrice, 0, i));
        }
        return result;
    }


    private int[][] minor(int[][] matrice, int i, int i2) {

        int n = matrice.length;
        int[][] result = new int[n - 1][n - 1];
        int row = 0;
        int col = 0;
        for (int j = 0; j < n; j++) {
            if (j != i) {
                for (int k = 0; k < n; k++) {
                    if (k != i2) {
                        result[row][col] = matrice[j][k];
                        col++;
                    }
                }
                row++;
                col = 0;
            }
        }
        return result;
        
    }
}
