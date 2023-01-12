import java.util.LinkedList;

class Solution
{
	
	int map[][];
	int Min= Integer.MAX_VALUE;
	
	public int solution(int n, int[][] wires) {
		
		int answer = -1;
		map = new int[n+1][n+1];
		
		
		
		for(int index =0; index < wires.length;index++)
		{
			int a=wires[index][0];
			int b=wires[index][1];
			
			map[a][b] = map[b][a] = 1;
		}
		
		for(int index =0;index<wires.length;index++)
		{
			int a=wires[index][0];
			int b=wires[index][1];
			
			//연결을 끊고
			map[a][b] = map[b][a] = 0;
			Min = Math.min(Min, check(n,a));
			
			//다시 연결
			map[a][b] = map[b][a] = 1;
		}
		
		
		return Min;
	}

	private int check(int n, int a) {
		boolean visited[] = new boolean[n+1];
		LinkedList<Integer> qu = new LinkedList<>();
		qu.offer(a);
		visited[a] = true;
		
		int cnt = 1;
		while(!qu.isEmpty())
		{
			int start = qu.poll();
			for(int index =1; index <=n;index++)
			{
				if(visited[index]) continue;
				
				if(map[start][index] == 1)
				{
					qu.offer(index);
					visited[index] = true;
					cnt++;
				}
			}
		}
		
		
		
		return Math.abs(cnt*2 - n);
	}
}