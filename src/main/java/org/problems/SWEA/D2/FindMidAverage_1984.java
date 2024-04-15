package org.problems.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class FindMidAverage_1984 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;
            int count = 8;
            for (int j = 0; j < 10; j++)
                list.add(Integer.parseInt(st.nextToken()));
            list.sort(Integer::compareTo);

            for (int j = 1; j < 9; j++) {
                if(list.get(j).equals(list.get(0)) || list.get(j).equals(list.get(9)))
                    count -= 1;
                else
                    sum += list.get(j);
            }

            System.out.println("#" + (i+1) + " " + (int) Math.round((double) sum/count));
        }
    }
}
