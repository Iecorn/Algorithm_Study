package org.problems.BackJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartLink_14889 {
    static int N;
    static boolean[] check;
    static int Min = Integer.MAX_VALUE;
    static int[][] array;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        array = new int[N][N];
        check = new boolean[N];


        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0,0);

        System.out.println(Min);
    }

    public static void comb(int idx,int cnt){
        if(cnt == N/2){
            score();
            return;
        }
        if(idx == N)
            return;

        check[idx] = true;
        comb(idx+1, cnt+1);
        check[idx] = false;
        comb(idx+1, cnt);
    }

    public static void score(){
        //반대팀
        int start = 0, link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i+1; j < N; j++) {
                if(check[i] && check[j]){
                    start += array[i][j] + array[j][i];
                }
                else if(!check[i] && !check[j]){
                    link += array[i][j] + array[j][i];
                }
            }
        }

        int result = Math.abs(start-link);
        if(result == 0){
            System.out.println(0);
            System.exit(0);
        }

        Min = Math.min(Min,result);
    }
}
