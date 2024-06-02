package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class HelloBear_25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> s = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.equals("ENTER")){
                answer += s.size();
                s.clear();
            }
            else
                s.add(str);
        }

        answer += s.size();

        System.out.println(answer);
    }
}
