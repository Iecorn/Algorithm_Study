package org.problems.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NoGlasses_7272 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());



        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String Word1 = st.nextToken();
            String Word2 = st.nextToken();
            String AlterWord1 = "";
            String AlterWord2 = "";
            boolean flag = false;

            for (int j = 0; j < Word1.length(); j++) {
                if (Word1.length() != Word2.length()){
                    flag = true;
                    break;
                }
                AlterWord1 += AlterChar(String.valueOf(Word1.charAt(j)));
                AlterWord2 += AlterChar(String.valueOf(Word2.charAt(j)));
            }

            if (AlterWord1.equals(AlterWord2) & !flag)
                System.out.println("#" + (i+1) + " SAME");
            else if (flag | !AlterWord1.equals(AlterWord2))
                System.out.println("#" + (i+1) + " DIFF");
        }

    }

    public static String AlterChar(String c){
        String hole0 = "CEFGHIJKLMNSTUVWXYZ";
        String hole1 = "ADOPQR";

        if(hole0.contains(c))
            return "0";
        else if (hole1.contains(c))
            return "1";
        return "2";
    }
}
