class Solution 
{
    public int[] solution(int n, int s) {
        int[] answer = new int[n];


        //들어갈수 없을때
        if(s/n == 0){
        	int impossible[] = {-1};
            return impossible;
        }

        //아닌경우
        for(int index =0 ;index <answer.length;index++)
        {
        	answer[index] = s/n;
        	s -= answer[index];
        	n -=1;
        }
        


        return answer;
    }
}