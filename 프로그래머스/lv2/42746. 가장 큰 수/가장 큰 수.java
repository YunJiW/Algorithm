import java.util.Arrays;
import java.util.Comparator;

class Solution 
{
	public String solution(int[] numbers) {
		String[] num = new String[numbers.length];
		
		String answer="";
		
		//문자열로 변환
		for(int index =0; index < numbers.length;index++) {
			num[index] = String.valueOf(numbers[index]);
		}
		
		Arrays.sort(num, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return (o2+o1).compareTo(o1+o2);
			}
			
		});
		
		for(String nums:num) {
			answer+=nums;
		}
		
		if(answer.charAt(0) == '0')
		{
			return "0";
		}else
			return answer;
	}
}
