package org.problems.Programmers.LV2;

public class MagicElevator {
    public int solution(int storey) {
        int answer = 0;

        //do
        //2554 -446 -46 4
        //-1000 3 100 4 10 5 -1 4
        while (storey != 0) {
            int digit = storey%10;
            storey /= 10;

            if(digit == 5){
                if(storey%10 >= 5){
                    answer += 10 - digit;
                    storey++;
                }
                else
                    answer += digit;
            }
            else if(digit > 5){
                answer += 10 - digit;
                storey++;
            }
            else answer += digit;
        }

        return answer;
    }

}
