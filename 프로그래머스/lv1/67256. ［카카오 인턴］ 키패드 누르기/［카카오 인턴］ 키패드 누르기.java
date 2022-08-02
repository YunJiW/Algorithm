
// * 0 # 은 10 11 12 로 치환해서 계산

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;
        
        for(int check : numbers){
            if(check == 1 || check == 4 || check == 7){
                answer+="L";
                left = check;
            }
            else if(check == 3 || check == 6 || check == 9){
                answer += "R";
                right = check;
            }else{
                if(check == 0) check = 11;
                    int leftdist = Math.abs(check - left)/3 + Math.abs(check - left)%3;
                    int rightdist = Math.abs(check - right)/3 + Math.abs(check - right)%3;
                    
                    if(leftdist < rightdist){
                        answer +="L";
                        left = check;
                    }
                    else if(leftdist > rightdist){
                        answer +="R";
                        right = check;
                    }
                    else{
                        if(hand.equals("left")){
                            answer+="L";
                            left = check;
                        } else{
                            answer +="R";
                            right =check;
                        }
                    }
                    
                
            }
        }
        
        
        return answer;
    }
}