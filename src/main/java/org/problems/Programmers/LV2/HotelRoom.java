package org.problems.Programmers.LV2;

import java.time.LocalTime;
import java.util.PriorityQueue;

public class HotelRoom {

  static class BOOKTIME implements Comparable<BOOKTIME> {
    LocalTime start, end;

    public BOOKTIME(LocalTime start, LocalTime end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(BOOKTIME o) {
      int result = this.start.compareTo(o.start);
      if (result != 0) {
        return result;
      }

      return this.end.compareTo(o.end);
    }
  }

  public int solution(String[][] book_time) {
    int answer = 0;

    PriorityQueue<BOOKTIME> pq = new PriorityQueue<>();
    PriorityQueue<LocalTime> rooms = new PriorityQueue<>();

    for (int i = 0; i < book_time.length; i++) {
      pq.offer(new BOOKTIME(LocalTime.parse(book_time[i][0]), LocalTime.parse(book_time[i][1])));
    }

    while (!pq.isEmpty()) {
      BOOKTIME current = pq.poll();

      while (!rooms.isEmpty() && rooms.peek().plusMinutes(9).isBefore(current.start)) {
        rooms.poll();
      }

      rooms.offer(current.end);
      answer = Math.max(rooms.size(), answer);
    }

    return answer;
  }

  public static void main(String[] args) {
    HotelRoom h = new HotelRoom();
    String[][] timeRanges = {
            {"15:00", "17:00"},
            {"16:40", "18:20"},
            {"14:20", "15:20"},
            {"14:10", "19:20"},
            {"18:20", "21:20"}
    };

    System.out.println(h.solution(timeRanges));
  }
}
