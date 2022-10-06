//국어는 감소순
//영어는 증가순
//수학은 감소순
//이름은 증가순 -> 대묹는 소문자보다 작으므로 앞에옴.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Person[] rank = new Person[N];
		
				
		for(int index = 0; index < N;index++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String name = st.nextToken();
			int ko = Integer.parseInt(st.nextToken());
			int en = Integer.parseInt(st.nextToken());
			int ma = Integer.parseInt(st.nextToken());
			
			rank[index] = new Person(name,ko,en,ma);
		}
		
		Arrays.sort(rank, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if(o1.kor != o2.kor)
				{
					return o2.kor - o1.kor;
				}else {
					if(o1.eng != o2.eng)
					{
						return o1.eng - o2.eng;
					}else {
						if(o1.math != o2.math)
						{
							return o2.math - o1.math;
						}
						else {
							return o1.name.compareTo(o2.name);
						}
					}
				}
			}
		});
		
		
		for(int index =0 ; index < N;index++)
		{
			System.out.println(rank[index].getName());
		}
	
		
	}
	public static class Person{

		String name;
		int kor;
		int eng;
		int math;
		
		Person(String name,int kor,int eng,int math){
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		
		public String getName() {
			return name;
		}

		public int getKor() {
			return kor;
		}

		public int getEng() {
			return eng;
		}

		public int getMath() {
			return math;
		}

	}

}
