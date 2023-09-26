import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s = br.readLine();
			if(s == null) {
				break;
			}
			int N = Integer.parseInt(s);
			int num = 0;
			for(int i=1; i<=N; i++) {
				num = num*10 + 1;  // 자리수를 늘려준다.
				num %= N;                     
				//((3*3+2) * 10 +1)%3 == ((3+2)*10+1)%3 
				if(num == 0) { //나머지가 0이면 나누어 떨어진다 
					System.out.println(i);
					break;
				}
			}
			
		}
		
	}

}