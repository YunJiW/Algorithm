import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int cnt = 0;
		st.nextToken();
		int zi = Integer.parseInt(st.nextToken());
		int im = Integer.parseInt(st.nextToken());
		
		
		while(zi != im)
		{
			zi = zi/2 + zi%2;
			im = im/2 + im%2;
			cnt++;
		}
		
		System.out.println(cnt);
	}

}
