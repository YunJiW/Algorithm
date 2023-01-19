import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for(int index = 0; index <citations.length;index++){
            int h = citations.length-index;

            if(citations[index] >= h){
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}