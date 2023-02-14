import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		// 출력을 위한 StringBuilder;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 0; test_case < T; test_case++) {
			// 편의점 개수
			int convi = Integer.parseInt(br.readLine());
			Point convi_station[] = new Point[convi];
			// 시작 위치
			st = new StringTokenizer(br.readLine());
			Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			// 편의점 위치 체크
			for (int index = 0; index < convi; index++) {
				st = new StringTokenizer(br.readLine());
				convi_station[index] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			// 페스티벌위치
			st = new StringTokenizer(br.readLine());
			Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			if (Run(start, convi_station, end)) {
				sb.append("happy").append("\n");
			} else
				sb.append("sad").append("\n");

		}
		System.out.println(sb);
	}

	private static boolean Run(Point start, Point[] convi_station, Point end) {
		boolean visited[] = new boolean[convi_station.length];
		//이동가능한곳이 있는지 체크
		Queue<Point> que = new LinkedList<>();
		que.offer(start);
		
		while (!que.isEmpty()) {
			Point cur= que.poll();
			if (diff(cur, end)) {
				return true;
			}
			for (int idx = 0; idx < convi_station.length; idx++) {
				// 현재 위치에서 페스티벌까지 그냥 갈수 있을경우 true를 찍어버리고 끝냄.
				if(diff(cur,convi_station[idx]) && !visited[idx]) {
					que.offer(convi_station[idx]);
					visited[idx]= true;
				}

			}
		}
		//만약 이동이 되는곳이없을경우
		return false;
	}

	//이동이 가능한지 체크
	private static boolean diff(Point start, Point end) {
		int num = Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
		if (num <= 1000)
			return true;
		return false;
	}

}
