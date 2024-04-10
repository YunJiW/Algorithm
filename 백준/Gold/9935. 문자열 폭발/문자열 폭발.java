import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String bomb = br.readLine();

        int bomblen = bomb.length();

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int idx = 0; idx < line.length(); idx++) {
            stack.push(line.charAt(idx));

            if (stack.size() >= bomblen) {
                boolean check = true;

                for (int i = 0; i < bomblen; i++) {

                    if (stack.get(stack.size() - bomblen + i) != bomb.charAt(i)) {
                        check = false;
                        break;
                    }
                }
                //이게 가능한이유
                //문자열이 같아지면 시작하기 때문에 + stack의 특징
                if (check) {
                    for (int i = 0; i < bomblen; i++) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for (Character c : stack) {
                sb.append(c);
            }
            System.out.println(sb);
        }

    }
}
