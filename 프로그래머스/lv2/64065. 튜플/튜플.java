import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution
{
    public int[] solution(String s) {
        s= s.substring(2, s.length()-2);
        s= s.replace("},{","-");
        
        String arr[] = s.split("-");
        
        Arrays.sort(arr ,new Comparator<String>() {
        	
        	public int compare(String o1,String o2) {
        		return Integer.compare(o1.length(),o2.length());
        	}
        	
        });
        
        
        ArrayList<Integer> tuples = new ArrayList<>();
        for(int index =0 ;index <arr.length;index++) {
        	String[] check = arr[index].split(",");
        	for(int indexs = 0;indexs <check.length;indexs++) {
        		int number = Integer.parseInt(check[indexs]);
        		if(tuples.isEmpty()) {
        			tuples.add(number);
        			continue;
        		}
        		if(!tuples.contains(number)) {
        			tuples.add(number);
        		}
        		
        		
        	}
        }
        int answer[] = new int[tuples.size()];
        for(int idx = 0; idx< tuples.size();idx++) {
        	answer[idx] = tuples.get(idx);
        }
        
        return answer;
    }
}
