public class Trie {
    private Node root;

    public Trie(){
        root = new Node();
    }

    public Trie(Node root){
        this.root = root;
    }

    // Inserts a new string into the trie
    public void insert(String s){
        insert(s, root);
    }

    public void insert(String s, Node root){
        // Base case: String is done (all added)
        if(s.length() == 0){
            return;
        }

        // If the index of the array is filled
        if(root.getNext()[s.charAt(0)] == null){
            // If the index is empty then add the letter there
            root.getNext()[s.charAt(0)] = new Node();
        }

        insert(s.substring(1), root.getNext()[s.charAt(0)]);

    }

    // Returns true if the string already exists in the tree
    public boolean lookUp(String s){
        return false;
    }

    public void printTrie(){

    }


}
