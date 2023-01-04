import java.util.HashMap;

class Solution 
{
	public String[] solution(String[] record) {
		
		
		HashMap<String,String> list = new HashMap<>();
		
		int cnt = 0;
		for(int index = 0 ;index <record.length;index++)
		{
			String temp[] = record[index].split(" ");
			if(temp[0].equals("Enter")) {
				list.put(temp[1],temp[2]);
				cnt+=1;
				
			}else if(temp[0].equals("Leave")) {
				cnt+=1;
				
			}else if(temp[0].equals("Change")) {
				list.put(temp[1],temp[2]);
			}
		}
		
		String[] answer= new String[cnt];
		
		int record_result=0;
		
		for(int index = 0;index <record.length;index++)
		{
			String temp[]= record[index].split(" ");
			
			if(temp[0].equals("Enter"))
			{
				answer[record_result++] = list.get(temp[1]) + "님이 들어왔습니다.";
			}
			else if(temp[0].equals("Leave"))
			{
				answer[record_result++] = list.get(temp[1]) + "님이 나갔습니다.";
			}
		}
		
		
		
		return answer;
	}

}