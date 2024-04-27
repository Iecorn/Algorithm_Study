package org.problems.SWEA.D3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Flatten_1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int D = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int [] box = new int[100];
            int min = 100;
            int max = 0;
            for (int j = 0; j < 100; j++) {
                int h = Integer.parseInt(st.nextToken());
                max = Math.max(max,h);
                min = Math.min(min,h);
                box[h-1] += 1;
            }

            for (int j = 0; j < D; j++) {
                //dump
                box[min-1] -= 1;
                box[min] += 1;
                box[max-1] -= 1;
                box[max-2] += 1;
                if (box[min-1] == 0)
                    min += 1;
                if (box[max-1] == 0)
                    max -= 1;
                if (max == min)
                    break;
            }
            System.out.println("#" + (i+1) + " " + (max-min));
        }
    }
}
