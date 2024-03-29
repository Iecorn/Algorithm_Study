package org.problems;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        int s = solution(4, 3, score);
        System.out.println("Hello world!");
    }




    static int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        int max_box = score.length/m;

        int start = score.length-m;
        int end = score.length - max_box*m;
        System.out.println("max_box = " + max_box);
        System.out.println("start = " + start);
        System.out.println("end = " + end);

        for(int i = start; i >= score.length - max_box*m; i= i-m){
            System.out.println(i);
            System.out.println("apple = " + score[i]);
            answer += score[i]*m;
        }

        return answer;
    }
}