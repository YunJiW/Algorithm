import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        int Solders = n;


        PriorityQueue<Integer> enemyQueue = new PriorityQueue<>();
        //무적권보다 작거나 같으면 그냥 라운드 리턴하면됨.
        if (k >= enemy.length)
            return enemy.length;

        for (int index = 0; index < enemy.length; index++) {
            //병사수가 적 병사보다 크거나 같은경우 진행
            if (Solders >= enemy[index]) {
                Solders -= enemy[index];
                enemyQueue.offer(-enemy[index]);
                answer += 1;

                //병사수가 적을 때 무적권이 있는 경우
            } else if (k != 0) {
                k -= 1;
                if (!enemyQueue.isEmpty()) {
                    //이전 적의 병사가 더 많은 경우가 있을 때
                    if (-enemyQueue.peek() > enemy[index]) {
                        Solders = Solders + (Math.abs(enemyQueue.poll()) - enemy[index]);
                        enemyQueue.offer(-enemy[index]);
                        //이전 적의 병사가 더 적은 경우
                    }
                }
                answer += 1;
            } else {
                break;
            }
        }
        return answer;
    }
}