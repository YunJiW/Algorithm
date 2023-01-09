import java.util.Arrays;
class Solution
{
	
	public int solution(int[] A, int[] B) {
		int answer =0;
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		// 1 3 5 7 
		// 2 2 6 8
		
		
		int IdxB= 0;
		
		for(int index = 0;index <A.length;index++)
		{
			if(IdxB == B.length)
				break;
			
			if(A[index] < B[IdxB]) {
				answer+=1;
				IdxB+=1;
			}else {
                IdxB+=1;
				for(;IdxB <B.length;IdxB++) {
					if(A[index] < B[IdxB])
					{
						answer+=1;
                        IdxB+=1;
						break;
					}
				}
			}
		}
		
		
		
		
		
		return answer;
	}
}