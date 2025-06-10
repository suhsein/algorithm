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
    public Node cloneGraph(Node node) {
        if(node == null) 
            return null;
        if(node.neighbors.size() == 0)
            return new Node(1);

        Map<Integer, Node> dict = new HashMap<>();
        boolean[] visit = new boolean[101];
        Queue<Node> q = new LinkedList<>();

        Node first = new Node(1);
        dict.put(1, first);
        q.add(node);

        while(!q.isEmpty()){
            Node cur = q.poll();
            int val = cur.val;

            if(visit[val]) continue;
            visit[val] = true;

            Node clone = dict.get(val);
            if(clone == null) {
                clone = new Node(val);
                dict.put(val, clone);
            }

            for(Node n : cur.neighbors) {
                if(visit[n.val]) continue;

                Node nClone = dict.get(n.val);
                if(nClone == null) {
                    nClone = new Node(n.val);
                    dict.put(n.val, nClone);
                }

                clone.neighbors.add(nClone);
                nClone.neighbors.add(clone);
                q.add(n);
            }
        }
        
        return first;
    }
}