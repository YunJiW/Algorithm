import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] table = new int[N][2];
        
        for(int index =0 ; index < N;index++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            table[index][0] = Integer.parseInt(st.nextToken());
            table[index][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(table, new Comparator<int[]>(){
            
            public int compare(int[] o1,int[] o2)
            {
                if(o1[1] == o2[1])
                {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
            
        });
        
        int cnt = 0;
        int pre = 0;
        
        for(int index =0 ; index < N;index++){
            if(pre <= table[index][0])
            {
                pre = table[index][1];
                cnt++;
            }
        }
        System.out.println(cnt);
        
        
        
    }
}