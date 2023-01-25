import java.util.Arrays;
import java.util.Comparator;

class Solution 
{

	class file_name {
		String Head;
		String number;
		String tail;

		file_name(String name, String number, String tail) {
			this.Head = name;
			this.number = number;
			this.tail = tail;
		}
	}

	public String[] solution(String[] files) {
		String[] answer = new String[files.length];

		file_name filess[] = new file_name[files.length];
		// 자르기 0과 9 사이가 나오면 그전까지 잘라서 가져감.

		for (int index = 0; index < files.length; index++) {
			String Head = "";
			String num = "";
			String tail = "";
			// HEAD
			int file_idx = 0;
			for (; file_idx < files[index].length(); file_idx++) {
				//숫자일경우
				if (Character.toLowerCase(files[index].charAt(file_idx)) >= '0' && files[index].charAt(file_idx) <= '9') {
					break;
				}
				Head += files[index].charAt(file_idx);
			}
			// NUMBER
			for (; file_idx < files[index].length(); file_idx++) {
				if (files[index].charAt(file_idx) < '0' || files[index].charAt(file_idx) > '9') {
					break;
				}
				num += files[index].charAt(file_idx);
			}

			// TAIL
			for (; file_idx < files[index].length(); file_idx++) {
				tail += files[index].charAt(file_idx);
			}

			filess[index] = new file_name(Head,num, tail);

		}
		Arrays.sort(filess, new Comparator<file_name>() {

			@Override
			public int compare(file_name o1, file_name o2) {
				//HEAD가 같을경우
				if(o1.Head.toLowerCase().equals(o2.Head.toLowerCase())) {
					if(Integer.parseInt(o1.number) ==Integer.parseInt(o2.number))
						return 0;
					return Integer.parseInt(o1.number) -Integer.parseInt(o2.number);
				}
				else
					return o1.Head.toLowerCase().compareTo(o2.Head.toLowerCase());
			}

		});
		
		for(int index = 0;index <filess.length;index++) {
			answer[index] = filess[index].Head +filess[index].number+filess[index].tail;
		}

		return answer;
	}
}