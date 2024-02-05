package org.example.LV1;

import java.util.Arrays;

public class Fruit_Seller {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        int max_box = score.length/m;

        int start = score.length-m;
        int end = score.length - max_box*m;

        for(int i = start; i >= end; i-=m){
            answer += score[i]*m;
        }

        return answer;
    }
}
