import java.util.ArrayList;
import java.util.Collections;


class Solution 
{
	char alpha[] = {'A','E','I','O','U'};

	ArrayList<String> array = new ArrayList<>();
	
    public int solution(String word) {
        int answer = 0;
        
        
        start(0,"");
        
        
        //오름 차순 정리
        Collections.sort(array);
        
        answer = array.indexOf(word) +1;
        return answer;
    }

	private void start(int depth, String string) {
		if(depth >= 5) return;
		for(int index = 0; index < alpha.length;index++) {
			array.add(string+alpha[index]);
			start(depth+1,string+alpha[index]);
		}
		
	}
}