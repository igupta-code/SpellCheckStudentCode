public class TST {
    // private Node root;
    private static final char EMPTY = (char)0;
    private Node root;

    private class Node{
        private Node left, mid, right;
        private char letter;
        private boolean isWord;

        private Node(char letter){
            this.letter = letter;
        }

        private Node(){
            this.letter = EMPTY;
        }
    }

    public TST(){
        root = new Node();
    }

    // Inserts a new string into the trie
    public void insert(String s){
        // If the root is null, insert the letter (only in case of top node)
        if (root.letter == 0){
            // You want the top letter to be the one you start for
            root.letter = s.charAt(0);
            insert(s.substring(1), root, 0);
        }
        else
            root = insert(s, root, 0);
    }

    public Node insert(String s, Node node, int index){
        // If the string is empty you are done inserting
        if(index == s.length())
            return null;
        if(node == null)
            node = new Node(s.charAt(index));

        // Compare current letter to node
        // If equals node,
        if(s.charAt(index) == node.letter){
            node.mid = insert(s, node.mid, index+1);
        }
        else if(s.charAt(index) > node.letter){
            node.right = insert(s, node.right, index);
        }
        else{
            node.left = insert(s, node.left, index);
        }
        return node;
    }

}
