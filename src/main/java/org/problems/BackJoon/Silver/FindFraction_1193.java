package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindFraction_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        int N = Integer.parseInt(br.readLine());
        int step = 1;
        while(N-step > 0){
            N -= step++;
        }
        if(step%2==0)
            System.out.println(N+ "/" + (step-N+1));
        else
            System.out.println((step-N+1)+ "/" + N);
    }
}
