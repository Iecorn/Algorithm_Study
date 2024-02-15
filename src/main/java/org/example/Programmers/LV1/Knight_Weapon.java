package org.example.Programmers.LV1;

public class Knight_Weapon {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1 ; i <= number ; i++){

            int damage = countDivisors(i);

            if (damage > limit)
                answer += power;
            else
                answer += damage;
        }


        return answer;
    }

    static int countDivisors(int n)
    {
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(n); i++)
        {
            if (n % i == 0) {

                if (n / i == i)
                    cnt++;

                else
                    cnt = cnt + 2;
            }
        }
        return cnt;

    }
}
