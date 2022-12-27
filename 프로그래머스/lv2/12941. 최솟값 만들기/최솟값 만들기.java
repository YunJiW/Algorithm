import java.util.Arrays;
import java.util.Collections;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int index =0 ;index <A.length;index++)
        {
            answer += (A[index] * B[B.length-1-index]);
        }

        return answer;
    }
}