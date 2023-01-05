import java.util.ArrayList;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int x_count=0;
        int not_cnt=0;
        char ch = s.charAt(0);
        
        int index = 0;
        int start = 0;
        //문자열 마지막까지 체크
        while(index < s.length())
        {
            if(ch == s.charAt(index))
            {
                x_count++;
            }else
                not_cnt++;
            
            if(x_count == not_cnt){
                answer++;
                if(index+1 < s.length())
                    ch = s.charAt(index+1);
                x_count=0;
                not_cnt=0;
            }
            index++;
        }
        if(x_count != 0 || not_cnt != 0)
            answer+=1;
        
        
        return answer;
    }
}