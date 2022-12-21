class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown+yellow;
        //가로
        int row = 3;
        //세로
        int col = 0;
        while(true)
        {
               if(sum % row == 0)
               {
                   if(row < sum/row)
                   {
                       row++;
                       continue;
                   }
                   else if((row -2)*((sum/row)-2) == yellow)
                   {
                       col = sum/row;
                       break;
                   }
                   else
                       row++;
                       
               }else
                   row++;
        }
        answer[0] = row;
        answer[1] = col;
        return answer;
    }
}