import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        boolean flag = true;
        
        
        //지나간 단어들을 넣어줄 hashSet
        HashSet<String> word = new HashSet<>();
        
        //현재 누구 턴인지 체크 turn round 돈 횟수
        int turn = 1;
        int round = 1;
        
        word.add(words[0]);
        
        //말한 단어체크
        String sp_word = words[0];
        for(int index =1 ; index < words.length;index++)
        {
            turn+=1;
            
            if(turn % n == 1)
            {
                turn = 1;
                round++;
            }
            //이전 끝 문자
            char before_word = sp_word.charAt(sp_word.length() -1);
            
            sp_word = words[index];
            
            //제대로 말했을 경우
            if(before_word == sp_word.charAt(0) && !word.contains(sp_word))
            {
                word.add(sp_word);
            }else
            {
                flag = false;
                break;
                
            }

            

            
        }
        
        if(!flag){
            answer[0] = turn;
            answer[1] = round;
        }
        else{
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}