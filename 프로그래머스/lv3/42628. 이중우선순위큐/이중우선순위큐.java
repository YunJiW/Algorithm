import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;


class Solution
{
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> lists = new PriorityQueue<>();
        
        for(int index = 0; index < operations.length;index++)
        {
        	String com[] = operations[index].split(" ");
        	char command = com[0].charAt(0);
        	int data = Integer.parseInt(com[1]);
        	
        	if(command == 'I') {
        		lists.offer(data);
        		
        		//삭제 진행
        	}else if(command == 'D') {
        		if(data ==1) {
        			//비어있을경우 무시
        			if(lists.isEmpty()) {
        				continue;
        			}
        			int len = lists.size();
        			PriorityQueue<Integer> list = new PriorityQueue<>();
        			for(int num = 0;num <len-1;num++)
        			{
        				list.offer(lists.poll());
        			}
        			lists =list;
        		}
        		else if(data ==-1) {
        			//비어있을경우 무시
        			if(lists.isEmpty()) {
        				continue;
        			}
        			
        			lists.remove();
        		}
        		
        		
        		
        	}
        	
        }
        if(lists.isEmpty()) {
        	answer[0] = 0;
        	answer[1] = 0;
        }
        else {
        	answer[1] = lists.poll();
        	while(lists.size() > 0) answer[0] = lists.poll();
        }
        
        
        return answer;
    }
}