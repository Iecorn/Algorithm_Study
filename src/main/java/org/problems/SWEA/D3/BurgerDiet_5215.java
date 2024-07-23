package org.problems.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BurgerDiet_5215 {
    static int[] kcal, taste;
    static int L,N,max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            taste = new int[N];
            kcal = new int[N];
            max = Integer.MIN_VALUE;

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                taste[j] = Integer.parseInt(st.nextToken());
                kcal[j] = Integer.parseInt(st.nextToken());
            }

            dfs(0,0,0);

            System.out.printf("#%d %d %n", i + 1, max);
        }
    }

    public static void dfs(int cnt, int calSum, int tasteSum) {
        if(calSum > L)
            return;
        if(cnt == N){
            if(calSum <= L)
                max = Math.max(max, tasteSum);
            return;
        }

        dfs(cnt+1, calSum+ kcal[cnt], tasteSum + taste[cnt]);
        dfs(cnt+1, calSum, tasteSum);
    }


// 그리디 14/20 정답률
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int T = Integer.parseInt(br.readLine());
//        for (int i = 0; i < T; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int answer = 0;
//            int N = Integer.parseInt(st.nextToken());
//            int L = Integer.parseInt(st.nextToken());
//            ArrayList<Food> foods = new ArrayList<>();
//            for (int j = 0; j < N; j++) {
//                st = new StringTokenizer(br.readLine(), " ");
//                int Taste = Integer.parseInt(st.nextToken());
//                int Kcal = Integer.parseInt(st.nextToken());
//                double Godcost = (double) Taste/Kcal;
//                foods.add(new Food(Kcal, Taste ,Godcost));
//            }
//
//            Collections.sort(foods, Collections.reverseOrder());
//
//            int sum = 0;
//
//            for (int j = 0; j < N; j++) {
//                int getKcal = foods.get(j).Kcal;
//                if(L >= sum + getKcal){
//                    sum += getKcal;
//                    answer += foods.get(j).Taste;
//                    System.out.println(foods.get(j).Taste);
//                }
//            }
//
//            System.out.printf("#%d %d %n", i+1, answer);
//        }
//    }
//
//    static class Food implements Comparable<Food> {
//        int Kcal;
//        int Taste;
//        double Godcost;
//
//        public Food(int kcal, int taste, double godcost) {
//            Kcal = kcal;
//            Taste = taste;
//            Godcost = godcost;
//        }
//
//        @Override
//        public int compareTo(Food o) {
//            double epsilon = 0.00001;
//            if(Math.abs(this.Godcost-o.Godcost) < epsilon)
//                return 0;
//            else if (this.Godcost < o.Godcost)
//                return -1;
//            else
//                return 1;
//        }
//    }
}
