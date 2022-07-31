class Solution {
    //소수 판별용
    public boolean Prime(int n){
        if(n == 1)
            return false;
        else{
            for(int check = 2; check < n ; check++)
                if(n % check == 0)
                    return false;
        }
        return true;
    }
    public int solution(int[] nums) 
    	{
		int answer = 0;
		int num_sum = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++)
				for (int k = j + 1; k < nums.length; k++) {
					num_sum = nums[i] + nums[j] + nums[k];
					if (Prime(num_sum)) {
						answer++;
					}
				}
		}

		return answer;
		
		
	}
}