class Solution {
	
	static int zero=0;
	static int one =0;
	
	public int[] solution(int[][] arr) {
		int[] answer= new int[2];
		
		int N =arr.length;
		check(arr,0,0,N);
		
		
		answer[0]= zero;
		answer[1] = one;
		
		
		return answer;
	}
	
	
	
	
	private void check(int[][] arr, int row, int col, int length) {
		
		if(check_paper(row,col,length,arr)) {
			if(arr[row][col] == 0)
				zero++;
			else
				one++;
			
			return;
		}
		
		int newSize = length/2;
		
		check(arr,row,col,newSize);
		check(arr,row+newSize,col,newSize);
		check(arr,row,col+newSize,newSize);
		check(arr,row+newSize,col+newSize,newSize);
	}




	private boolean check_paper(int row,int col,int N,int[][] arr) {
		int color = arr[row][col];
		
		for(int rows = row; rows < row+N;rows++) {
			for(int cols=col; cols<col+N;cols++) {
				if(arr[rows][cols] != color)
					return false;
			}
		}
		return true;
	}
}