class Solution {
    static final int INF = 500001;
    	public int solution(int N, int[][] road,int K) 
	{
		int answer =0;
		
		int map[][] = new int[N+1][N+1];
		
		for(int row =1; row <=N;row++)
		{
			for(int col = 1; col <= N; col++)
			{
				if(row == col)
				{
					continue;
				}
				map[row][col] = INF;
			}
		}
		
		for(int index =0;index <road.length;index++)
		{
			int start = road[index][0];
			int end = road[index][1];
			int weight = road[index][2];
			
			if(map[start][end] > weight) {
				map[start][end] = weight;
				map[end][start] = weight;
			}
		}
		
		//최소 거리 가중치를 저장하기 위한 dist
		int dist[] = new int[N+1];
		for(int index = 2; index <=N;index++)
		{
            //갈수있을경우 dist를 INF말고 가중치로 갱신
			if(map[1][index] != INF)
				dist[index] = map[1][index];
			else
				dist[index] = INF;
		}
		
		
		//방문 여부 체크
		boolean visited[] = new boolean[N+1];
		visited[1] = true;
		
		for(int row = 1; row < N; row++ )
		{
			int min_idx =1;
			int min_value = INF;
			
			for(int j = 2; j <=N;j++)
			{
				if(!visited[j] && dist[j] < min_value)
				{
					min_value = dist[j];
					min_idx = j;
				}
			}
			visited[min_idx] = true;
			
			for(int j= 2; j <=N;j++)
			{
				if(dist[j] > dist[min_idx] + map[min_idx][j])
				{
					dist[j] = dist[min_idx] + map[min_idx][j];
				}
			}
			
		}
		
		for(int index =1 ;index <=N;index++)
		{
			if(dist[index] <= K) answer++;
		}
		return answer;
	}
}