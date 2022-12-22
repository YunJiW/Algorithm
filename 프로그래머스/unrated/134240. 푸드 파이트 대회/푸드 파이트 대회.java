class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int index = 1; index <food.length;index++)
        {
            if(food[index] != 1)
            {
                food[index] /= 2;
            }
            else
                food[index] =0;
        }
        
        for(int index =1; index <food.length;index++)
        {
            for(int check = 0; check < food[index]; check++)
            {
                answer+= String.valueOf(index);
            }
        }
        answer+="0";
        
        for(int index =food.length-1; index >0;index--)
        {
            for(int check = 0; check<food[index];check++)
            {
                answer+= String.valueOf(index);
            }
        }
        
        
        
      
        return answer;
    }
}