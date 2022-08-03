import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			int palin = sc.nextInt();
			if(palin == 0)
				break;
			
			
			String pa = Integer.toString(palin);
			int len = pa.length();
			int j = len;
			for(int i = 0; i < len; i++){
				char tmp = pa.charAt(i);
				char tmp2 = pa.charAt(j-1);
				if(tmp == tmp2)
				{
					j--;
					continue;
				}
				else if(j == 0)
					break;
				else {
					System.out.println("no");
					break;
				}

				
				
				
			}
			if(j == 0)
				System.out.println("yes");
			
			
		}
		
		
	}
}
