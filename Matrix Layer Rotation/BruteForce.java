import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void matrixRotation(int[][] matrix) {
        // Complete this function
        int matrixRows = matrix.length;
        int matrixColumns = matrix[0].length;
        int counter = 0;
        int min = Math.min(matrixRows,matrixColumns);
        while(counter < min/2){
            int temp = matrix[counter][counter];
            int temp2 = matrix[matrixRows-1-counter][matrixColumns-1-counter];
            for(int i = counter; i < matrixColumns - 1 - counter; i++){
                matrix[counter][i] = matrix[counter][i+1];
                matrix[matrixRows-1-counter][matrixColumns-1-i] = matrix[matrixRows-1-counter][matrixColumns-1-i-1];
            }
            for(int i = counter; i < matrixRows - 1 - counter-1; i++){
                matrix[matrixRows-1-i][counter] = matrix[matrixRows-1-i-1][counter];
                matrix[i][matrixColumns-1 - counter] = matrix[i+1][matrixColumns-1 - counter];
            }
            matrix[counter+1][counter] = temp;
            matrix[matrixRows-1-counter-1][matrixColumns-1-counter] = temp2;
            counter++;
        }
    }
    
    public static void print(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int r = in.nextInt();
        int[][] matrix = new int[m][n];
        for(int matrix_i = 0; matrix_i < m; matrix_i++){
            for(int matrix_j = 0; matrix_j < n; matrix_j++){
                matrix[matrix_i][matrix_j] = in.nextInt();
            }
        }
        for(int i = 0; i < r; i++){
            matrixRotation(matrix);    
        }
        print(matrix);
        in.close();
    }
}