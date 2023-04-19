import java.util.*;

class Solution {
    ArrayList<int[]> seq;
    public int[][] solution(int n) {
        seq = new ArrayList<>();
                        
        Hanoi(n,1,3,2);
        int[][] answer = new int[seq.size()][2];
        
        for(int i = 0 ; i<seq.size();i++)
        {
            int [] cmd = seq.get(i);
            answer[i][0] = cmd[0];
            answer[i][1] = cmd[1];
        }
        
        
        
        
        
        return answer;
    }
    
    private void Hanoi(int n,int from,int to,int via){
        int [] move ={from,to};
        if(n == 1){
            seq.add(move);
        }else{
            Hanoi(n-1,from,via,to);
            seq.add(move);
            Hanoi(n-1,via,to,from);
        }
            
    }
}