import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        ArrayList<Integer> Fame = new ArrayList<>();
        
        for(int index =0; index < score.length;index++)
        {
            //K보다 작을경우
            if(Fame.size() <k)
            {
                Fame.add(score[index]);
            
                Collections.sort(Fame,Collections.reverseOrder());
                answer[index] = Fame.get(Fame.size()-1);
            }
            
            else{
                Fame.add(score[index]);
                Collections.sort(Fame,Collections.reverseOrder());
                Fame.remove(Fame.size()-1);
                answer[index] = Fame.get(Fame.size()-1);
            }
        }
        
        
        
        return answer;
    }
}