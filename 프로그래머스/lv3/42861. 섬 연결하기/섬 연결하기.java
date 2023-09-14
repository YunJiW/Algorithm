import java.util.*;


class Solution {
    private int[] parent;


    public int solution(int n, int[][] costs) {
        int answer = 0;
        int index, j;
        parent = new int[n];

        //각 부모값들을 자기 자신으로 먼저 해둔다.
        for(index =0 ;index < parent.length;parent[index] = index++);
        //비용 기준 오름 차순 정렬진행
            Arrays.sort(costs, (o1, o2) -> {
                if(o1[2] > o2[2]){
                    return 1;
                }else
                    return -1;
            });

            //핵심로직
            for(index = 0; index <costs.length;index++){
                //둘이 부모가 같은 경우 -> 연결되어있음.
                if(get_parent(costs[index][0]) == get_parent(costs[index][1]))
                    continue;
                union(costs[index][0],costs[index][1]);
                //이게 되는 이유 -> 비용기준으로 오름차순 정렬을 했기 때문에
                answer += costs[index][2];
            }


        return answer;
    }

    //부모 찾기
    private int get_parent(int a){
        if(a == parent[a]){
            return parent[a];
        }else{
            return parent[a] = get_parent(parent[a]);
        }
    }

    public void union(int a, int b){
        a = get_parent(a);
        b = get_parent(b);

        if(a > b){
            parent[a] = b;
        }else{
            parent[b] = a;
        }
    }
}