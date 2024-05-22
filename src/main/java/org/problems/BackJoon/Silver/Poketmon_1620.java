package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Poketmon_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        Map<Integer, String> pokedex1 = new HashMap<Integer, String>();
        Map<String, Integer> pokedex2 = new HashMap<>();
        for (int i = 1; i < N+1; i++) {
            String poketmon = br.readLine();
            pokedex1.put(i, poketmon);
            pokedex2.put(poketmon, i);
        }
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if(Character.isDigit(str.charAt(0)))
                System.out.println(pokedex1.get(Integer.parseInt(str)));
            else
                System.out.println(pokedex2.get(str));
        }
    }
}
