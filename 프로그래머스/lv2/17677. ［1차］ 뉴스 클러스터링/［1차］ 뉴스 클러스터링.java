import java.util.*;

class Solution 
{
	public int solution(String str1,String str2) {
		//소문자로 전부 통일
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		int answer =0;
		HashMap<String,Integer> Map1= new HashMap<>();
		HashMap<String,Integer> Map2 =new HashMap<>();
		HashSet<String> union = new HashSet<>(); //합집합용
		
		//문자열 1번 모아놓기
		for(int idx = 0; idx< str1.length()-1;idx++) {
			String check = str1.substring(idx,idx+2);
			if(is_possible(check)) {
				Map1.put(check,Map1.getOrDefault(check,0)+1);
				union.add(check);
			}
		}
		//문자열 2번 모아놓기
		for(int idx = 0; idx< str2.length()-1;idx++) {
			String check2 = str2.substring(idx,idx+2);
			if(is_possible(check2)) {
				Map2.put(check2,Map2.getOrDefault(check2,0)+1);
				union.add(check2);
			}
		}
		int total = 0;
		
		for(String s: union) {
			total += Math.max(Map1.getOrDefault(s, 0),Map2.getOrDefault(s,0));
		}
		for(String s:Map2.keySet()) {
			if(Map1.containsKey(s)) {
				answer+= Math.min(Map1.get(s), Map2.get(s));
			}
		}
		
		if(total == 0) return 65536;
		return (answer * 65536)/total;
	}

	//알파벳인지 체크
	private boolean is_possible(String check) {
		for(int idx=0;idx<check.length();idx++)
		{
            if(check.charAt(idx) ==' ')
                return false;
			//범위안에 못들어갈경우 알파벳이 아니다.
			if(check.charAt(idx) < 'a' || check.charAt(idx) > 'z') {
				return false;
			}
		}
		return true;
	}

}
