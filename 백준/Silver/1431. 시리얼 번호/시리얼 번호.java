import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.Comparator;
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] s = new String[N];
		
		for(int index =0 ;index <N;index++)
		{
			s[index] = br.readLine();
		}
		
		Arrays.sort(s, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				if(o1.length() < o2.length())
					return -1;
				
				else if(o1.length() == o2.length())
				{
					int o1_sum =0;
					int o2_sum = 0;
					for(int index =0; index <o1.length();index++)
					{
						char k = o1.charAt(index);
						if(k >= '0' && k <= '9') {
							o1_sum += k -'0';
						}
						
						char j = o2.charAt(index);
						if(j >= '0' && j <= '9') {
							o2_sum+= j -'0';
						}
					}
					if(o1_sum == o2_sum)
						return o1.compareTo(o2);
					
					return o1_sum - o2_sum;
				}
				
				
				return 1;
				

			}
			
		});
		
		for(String k : s)
		{
			System.out.println(k);
		}
	}

}
