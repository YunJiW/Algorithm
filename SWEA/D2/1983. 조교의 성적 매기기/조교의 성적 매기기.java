import java.util.*;
import java.io.*;

class Solution
{
       static int mid_per = 35;
    static int final_per = 45;
    static int quiz_per = 20;

    //학점 등급표
    static String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int all = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int grade_part = all / 10;
            List<person> persons = new ArrayList<>();
            for (int idx = 0; idx < all; idx++) {
                st = new StringTokenizer(br.readLine());
                int mid = Integer.parseInt(st.nextToken());
                int finals = Integer.parseInt(st.nextToken());
                int quiz = Integer.parseInt(st.nextToken());
                person person = new person();
                person.index = idx + 1;
                person.sum = (mid * mid_per) + (finals * final_per) + (quiz * quiz_per);

                persons.add(person);
            }
            //성적순 정렬
            Collections.sort(persons, new Comparator<person>() {
                @Override
                public int compare(person o1, person o2) {
                    return o2.sum - o1.sum;
                }
            });

            int pos = 0;
            //등수 체크
            for (int idx = 0; idx < persons.size(); idx++) {
                if (persons.get(idx).index == K) {
                    pos = idx;
                    break;
                }
            }
            //현재 몇등인가?
            sb.append("#" + test_case + " ").append(grade[pos / grade_part]).append("\n");
        }
        System.out.println(sb);

    }

    static class person {
        int index;
        int sum;
    }
}