import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.Comparator;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        Integer[] nums = new Integer[S.length()];
        
        int total = 0;
        for(int index = 0 ;index < S.length();index++)
        {
            nums[index] = S.charAt(index) - '0';
            total += nums[index];
        }
        
        Arrays.sort(nums, new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2)
            {
                return o2 - o1;
            }
        });
        
        if(!S.contains("0") || total % 3 != 0)
        {
            System.out.print("-1");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int number : nums){
            sb.append(number);
        }
        System.out.print(sb);
    }
}