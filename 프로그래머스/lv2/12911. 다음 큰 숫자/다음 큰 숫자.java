class Solution 
{
	
	public int solution(int n) {
		int answer = 0;
		
		int cnt = Integer.bitCount(n);
		
		for(int index =n+1;index <1000000;index++)
		{
			int idx_cnt = Integer.bitCount(index);
			
			if(idx_cnt == cnt)
			{
				answer = index;
				break;
			}
		}
		
		
		return answer;
	}
}
