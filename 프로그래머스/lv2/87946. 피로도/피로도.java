class Solution
{
	int Max = Integer.MIN_VALUE;
	public int solution(int k ,int[][] dungeons) {
		
		//순서를 매기고 그 순서로 돌경우 던전을 몇개 도는지 체크
		boolean check[] = new boolean[dungeons.length];
		
		int turn[] = new int[dungeons.length];
		run(0,check,dungeons,turn,k);
		
		
		return Max;
	}

	private void run(int depth, boolean[] check, int[][] dungeons, int[] turn, int k) {
		if(depth == dungeons.length)
		{
			Max = Math.max(Max, dungeons_check(turn,dungeons,k));
		}
		
		
		for(int index =0; index <dungeons.length;index++)
		{
			if(!check[index]) {
				check[index] = true;
				turn[depth] = index;
				run(depth+1,check,dungeons,turn,k);
				check[index] = false;
			}
		}

		
	}

	private int dungeons_check(int[] turn, int[][] dungeons,int k) {
		
		int cnt = 0;
		for(int turns : turn)
		{
			//최소 피로도를 넘기면서 
			if( k >=dungeons[turns][0])
			{
				k -= dungeons[turns][1];
				cnt++;
			}
		}
		
		
		
		return cnt;
	}

}
