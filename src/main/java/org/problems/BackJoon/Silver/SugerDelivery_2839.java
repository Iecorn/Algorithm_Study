package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SugerDelivery_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int limit5 = N/5;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= limit5; i++) {
            if((N-5*i)%3!=0)
                continue;
            answer = Math.min(answer, i+(N-5*i)/3);
        }
        if(answer == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(answer);
    }
}
