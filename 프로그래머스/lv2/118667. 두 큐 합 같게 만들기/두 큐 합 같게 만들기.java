import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long all_sum = 0;

        long max = queue1.length*4;
        for(int idx= 0; idx <queue1.length;idx++)
        {
            all_sum += queue1[idx];
            all_sum += queue2[idx];
        }
        all_sum /=2;


        //각 큐의 값 갱신용
        long queue1_sum = 0;
        long queue2_sum = 0;

        Queue<Integer> Q1 = new LinkedList<>();
        Queue<Integer> Q2 = new LinkedList<>();

        for(int idx= 0; idx <queue1.length;idx++)
        {
            //가장 큰값이 현재 둘이 가져야하는 값보다 크면 -1 리턴
            if(all_sum < queue1[idx] || all_sum < queue2[idx])
                return -1;
            queue1_sum += queue1[idx];
            Q1.offer(queue1[idx]);

            queue2_sum += queue2[idx];
            Q2.offer(queue2[idx]);
        }

        while(queue1_sum != all_sum && queue2_sum != all_sum){
            if(queue1_sum > all_sum){
                int num = Q1.poll();
                queue1_sum-= num;

                Q2.offer(num);
                queue2_sum+=num;

                answer+=1;
                continue;
            }

            if(queue2_sum > all_sum){
                int num = Q2.poll();
                queue2_sum-= num;

                Q1.offer(num);
                queue1_sum+=num;
                answer+=1;
            }

            if(answer > max)
                return -1;
        }
        return answer;
    }
}