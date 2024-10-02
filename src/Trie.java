import java.sql.SQLOutput;
import java.util.ArrayList;

// Isha Gupta
// Oct ___
public class Trie {
    private Node root;

    public Trie(){
        root = new Node();
    }

    // Inserts a new string into the trie
    public void insert(String s){
        insert(s, root);
    }

    public void insert(String s, Node root){
        // Base case: String is done (all added)
        if(s.isEmpty()){
            root.setWord(true);
            return;
        }

        // If the index of the array is filled
        if(root.getNext()[s.charAt(0)] == null){
            // If the index is empty then add the letter there
            root.getNext()[s.charAt(0)] = new Node();
        }
        System.out.println();
        insert(s.substring(1), root.getNext()[s.charAt(0)]);

    }

    // Returns true if the string already exists in the tree
    public boolean lookUp(String s){
        return false;
    }

    public void printTrie(){
        String word = "";
        printTrie(root, word);
    }

    public void printTrie(Node n, String word){
        if(n == null){
            return;
        }

        if(n.isWord()){
            System.out.println(word);
        }

        for(int i = 0; i < 255; i++){
            if(n.getNext()[i] == null){
                word += (char) i;
                printTrie(n.getNext()[i], word);
            }
        }
    }
}
