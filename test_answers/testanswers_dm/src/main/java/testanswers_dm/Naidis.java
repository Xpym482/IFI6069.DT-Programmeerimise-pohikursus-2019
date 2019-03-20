package kontrolltoo_naidis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

class Naidis {

    String text;
    String[] words;

	public Naidis(String path){
         this.text = this.read_file(path);
         this.splitIntoWords();
    }

    public void splitIntoWords(){
        this.words = this.text.split("\\s+");
    }

    public void sortWordsInArray(){
        System.out.println(Arrays.toString(this.words));
        Arrays.sort(this.words);
        System.out.println(Arrays.toString(this.words));
    }

    public void countUppercasePercentage(){
        double amountOfWords = this.words.length;
        double isUppercaseConter = 0;

        for (String word : this.words) {
            char firstLetter = word.charAt(0);
            if (Character.isUpperCase(firstLetter)) {
                isUppercaseConter++;
            }
        }

        System.out.println(isUppercaseConter/amountOfWords);
    }

    void countLetterOccurances(char letter){
        int counter = 0;

        for (String word : this.words) {
            char firstLetter = word.charAt(0);
            char lastLetter = word.charAt(word.length() - 1);

            if (firstLetter == letter || lastLetter == letter) {
                counter++;
            }
        }

        System.out.println(counter);
    }

    void statistics(){
        List<Integer> collection = new ArrayList<Integer>();

        collection.add(5);
        collection.add(10);
        collection.add(23);
        collection.add(14);
        collection.add(54);

        Collections.sort(collection);
        System.out.println(collection.toString());


  /*       IntSummaryStatistics summary = new IntSummaryStatistics();
        summary.accept(5);
        summary.accept(40);
        summary.accept(23);
        summary.accept(14);

        System.out.println(summary.getAverage());
        System.out.println(summary.getSum());
        System.out.println(summary.getMin());
        System.out.println(summary.getMax()); */


    }

    int count_characters(char letter){
        int counter = 0;
        for (int i = 0; i < this.text.length(); i++){
            char c = this.text.charAt(i);
            if (c != letter) {
                counter++;
            }
        }
        return counter;

    }


    String read_file(String path){
        try {
            // Faili sisselugemine korraga, EI SOOVITA. MÄLU VÕIB OTSA SAADA.
           Path file_path = Paths.get(path); // Olenevalt OS'st pane paika õige path. (\ ja / on erinevad nt Linux ja Win puhul)
           byte[] file_content_in_bytes = Files.readAllBytes(file_path); // Loeb byte'na sisse binaarkujus, selles teksti pole.
           String fail_content = new String(file_content_in_bytes, StandardCharsets.UTF_8); // String objekti loomisel, annab sisse byte'e kogumiku, mingi byte kogumikule, vastab UTF8 tähestik.
           return fail_content;

       } catch (IOException e) {
           e.printStackTrace();
           return "";
       }
    }

}
