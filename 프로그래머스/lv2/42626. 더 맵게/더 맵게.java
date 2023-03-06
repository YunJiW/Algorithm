import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> List = new PriorityQueue<>();
        //정렬
        for(int idx = 0; idx <scoville.length;idx++){
            List.offer(scoville[idx]);
        }
        while(true){
            //큐의 크기가 1보다 작을경우 그값이 K보다 작은경우 -1 리턴
            if(List.size() <= 1){
                if(List.poll() < K){
                    return -1;
                }
                else {
                    return answer;
                }
            }
            else{
                int first = List.poll();
                int second = List.poll();
                //첫번째 뽑은 값이 K이상일경우 계산 끝
                if(first >= K)
                    break;

                //계산후 값을 다시 넣어준다.
                int sum = first + (second *2);
                List.offer(sum);
                answer+=1;
            }
        }
        return answer;
    }
}