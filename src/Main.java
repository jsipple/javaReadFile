import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
//            use bufferedReader and fileReader to read the text file
            String line;
            br = new BufferedReader(new FileReader("resume.txt"));
//            initilialize stringbuilder
            StringBuilder content = new StringBuilder();
//            continues loop until reaches the last line of the text file
            while ((line = br.readLine()) != null) {
//                deletes punctuation
                line = line.replaceAll("\\p{P}", "");
//              adds one line at a time to content stringbuilder
                content.append(line);
            }
//            converts contents to string to allow use of .split()
            String contents = content.toString();
//            creates an array based on spaces
            String[] words = contents.split("[' ']");
//            creates new arrayList
            Words resume = new Words();
            for (int i = 0; i < words.length; i++) {
//                loops through the word array and adds each word to the arraylist
                resume.addWord(words[i].trim(), 1);
            }
//          uncomment below and change to search for words
//            resume.getWord("created");
//            uses the word arraylist to create an ordered one and prints the values
            resume.printOrderedWords();
        } catch (IOException e) {
//            print an exception if file is not found and a few other issues
            System.out.println(e.toString());
        }
    }
}
