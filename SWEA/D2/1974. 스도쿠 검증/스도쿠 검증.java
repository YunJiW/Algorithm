
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
class Solution
{
    static int[] check;
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        int Map[][] = new int[10][10]; // 1 ~ 9로 사용하기 위해서
        StringBuilder sb = new StringBuilder();//출력용
        
        int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            for(int row = 1 ; row < 10; row++)
            {
                st =new StringTokenizer(br.readLine());
                for(int col = 1; col <10; col++){
                    Map[row][col] = Integer.parseInt(st.nextToken());
                }
            }
                
                if(check_row(Map) && check_col(Map) && check_box(Map))
                    sb.append('#').append(test_case).append(" ").append(1).append('\n');
                else
                    sb.append('#').append(test_case).append(" ").append(0).append('\n');
            }
        System.out.print(sb);
        
		
        
	}
    public static boolean check_row(int[][] Map){
        for(int row =1; row < 10; row++)
        {
            check = new int[10];
            for(int col = 1; col <10;col++)
            {
                if(check[Map[row][col]] == 0)
                    check[Map[row][col]] +=1;
                else
                    return false;
            }
        }
        return true;
    }
    public static boolean check_col(int[][] Map){
        
        for(int col =1;  col< 10; col++)
        {
            check = new int[10];
            for(int row = 1; row <10; row++)
            {
                if(check[Map[row][col]] == 0)
                    check[Map[row][col]] +=1;
                else
                    return false;
            }
        }
        return true;
    }
    public static boolean check_box(int[][] Map){
        for(int row = 1; row <= 7; row+= 3)
        {
            for(int col = 1; col <= 7; col+=3){
                check = new int[10];
                for(int row_check = row; row_check < row+3; row_check++)
                {
                    for(int col_check = col; col_check < col +3; col_check++){
                        if(check[Map[row_check][col_check]] == 0)
                            check[Map[row_check][col_check]]+=1;
                        else
                            return false;
                    }
                }
                
            }
        }
        return true;
    
    }
}