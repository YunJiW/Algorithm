import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		//최대 받을 수있는 수
		long N = sc.nextLong();
		int cnt = 1; // 지나가는 방의 개수 세기
		int room = 1;
		int i = 1;
		
		
		while(room < N)
		{
			room = room +( 6 * i );
			i++;
			cnt++;
		}
		
		
		System.out.println(cnt);
	}
}
