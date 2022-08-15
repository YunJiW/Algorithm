//ACM 호텔


/*   
 * 	호텔 정문으로부터 걸어가는 거리가 가장 짧은 방을 선호.
 *  각층은 W개의 방이있는 H 층 건물
 *  
 *  w 와 H는 둘다 1 ~ 99까지 존재
 *  엘리베이터는 맨 왼쪽에 존재
 *  엘리베이터 타고 이동하는건 신경안씀
 *  거리가 같을 경우 아래층의 방을 선호
 *  
 * 
 * 구현문제
 * 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader; 
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		while(T --> 0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			// H = > 층수 , W => 각 층의 방수 check => 몇 번쨰 손님
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int check = Integer.parseInt(st.nextToken());
			
			int cnt = 1;
			while(check > H)
			{
				check = check-H;
				cnt++;
			}
			
			int Hotel = check*100 + cnt;
			System.out.println(Hotel);
			
		}
	}
}
