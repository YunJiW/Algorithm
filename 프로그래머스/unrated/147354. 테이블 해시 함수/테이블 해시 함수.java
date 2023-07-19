import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        //첫 번째 정렬하기
        Arrays.sort(data, (o1, o2) -> {
            //값이 같다면 첫번째 col값으로  내림차순 정렬진행
            if(o1[col -1] == o2[col -1]){
                return o2[0] - o1[0];
            }

            return o1[col-1] - o2[col-1];
        });

        int diff = row_end - row_begin +1;
        int len = data[0].length;
        int part_sum[] = new int[diff];
        for(int idx = 0; idx <diff;idx++){
            int sum = 0;

            //나눈 나머지의 합을 모아준다.
            for(int num = 0; num < len;num++){
                sum = sum + (data[row_begin + idx-1][num] % (row_begin+idx));

            }
            //그 값을 넣어준다.
            part_sum[idx] = sum;
        }


        answer = bitwiseXor(part_sum);





        return answer;
    }

    public int bitwiseXor(int[] part_sum){
        int sum = part_sum[0];

        for(int idx =1; idx <part_sum.length;idx++){
            sum ^= part_sum[idx];
        }

        return sum;
    }
}