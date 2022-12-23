class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int check =0;
        
        for(int index =0 ;index < seoul.length;index++)
        {
            if(seoul[index].equals("Kim"))
            {
                check = index;
                break;
            }
        }
        
        answer ="김서방은 " + String.valueOf(check)+"에 있다";
        return answer;
    }
}