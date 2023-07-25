import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        //정렬
        Arrays.sort(times);

        long left = 0;
        long right = (long)n * times[times.length - 1];

        while(left <= right){
            long mid = (left +right)/2;
            long sum = 0;
            for(int idx=0;idx< times.length;idx++){
                sum += mid/times[idx];
            }

            if(sum <n){
                left =mid+1;

            }else{
                right = mid -1;
                answer= mid;
            }
        }


        return answer;
    }
}