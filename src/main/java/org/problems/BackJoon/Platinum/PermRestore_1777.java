package org.problems.BackJoon.Platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class PermRestore_1777 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] InversionSequence = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            InversionSequence[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> answer = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int j = InversionSequence[i];
            answer.add(answer.size() - j, i + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer n : answer) {
            sb.append(n + " ");
        }

        System.out.println(sb.toString());
    }
}
