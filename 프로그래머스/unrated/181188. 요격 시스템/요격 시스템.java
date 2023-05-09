import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        //미사일 첫 구역 정렬
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int pre = 0;

        for(int idx = 0; idx <targets.length;idx++){
            if(pre <= targets[idx][0]){
                pre = (targets[idx][1]);
                System.out.println("pre = " + pre);
                answer++;
            }
        }

        return answer;
    }
}