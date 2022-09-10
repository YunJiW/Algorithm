import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
		public static void main(String[] args)throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int M = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());
			
			int sum = 0;
	        double min = 10000;
			
	        StringBuilder sb = new StringBuilder();
	        
	        
	        for(int index= M; index <=N;index++)
	        {
	        	for(int num = 1; num<=100;num++)
	        	{
	        		if(num == Math.pow(index, 0.5))
	        		{
	        			sum+= index;
	        			if(min > index)
	        				min = index;
	        			break;
	        		}
	        	}
	        }

            if(sum == 0) {
	        	System.out.print(-1);
	        	return;
	        }
	        
	        sb.append(sum).append('\n').append((int)min);
	        System.out.print(sb);
		}
	}

