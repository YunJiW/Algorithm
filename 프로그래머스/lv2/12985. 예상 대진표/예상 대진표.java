class Solution
{
    public int solution(int n, int a, int b)
    {
        
        int cnt =1;

        while(Math.abs(a-b) != 1 || a/2 == b/2){
            a = nxt_number(a);
            b = nxt_number(b);
            cnt++;
        }
        
        return cnt;
    }
    
    public int nxt_number(int number){
        if(number % 2==0)
        {
            number /= 2;
        }
        else{
            number = number/2 +1;
        }
        
        return number;
    }
}