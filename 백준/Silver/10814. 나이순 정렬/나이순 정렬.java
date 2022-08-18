import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Person[] p = new Person[N];
		
		for(int i = 0; i <N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			//p[i]에 넣어줌
			p[i] = new Person(age,name);
		}
		//Comparator 오버라이딩
		Arrays.sort(p, new Comparator<Person>() {
			
			//나이 비교
			@Override
			public int compare(Person s1, Person s2) {
				return s1.age - s2.age;
			}		
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ;i<N; i++) {
			sb.append(p[i]);
		}
        System.out.println(sb);
	}
	
	//나이와 이름을 가지고있는 클래스 person
	public static class Person{
		int age;
		String name;
		
		Person(int age,String name){
			this.age = age;
			this.name = name;
			
		}
		
		@Override
			public String toString() {
				return age + " " + name + "\n";
			}
	}
}
