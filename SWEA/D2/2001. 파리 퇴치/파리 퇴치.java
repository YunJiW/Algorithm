
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T;
		T= Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            st = new StringTokenizer(br.readLine());
            
            //N 과 M 체크
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            //전체 맵
            int map[][] = new int[N][N];
            int Max = Integer.MIN_VALUE;
            
            
            for(int row = 0; row < N; row++)
            {
            	st = new StringTokenizer(br.readLine());
            	for(int col =0; col < N;col++)
            		map[row][col] = Integer.parseInt(st.nextToken());
            }
            
            
            
            for(int row =0; row <= N - M; row++)
            {
                for(int col =0; col <= N-M;col++)
                {
                	int sum = 0;
                	for(int row_check = row; row_check < row +M; row_check++)
                	{
                		for(int col_check = col; col_check < col+M;col_check++)
                		{
                			sum += map[row_check][col_check];
                		}
                	}
                	if(Max < sum)
                	{
                		Max =sum;
                	}
                }
            } 
            sb.append('#').append(test_case).append(" ").append(Max).append('\n');
	
		}
        System.out.print(sb);
	}
}