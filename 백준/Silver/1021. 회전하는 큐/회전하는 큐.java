import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		LinkedList<Integer> dequeue = new LinkedList<>();

		int N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());

		for (int index = 1; index <= N; index++) {
			dequeue.offer(index);
		}

		int[] seq = new int[M];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < M; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int cnt = 0;
		for (int index = 0; index < M; index++) {
			int target = dequeue.indexOf(seq[index]);
			int half;

			if (dequeue.size() % 2 == 0)
				half = dequeue.size() / 2 - 1;
			else
				half = dequeue.size() / 2;

			if (target <= half) {
				
				for(int i = 0; i<target;i++)
				{
					int tmp = dequeue.pollFirst();
					dequeue.offerLast(tmp);
					cnt++;
				}

			} else {
				
				for(int i = 0; i <dequeue.size() - target; i++)
				{
					int tmp = dequeue.pollLast();
					dequeue.offerFirst(tmp);
					cnt++;
				}

			}
			dequeue.pollFirst();
		}
		System.out.print(cnt);
	}
	
}
