package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class StringSet_14425 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < N; i++)
            map.put(br.readLine(), true);

        for (int i = 0; i < M; i++)
            if(map.getOrDefault(br.readLine(), false))
                answer++;

        System.out.println(answer);
    }
}
