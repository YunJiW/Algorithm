import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> child[];
    int maxSheepCnt = 0;

    int Info[];
    public int solution(int[] info, int[][] edges) {
        child = new ArrayList[info.length];
        Info = info;

        for(int [] I : edges){
            int parent = I[0];
            int childs = I[1];

            if(child[parent] == null){
                child[parent] = new ArrayList<>();
            }
            child[parent].add(childs);
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0,0,0,list);




        return maxSheepCnt;
    }

    private void dfs(int idx, int sheepCnt,int wolfCnt ,List<Integer> nextPos) {
        if(Info[idx] == 0) sheepCnt +=1;
        else wolfCnt +=1;

        //양보다 늑대가 많은 경우 return 그 경우 끝내줌
        if(wolfCnt >= sheepCnt) return;
        maxSheepCnt = Math.max(sheepCnt,maxSheepCnt);

        List<Integer> list = new ArrayList<>();
        list.addAll(nextPos);

        //중복 제거
        list.remove(Integer.valueOf(idx));
        if(child[idx] != null){
            for(int childs : child[idx]){
                list.add(childs);
            }
        }
        for(int next : list){
            dfs(next,sheepCnt,wolfCnt,list);
        }
        
    }
}