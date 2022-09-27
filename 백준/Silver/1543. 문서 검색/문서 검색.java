
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();

		String check = br.readLine();
		int cnt=0;
		int Max = Integer.MIN_VALUE;
		for (int index_S = 0; index_S < S.length() - check.length() + 1; index_S++) {
			String Temp = S.substring(index_S,index_S+check.length());
			
			if(Temp.equals(check))
			{
				cnt++;
				index_S+= check.length();
				index_S--;
			}
			

		}

		System.out.print(cnt);
	}

}
