 import java.util.LinkedList;

class Solution 
{
	int dx[] = { 0, 0, -1, 1 };
	int dy[] = { -1, 1, 0, 0 };

	public int solution(int[][] maps) {
		int answer = 0;

		answer = bfs(maps, 0, 0);

		return answer;
	}

	private int bfs(int[][] maps, int row, int col) {
		LinkedList<int[]> que = new LinkedList<>();
		que.offer(new int[] { row, col });
		int visited[][] = new int[maps.length][maps[0].length];
		visited[row][col] = 1;

		while (!que.isEmpty()) {
			int[] value = que.poll();
			int curx = value[0];
			int cury = value[1];

			if (curx == maps.length-1 && cury == maps[0].length-1)
				return visited[curx][cury];

			for (int index = 0; index < 4; index++) {
				int nxtx = curx + dx[index];
				int nxty = cury + dy[index];

				if (nxtx >= 0 && nxtx < maps.length && nxty >= 0 && nxty < maps[0].length && maps[nxtx][nxty] == 1) {
                    
					if (visited[nxtx][nxty] == 0) {
						que.offer(new int[] { nxtx, nxty });
						visited[nxtx][nxty] = visited[curx][cury] + 1;
					}
				}

			}

		}

		return -1;

	}
}
