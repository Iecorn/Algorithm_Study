package org.problems.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheaterSeat_8500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i < T+1; i++) {
            int N = Integer.parseInt(br.readLine());
            int [] seats = new int[N];
            int max = 0;
            int answer = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++)
                seats[j] = Integer.parseInt(st.nextToken());

            for(int s : seats) {
                max = Math.max(max,  s);
                answer += 1+s;
            }
            answer += max;

            System.out.println("#"+i+" " + answer);
        }
    }
}
