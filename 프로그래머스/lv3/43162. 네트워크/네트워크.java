
import java.util.LinkedList;


class Solution {
    
    int dx[] = {0,0,-1,1};
    int dy[] = {-1,1,0,0};

    boolean visited[];
    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        for(int index =0;index <n;index++){
            if(!visited[index]){
                answer+=1;
                newtwork_check(index,visited,computers);
            }
        }
        return answer;
    }


    public void newtwork_check(int index,boolean[] visited,int[][] computers){
        visited[index] = true;
        for(int col = 0; col < computers[index].length;col++){
            if(index == col){
                continue;
            }

            if(!visited[col] && computers[index][col] != 0){
                newtwork_check(col,visited,computers);
            }
        }
    }
}
