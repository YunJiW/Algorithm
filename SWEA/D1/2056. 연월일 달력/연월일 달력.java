import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		sc.nextLine();

		for (int test_case = 1; test_case <= T; test_case++) {
			String One_day = sc.nextLine();
			int Year = Integer.parseInt(One_day.substring(0, 4));
			int month = Integer.parseInt(One_day.substring(4, 6));
			int day = Integer.parseInt(One_day.substring(6));
			

			if (month > 12 || month <= 0) {
				System.out.println("#" + test_case + " -1");
				continue;
			}

			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				if ( day > months[month-1]) {
					System.out.println("#" + test_case + " -1");
					continue;
				}

			} else if (month == 2) {
				if ( day > months[month-1]) {
					System.out.println("#" + test_case + " -1");
					continue;
				}
			} else if(month == 4 || month == 6 || month == 9 || month == 11){
				if ( day > months[month-1]) {
					System.out.println("#" + test_case + " -1");
					continue;
				}		
			}
			else {
				System.out.println("#" + test_case + " -1");
				continue;
			}
			System.out.println("#" + test_case + " " + String.format("%04d", Year) + "/" + String.format("%02d", month) + "/" + String.format("%02d", day));
		}

	}
}