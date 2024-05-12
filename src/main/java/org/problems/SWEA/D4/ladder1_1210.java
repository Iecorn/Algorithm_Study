package org.problems.SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ladder1_1210 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0 ; i < 10 ; i++) {
            int T = Integer.parseInt(br.readLine());
            int[][] ladders = new int[100][100];
            for(int j = 0; j < 100; j++) {
                st = new StringTokenizer(br.readLine()," ");
                for(int k = 0; k < 100; k++)
                    ladders[j][k] = Integer.parseInt(st.nextToken());
            }

            int answer = startGame(ladders);

            System.out.println("#" + T + " " + answer);

        }
    }

    public static int startGame(int[][] ladder) {
        int answer = 0;
        int[] xmove = {0, 0, 1}; // left, right, down
        int[] ymove = {1, -1, 0}; // left, right, down

        boolean flag = true;

        for(int i = 0; i < 100; i++) {
            answer = i;
            int x = 0;
            int y = i;
            flag = true;
            int[][] visited = new int[100][100];

            if(ladder[x][y] == 0)
                continue;

            while(flag) {
                visited[x][y] = 1;

                if(ladder[x][y] == 2)
                    return answer;
                else if(x == 99)
                    break;
                else {
                    for(int j = 0 ; j < 3; j++) {
                        if(y + ymove[j] == -1 || y + ymove[j] == 100)
                            continue;
                        else if(ladder[x + xmove[j]][y + ymove[j]] != 0 && visited[x + xmove[j]][y + ymove[j]] == 0) {
                            x += xmove[j];
                            y += ymove[j];
                            break;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
