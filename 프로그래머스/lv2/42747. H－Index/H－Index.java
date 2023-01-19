import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer =0;
        //내림차순정렬
        Arrays.sort(citations);
        
        


        int H_idx=1;
        //0 1 3 5 6
        for(int count =0; count <=10000;count++){
            int over = 0;
            int under = 0;
            for(int index =0; index < citations.length;index++)
            {
                if(citations[index] >= count )
                {
                    over+=1;
                }

            }
            under = citations.length - over;
            System.out.println(over);
            System.out.println(under);
            if(over >= count && under < count){
                answer = count;
                break;
            }
        }
        
        
        return answer;
    }
}