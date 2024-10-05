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

    // Inserts a new string into the tst
    public void insert(String s){
        // If the root is null, insert the letter (only in case of top node)
        if (root.letter == 0){
            // You want the top letter to be the one you start for
            root.letter = s.charAt(0);
            if (s.length() == 1) root.isWord = true;
            root.mid = insert(s, root.mid, 1);
        }
        else
            root = insert(s, root, 0);
    }

    public Node insert(String s, Node node, int index){
        // When you reach the end of the string, you are done inserting
        if(index == s.length()) {
            return null;
        }

        // If the node is null, create a new node
        if(node == null) {
            node = new Node(s.charAt(index));
            //
            if(index == s.length()-1)
                node.isWord = true;
        }

        // Compare current letter to node
        // If equals node, the correct letter is already at the tree(so index + 1)
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

    // Checks if given word is in the TST
    public boolean lookUp(String s){
        return lookUp(s, root, 0);
    }

    public boolean lookUp(String s, Node node, int index){
        // When you reach end of string, check if it's a word
        if(node == null)
            return false;

        // If the node is correct, accept it by move onto the middle node
        if(s.charAt(index) == node.letter){
            if(index == s.length() - 1)
                return node.isWord;
            else
                return lookUp(s, node.mid, index+1);
        }
        else if(s.charAt(index) > node.letter)
            return lookUp(s, node.right, index);
        else if(s.charAt(index) < node.letter)
            return lookUp(s, node.left, index);

        return false;
    }
}
