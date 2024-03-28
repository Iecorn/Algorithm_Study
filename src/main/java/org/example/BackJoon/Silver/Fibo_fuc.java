package org.example.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fibo_fuc {

    static int zero;
    static int one;
    static int next;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());

            fibo(n);
            System.out.println(zero + " " + one);
        }
    }

    static void fibo(int n){

        zero = 1;
        one = 0;
        next = 1;

        for(int i = 0; i < n; i++){
            zero = one;
            one = next;
            next = zero + one;
        }
    }
}
