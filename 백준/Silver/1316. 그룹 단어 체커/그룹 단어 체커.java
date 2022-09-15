import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		
		int cnt = 0;
		
		for (int index = 0; index < T; index++) {
			String alph = br.readLine();
			ArrayList<Character> alpha = new ArrayList<>();
			int check;
			for(check = 0 ; check<alph.length();check++)
			{
				char k = alph.charAt(check);
				if(check == 0 ) {
					alpha.add(k);
					continue;
				}
				//없을경우
				if(!alpha.contains(k)) {
					alpha.add(k);
					continue;
				//있을경우
				}else {
					if(alph.charAt(check-1) == k)
					{
						continue;
					}else {
						break;
					}
				}
			}
			if(check == alph.length())
				cnt++;

			
		}
		System.out.println(cnt);
	}
}
