package org.problems.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArmFight_13547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i < T+1; i++) {
            String str = br.readLine();
            int o = 0;
            int x = 0;
            for(int j=0; j < str.length(); j++) {
                if (str.charAt(j) == 'o')
                    o++;
                else
                    x++;
            }

            if(x >= 8)
                System.out.println("#" + i + " NO");
            else
                System.out.println("#" + i + " YES");
        }
    }
}
