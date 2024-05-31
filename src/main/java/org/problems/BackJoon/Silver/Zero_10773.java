package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero_10773 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        int sum = 0;

        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                s.pop();
            else
                s.push(n);
        }

        for (Integer i : s)
            sum += i;

        System.out.println(sum);
    }
}
