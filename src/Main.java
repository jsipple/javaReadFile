import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Main {
//    static final Comparator<hmap> OccuranceOrder = new Comparator<hmap>() {
//        @Override
//        public int compare(hmap o1, hmap o2) {
//            if
//        }
//    }
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
            hmap hash = new hmap();
            for (int i = 0; i < words.length; i++) {
                hash.addWord(words[i]);
            }

            System.out.println(hash.getHmap());
            hash.sort();
        } catch (IOException e) {
//            print an exception if file is not found and a few other issues
            System.out.println(e.toString());
        }
    }
}
