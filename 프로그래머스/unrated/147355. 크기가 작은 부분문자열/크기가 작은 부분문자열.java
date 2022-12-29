class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        //숫자 길이 만큼 자름
        int len = p.length();
        Long p_int = Long.parseLong(p);
        
        for(int index = 0; index <t.length();index++)
        {
            //t의 문자열 안쪽에서만 되기 때문에
            //t의 범위를 넘어가지않을 경우만 실행
            if(index + p.length()  <= t.length())
            {
                String check = t.substring(index,len);
                
                if(p_int >= Long.parseLong(check))
                    answer++;
            }
            len++;
            
            
        }
        
        
        
        return answer;
    }
}