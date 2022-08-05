import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int first = 666;
        int cnt = 1;
        
        while(cnt < N)
        {
            first++;
            String ans = String.valueOf(first);
            if(ans.contains("666"))
                cnt++;
            
        }
        System.out.print(first);
    }
}