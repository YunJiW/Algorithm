import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
class Solution {

    HashSet<String> Sets = new HashSet<>();
    HashMap<String,Integer> maps = new HashMap<>();
    //새로운 누적 idx가 생길떄마다 갱신위해서 사용

    public int[] solution(String msg) {
        char alpha = 'A';
        //담아둘꺼
        ArrayList<Integer> ans = new ArrayList<>();
        //처음 A~Z까지 먼저 넣어두기
        for(int idx=0;idx <26;idx++)
        {

            String al = String.valueOf((char) (alpha + idx));
            System.out.println(al);
            Sets.add(al);
            maps.put(al,idx+1);
        }
        int check_idx = maps.size()+1;
        //첫 글자부터 시작
        int idx;
        String checking="";
        for(idx =0; idx< msg.length()-1;) {
            System.out.println("현재 글자위치 : " + idx);
            checking = String.valueOf(msg.charAt(idx));
            int checking_idx = maps.get(checking);
            for (int next = idx + 1; next < msg.length(); next++) {
                checking += String.valueOf(msg.charAt(next));
                System.out.println(checking);
                //만약 먼저 넣어둔거에 없는 경우
                if (!Sets.contains(checking)) {
                    System.out.println(checking + ": 없음");
                    ans.add(checking_idx);
                    Sets.add(checking);
                    maps.put(checking, check_idx++);
                    idx = next;
                    checking ="";
                    break;
                } else {
                    checking_idx = maps.get(checking);
                    idx++;
                }
            }
        }
        if(checking.equals("")){
            ans.add(maps.get(String.valueOf(msg.charAt(msg.length()-1))));
        }
        else {
            ans.add(maps.get(checking));
        }
        int answer[] = new int[ans.size()];
        for(int index = 0; index<ans.size();index++){
            answer[index] = ans.get(index);
        }
        return answer;
    }
}