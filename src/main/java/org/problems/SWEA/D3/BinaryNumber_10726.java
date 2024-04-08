package org.problems.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinaryNumber_10726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long T = Long.parseLong(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long N = Long.parseLong(st.nextToken());
            long M = Long.parseLong(st.nextToken());



            String binary = Long.toBinaryString(M);
            String one = "";
            for (int j = 0; j < N; j++)
                one += "1";

            if(binary.length() >=N)
                if(binary.substring((int) (binary.length() - N),binary.length()).equals(one))
                    System.out.println("#" + (i+1) + " ON");
                else
                    System.out.println("#" + (i+1) + " OFF");
            else
                System.out.println("#" + (i+1) + " OFF");
        }

    }
}
