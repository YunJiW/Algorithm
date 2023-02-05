import java.util.Arrays;


class Solution 
{
	public boolean solution(String[] phone_book) {
		boolean answer = true;

		Arrays.sort(phone_book);

		for (int index = 0; index < phone_book.length-1; index++) {
			if(phone_book[index+1].startsWith(phone_book[index]))
				return false;
		}

		return answer;
	}
}
