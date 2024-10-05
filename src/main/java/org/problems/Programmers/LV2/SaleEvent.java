package org.problems.Programmers.LV2;

import java.util.HashMap;
import java.util.Map;

public class SaleEvent {
  public int solution(String[] want, int[] number, String[] discount) {
    int answer = 0;

    Map<String, Integer> havetobuy = new HashMap<>();
    Map<String, Boolean> products = new HashMap<>();

    for (int i = 0; i < want.length; i++) {
      havetobuy.put(want[i], number[i]);
      products.put(want[i], true);
    }

    for (int i = 0; i < discount.length - 9; i++) {
      if(products.getOrDefault(discount[i], false)){
        Map<String, Integer> clone = new HashMap<>(havetobuy);
        boolean flag = false;

        for (int j = 0; j < 10; j++) {
          String product = discount[i + j];
          int num = clone.getOrDefault(product, 0);

          if(!products.getOrDefault(product, false))
            break;

          if(num != 0){
            clone.put(product, num - 1);
          }

        }

        for (int j = 0; j < want.length; j++) {
          if(clone.get(want[j]) != 0){
            flag = true;
            break;
          }
        }

        if(!flag)
          answer++;
      }
    }

    return answer;
  }

}
