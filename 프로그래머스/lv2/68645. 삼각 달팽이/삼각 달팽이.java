class Solution
{
	public int[] solution(int n) {

		
		int check = n;
		int map[][] = new int[n][n];
		

		
		int all_box = 0;
		for(int index = n; index > 0;index--)
		{
			all_box += index;
		}
		int[] answer = new int[all_box];
		
		
		int row = -1;
		int col = 0;
		int number = 1;
		
		
		// %3 == 0 밑으로 
		// %3 == 1 오른쪽으로
		// %3 == 2 대각
		for(int idx = 0; idx <n;idx++) {
			for(int j = idx; j < n;j++) {
				if(idx % 3== 0){
					row++;
				}else if(idx %3 == 1){
					col++;
				}else if(idx %3 == 2){
					row--;
					col--;
				}
				map[row][col] = number++;
			}
		}
		
		int box = 0;
		for(int rows = 0; rows <n;rows++){
			
			for(int cols=0;cols<n;cols++){
				if(map[rows][cols] == 0) {
					break;
				}
				answer[box++] = map[rows][cols];
			}
		}
		
		return answer;
	}


}