import java.util.ArrayList;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 * */

public class SpellCheck {


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {


        ArrayList<String>  allMisspelled = new ArrayList<String>();
        Trie dict = new Trie();
        for(String word: dictionary){
            dict.insert(word);
            // dict.printTrie();
        }

        Trie misspelled = new Trie();

        // Go through the text
        for(String word: text){
            // If word is not in the dictionary
            if(!dict.lookUp(word) && !misspelled.lookUp(word)){
                misspelled.insert(word);
                allMisspelled.add(word);
            }
        }
        misspelled.printTrie();

        String[] toReturn = new String[allMisspelled.size()];
        for(int i=0; i < allMisspelled.size(); i++){
            toReturn[i] = allMisspelled.get(i);
        }
        return toReturn;
    }
}
