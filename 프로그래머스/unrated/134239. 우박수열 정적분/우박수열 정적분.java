import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        List<Part> parts = new ArrayList<>();
        int cnt =0;

        Part part = new Part();
        part.x = cnt++;
        part.y = k;
        parts.add(part);
        //콜리츠의 추측
        while(k > 1){
            if(k % 2 == 0){
                k = k/2;
            }
            else {
                k = k * 3 + 1;
            }

            part = new Part();
            part.x = cnt++;
            part.y = k;

            parts.add(part);
        }

        double part_sum[] = new double[parts.size()-1];

        part_sum[0] = (double)(parts.get(0).y + parts.get(1).y)/2;
        //각 범위별 구역넓이
        for(int idx = 1; idx < part_sum.length;idx++) {
            part_sum[idx] = part_sum[idx-1] + ((double)(parts.get(idx).y + parts.get(idx+1).y)/2);
        }



        for(int index = 0; index< ranges.length;index++){
            //b의 값이 0이거나 음수인경우
            if(ranges[index][1] <= 0){
                ranges[index][1] = cnt + ranges[index][1] - 1;
            }

            //앞의 점이 더 큰경우
            if(ranges[index][0] > ranges[index][1]){
                answer[index] = -1;
                continue;
            }

            int start = ranges[index][0];
            int end = ranges[index][1];

            if(start == 0 && end != 0){
                answer[index] = part_sum[end-1];

            }else if(start == end){
                answer[index] = 0;

            }else{
                answer[index] = part_sum[end-1] - part_sum[start -1];
            }

        }
        return answer;
    }

    public class Part{
        int x;
        int y;

    }
}