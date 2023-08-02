import java.util.*;

class Solution {
    int[][] result;
    int index = 0;


    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};

        Node[] nodes = new Node[nodeinfo.length];

        for(int idx = 0; idx <nodeinfo.length;idx++){
            nodes[idx] = new Node(idx+1,nodeinfo[idx][0],nodeinfo[idx][1],null,null);
        }

        Arrays.sort(nodes, (o1, o2) -> {

            if(o1.y == o2.y){
                return o1.x - o2.x;
            }
            return o2.y - o1.y;
        });

        Node parent = nodes[0];

        for(int idx =1;idx <nodes.length;idx++){
            MakeTree(parent,nodes[idx]);
        }

        result = new int[2][nodeinfo.length];
        preorder(parent);
        index=0;
        postorder(parent);

        answer =result;
        return answer;
    }

    //트리 만들기(핵심 로직)
    //현재 기준에서 parent x보다 크면 right 작으면 left
    private void MakeTree(Node parent, Node node) {
        if(parent.x < node.x){
            if(parent.right == null){
                parent.right = node;
                //연결된것이 있는경우 다음 노드로 가서 진해
                //연결된것이 있는경우 다음 노드로 가서 진해
            }else{
                MakeTree(parent.right,node);
            }

        }

        //left부분도 같은 수순으로 진행
        else{
            if(parent.left == null){
                parent.left = node;
            }else{
                MakeTree(parent.left,node);
            }
        }
    }

    //전위순회
    public void preorder(Node root){
        if(root != null){
            result[0][index++] = root.value;
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            result[1][index++] = root.value;
        }
    }

    //핵심 클래스
    class Node {
        public int value;
        public int x;
        public int y;

        //좌우 노드 
        public Node right;
        public Node left;


        public Node(int value, int x, int y, Node right, Node left) {
            this.value = value;
            this.x = x;
            this.y = y;
            this.right = right;
            this.left = left;
        }
    }
}