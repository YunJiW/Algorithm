
class Solution 
{
    int answer = 0;
    String person[] = {"A","C","F","J","M","N","R","T"};
 
  
    
    public int solution(int n, String[] data) {
    	  	boolean check[] = new boolean[8];
        	dfs("",check,data);
        	return answer;
               
    }
    
    public void dfs(String list,boolean check[],String[] data){
        //8명을 다 세웠을 경우
        if(list.length() == 7)
        {
            if(checking_name(data,list))
            {
                answer++;
            }
            return;
        }
        //중복없이 8명 세우는 경우의 수 체크
        for(int index = 0;index < 8; index ++)
        {
            if(!check[index])
            {
                check[index]= true;
                String name = list + person[index];
                dfs(name,check,data);
                check[index] = false;
            }
        }
    }

	private boolean checking_name(String[] data, String list) {
		for(int index =0 ;index <data.length;index++)
		{		
			int name1_pos = list.indexOf(data[index].charAt(0));
			int name2_pos = list.indexOf(data[index].charAt(2));
			char op = data[index].charAt(3);
			int checking = data[index].charAt(4) -'0';
			
			switch(op) {
			case '=':
				if(!(Math.abs(name1_pos - name2_pos ) == checking+1))
					return false;
				break;
			case '<':
				if(!(Math.abs(name1_pos - name2_pos ) < checking+1))
					return false;
				break;
			case '>':
				if(!(Math.abs(name1_pos - name2_pos ) > checking+1))
					return false;
				break;
			}
			
		}
		
		return true;
	}
}
