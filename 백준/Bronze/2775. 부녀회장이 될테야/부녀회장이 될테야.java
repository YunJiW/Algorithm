import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//test_Case
		int T = Integer.parseInt(br.readLine());
		
		//층은 0층 ~ 14층까지
		int[][] building = new int[15][15];
		
		for(int i = 0 ; i<15;i++)
		{
            //호수는 1호부터 존재
			building[i][1] = 1;
			building[0][i] = i;
		}
		
		for(int i = 1;i<15;i++)
		{
			for(int j = 2; j< 15;j++)
			{
				building[i][j] = building[i-1][j] + building[i][j-1];
			}
		}
		while(T --> 0)
		{
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(building[k][n]);
		}
				
		
	}
}
