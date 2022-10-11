import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		HashMap<Long, Integer> map = new HashMap<>();

		for (int index = 0; index < N; index++) {
			Long num = Long.parseLong(br.readLine());
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		int max = Integer.MIN_VALUE;
		
		
		
		for(Long nums: map.keySet())
		{
			if(max < map.get(nums))
			{
				max = map.get(nums);
			}
		}
		Long check = Long.MAX_VALUE;
		for(Long nums: map.keySet())
		{
			if(max == map.get(nums)) {
				check = Math.min(check, nums);
			}
		}
		
		System.out.println(check);
		

	}
}
