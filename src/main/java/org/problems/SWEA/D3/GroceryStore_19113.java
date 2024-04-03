package org.problems.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GroceryStore_19113 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            List<Long> prices = new ArrayList<>();
            List<Long> answer = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < 2 * N; j++) {
                long price = Long.parseLong(st.nextToken());
                prices.add(price);
            }

            for (int j = 0; j < N*2; j++) {
                if (prices.get(j) == 0L)
                    continue;
                for (int k = j+1; k < N*2; k++) {
                    if ((prices.get(j)*4)/3 == prices.get(k)){
                        answer.add(prices.get(j));
                        prices.set(k, 0L);
                        break;
                    }
                }
                prices.set(j, 0L);
            }

            System.out.print("#" + (i+1) + " ");
            for (Long a : answer)
                System.out.print(a + " ");
            System.out.println();

        }
    }

}
