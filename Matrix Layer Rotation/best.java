import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void matrixRotation(int[][] matrix, int r) {
        // Complete this function
        int matrixRows = matrix.length;
        int matrixColumns = matrix[0].length;
        
        int flat = 2*matrixRows+2*matrixColumns-4; // every next layer should have 8 less;
            
        int[] linear = new int[flat];
        int counter = 0;
        int min = Math.min(matrixRows,matrixColumns);
        while(counter < min/2){
            
            int ptr = 0;
            
            //top row, left to right
            for (int j=counter; j<matrixColumns-counter; j++) {
                linear[ptr++] = matrix[counter][j];
            }

            // right column, top to bottom
            for (int j=counter+1; j<matrixRows-counter; j++) {
                linear[ptr++] = matrix[j][matrixColumns-1-counter];
            }

            // bottom row, right to left
            for (int j=matrixColumns-2-counter; j>=counter; j--) {
                linear[ptr++] = matrix[matrixRows-1-counter][j];
            }

            // left column, bottom to top
            for (int j=matrixRows-2-counter; j>counter; j--) {
                linear[ptr++] = matrix[j][counter];
            }
            
            int startingPosition = r%ptr;
            
            if(startingPosition > 0 ){
                
                for (int j=counter; j<matrixColumns-counter; j++) {
                    matrix[counter][j] = linear[startingPosition];
                    startingPosition = (startingPosition+1) % ptr;
                }

                // right column, top to bottom
                for (int j=counter+1; j<matrixRows-counter; j++) {
                    matrix[j][matrixColumns-1-counter] = linear[startingPosition];
                    startingPosition = (startingPosition+1) % ptr;
                }

                // bottom row, right to left
                for (int j=matrixColumns-2-counter; j>=counter; j--) {
                    matrix[matrixRows-1-counter][j] = linear[startingPosition];
                    startingPosition = (startingPosition+1) % ptr;
                }

                // left column, bottom to top
                for (int j=matrixRows-2-counter; j>counter; j--) {
                    matrix[j][counter] = linear[startingPosition];
                    startingPosition = (startingPosition+1) % ptr;
                }
                
            }
            
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
        int matrixRows = in.nextInt();
        int matrixColumns = in.nextInt();
        int r = in.nextInt();
        int[][] matrix = new int[matrixRows][matrixColumns];
        for(int matrix_i = 0; matrix_i < matrixRows; matrix_i++){
            for(int matrix_j = 0; matrix_j < matrixColumns; matrix_j++){
                matrix[matrix_i][matrix_j] = in.nextInt();
            }
        }
        matrixRotation(matrix,r);    
        print(matrix);
        in.close();
    }
}
