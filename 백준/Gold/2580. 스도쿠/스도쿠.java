import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	//기본 맵생성
	static int Map[][] = new int[9][9];
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		//먼저 입력값들을 넣어준다.
		for(int row = 0; row < 9;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col = 0; col<9;col++) {
				Map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		Run(0,0);
	}

	private static void Run(int row, int col) {
		if(col ==9) {
			Run(row+1,0);
			return;
		}
		
		//다돌았을경우 출력
		if(row == 9) {
			StringBuilder sb = new StringBuilder();
			for(int rows = 0; rows<9;rows++)
			{
				for(int cols= 0; cols<9;cols++)
				{
					sb.append(Map[rows][cols]).append(" ");
				}
				sb.append('\n');
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		if(Map[row][col] == 0) {
			for(int num =1; num<=9;num++) {
				if(is_possible(row,col,num)){
					Map[row][col] = num;
					Run(row,col+1);
				}
			}
			Map[row][col] = 0;
			return;
		}
		Run(row,col+1);
	}

	private static boolean is_possible(int row, int col, int num) {
		for(int idx = 0; idx<9;idx++)
		{
			if(Map[row][idx] == num) {
				return false;
			}
			
			if(Map[idx][col] == num) {
				return false;
			}
		}
		int check_row = (row/3) *3;
		int check_col = (col/3) *3;
		
		for(int rows =check_row; rows < check_row+3;rows++)
		{
			for(int cols=check_col; cols< check_col+3;cols++) {
				if(Map[rows][cols] == num) {
					return false;
				}
			}
		}
		return true;
	}

}
