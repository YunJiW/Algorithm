import java.util.Arrays;

class Solution 
{
	public static String solution(String x, String y) {
		
        StringBuilder answer = new StringBuilder();
		
		int X[]= new int[10];
		int Y[]= new int[10];
		
		for(int index = 0;index <x.length();index++) {
			X[x.charAt(index)-'0'] +=1;
			
		}
		
		for(int index = 0;index <y.length();index++) {
			Y[y.charAt(index)-'0'] +=1;
		}
		
		
		for(int index =9;index >=0;index--)
		{
			int check = Math.min(X[index],Y[index]);
			//최소값이 0 일경우 -> 한쪽이 없을경우
			if(check == 0)
			{
				continue;
			}
			//최소값이 존재할경우 -> 중복되는 값이다.
			for(int count =0; count<check;count++)
			{
				answer.append(index);
			}
			
		}
        if(answer.toString().equals(""))
			return "-1";
		if(answer.charAt(0) == '0')
			return "0";

		
		
		
		return answer.toString();
	}

}