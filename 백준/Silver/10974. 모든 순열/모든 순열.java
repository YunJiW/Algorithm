import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static int N;
    public static int[] arr;
    public static boolean[] check;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        check = new boolean[N];
        
        dfs(0);
        
    }
    public static void dfs(int depth){
        if(depth == N)
        {
            for(int num : arr)
            {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        
        for(int index =0 ; index <N;index++)
        {
            if(!check[index])
            {
                check[index] = true;
                arr[depth] = index+1;
                dfs(depth+1);
                check[index] = false;
            }
        }
    }
}