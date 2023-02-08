
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static class Class_Time {
		int start;
		int end;

		Class_Time(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		
		int Class_times[][] = new int[N][2];

		int Max_class = -1;

		for (int index = 0; index < N; index++) {
			st = new StringTokenizer(br.readLine());
			Class_times[index][0] = Integer.parseInt(st.nextToken());
			Class_times[index][1] = Integer.parseInt(st.nextToken());
		}
		//시작 시간순으로 정렬
		Arrays.sort(Class_times,new Comparator<int[]>() {
			
			public int compare(int[] o1,int[]o2) {
				return o1[0] - o2[0];
			}
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(Class_times[0][1]);
		
		for(int index= 1; index <Class_times.length;index++) {
			if(pq.peek() <= Class_times[index][0]) {
				pq.poll();
			}
			pq.offer(Class_times[index][1]);
		}
		System.out.print(pq.size());
	}
}
