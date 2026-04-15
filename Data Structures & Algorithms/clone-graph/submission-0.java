/*
Definition for a Node.
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

    HashMap<Node,Node> hm=new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }

        Node clone=new Node(node.val);
        hm.put(node,clone); // Marking as visited

        // Checking if neighbors eksist

        for(Node neighbor: node.neighbors){
            if(hm.containsKey(neighbor)){
                clone.neighbors.add(hm.get(neighbor)); // clone is aldrady present, means it ws aldready visited
            }else{
                clone.neighbors.add(cloneGraph(neighbor));
            }

        }
        return clone;
    }
}