package org.problems.BackJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WordStudy_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        long max = 0;

        for (String alpha : br.readLine().split("")){
            alpha = alpha.toUpperCase();
            if(map.containsKey(alpha)){
                if(map.get(alpha) + 1 > max){
                    max = map.get(alpha) + 1;
                    list.clear();
                    list.add(alpha);
                }
                else if (map.get(alpha) + 1 == max)
                    list.add(alpha);

                map.put(alpha, map.get(alpha)+1);
            }
            else{
                if (max == 0){
                    list.add(alpha);
                    max = 1;
                }
                else if (max == 1)
                    list.add(alpha);
                map.put(alpha, 1);
            }

        }

        if(list.size() == 1)
            System.out.println(list.get(0));
        else
            System.out.println("?");
    }
}
