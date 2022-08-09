import java.util.Stack;
import java.util.Scanner;
import java.util.ArrayList;

// Stack -> 후입 선출 맨뒤에 들어온놈 먼저나감

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		
		Stack<Integer> sequence = new Stack<>();
		ArrayList<Character> ans = new ArrayList<>();
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		
		// 만들어낼 수열을 받아둠.
		for(int i = 0; i < N;i++)
		{
			int k = sc.nextInt();
			arr.add(k);
		}
		
		//arr 배열 값
		int n = 0;
		//들어갈 숫자
		int num = 1;
		
		//비교해서 수와 같지않다면 push
		//수와 같을 경우 pop
		while(true)
		{
			//비어 있지만 숫자가 다안들어갔을경우
			if(sequence.empty() && num <= N)
			{
				sequence.push(num);
				ans.add('+');
				num++;
			}
			else if(sequence.empty())
				break;
			
            //다를경우 push
			if(!sequence.peek().equals(arr.get(n))  && num <= N)
			{
				sequence.push(num);
				ans.add('+');
				num++;
				
			}
            //같을 경우 pop
			else if(sequence.peek().equals(arr.get(n))) {
				sequence.pop();
				ans.add('-');
				n++;
			}
			else if(sequence.empty() && num == N)
				break;
			
			//상단 값과 아예 다를 경우 끝냄
			else if(!sequence.peek().equals(arr.get(n)))
			{
				System.out.println("NO");
				break;
			}

		}
		//전부 사용했을경우 순열이 완성됬다는 의미이므로 이경우에만 출력
		if(sequence.empty())
		{
			for(char answer : ans)
				System.out.println(answer);
		}
		
		
		
		
		
		sc.close();
	}

}
