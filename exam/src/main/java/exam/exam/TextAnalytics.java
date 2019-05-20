package exam.exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class TextAnalytics {
    String text;
    List<String> words;
    HashMap<String, Integer> uniqueWordCounter = new HashMap<>();

    public TextAnalytics(String text) {
        this.text = text;
        this.splitToWords();
        this.turnWordsToLowercase();
        this.countUniqueWords();
    }

    public void splitToWords() {
        this.words = Arrays.asList(this.text.split(" "));
    }

    // Uses the Streams introduced in Java 8 to proccess a list of strings into
    // lowercase and saves them as a List using collect and the Collector class' static toList function.
    public void turnWordsToLowercase() {
        this.words = this.words.stream().map(String::toLowerCase).collect(Collectors.toList());
    }

    public void countUniqueWords() {
        for (String word : this.words) {
            if (this.uniqueWordCounter.containsKey(word)) {
                int updatedCounter = this.uniqueWordCounter.get(word) + 1;
                this.uniqueWordCounter.put(word, updatedCounter);
            } else {
                this.uniqueWordCounter.put(word, 1);
            }
        }
    }

    // Simple function to return the data from this class
    // as a HashMap so that the RestController could return this as valid JSON to the frontend.
    public HashMap<String, String> toJSON(){
        HashMap<String, String> json = new HashMap<>();
        json.put("uniqueWordCount", Integer.toString(this.uniqueWordCounter.size()));
        json.put("wordOccurances", this.uniqueWordCounter.toString());
        return json;

    }

    // Just some code to check if the class is functional.
    // You will never need to touch change this or run this.... EVER.
    // Hands off, shoo!
    public static void main(String[] args) {
        TextAnalytics analytics = new TextAnalytics("Lorem ipsum ipsum adfinitum");
        System.out.println(analytics.uniqueWordCounter.toString());

    }
}