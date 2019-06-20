import java.util.ArrayList;
import java.util.Arrays;

public class Words {
//    create an arraylist with arrays inside of it that have words and instances
        private ArrayList<instances> words = new ArrayList<>();
//        give global scope to position so that it can be set then used from anywhere
        private int position;
//        create another arraylist to store list in order of occurance
        private ArrayList<instances> orderedWords = new ArrayList<>();
//        and new word and how many times it occurs
        public void addWord(String item, int instance) {
//            since words at the start will have 0 length and the below logic will not work if it is empty have if statement check
            if (words.size() > 0) {
//                check over all occurances added so far to see if any match
                for (int i = 0; i < words.size(); i++) {
//                    trim and tolowercase so capitals do not matter any extra spaces not deleted
                    item = item.toLowerCase().trim();
//                    check if word is already in arraylist if it is grab the position
                    if (item.equals(words.get(i).getWord().toLowerCase().trim())) {

                        this.position = i;
                        break;
                    } else if (i == (words.size() - 1)) {
                        this.position = - 1;
                        break;
                    }
                }
                if (position >= 0) {
//                    use position gained from above to replace the occurances of that word
                    int times = words.get(position).getIntstances();
                    times++;
                    words.set(position, new instances(item, times));
                } else {
//                    if not found add it to the array
                    words.addAll(Arrays.asList(new instances(item, 1)));
                }
            } else {
//                if nothing in array add this to the array
                words.addAll(Arrays.asList(new instances(item, instance)));
            }
        }
        public void printWord(String word) {
//            search for the word and print out word and how many times it has occurred
            System.out.println("You have " + words.size() + "words in document");
            for (int i = 0; i < words.size(); i++) {
                if (word.equals(words.get(i).getWord().toLowerCase().trim())) {
                    System.out.println(words.get(i).getWord() + ": " + words.get(i).getIntstances());
                }
            }
        }
        public void printAllWords() {
//            print out the word arraylist
            for (int i = 0; i < words.size(); i++) {
                System.out.println(words.get(i).getWord() + ": " + words.get(i).getIntstances());
            }
        }
//        creates and prints orderd words(must have word array created)
        public void printOrderedWords() {
            for (int i = 0; i < words.size(); i++) {
                if (orderedWords.size() != 0) {
//                    loops over both arrays and checks if new word from word array occurs more than any of the words in ordered array and inserts it accordingly
                for (int j = 0; j < orderedWords.size(); j++) {
                    if (words.get(i).getIntstances() > orderedWords.get(j).getIntstances()) {
                        orderedWords.add(j, new instances(words.get(i).getWord(), words.get(i).getIntstances()));
                        break;
//                        if reached end of ordered array add to the end of the ordered array
                    } else if (j == orderedWords.size() - 1) {
                        orderedWords.add(new instances(words.get(i).getWord(), words.get(i).getIntstances()));
                        break;
                    }
                }
                } else {
//                    if word has not occured least of ones in ordered array add it to the end
                    orderedWords.add(new instances(words.get(i).getWord(), words.get(i).getIntstances()));
                }
            }
            for (int j = 0; j < orderedWords.size(); j++) {
//                print out the ordered array
                System.out.println(orderedWords.get(j).getWord() + ": " + orderedWords.get(j).getIntstances());
            }

        }
        public void getWord(String search) {
            search.toLowerCase().trim();
            search = search.toLowerCase().trim();
            boolean appeared = false;
//            loop through the array and see how many times it occurred and prints out value
            for (int j = 0; j < words.size(); j++) {
                if (search.equals(words.get(j).getWord().toLowerCase().trim())) {
                    System.out.println("this word appears " + words.get(j).getIntstances() +  " times.");
                    break;
//                    if reached end of the array and not found print word not found
                } else if (j == (words.size() - 1)) {
                    System.out.println("word not found");
                    break;
                }
            }
        }

}
