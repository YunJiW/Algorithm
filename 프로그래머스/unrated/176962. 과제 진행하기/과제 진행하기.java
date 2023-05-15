import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];

        subject[] subjects = new subject[plans.length];

        for (int idx = 0; idx < plans.length; idx++) {
            subject idx_subject = new subject();
            idx_subject.name = plans[idx][0];
            String[] times = plans[idx][1].split(":");
            //분으로 변환해서 체크
            int start = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            int end = start + Integer.parseInt(plans[idx][2]);

            idx_subject.start_time = start;
            idx_subject.end_time = end;

            subjects[idx] = idx_subject;
        }


        //시작 시간순 정렬
        Arrays.sort(subjects, new Comparator<subject>() {
            @Override
            public int compare(subject o1, subject o2) {
                return o1.start_time - o2.start_time;
            }
        });

        System.out.println("정렬 후");
        for (int idx = 0; idx < subjects.length; idx++) {
            System.out.println(subjects[idx].name);
        }
        System.out.println("---");
        Stack<subject> stack = new Stack<>();
        int index = 0;
        for (int idx = 0; idx < subjects.length; idx++) {
            //비어있는경우
            if (stack.isEmpty()) {
                stack.push(subjects[idx]);
                continue;
            }
            //끝나는 시간보다 시작시간이 빠른경우
            if (stack.peek().end_time > subjects[idx].start_time) {
                subject subject = stack.pop();
                subject.rest_time = subject.end_time - subjects[idx].start_time;
                stack.push(subject);
                stack.push(subjects[idx]);
            }
            //끝나는 시간이 시작 시간보다 빠를경우
            else if (stack.peek().end_time < subjects[idx].start_time) {
                subject subject = stack.pop();

                answer[index++] = subject.name;
                int curEndTime = subject.end_time;
                //멈춰둔 과제를 체크한다.
                while (!stack.isEmpty()) {
                    subject stopsubject = stack.pop();
                    //만약 멈춰둔 과제를 남은 시간과 이전 과제가 끝난 시간 합친게 다음 과제시작 시간보다 빠르거나 같은경우
                    if (stopsubject.rest_time + curEndTime <= subjects[idx].start_time) {
                        answer[index++] = stopsubject.name;
                        curEndTime += stopsubject.rest_time;
                        
                    }
                    // 늦는 경우 -> 시간만큼 돌리고 다시 넣어줌
                    else {
                        stopsubject.rest_time -= (subjects[idx].start_time - curEndTime);
                        stack.push(stopsubject);
                        break;
                    }
                }
                stack.push(subjects[idx]);
            }
            //둘이 같은경우
            else {
                answer[index++] = stack.pop().name;
                stack.push(subjects[idx]);
            }
        }

        //마지막 남아있는 친구 뺴기
        while (!stack.isEmpty()) {
            answer[index++] = stack.pop().name;
        }
        return answer;
    }

    class subject {
        String name;
        int start_time;
        int end_time;

        int rest_time;

    }


}




