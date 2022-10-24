import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	
	
	//수빈
	static int N;
	//동생
	static int K;
	
    //방문 안했을 때는 0 
	static int[] check = new int[100001];
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Find(0);
		
	}

	private static void Find(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		check[N] = 0;
		
		while(!queue.isEmpty())
		{
			int cur_place = queue.poll();
			
			if(cur_place == K)
			{
				System.out.print(check[cur_place]);
				return;
			}
			
            // 앞으로 1 이동시 check[cur_place] 에서 1더해줌
			if(cur_place +1 <= 100000 && check[cur_place+1] == 0)
			{
				check[cur_place+1] = check[cur_place]+1;
				queue.offer(cur_place+1);
			}
			// 뒤로 1 이동시 check[cur_place] 에서 1더해줌
			if(cur_place-1 >= 0 && check[cur_place-1] == 0)
			{
				check[cur_place-1] = check[cur_place]+1;
				queue.offer(cur_place-1);
			}
			// 순간이동시 check[cur_place] 에서 1더해줌
			if(cur_place*2 <= 100000 && check[cur_place*2] == 0)
			{
				check[cur_place*2] = check[cur_place]+1;
				queue.offer(cur_place*2);
			}
		}
		
	}

}
