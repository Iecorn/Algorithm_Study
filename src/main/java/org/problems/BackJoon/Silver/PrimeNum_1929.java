package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimeNum_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] num = new boolean[N+1];

        //init
        for (int i = 2; i < N+1; i++)
            num[i] = true;
        num[1] = false;

        for (int i = 2; i*i < N+1; i++) {
            if(!num[i])
                continue;
            for (int j = i*i; j < N+1; j += i) {
                num[j] = false;
            }
        }

        for (int i = M; i < N+1; i++)
            if(num[i])
                System.out.println(i);
    }
}
