
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int[][] arr = new int[n][n]; //2차원 배열 생성
            //행렬
            int row = 0;
            int col = 0;
            int dir = 1; //방향전환을 위한 1 : 우 2: 하 3:좌 4:상으로 
            int num = 1;
            while(num <= n*n){
            	arr[row][col] = num++;
                switch(dir){
                    case 1: //우
                        if( col == n-1 || arr[row][col+1] != 0)
                        {
                            dir = 2;
                            row++;
                        }else{
                        	col++;
                            
                        }break;
                    case 2: //하
                        if(row == n-1 || arr[row+1][col] != 0)
                        {
                            dir =3;
                            col--;
                        }else{
                        	row++;
                        }break;
                    case 3: //좌
                        if(col == 0 || arr[row][col-1] != 0)
                        {
                            dir =4;
                            row--;
                        }else{
                        	col--;
                        }break;
                    case 4: //상
                        if(row == 0 || arr[row-1][col] !=0)
                        {
                            dir = 1;
                            col++;
                        }else {
                        	row--;  
                        }break; 	
                } 
            } //while
            System.out.println("#" + test_case);
            for(int i =0; i < n;i++)
            {
                for(int j = 0; j<n;j++)
                {
                    System.out.print(arr[i][j] + " " );
                }
                System.out.println();
            }
		}
	}
}