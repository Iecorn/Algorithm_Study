package org.problems.Programmers.LV2;

import java.util.HashMap;
import java.util.Map;

public class Clothes {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> cnt = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < clothes.length; i++)
            cnt.put(clothes[i][1], cnt.getOrDefault(clothes[i][1], 0) + 1);

        for (String s : cnt.keySet()) {
            if (answer == 0)
                answer = cnt.get(s)+1;
            else
                answer *= cnt.get(s)+1;
        }

        answer--;

        return answer;
    }
}
