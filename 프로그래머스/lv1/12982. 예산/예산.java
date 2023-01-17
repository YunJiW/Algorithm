import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        for(int index = 0;index <d.length;index++)
        {
            if(d[index] <= budget)
            {
                answer+=1;
                budget -= d[index];
            }
            else
                break;
        }
        
        
        return answer;
    }
}