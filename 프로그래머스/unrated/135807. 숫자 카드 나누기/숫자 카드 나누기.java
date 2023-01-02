import java.util.Arrays;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        //A와 B를 정렬한다.
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int min_A = arrayA[0];
        int min_B = arrayB[0];
        
        
        //철수의 카드부터 체크
        for(int num = min_A; num > 0; num--)
        {
            int index_A =0;
            int index_B =0;
            while(index_A != arrayA.length){
                if(arrayA[index_A] % num != 0)
                    break;
                index_A++;
            }
            if(index_A == arrayA.length)
            {
                while(index_B != arrayB.length){
                    if(arrayB[index_B] % num == 0)
                        break;
                    index_B++;
                }
            }
            
            //끝까지 돌았을경우 => 전부 나눠 졌을경우
            if(index_B == arrayB.length)
                answer = Math.max(answer,num);
        }
        //민수의 카드 체크
        for(int num = min_B; num > 0; num--){
            int index_A =0;
            int index_B =0;
            while(index_B != arrayB.length){
                if(arrayB[index_B] % num != 0)
                    break;
                index_B++;
            }
            if(index_B == arrayB.length)
            {
                while(index_A != arrayA.length){
                    if(arrayA[index_A] % num == 0)
                        break;
                    index_A++;
                }
            }
            
            //끝까지 돌았을경우 => 전부 나눠 졌을경우
            if(index_A == arrayA.length)
                answer = Math.max(answer,num);
        }
            
        return answer;
    }
    
}