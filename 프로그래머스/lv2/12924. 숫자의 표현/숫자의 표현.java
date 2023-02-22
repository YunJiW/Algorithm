class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int start =0;
        int end = 1;
        int sum = 0;
        if(n == 1)
            return 1;
        while(start <= n){
            if(sum > n || end > n){
                sum -= start;
                start+=1;
            }else{
                sum+= end;
                end+=1;
            }
            if(sum == n)
                answer+=1;
        }
        
         
        return answer;
    }
}