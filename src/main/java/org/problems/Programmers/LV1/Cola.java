package org.problems.Programmers.LV1;

public class Cola {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while(n > a-1){
            int quo = n/a;
            int remain = n%a;
            answer += b*quo;
            n = remain + quo*b;
        }

        return answer;
    }
}
