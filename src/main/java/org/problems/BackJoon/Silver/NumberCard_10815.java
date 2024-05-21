package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class NumberCard_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Set<Integer> s = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            s.add(Integer.parseInt(st.nextToken()));
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++){
            if(s.contains(Integer.parseInt(st.nextToken())))
                System.out.print("1 ");
            else
                System.out.print("0 ");
        }
    }
}
