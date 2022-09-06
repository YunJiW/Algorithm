
public class Main{
	public static void main(String[] args) {
		int[] n = new int[10001];

		for (int index = 1; index < 10001; index++) {
            int number= index;
            int sum = 0;
            while(number !=0)
            {
                sum += number %10;
                number/=10;
            }
            if(index+ sum+number < 10001)
            {
                n[index+sum+number] = 1;
            }

            
		}
		StringBuilder sb = new StringBuilder();

		for (int index = 1; index < 10001; index++) {
			if (n[index] == 0)
				sb.append(index).append("\n");
		}

		System.out.print(sb);
	}
}
