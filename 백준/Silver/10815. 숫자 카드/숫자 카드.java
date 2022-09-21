import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] card = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int index = 0; index < N; index++) {
			card[index] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(card);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int index = 0 ;index <M ;index++) {
			int sel = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(card,sel)).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int binarySearch(int[] card, int sel) {
		int start = 0;
		int end = card.length-1;
		int mid = (start+end)/2;
		
		while(end-start >=0) {
			if(card[mid] == sel)
			{
				return 1;
			}else if(card[mid] <= sel)
			{
				start = mid + 1;
			}else {
				end = mid -1;
			}
			mid =(end+start)/2;
		}
		
		return 0;
	}

}
