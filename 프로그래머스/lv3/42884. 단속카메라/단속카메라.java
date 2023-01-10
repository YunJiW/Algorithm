import java.util.Arrays;
import java.util.Comparator;

class Solution 
{
	public int solution(int[][] routes) {
		
		Arrays.sort(routes,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[0]-o2[0];
				return o1[1] - o2[1];
			}
			
		});
		
		int cnt = 0;
		int pre = -30000;
		
		for(int index = 0;index <routes.length;index++) {
			if(pre < routes[index][0])
			{
				pre=routes[index][1];
				cnt++;
			}
		}
		
		
		return cnt;
	}

}