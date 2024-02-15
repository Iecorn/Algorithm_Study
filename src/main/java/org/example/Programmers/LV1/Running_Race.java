package org.example.Programmers.LV1;

import java.util.HashMap;

public class Running_Race {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> player_map = new HashMap<>();

        for(int i = 1; i <= players.length; i++)
            player_map.put(players[i-1], i);

        for (String calling : callings) {
            int value = player_map.get(calling);
            String forward = players[value - 2];

            player_map.put(calling, value-1);
            player_map.put(forward, value);

            players[value-2] = players[value-1];
            players[value-1]=forward;
        }

        return players;
    }
}
