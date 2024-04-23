package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Confetti_2563 {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int [][] paper = new int[100][100];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            paint(paper,x,y);
        }

        int sum = area(paper);

        System.out.println(sum);
    }

    public static void paint(int[][] paper, int x, int y) {
        for(int i = x-1; i < x+9; i++)
            for(int j = y-1; j < y+9; j++)
                paper[i][j] = 1;
    }

    public static int area(int[][] paper) {
        int sum = 0;

        for(int i = 0; i < 100; i++)
            for(int j = 0; j < 100 ; j++)
                if(paper[i][j] == 1)
                    sum += 1;

        return sum;
    }
}
