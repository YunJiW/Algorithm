import java.util.*;


class Solution {

    boolean[] visited;


    List<Integer> list;


    public int solution(int[] cards) {
        int answer = 1;
        int len = cards.length;
        visited = new boolean[len];

        list = new ArrayList<>();
        for (int idx = 0; idx < len; idx++) {
            if (!visited[idx]) {
                start(cards, idx, 0);
            }
        }
        if(list.size() < 2) {
            return 0;
        }

        Collections.sort(list, Collections.reverseOrder());
        answer = list.get(0) * list.get(1);


        return answer;
    }

    private void start(int[] cards, int idx, int cnt) {
        if (visited[idx]) {
            list.add(cnt);
            return;
        }

        visited[idx] = true;
        start(cards,cards[idx]-1, cnt + 1);
    }
}