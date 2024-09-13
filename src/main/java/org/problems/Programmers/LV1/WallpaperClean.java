package org.problems.Programmers.LV1;

public class WallpaperClean {
    public int[] solution(String[] wallpaper) {
        int l = wallpaper[0].length(); // +1 해야지 가로 길이
        int h = wallpaper.length; // +1 해야지 세로 길이
        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int x = 0; x < h; x++) {
            for (int y = 0; y < l; y++) {
                if(wallpaper[x].charAt(y) == '#'){
                    answer[0] = Math.min(answer[0], x);
                    answer[1] = Math.min(answer[1], y);
                    answer[2] = Math.max(answer[2], x+1);
                    answer[3] = Math.max(answer[3], y+1);
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        WallpaperClean w = new WallpaperClean();
        String[] arr = {".#...", "..#..", "...#."};
        int[] answer = w.solution(arr);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}
