import java.util.Arrays;
import java.util.HashSet;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> sum_num = new HashSet<>();
        for(int index=0;index <numbers.length-1;index++)
        {
            for(int nxt=index+1; nxt<numbers.length;nxt++)
            {
                int sum = numbers[index] + numbers[nxt];
                sum_num.add(sum);
            }
        }
        
        List<Integer> sorting = new ArrayList<>(sum_num);
        Collections.sort(sorting);
        int[] answer = new int[sorting.size()];
        for(int index =0;index<sorting.size();index++)
        {
            answer[index] = sorting.get(index);
        }
        
        return answer;
    }
}