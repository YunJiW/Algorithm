import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		String[] suffix = new String[S.length()];
		
		suffix[0] = S;
		for(int index = 1 ; index < suffix.length;index++)
		{
			suffix[index] = suffix[index-1].substring(1);
		}
		
		
		Arrays.sort(suffix);
		for(String k : suffix) {
			System.out.println(k);
		}
	}

}
