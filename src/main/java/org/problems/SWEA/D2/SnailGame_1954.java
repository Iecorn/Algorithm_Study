package org.problems.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SnailGame_1954 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] row = {1,0,-1,0};
        int[] col = {0,1,0,-1};

        for (int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            int [][]matrix = new int[n][n];
            int x = 0;
            int y = 0;
            int step = 0;
            matrix[0][0] = 1;


            for(int j = 2; j <= n*n; j++){
                if(x+row[step] >= n || y+col[step] >= n || x+row[step] < 0 || y+col[step] < 0 ||  matrix[y+col[step]][x+row[step]] != 0)
                    step = (step+1)%4;
                y += col[step];
                x += row[step];
                matrix[y][x] = j;
            }
            System.out.println("#"+(i+1));
            print_matrix(matrix, n);
        }
    }

    public static void print_matrix(int[][] matrix, int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
