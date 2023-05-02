class Solution {
	public int solution(int n)
	{
        //int answer =0;
		int before=0; //F(n-2)
		int cur =1; //F(n-1)
		int temp; //바꾸기용
        if(n > 1 )
        {
		    for(int i = 1; i<n;i++)
		    {
			    temp =cur;
			    cur = cur + before;
			    before = temp;
                cur %=1234567;
		    }
        }
	
		
		
		return cur;
		
		
	}

}