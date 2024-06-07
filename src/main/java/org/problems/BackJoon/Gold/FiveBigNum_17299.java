package org.problems.BackJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FiveBigNum_17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] data = new int[N];
        int[] cnt = new int[1000001];
        int[] answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            cnt[data[i]]++;
        }

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < N; i++) {
            while(!s.isEmpty() && cnt[data[s.peek()]] < cnt[data[i]]) {
                answer[s.pop()] = data[i];
            }

            s.add(i);
        }

        while(!s.isEmpty())
            answer[s.pop()] = -1;


        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }
}
