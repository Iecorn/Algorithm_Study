package org.problems.Programmers.LV2;

import java.util.ArrayList;
import java.util.List;

public class Visit_Lenth {
    static List<String> history = new ArrayList<>();
    public int solution(String dirs) {
        int answer = 0;
        int x = 0;
        int y = 0;

        for (char c : dirs.toCharArray()) {
            String before = Integer.toString(x) + Integer.toString(y);
            switch (c){
                case 'U':
                    if (y < 5)
                        y += 1;
                    break;
                case 'D':
                    if (y > -5)
                        y -= 1;
                    break;
                case 'R':
                    if (x < 5)
                        x += 1;
                    break;
                case 'L':
                    if (x > -5)
                        x -= 1;
                    break;
            }

            String after = Integer.toString(x) + Integer.toString(y);

            if(!history.contains(before+after) & !after.equals(before)){
                history.add(before+after);
                history.add(after+before);
                answer += 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Visit_Lenth v = new Visit_Lenth();
        v.solution("LULLLLLLU");
    }
}

