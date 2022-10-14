
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		cow[] Cow_time = new cow[N];
		StringTokenizer st;

		for (int index = 0; index < N; index++) {
			st = new StringTokenizer(br.readLine());
			int arrive = Integer.parseInt(st.nextToken());
			int Time = Integer.parseInt(st.nextToken());
			Cow_time[index] = new cow(arrive,Time);
		}
		
		Arrays.sort(Cow_time, new Comparator<cow>() {

			@Override
			public int compare(cow o1, cow o2) {
				return o1.getArr() - o2.getArr();
			}
		});
		
		int All_time =0;
		
		for(int index =0 ;index < N;index++)
		{
			if(All_time < Cow_time[index].getArr()) {
				All_time = Cow_time[index].getArr() + Cow_time[index].getTime();
			}
			else {
				All_time += Cow_time[index].getTime();
			}
		}
		
		System.out.print(All_time);

	}

	public static class cow {
		int arr;
		int time;

		cow(int arr, int time) {
			this.arr = arr;
			this.time = time;
		}

		public int getArr() {
			return arr;
		}

		public int getTime() {
			return time;
		}

	}
}
