class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int max  =0;
        for(int idx : section){
            if(max > idx) continue;

            answer+=1;
            max = idx + m;
        }



        return answer;
    }
}