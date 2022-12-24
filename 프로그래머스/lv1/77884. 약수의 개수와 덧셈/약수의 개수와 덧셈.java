class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        int gcd_cnt[] = new int[right - left +1];
        for(int number = left; number<=right;number++)
        {
            int cnt =0;
            int middle= 0;
            for(int index =1; index <=Math.sqrt(number);index++)
            {
                if(number % index == 0 && number / index == index)
                {
                    middle +=1;
                }       
                else{
                    cnt++;
                }
            }
            
            gcd_cnt[number-left] = cnt *2 + middle;
        }
        
        for(int check = left; check <= right; check++)
        {
            if(gcd_cnt[check - left] % 2==0)
                answer+= check;
            else
                answer-= check;
        }
        
        
        return answer;
    }
}