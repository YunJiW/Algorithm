import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.Comparator;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        Integer[] nums = new Integer[S.length()];
        
        for(int index = 0 ; index < S.length();index++)
        {
            char ch = S.charAt(index);
            nums[index] = ch - '0';
        }
        Arrays.sort(nums, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
            
        });
        for(int k : nums)
        {
        	System.out.print(k);
        }
    }
}