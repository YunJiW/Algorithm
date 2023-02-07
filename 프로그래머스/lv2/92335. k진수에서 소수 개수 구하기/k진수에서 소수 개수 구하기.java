class Solution 
{

	public int solution(int n, int k) {
		int answer = 0;
		
		//진수변환
		String s = Integer.toString(n,k);
		
		String number[] = s.split("0");
		
		for(int index = 0;index < number.length;index++) {
			if(number[index].length() !=0) {
				System.out.println(origin_number(number[index]));
				answer += origin_number(number[index]);
			}
		}
		
		return answer;
	}

	private int origin_number(String numbers) {
		if(is_prime(Long.parseLong(numbers)))
			return 1;
		else
			return 0;
	}

	private boolean is_prime(Long number) {
		if(number == 1 || number == 0 ) return false;
		
		for(int index =2; index <=Math.sqrt(number);index++)
		{
			if(number % index == 0)
				return false;
		}
		
		
		return true;
	}
}
