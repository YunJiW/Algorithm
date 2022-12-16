class Solution {
    public String solution(String s) {
        String answer = "";
        
        //s의 길이가 1일경우
        if(s.length() == 1)
        {
            return s;
        }
        
        
        //짝수일경우
        if(s.length()%2 == 0)
        {
            int mid = (s.length()/2)-1;
            answer += String.valueOf(s.charAt(mid));
            answer += String.valueOf(s.charAt(mid+1));
            
            
            //홀수일경우
        }else{
            int mid = (s.length()/2);
            answer+= String.valueOf(s.charAt(mid));
        }

        

        return answer;
    }
}