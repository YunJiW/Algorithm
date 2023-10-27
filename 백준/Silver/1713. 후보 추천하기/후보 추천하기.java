import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        Student stds[] = new Student[101];
        ArrayList<Student> album = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int ReCommand= Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int idx= 0; idx < ReCommand;idx++){
            int std_id = Integer.parseInt(st.nextToken());

            if(stds[std_id] == null){
                stds[std_id] = new Student(std_id,0,0,false);
            }

            if(stds[std_id].posted){
                stds[std_id].count +=1;
            }

            else{
                if(album.size() == N){

                    Collections.sort(album, new Comparator<Student>() {
                        public int compare(Student o1, Student o2) {
                            if(o1.count == o2.count){
                                return o1.time - o2.time;
                            }
                            return o1.count - o2.count;
                        }
                    });
                    album.get(0).posted = false;
                    album.remove(0);
                }
                stds[std_id].count =1;
                stds[std_id].time = idx;
                stds[std_id].posted = true;
                album.add(stds[std_id]);
            }
        }

        Collections.sort(album,(o1, o2) -> o1.index - o2.index);

        StringBuilder sb = new StringBuilder();
        for(Student s : album){
            sb.append(s.index).append(" ");
        }

        System.out.print(sb);

    }


    public static class Student {
        int index;
        int count;

        int time;

        boolean posted;

        public Student(int index, int count, int time, boolean posted) {
            this.index = index;
            this.count = count;
            this.time = time;
            this.posted = posted;
        }
    }
}
