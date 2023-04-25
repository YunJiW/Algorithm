import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] sequence, int k) {

        int answer[] = new int[2];

        int length = sequence.length;

        //
        int start = 0;
        int end = 0;
        //둘의 인덱스 차이
        int diff = Integer.MAX_VALUE;
        int sum_check = 0;

        while (start < length) {
            //end가 끝에 도달했을경우
            if (end == length) {
                sum_check -= sequence[start++];
                if (sum_check == k) {
                    if(diff > end - start +1){
                        answer[0] = start;
                        answer[1] = end-1;
                        diff = end - start +1;
                    }
                }

                continue;
            }
            //중간지점 계산
            if (sum_check <= k) {
                sum_check += sequence[end++];
            } else if (sum_check > k) {
                sum_check -= sequence[start++];
            }

            //sum_check 가 k와 같은경우
            if (sum_check == k) {
                if(diff > end - start +1){
                    answer[0] = start;
                    answer[1] = end-1;
                    diff = end - start +1;
                }
            }
        }



        return answer;
    }
}