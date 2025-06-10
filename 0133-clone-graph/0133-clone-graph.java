/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> hm = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) 
            return null;
        
        if(hm.containsKey(node))
            return hm.get(node);
        
        Node cur = new Node(node.val);
        hm.put(node, cur);

        for(Node n : node.neighbors)
            cur.neighbors.add(cloneGraph(n));

        return cur;
    }
}