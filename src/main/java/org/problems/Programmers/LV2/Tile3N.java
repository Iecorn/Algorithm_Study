package org.problems.Programmers.LV2;

public class Tile3N {

    long[] tile = new long[5001];

    //2칸 패턴 = 3
    //4칸 패턴 = 2
    public int solution(int n) {
        int mod=1000000007;

        tile[0]=1;
        tile[2]=3;

        for(int i=4; i<=n; i+=2){
            tile[i] = tile[i-2] * 3;
            for(int j=i-4; j>=0; j-=2){
                tile[i] += tile[j] * 2;
            }
            tile[i] = tile[i] % mod;
        };

        return (int) tile[n];
    }

    public static void main(String[] args) {
        Tile3N t = new Tile3N();
        t.solution(4);
    }
}
