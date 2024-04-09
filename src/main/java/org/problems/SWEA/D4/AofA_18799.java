package org.problems.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AofA_18799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            double list_sum = 0;
            double subset_sum = 0;
            double answer;
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++)
                list_sum += Double.parseDouble(st.nextToken());

            for (int j = 0; j <= n-1; j++)
                subset_sum += list_sum*factorial(n - 1) / (factorial(j) * factorial(n - 1 - j) * (j + 1));

            answer = subset_sum/(Math.pow(2,n)-1);

            if(isInteger(answer))
                System.out.println("#" + (i+1) + " " + (int) answer);
            else
                System.out.println("#" + (i+1) + " " +  answer);
        }
    }

    public static long factorial(long n){
        if (n==1 || n==0)
            return 1;

        return n*factorial(n-1);
    }

    public static boolean isInteger(double n){
        return n == (int) n;
    }
}
