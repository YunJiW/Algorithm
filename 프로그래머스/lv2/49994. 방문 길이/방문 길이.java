import java.util.Objects;
import java.util.HashSet;

class Solution
{
	class pointxy {
		int curx;
		int cury;

		int nxtx;
		int nxty;

		pointxy(int curx, int cury, int nxtx, int nxty) {
			this.curx = curx;
			this.cury = cury;

			this.nxtx = nxtx;
			this.nxty = nxty;
		}
		@Override
		public boolean equals(Object obj) {
			if (obj == this)
				return true;
			if (!(obj instanceof pointxy)) {
				return false;
			}
			pointxy tmp = (pointxy) obj;

			return curx == tmp.curx && cury == tmp.cury && nxtx == tmp.nxtx && nxty == tmp.nxty;
		}
		@Override
		public int hashCode() {
			return Objects.hash(curx, cury, nxtx, nxty);
		}
	}

	public int solution(String dirs) {
		int answer = 0;
		char command[] = new char[dirs.length()];
		HashSet<pointxy> pointing = new HashSet<>();
		for (int index = 0; index < dirs.length(); index++) {
			command[index] = dirs.charAt(index);
		}

		// 진행
		answer = Run(command, pointing);
		return answer;
	}

	private int Run(char[] command, HashSet<pointxy> pointing) {
		int x = 0;
		int y = 0;
		int nxtx = 0;
		int nxty = 0;

		for (int index = 0; index < command.length; index++) {
			char com = command[index];

			switch (com) {
			case 'U':
				if (y + 1 > 5)
					continue;
				nxty = y + 1;
				pointing.add(new pointxy(x, y, nxtx, nxty));
				y = nxty;
				break;
			case 'D':
				if (y - 1 < -5)
					continue;
				nxty = y-1;
				pointing.add(new pointxy(nxtx, nxty, x, y));
				y = nxty;

				break;
			case 'L':
				if (x - 1 < -5)
					continue;
				nxtx=x-1;
				pointing.add(new pointxy(nxtx, nxty, x, y));
				x=nxtx;
				break;
			case 'R':
				if (x + 1 > 5)
					continue;
				nxtx = x + 1;
				pointing.add(new pointxy(x, y, nxtx, nxty));
				x = nxtx;
				break;
			}

		}

		return pointing.size();
	}
}