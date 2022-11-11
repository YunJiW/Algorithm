import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	static int N;
	
	static int col[];
	
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		col = new int[N];
	
		checking(0);
		System.out.println(cnt);
	}


	private static void checking(int depth) {
		if(depth == N)
		{
			cnt++;
			return;
		}
		
		for(int index = 0; index <N;index++)
		{
			col[depth] = index;
			if(ispossible(depth))
			{
				checking(depth+1);
			}

		}
	}


	private static boolean ispossible(int depth) {
		for(int index = 0; index < depth; index++)
		{
			if(col[depth] == col[index]) return false;
			
			else if(Math.abs(depth - index) == Math.abs(col[depth] - col[index])) return false;
		}
		return true;
	}

}
