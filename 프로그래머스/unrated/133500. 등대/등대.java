import java.util.*;
class Solution {
    public int N,result = 0;
    public List<List<Integer>> map= new ArrayList<>();

        public int solution(int n, int[][] lighthouse) {
            N =n;

            for(int idx = 0; idx <=n;idx++){
                map.add(new ArrayList<>());
            }
            for(int index = 0; index <lighthouse.length;index++){
                int start = lighthouse[index][0];
                int end = lighthouse[index][1];
                map.get(start).add(end);
                map.get(end).add(start);
            }

            dfs(1,0);
            return result;
        }

        //1 불을 키지않는다
        //0 불을 킨다.
    private int dfs(int cur, int before) {
            if(map.get(cur).size() == 1 && map.get(cur).get(0) == before){
                return 1;
            }
            int tmp =0;
            for(int idx = 0; idx < map.get(cur).size();idx++){
                int next = map.get(cur).get(idx);
                //이미 체크된경우 pass
                if(next == before) continue;
                tmp += dfs(next,cur);

            }

            if(tmp ==0){
                return 1;
            }


            result +=1;
            return 0;
    }
}
