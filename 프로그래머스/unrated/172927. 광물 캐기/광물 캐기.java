import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        //그룹 리스트 정리용
        List<Group> GroupList = new ArrayList<>();

        int dia = picks[0];
        int iron = picks[1];
        int rock = picks[2];

        int all_pick = dia + iron + rock;

        //미네랄 그룹 나누기
        for (int idx = 0; idx < minerals.length; idx += 5) {
            if(GroupList.size() >=all_pick)
                break;
            Group group = new Group();
            group.Lists = new ArrayList<>();
            for (int check = idx; check < idx + 5; check++) {
                if(minerals.length <= check)
                    break;
                switch (minerals[check]) {
                    case "diamond":
                        group.sum += 25;
                        group.Lists.add(minerals[check]);
                        break;
                    case "iron":
                        group.sum += 5;
                        group.Lists.add(minerals[check]);
                        break;
                    default:
                        group.sum += 1;
                        group.Lists.add(minerals[check]);
                }
            }
            GroupList.add(group);
        }

        //내림차순 정리
        Collections.sort(GroupList, (o1, o2) -> o2.sum - o1.sum);

        for (int idx = 0; idx < GroupList.size(); idx++) {
            //다이아곡갱이는 어쩌피 전부 1임
            if (dia != 0) {
                dia -= 1;
                answer += GroupList.get(idx).Lists.size();
                //철곡갱이는 다이아만 5 그외 전부 1
            } else if (iron != 0) {
                iron -= 1;
                for (int checking = 0; checking < GroupList.get(idx).Lists.size(); checking++) {
                    if (GroupList.get(idx).Lists.get(checking).equals("diamond")) {
                        answer += 5;
                    } else {
                        answer += 1;
                    }
                }
                //돌곡은 다이아 25 철 5 돌 1
            } else if (rock != 0) {
                rock -= 1;
                for (int checking = 0; checking < GroupList.get(idx).Lists.size(); checking++) {
                    if (GroupList.get(idx).Lists.get(checking).equals("diamond")) {
                        answer += 25;
                    } else if (GroupList.get(idx).Lists.get(checking).equals("iron")) {
                        answer += 5;
                    } else {
                        answer += 1;
                    }
                }

                //곡갱이 다쓰면 끝
            } else
                break;
        }

        System.out.println(answer);
        return answer;
    }

    class Group {
        int sum;
        List<String> Lists;
    }
}