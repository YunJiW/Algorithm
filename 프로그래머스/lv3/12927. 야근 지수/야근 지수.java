import java.util.Collections;
import java.util.PriorityQueue;


class Solution 
{
	
	public long solution(int n, int[] works) {
		long answer =0;
		
		//일의 크기가 큰순으로 정렬
		PriorityQueue<Integer> work = new PriorityQueue<>(Collections.reverseOrder());
		for(int index = 0; index< works.length;index++)
		{
			work.offer(works[index]);
		}
		
		//야근 쳐내기
		for(int index = 0; index <n;index++) {
			int work_weight = work.poll();
			if(work_weight == 0) {
				return 0;
			}
			
			work.offer(work_weight-1);
		}
		
		while(!work.isEmpty()) {
			int weight = work.poll();
			if(weight != 0) {
				answer+= Math.pow(weight, 2);
			}
		}
		
		
		return answer;
	}


}
