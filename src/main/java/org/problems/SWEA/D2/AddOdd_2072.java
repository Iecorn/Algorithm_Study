package org.problems.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AddOdd_2072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            int sum = 0;
            st = new StringTokenizer(br.readLine(), " ");
            List<Integer> list = new ArrayList<>();

            for(int j = 0; j < 10; j++){
                int n = Integer.parseInt(st.nextToken());
                if(n%2 == 1)
                    sum += n;
            }
            System.out.println("#" + (i+1) + " " + sum);
        }
    }
}
