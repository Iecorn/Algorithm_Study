package org.problems.Programmers.LV2;

import java.util.Stack;

public class BracketRotate {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            answer += check(s);
            s = rotate(s);
        }

        return answer;
    }

    public int check(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case ')':
                    if (!stack.isEmpty() && stack.peek().equals('(')) {
                        stack.pop();
                        break;
                    } else
                        return 0;
                case ']':
                    if (!stack.isEmpty() && stack.peek().equals('[')) {
                        stack.pop();
                        break;
                    } else
                        return 0;
                case '}':
                    if (!stack.isEmpty() && stack.peek().equals('{')) {
                        stack.pop();
                        break;
                    } else
                        return 0;
                default:
                    stack.push(s.charAt(i));
            }
        }

        if (stack.isEmpty())
            return 1;

        return 0;
    }

    public String rotate(String s) {
        return s.substring(1, s.length()) + s.charAt(0);
    }

    public static void main(String[] args) {
        BracketRotate b = new BracketRotate();
        String str = "[](){}";
        System.out.println(str.substring(1, str.length()) + str.charAt(0));
        System.out.println(b.solution("[](){}"));
    }
}
