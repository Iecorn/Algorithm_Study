package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GroupWordChecker_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            List<String> alphas = new ArrayList<>();
            String word = br.readLine();
            String before = null;
            boolean flag = true;

            for (String s : word.split("")) {
                // 없을때
                if (!alphas.contains(s)) {
                    alphas.add(s);
                    before = s;
                }
                // 있는데 이전에 나온거 일때
                else if ((alphas.contains(before) && !before.equals(s))){
                    flag = false;
                    break;
                }
            }
            if (flag)
                result++;
        }
        System.out.println(result);
    }
}

