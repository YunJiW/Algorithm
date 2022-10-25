import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	
	//로봇 위치 좌표
	static class Robot {
		int col;
		int row;

		public Robot(int col, int row) {
			this.col = col;
			this.row = row;
		}
	}

	// 움직임 9방향
	static int dx[] = { 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static int dy[] = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	static int R;
	static int C;

	// 전체 맵
	static char Map[][];
	// 미친 아두이노 있는 곳 체크용
	static int visited[][];

	// 종수 로봇
	static Robot Zhong;
	// 미친 아두이노 로봇들
	static Robot Crazy[];
	// 미친 아두이노 개수
	static int CA_cnt = 0;
	static int moving;

	// 입력 횟수 체크용
	static int Command_cnt = 0;
	static int[] Command;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		Map = new char[R][C];
		visited = new int[R][C];
		// 미친 아두이노는 최대로 맵 전체기 때문에 최대값으로 가지고 있음
		Crazy = new Robot[R * C];
		

		// 맵에 있는 종수 아두이노 위치와 미친 아두이노 갯수 및 위치 체크
		for (int col = 0; col < R; col++) {
			String Line = br.readLine();
			for (int row = 0; row < C; row++) {
				if (Line.charAt(row) == 'I') {
					Zhong = new Robot(col, row);
				} else if (Line.charAt(row) == 'R') {
					Crazy[CA_cnt++] = new Robot(col, row);
					visited[col][row] ++;
				}
				Map[col][row] = '.';
			}
		}

		// 입력 개수및 입력 방향 체크
		String Com = br.readLine();
		Command_cnt = Com.length();
		Command = new int[Command_cnt];

		for (int index = 0; index < Command_cnt; index++) {
			Command[index] = Com.charAt(index) - '0';
		}

		// 0일 경우 만나지 않고 명령을 수행이 끝남
		moving = 0;
		 
		if (Run()) {
			for(int CA=0; CA<CA_cnt; CA++)
			{
				Map[Crazy[CA].col][Crazy[CA].row] = 'R';
			}
			Map[Zhong.col][Zhong.row] = 'I'; 
			
			
			for(int col =0; col <R;col++)
			{
				for(int row = 0; row <C;row++)
				{
					System.out.print(Map[col][row]);
				}
				System.out.println();
			}
			
			
		}
		// 아닐경우 중간에 끝남
		else {
			System.out.print("kraj " + (moving));

		}

	}

	private static boolean Run() {

		for (int index = 0; index < Command.length; index++) {
			moving++;
			Zhong.col += dx[Command[index] -1];
			Zhong.row += dy[Command[index] -1];

			// 종수의 아두이노가 미친 아두이노를 만날 경우 종료
			if(visited[Zhong.col][Zhong.row] != 0)
				return false;

			// 미친 아두이노들 이동
			for (int CA = 0; CA < CA_cnt; CA++) {
				//다음 좌표 저장용
				int next_col =-1;
				int next_row =-1;
				
				int min = Integer.MAX_VALUE;
				
				for(int dir =0; dir <9; dir++)
				{
					int CA_col = Crazy[CA].col + dx[dir];
					int CA_row = Crazy[CA].row + dy[dir];
					
					if (CA_col < 0 || CA_col >= R || CA_row< 0 || CA_row >= C)
						continue;
					
					int dis = Math.abs(Zhong.col - CA_col) + Math.abs(Zhong.row - CA_row);
					
					//차이가 0이다 => 종수 아두이노랑 부딪친다 -> 종료
					if(dis == 0)
						return false;
					
					//최솟갑의 좌표 저장
					if(min > dis)
					{
						min = dis;
						next_col = CA_col;
						next_row = CA_row;
					}
				}
				//원래 있던 곳의 개수를 -1 해주고 다음 방문 하는곳의 좌표에 +1을 해준다.
				visited[Crazy[CA].col][Crazy[CA].row] -=1;
				Crazy[CA].col = next_col;
				Crazy[CA].row = next_row;
				visited[Crazy[CA].col][Crazy[CA].row] +=1; 
			}
			Destroy_checking();

		}
 
		return true;

	}
	
	//파괴되는 아두이노 체크
	//2개이상 같은 곳에 있을경우 터짐
	private static void Destroy_checking() {
		for(int col =0 ; col <R;col++)
		{
			for(int row =0 ;row <C;row++)
			{
				if(visited[col][row] >=2)
				{
					for(int Adu= 0; Adu < CA_cnt; Adu++)
					{
						if(Crazy[Adu].col == col && Crazy[Adu].row == row)
						{
							Crazy[Adu] = Crazy[--CA_cnt];
							Adu--;
						}
					}

                    visited[col][row] = 0;
				}
				
			}
		}
		
	}
}
