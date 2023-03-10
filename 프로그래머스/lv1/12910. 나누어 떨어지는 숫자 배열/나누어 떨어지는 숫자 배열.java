import java.util.Arrays;
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        

        Arrays.sort(arr);
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int idx = 0; idx <arr.length;idx++){
            if(arr[idx] % divisor == 0){
                ans.add(arr[idx]);
            }
        }
        if(ans.size() == 0){
            return new int[]{-1};
        }
        int answer[] = new int[ans.size()];
        
        
        for(int idx = 0; idx <ans.size();idx++){
            answer[idx] = ans.get(idx);
        }
        return answer;
    }
}