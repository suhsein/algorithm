import java.util.*;
import java.io.*;

class Solution {
    static int[][] tree;
    static boolean[] visit;
    public int[][] solution(int[][] nodeinfo) {      
        int idx = 1;
        List<Node> list = new ArrayList<>();
        
        for(int i = 0; i < nodeinfo.length; i++)
            list.add(new Node(idx++, nodeinfo[i][0], nodeinfo[i][1])); 

        Collections.sort(list);
        
        
        int N = list.size();        
        BST tree = new BST();
        
        for(Node node : list) 
            tree.insert(node);
        
        int[][] answer = new int[2][N];
        
        List<Integer> preorder = tree.preorder();
        List<Integer> postorder = tree.postorder();
        
        for(int i = 0; i < N; i++) {
            answer[0][i] = preorder.get(i);
            answer[1][i] = postorder.get(i);
        }
        
        return answer;
    }
    
    class BST {
        public Node root;
        
        public BST() {
            root = null;    
        }
        
        public void insert(Node node) {
            if(root == null) {
                root = node;
                return;
            }
            insertRec(root, node);
        }
        
        public Node insertRec(Node parent, Node child) {
            if(parent == null) return child;
            
            if(parent.x > child.x) parent.left = insertRec(parent.left, child);
            else if(parent.x < child.x) parent.right = insertRec(parent.right, child);
                
            return parent;
        }
        
        public List<Integer> preorder(){
            List<Integer> order = new ArrayList<>();
            preorderRec(root, order);
            return order;
        }
        
        public void preorderRec(Node cur, List<Integer> order){
            if(cur == null) return;
            order.add(cur.num);
            preorderRec(cur.left, order);
            preorderRec(cur.right, order);
        }
        
        public List<Integer> postorder(){
            List<Integer> order = new ArrayList<>();
            postorderRec(root, order);
            return order;
        }

        public void postorderRec(Node cur, List<Integer> order){
            if(cur == null) return;
            postorderRec(cur.left, order);
            postorderRec(cur.right, order);
            order.add(cur.num);
        }
    }
    
    class Node implements Comparable<Node>{
        int num, x, y;
        Node left, right;
        
        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.left = null;
            this.right = null;
        }
        
        public int compareTo(Node n){
            if(this.y == n.y) 
                return this.x - n.x;
            return n.y - this.y;
        }
    }
}