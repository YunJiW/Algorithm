class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        
        int len = numbers.length;
        //중복체크
        boolean check[] = new boolean[numbers.length];
        
        dfs(0,numbers,target,0);
        
        
        return answer;
    }
    
    public void dfs(int depth,int[] numbers,int target,int sum)
    {
        if(depth == numbers.length)
        {
            if(sum == target)
                answer+=1;
            return;
        }
        
        dfs(depth+1,numbers,target,sum + numbers[depth]);
        dfs(depth+1,numbers,target,sum - numbers[depth]);
    }
}