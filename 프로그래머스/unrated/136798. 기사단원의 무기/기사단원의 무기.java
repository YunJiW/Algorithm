class Solution {
      public int solution(int number, int limit, int power) {
        int answer = 0;
        
        //1부터 number까지 매치
        int check_div[] = new int[number+1];
        check_div[1] = 1;
        
        //각 개수 체크
        for(int index = 2; index <=number;index++)
        {
            int cnt = 0;
            int i = 0;
            for(int numbers = 1; numbers <= Math.sqrt(index); numbers++)
            {
                if((index % numbers == 0) && (index / numbers == numbers))
                	i+=1;
                else if(index % numbers == 0)
                	cnt+=1;
            }
            int sum_cnt = cnt *2 + i;
            
            if(sum_cnt <= limit)
                check_div[index] = sum_cnt;
            else
                check_div[index] = power;
        }
        for(int check_num: check_div) {
            answer+= check_num;
        }
        
        
        return answer;
    }
}