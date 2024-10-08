import java.util.ArrayList;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Isha Gupta
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
        TST dict = new TST();
        TST foundWords = new TST();
        ArrayList<String> allMisspelled = new ArrayList<String>();


        // Load in the dictionary to the dict tst
        for (String word : dictionary){
            dict.insert(word);
        }

        // Check each word in the text to see if it's a word
        for (String word: text){
            // If the word is not in foundWords yet, add it
            if(!foundWords.lookUp(word)){
                foundWords.insert(word);
                // If word is not already in the text, and it's not in the dictionary, then add it
                if(!dict.lookUp(word)){
                    allMisspelled.add(word);
                }
            }
        }

            // Convert Array list to array and return
            String[] toReturn = new String[allMisspelled.size()];
            for (int i = 0; i < allMisspelled.size(); i++) {
                toReturn[i] = allMisspelled.get(i);
            }
            return toReturn;

          // Version that implements Trie:
//        ArrayList<String>  allMisspelled = new ArrayList<String>();
//        Trie dict = new Trie();
//        for(String word: dictionary){
//            dict.insert(word);
//        }
//
//        Trie misspelled = new Trie();
//
//        // Go through the text
//        for(String word: text){
//            // If word is not in the dictionary
//            if(!dict.lookUp(word) && !misspelled.lookUp(word)){
//                misspelled.insert(word);
//                allMisspelled.add(word);
//            }
//        }
//
//        String[] toReturn = new String[allMisspelled.size()];
//        for(int i=0; i < allMisspelled.size(); i++){
//            toReturn[i] = allMisspelled.get(i);
//        }
//        return toReturn;
        }
    }
