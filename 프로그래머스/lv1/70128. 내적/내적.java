class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        
        for(int num = 0 ;num<a.length;num++)
            answer += a[num] *b[num];
            
        return answer;
    }
}