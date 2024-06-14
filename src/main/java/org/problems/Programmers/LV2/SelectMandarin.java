package org.problems.Programmers.LV2;

import java.util.Arrays;

public class SelectMandarin {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] mandarin = new int[10000001];

        for (int i = 0; i < tangerine.length; i++)
            mandarin[tangerine[i]] += 1;

        Arrays.sort(mandarin);

        int sum = 0;
        int index = 10000000;
        while(sum < k){
            sum += mandarin[index];
            answer++;
            index--;
        }

        return answer;
    }

    public static void main(String[] args) {
        SelectMandarin s = new SelectMandarin();
        int[] arr = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(s.solution(6, arr));
    }
}
