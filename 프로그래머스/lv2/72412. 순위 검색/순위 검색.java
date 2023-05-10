import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        Map<String, List<Integer>> combi = new HashMap<>();
        //전체 조합 부분
        for (String infoRows : info) {
            String[] infos = infoRows.split(" ");

            String[] langs = new String[]{"-", infos[0]};
            String[] jobs = new String[]{"-", infos[1]};
            String[] carrers = new String[]{"-", infos[2]};
            String[] soulfoods = new String[]{"-", infos[3]};
            int score = Integer.parseInt(infos[4]);

            for (String language : langs) {
                for (String job : jobs) {
                    for (String carrer : carrers) {
                        for (String soulfood : soulfoods) {
                            String Key = language + " " + job + " " + carrer + " " + soulfood;
                            combi.putIfAbsent(Key, new ArrayList<>());
                            combi.get(Key).add(score);
                        }
                    }
                }
            }
        }
        combi.forEach((key, score) -> score.sort(Integer::compareTo));

        for(int idx= 0; idx < answer.length;idx++){
            int lastSpaceIndex = query[idx].lastIndexOf(" ");
            String key = query[idx].substring(0, lastSpaceIndex).replaceAll(" and "," ");
            int count = Integer.parseInt(query[idx].substring(lastSpaceIndex+1));

            answer[idx] = countBiggerThan(combi.get(key),count);
        }
        return answer;
    }
    


    private int countBiggerThan(List<Integer> personList, int score) {
        if (personList == null) return 0;
        if (personList.isEmpty()) return 0;

        int left_idx = 0;
        int right_idx = personList.size() - 1;

        while (left_idx <= right_idx) {
            int mid = (left_idx + right_idx) / 2;

            if (personList.get(mid) < score) {
                left_idx = mid + 1;
            } else {
                right_idx = mid - 1;
            }
        }
        return personList.size() - left_idx;
    }

}