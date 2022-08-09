import java.util.Arrays;
import java.util.Scanner;

//정수의 범위가 2^31이기때문에 long 으로 진행

// N 과 M 은 1 ~ 100000
// A[N]안의 존재는 2^31까지

// 2중 for문을 통한 체크
// 값을 찾으면 1을 찍고 다음  순서로 넘어감 -> break;
// 이분탐색이였음.
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		
		long[] Arr = new long[N];
		
		//배열 넣어두기
		for(int i = 0 ; i <Arr.length;i++)
		{
				Arr[i] = sc.nextLong();
		}
		
		//오름차순 정리
		Arrays.sort(Arr);
		

		
		
		//M개의 수
		int M = sc.nextInt();
		
		for(int i = 0 ; i<M;i++)
		{
			long num = sc.nextLong();
			int start = 0;
			int end = Arr.length-1;
			int mid = (start + end) /2;
			while(end-start >=0)
			{
				if(Arr[mid] == num)
				{
					System.out.println("1");
					break;
				}
				else if(Arr[mid] <= num)
				{
					start = mid+1;
				}
				else {
					end = mid -1;
				}
				mid = (start+end) /2;
			}
			if(end -start < 0)
			{
				System.out.println("0");
			}
			
			
		}
		
	}
}
