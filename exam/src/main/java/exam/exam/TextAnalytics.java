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

    public HashMap<String, String> toJSON(){
        HashMap<String, String> json = new HashMap<>();
        json.put("uniqueWordCount", Integer.toString(this.uniqueWordCounter.size()));
        json.put("wordOccurances", this.uniqueWordCounter.toString());
        return json;

    }

    public static void main(String[] args) {
        TextAnalytics analytics = new TextAnalytics("Lorem ipsum ipsum adfinitum");
        System.out.println(analytics.uniqueWordCounter.toString());

    }
}