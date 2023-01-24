import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {

    boolean visited[];
    ArrayList<String> arr;
    public String[] solution(String[][] tickets) {
        arr= new ArrayList<>();
        visited = new boolean[tickets.length];

        dfs(0,"ICN","ICN",tickets);
        Collections.sort(arr);
        String[] answer = arr.get(0).split(" ");
        return answer;
    }

    public void dfs(int depth,String start,String Route,String[][] tickets){
        if(depth == tickets.length){
            arr.add(Route);
            return;
        }


        for(int index =0 ;index <tickets.length;index++){
            if(!visited[index] && tickets[index][0].equals(start)){
                visited[index] = true;
                dfs(depth+1,tickets[index][1],Route+" "+tickets[index][1],tickets);
                visited[index] = false;
            }
        }



    }
}