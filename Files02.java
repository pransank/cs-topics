import java.io.*;
import java.util.*;

public class Files02 {
    public static void main (String[] args) throws FileNotFoundException {
        File modi = new File("mobydick-text.txt");
        Scanner sc = new Scanner(modi);
        
        ArrayList<String> words = new ArrayList<>();

        while (sc.hasNextLine()){
            String line = sc.nextLine().strip();
            String[] wordinline = line.split("[^a-zA-Z]+");
            for (String word : wordinline) {
                if(words.contains(word)){
                    continue;
                }
                else {
                    words.add(word);
                }
            }
        }
        for (String wordinal : words) {
            System.out.println(wordinal);
        }
    }
}