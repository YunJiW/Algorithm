import java.util.*;

class Solution {
    ArrayList<String> answerList = new ArrayList<>();

    HashMap<String,Integer> maps = new HashMap<>();


    public String[] solution(String[] orders, int[] course) {
        String[] answer;

        //정렬해준다.
        for(int idx =0 ;idx < orders.length;idx++) {
            char arr[] = orders[idx].toCharArray();
            Arrays.sort(arr);
            orders[idx] = String.valueOf(arr);
        }

        for(int courselength: course){
            for(String order : orders){
                combi("",order,courselength);
            }

            if(!maps.isEmpty()){
                List<Integer> countList = new ArrayList<>();
                //최대값을 뽑기위해서 넣어줌.
                for(String key : maps.keySet()){
                    countList.add(maps.get(key));
                }
                int max = Collections.max(countList);
                if(max > 1){
                    for(String key : maps.keySet()){
                        if(maps.get(key) == max){
                            answerList.add(key);
                        }
                    }
                }


            }
            maps.clear();
        }

        Collections.sort(answerList);
        answer = new String[answerList.size()];
        for(int idx=0; idx <answer.length;idx++){
            answer[idx] = answerList.get(idx);
        }
        return answer;
    }

    private void combi(String order, String orders, int count) {
        if(count == 0){
            maps.put(order,maps.getOrDefault(order,0)+1);
            return;
        }
        for(int idx = 0; idx < orders.length();idx++){
            combi(order+orders.charAt(idx),orders.substring(idx+1),count-1);
        }
    }
}