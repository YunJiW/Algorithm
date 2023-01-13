class Solution 
{
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right-left+1)];
        
        int check_cnt =0;
        int idx = 0;
        
        for(int row = (int)(left/n);row<=right/n;row++)
        {
            if(row == (int)(left/n))
            {
                for(int col=(int)(left%n);col<n;col++)
                {
                    if(idx < answer.length)
                        answer[idx++] = Math.max(row+1,col+1);
                    else
                        return answer;
                }
            }else
                for(int col=0;col<n;col++)
                {
                    if(idx < answer.length)
                        answer[idx++] = Math.max(row+1,col+1);
                    else
                        return answer;
                }
        }
        
        return answer;
    }
}