package org.problems.BackJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Password_1759 {

    static String vowel = "aeiou";
    static boolean[] check;
    static List<String> letters = new ArrayList<>();
    static List<String> result = new ArrayList<>();
    static List<String> before = new ArrayList<>();
    static int L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        check = new boolean[C];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            letters.add(st.nextToken());
        }

        letters = letters.stream().sorted().collect(Collectors.toList());

        comb(0,0);


        for (String s : result) {
            int v = 0;
            int c = 0;

            for (int i = 0; i < s.length(); i++) {
                if(vowel.contains(String.valueOf(s.charAt(i))))
                    v++;
                else
                    c++;
            }
            if(v >= 1 && c >= 2){
                before.add(s);
            }

        }

        before.stream()
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);




    }

    public static void comb(int idx, int cnt){
        if(cnt == L){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < letters.size(); i++) {
                if(check[i])
                    sb.append(letters.get(i));
            }
            result.add(sb.toString());
            return;
        }
        if(idx == letters.size())
            return;

        check[idx] = true;
        comb(idx+1, cnt+1);
        check[idx] = false;
        comb(idx+1, cnt);
    }
}
