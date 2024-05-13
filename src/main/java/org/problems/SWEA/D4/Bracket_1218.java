package org.problems.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bracket_1218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 1 ; i < 11 ; i++) {
            int L = Integer.parseInt(br.readLine());
            String str = br.readLine();

            int answer = func(str,L);
            System.out.println("#" + i + " " + answer);
        }
    }

    public static int func(String str, int L) {
        Stack<Character> s = new Stack<>();

        for(int j = 0; j < L; j++) {
            switch (str.charAt(j)) {
                case ')':
                    if(s.peek() == '(')
                        s.pop();
                    else
                        return 0;
                    break;
                case ']':
                    if(s.peek() == '[')
                        s.pop();
                    else
                        return 0;
                    break;
                case '}':
                    if(s.peek() == '{')
                        s.pop();
                    else
                        return 0;
                    break;
                case '>':
                    if(s.peek() == '<')
                        s.pop();
                    else
                        return 0;
                    break;
                default:
                    s.add(str.charAt(j));
                    break;
            }
        }
        return 1;
    }
}
