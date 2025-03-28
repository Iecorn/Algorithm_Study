package org.problems.Programmers.LV2;

import java.util.LinkedList;
import java.util.Queue;

public class Server {
  Queue<Integer> servers = new LinkedList<>();

  // 서버 반납
  public void return_server(){
    if(!servers.isEmpty()){
      int n = servers.size();
      for (int i = 0; i < n; i++) {
        if(servers.peek() == 1){
          servers.poll();
        }
        else {
          servers.add(servers.poll() - 1);
        }
      }
    }
  }

  public int solution(int[] players, int m, int k) {
    int answer = 0;
    int n = 0;

    for (int i = 0; i < players.length; i++) {
      if(!servers.isEmpty())
        n = servers.size();
      int current = players[i];

      if(current >= (n+1)*m){
        // 서버 증설
        int increment = (current - n*m)/m;
        answer += increment;

        for (int j = 0; j < increment; j++) {
          servers.add(k);
        }
      }

      n = 0;
      return_server();
    }

    return answer;
  }

  public static void main(String[] args) {
    int[] numbers = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
    int a = 3;
    int b = 5;

    Server s = new Server();

    System.out.println(s.solution(numbers, a, b));
  }
}
