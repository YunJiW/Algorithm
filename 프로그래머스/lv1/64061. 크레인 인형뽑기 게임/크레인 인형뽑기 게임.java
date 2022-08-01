
import java.util.ArrayList;
class Solution {
    public int solution(int[][] board, int[] moves) 
	   {
		int answer = 0;

		// 바구니 대용
		ArrayList<Integer> arr = new ArrayList<>();
		
		
		for (int i = 0; i < moves.length; i++) {
			for (int check = 0; check < board.length; check++) {
				if(board[check][moves[i]-1] != 0)
				{
					arr.add(board[check][moves[i]-1]);
					board[check][moves[i]-1] = 0;
					
					if(arr.size() > 1)
					{
						int now = arr.get(arr.size() -1);
						int before = arr.get(arr.size()-2);
						
						if(now == before)
						{
							arr.remove(arr.size()-1);
							arr.remove(arr.size()-1);
							answer += 2;
						}
					}
					break;
				}
			}
		}
		return answer;
	}
}