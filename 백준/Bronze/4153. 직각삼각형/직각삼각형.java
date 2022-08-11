
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			if (x == 0 && y == 0 && z == 0)
				break;
			
			int max = 0;
			
			
			max = x > y ? (x  > z ? x : z) : (y > z ? y : z);
			
			
			if(max == x)
			{
				if(Math.pow(max, 2) == (Math.pow(y, 2) + Math.pow(z, 2)))
					System.out.println("right");
				else
					System.out.println("wrong");
			}else if(max == y){
				if(Math.pow(max, 2) == (Math.pow(x, 2) + Math.pow(z, 2)))
					System.out.println("right");
				else
					System.out.println("wrong");
			}else if(max == z){
				if(Math.pow(max, 2) == (Math.pow(x, 2) + Math.pow(y, 2)))
					System.out.println("right");
				else
					System.out.println("wrong");
			}
			 

		}
	}
}
