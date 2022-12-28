import java.util.Arrays;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        //각 점수를 정렬
        Arrays.sort(score);
        int index = score.length;
        
        //되는 만큼 박스만들어서 계산
        while(index > m){
            int min =Integer.MAX_VALUE;
            for(int apple = index-1; apple >= index - m;apple--)
            {
                min = Math.min(min,score[apple]);
            }
            answer += min * m;
            
            index -= m;
        }
        
        //마지막박스
        if(index == m)
        {
            answer += score[0] * m;
        }
        
        
        
        return answer;
    }
}