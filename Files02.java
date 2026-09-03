import java.io.*;
import java.util.*;

public class Files02 {
    public static void main (String[] args) throws FileNotFoundException {
        File modi = new File("mobydick-text.txt");
        Scanner sc =new Scanner(modi);
        Scanner input =new Scanner(System.in);

        ArrayList<String> words= new ArrayList<>();
        ArrayList<String> uniqueWords = new ArrayList<>();
        ArrayList<Integer> uniqueNumT = new ArrayList<>();

        while (sc.hasNextLine()){
            String line = sc.nextLine().strip();
            String[] wordinline = line.split("[^a-zA-Z]+");
            for (String word : wordinline) {
                 if (!word.isEmpty()) {
                    words.add(word.toLowerCase());
                }
            }
        }

        for (String word : words) {
            if (!uniqueWords.contains(word)) {
                uniqueWords.add(word);
            }
        }

        /*
        for (String wordinal : uniqueWords) {
            System.out.println(wordinal);
        }
        */
        
        for (String uniWord : uniqueWords) {
            int count = 0;
            for (String word : words) {
                if (word.equals(uniWord)){
                    count++;
                }
            }
            uniqueNumT.add(count);
        }

        /*
        for (int num : uniqueNumT) {
            System.out.println(num);
        }
        */
        boolean running = true;
        while (running) {
            System.out.println("Enter a word to search number of ocurences: ");
            String word = input.nextLine().strip();
            
            int indexWrd = 0;
            boolean found = false;

            if (word.equalsIgnoreCase("quit")){
                running = false;
                System.out.println("----FINAL STATS----");
                System.out.println("Number of words: " + words.size());
                System.out.println("Number of unique words: " + uniqueWords.size());

                System.out.println("TOP 10 REPEATED WORDS: " );
                ArrayList<Integer> tempCounts = new ArrayList<>(uniqueNumT);

                for (int i = 0; i < 10; i++) {
                    int max = 0;
                    int maxIndex = 0;

                    for (int j = 0; j < tempCounts.size(); j++) {
                        if (tempCounts.get(j) > max) {
                            max = tempCounts.get(j);
                            maxIndex = j;
                        }
                    }

                    System.out.println(uniqueWords.get(maxIndex) + "-" + max);

                    tempCounts.set(maxIndex, -1);
                }

                ArrayList<Integer> wordLength = new ArrayList<> ();
                for (String wordLenUnique : uniqueWords) {
                    wordLength.add(wordLenUnique.length());
                }
                int lengthWordTotal = 0;
                for (int wordLen : wordLength) {
                    lengthWordTotal += wordLen;
                }
                System.out.printf("The average word length is: %.2f letter(s)%n", (double) lengthWordTotal / wordLength.size());

                break;
            }
            
            for (String UW : uniqueWords) {
                if (UW.equals(word)) {
                    System.out.println("This word has appered " + uniqueNumT.get(indexWrd) + " time(s)!");
                    found = true;
                    break;
                }
                indexWrd++;
            }

            if (!found) {
                System.out.println("The word you entered cannot be found!");
            }

        }

    }
}