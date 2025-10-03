package org.problems.Programmers.LV2;

import java.util.HashMap;
import java.util.Map;

public class KakaoCache {
  public int solution(int cacheSize, String[] cities) {
    int answer = 0;
    int len = cities.length;
    Map<String, Integer> map = new HashMap<>();

    if (cacheSize == 0) {
      return cities.length * 5;
    }

    for (int i = 0; i < len; i++) {
      String currentCity = cities[i].toUpperCase();
      Integer index = map.getOrDefault(currentCity, -1);

      if(index < 0){
        if(map.size() >= cacheSize){
          int min = Integer.MAX_VALUE;
          String removeCity = null;
          for (String s : map.keySet()) {
            if(map.get(s) < min){
              min = map.get(s);
              removeCity = s;
            }
          }

          map.remove(removeCity);
        }
        map.put(currentCity, i);
        answer += 5;
      } else {
        map.put(currentCity, i);
        answer += 1;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    int n = 3;
    String[] cities = {"a", "b", "a", "c", "d", "a"};

    KakaoCache c = new KakaoCache();
    System.out.println(c.solution(n, cities));
  }
}
