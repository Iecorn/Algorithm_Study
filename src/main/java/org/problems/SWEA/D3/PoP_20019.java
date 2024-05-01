package org.problems.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PoP_20019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            String str = br.readLine();
            boolean flag = true;
            for(int j = 0; j < (int) str.length()/2 ; j++) {
                if(str.charAt(j) != str.charAt(str.length()/2+j+1)) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.println("#" + (i+1) + " YES");
            else
                System.out.println("#" + (i+1) + " NO");
        }
    }
}
