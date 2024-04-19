import java.io.*;

public class Main {

    static class Node{
        int num;
        Node left,right;

        public Node(int num) {
            this.num = num;
        }

        public Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        public void insert(int n){
            if(n < num){
                if(left == null){
                    left = new Node(n);
                }else {
                    left.insert(n);
                }
            }else{
                if(right ==null){
                    right = new Node(n);
                }else{
                    right.insert(n);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while(true){
            input = br.readLine();
            if(input == null || input == "")
                break;
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);

    }

    private static void postOrder(Node node) {
        if(node ==null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
}
