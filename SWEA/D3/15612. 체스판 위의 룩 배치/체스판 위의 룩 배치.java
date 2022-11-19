import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution
{
    static class Point{
        int row;
        int col;
        Point(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    static Point rook[];
    static int rook_cnt;
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            rook = new Point[8*8];
            rook_cnt = 0;
            //룩들의 좌표 체크
            for(int row =0; row < 8;row++)
            {
                String Line = br.readLine();
                for(int col = 0; col < 8; col++)
                {
                    if(Line.charAt(col) == 'O')
                        rook[rook_cnt++] = new Point(row,col);
                }
            }
            if(rook_cnt < 7 ){
                 sb.append("#").append(test_case).append(" ").append("no" + "\n");
                continue;
            }
            
            //룩들이 겹치는게 있는지 체크 없을경우 yes 있을경우 no
            if(checking())
            {
                sb.append("#").append(test_case).append(" ").append("yes" + "\n");
            }else
            {
                sb.append("#").append(test_case).append(" ").append("no" + "\n");
            }
		}
        System.out.print(sb);
	}
    private static boolean checking(){
        for(int index =0 ; index < rook_cnt-1; index++)
        {
            for(int tmp = index+1; tmp < rook_cnt; tmp++){
                if(Math.abs(rook[index].row - rook[tmp].row )  == 0 || Math.abs( rook[index].col - rook[tmp].col ) == 0)
                    return false;
            }
        }
        return true;
    }
    
}