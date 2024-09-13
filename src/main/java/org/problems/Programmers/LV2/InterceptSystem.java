package org.problems.Programmers.LV2;

import java.util.Arrays;
import java.util.Comparator;

public class InterceptSystem {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        for (int i = 0; i < targets.length; i++) {
            if(cnt <= targets[i][0]){
                cnt = targets[i][1];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        InterceptSystem i = new InterceptSystem();
        int[][] array = {
                {4, 5},
                {4, 8},
                {10, 14},
                {11, 13},
                {5, 12},
                {3, 7},
                {1, 4}
        };

        i.solution(array);


    }
}
