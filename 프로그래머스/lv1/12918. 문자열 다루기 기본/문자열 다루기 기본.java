class Solution {
    public boolean solution(String s) {
        boolean answer = false;

        if(s.length() == 4 || s.length() == 6)
        {
            for(int idx = 0 ; idx < s.length();idx++)
            {
                if(s.charAt(idx) < '0' || s.charAt(idx) > '9'){
                    
                    return false;
                }
            }
            
            return true;
        }

        return answer;
    }
}
