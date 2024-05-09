package org.problems.SWEA.D3;

import java.util.Scanner;

public class Pow_1217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 10; i++) {
            int T = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.println("#"+ T +" " + pow(N,M));
        }
    }

    public static int pow(int n, int m) {
        if(m == 1) {
            return n;
        }
        return pow(n,m-1)*n;
    }
}
