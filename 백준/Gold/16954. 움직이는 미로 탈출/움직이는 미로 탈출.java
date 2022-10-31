import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.LinkedList;


public class Main {
	//욱제와 벽들의 좌표 체크
	static class Point{
		int row;
		int col;
		
		Point(int x, int y){
			this.row = x;
			this.col = y;
			
		}
		
		
	}
	
	//벽이 욱제와 만나는지 체크용
	static boolean[][] visit;
	static char[][] Map = new char[8][8];
	
	//욱제 캐릭 위치 체크용
	static Point body = new Point(7,0);
	
	//벽 개수
	static Point[] Wall;
	static int Wall_cnt = 0;
	
	static int dx[] = {1,1,1,0,0,0,-1,-1,-1};
	static int dy[] = {-1,0,1,-1,0,1,-1,0,1};
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		//벽의 개수가 정해진게 아니기때문에 최대 개수로 저장
		Wall = new Point[8*8];
		
		for(int row =0; row <8; row++)
		{
			String Line = br.readLine();
			for(int col =0; col <8; col++)
			{
				Map[row][col] = Line.charAt(col);
				if(Map[row][col] == '#') {
					Wall[Wall_cnt++] = new Point(row,col);
				}
			}
		}
		
		if(Run()) {
			System.out.print(1);
		}else
			System.out.print(0);
		
		
	}
	
	private static void print() {
		
		for(int cnt =0; cnt < Wall_cnt;cnt++)
		{
			Map[Wall[cnt].row][Wall[cnt].col] = '#';
		}
		
		for(int row =0; row <8; row++)
		{
			for(int col =0; col <8; col++)
			{
				System.out.print(Map[row][col]);
			}
			System.out.println();
		}
		System.out.println();
		
	}

	private static boolean Run() {
		Queue<Point> q = new LinkedList<>();
		q.offer(body);
		
		
		boolean visited[][];
		
		while(!q.isEmpty())
		{
			int move = q.size();
			
			//중복으로 가는곳 제외시키기
			visited = new boolean[8][8];
			
			for(int index =0; index < move; index++)
			{
				Point cur = q.poll();
				
				if(Map[cur.row][cur.col] == '#')
					continue;
				if(cur.row == 0 && cur.col == 7)
					return true;
				
				//8방향 체크
				for(int dir = 0; dir < 9 ;dir++)
				{
					int m_row = cur.row + dx[dir];
					int m_col = cur.col + dy[dir];
					
					//바깥일경우 제외
					if(m_row < 0 || m_row >= 8 || m_col < 0 || m_col >= 8)
						continue;
					
					//벽이거나 이미 방문했으면 제외
					if(Map[m_row][m_col] == '#' || visited[m_row][m_col])
						continue;
					
					visited[m_row][m_col] = true;
					q.offer(new Point(m_row,m_col)); 
					
				}
			}
			//욱제 움직이고 벽 움직이기
			move_Wall();

		}
		return false;
	}

	private static void move_Wall() {
		for(int wall_cnt =0; wall_cnt < Wall_cnt; wall_cnt++)
		{
			Map[Wall[wall_cnt].row][Wall[wall_cnt].col] = '.';
			Point tmp = Wall[wall_cnt];
			//벽이 아래로 내려갈곳이 없을경우 사라짐
			tmp.row = tmp.row+1;
			if(tmp.row == 8) {
				Wall[wall_cnt] = Wall[--Wall_cnt];
				wall_cnt--;
				continue;
			}
			
			Wall[wall_cnt].row = tmp.row;
		}
		
		for(int index = 0; index <Wall_cnt;index++)
		{
			Map[Wall[index].row][Wall[index].col] = '#'; 
		}
		
	}

}
