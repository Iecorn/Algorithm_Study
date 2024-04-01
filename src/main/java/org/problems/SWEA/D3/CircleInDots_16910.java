package org.problems.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CircleInDots_16910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            int r = Integer.parseInt(br.readLine());

            int dots = line_dots(r) + Quadrant_dots(r);

            System.out.println("#" + (i+1) + " " + dots);
        }
    }

    public static int line_dots(int r){
        //(0,0)
        int dots = 1;

        for(int i = 1; i <= r; i++){
            dots += 4;
        }

        return dots;
    }

    public static int Quadrant_dots(int r){
        int dots = 0;

        //Start (1,1)
        for(int i = 1; i < r; i++)
            for(int j = 1; j < r; j++)
                if(Math.pow(i,2)+Math.pow(j,2) <= Math.pow(r,2))
                    dots += 4;

        return dots;
    }
}
