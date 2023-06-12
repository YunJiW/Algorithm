import java.util.*;
class Solution {


    static char top[] = {'-', '*', '+'};
    long answer = Long.MIN_VALUE;

    public long solution(String expression) {
        ArrayList<Long> list = new ArrayList<>();
        ArrayList<Character> op_list = new ArrayList<>();

        String num = "";
        for (int idx = 0; idx < expression.length(); idx++) {
            if (expression.charAt(idx) >= '0' && expression.charAt(idx) <= '9') {
                num += expression.charAt(idx);
            } else {
                list.add(Long.parseLong(num));
                num = "";
                op_list.add(expression.charAt(idx));
            }

        }
        list.add(Long.parseLong(num));

        perm(list, op_list, 0);


        return answer;
    }

    private void perm(ArrayList<Long> list, ArrayList<Character> opList, int depth) {
        if (depth == 3) {
            Long temp = Calc((ArrayList<Long>) list.clone(), (ArrayList<Character>) opList.clone());
            if(temp > answer){
                answer = temp;
            }
            return;
        }

        for (int idx = depth; idx < 3; idx++) {
            swap(idx, depth);
            perm(list, opList, depth + 1);
            swap(idx, depth);
        }
    }

    private Long Calc(ArrayList<Long> list, ArrayList<Character> opList) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < opList.size(); j++) {
                if (opList.get(j) == top[i]) {
                    switch (top[i]) {
                        case '-':
                            list.add(j, list.remove(j) - list.remove(j));
                            break;
                        case '*':
                            list.add(j, list.remove(j) * list.remove(j));
                            break;
                        case '+':
                            list.add(j, list.remove(j) + list.remove(j));
                            break;
                    }
                    opList.remove(j--);
                }
            }
        }

        return Math.abs(list.get(0));
    }


    public void swap(int a, int b) {
        char temp = top[a];
        top[a] = top[b];
        top[b] = temp;
    }

}