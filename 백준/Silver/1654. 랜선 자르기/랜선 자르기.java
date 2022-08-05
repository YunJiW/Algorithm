import java.util.*;

public class Main {
	public static void main(String[] args) {
		int N, K;
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();

		long[] lan_length = new long[K];
		long max = 0;
		
		//최대 길이를 찾아둠
		for (int i = 0; i < K; i++) {
			lan_length[i] = sc.nextInt();
			if (max < lan_length[i])
				max = lan_length[i];
		}
		
		//mid 값이 0이되지 않게 max+1범위를 계산
		max ++;
		long min = 0;
		long mid = 0;

		while (min < max) {
			mid = (max + min) / 2;

			long cnt = 0;

			for (int i = 0; i < lan_length.length; i++) {
				cnt += (lan_length[i] / mid);
			}
			
			if(cnt < N)
			{
				max = mid;
			}
			else {
				min = mid +1;
			}
		}
		
		System.out.println(min -1);
	}

}
