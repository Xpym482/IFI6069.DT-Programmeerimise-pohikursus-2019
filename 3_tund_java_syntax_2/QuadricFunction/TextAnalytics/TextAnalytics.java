import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/* 
Laadige fail aadresist http://www.tlu.ee/~jaagup/andmed/keel/artiklikogumik.txt ja pange see sama kausta kuhu loote programmi.
Loege failis olev tekst sisse (tunni kaustas on näited olemas).
Eraldate kõik sõnad (Kasuks String.split() ).
Muuda kõik tähed väikseteks (ÕUN -> õun).
Loend sellest, mitu korda mingi sõna esineb (Kasuks HashMap). 
*/

public class TextAnalytics {

    String file_path;
    String file_content;
    String[] array_of_words;
    HashMap<String, Integer> word_counter = new HashMap<>();

    public TextAnalytics(String _path) {
        this.file_path = _path;

        this.read_file();
        this.split_to_words();
        this.words_to_lowercase();
    }

    public void read_file() {
        // Loeb failitee sisse, vastavalt OS'le tõlgib ümber.
        Path file_path = Paths.get(this.file_path);

        try {
            // Loeme faili sisse binaarkujul kui baitide massiivi.
            byte[] file_content_in_bytes = Files.readAllBytes(file_path);

            // Loome uue sõna kasutades String klassi, kasutades baitide kogumikku, ja 
            // encodingut.
            String file_content_str = new String(file_content_in_bytes, StandardCharsets.UTF_8);
            this.file_content = file_content_str;

        } catch (IOException my_error_variable) {
            my_error_variable.printStackTrace();
        }

    }

    public void split_to_words() {
        this.array_of_words = this.file_content.split(" ");
    }

    public void words_to_lowercase() {
        for (int i = 0; i < this.array_of_words.length; i++) {
            String word_in_array = this.array_of_words[i];
            String word_in_lowercase = word_in_array.toLowerCase();
            this.array_of_words[i] = word_in_lowercase;
        }

    }

    public void count_the_words() {
        // Läbime massiivi foreach tsükliga.
        // Vaatame kas sõna on HashMapis võtmena olemas.
            // Kui ei ole, siis lisame selle ja anname väärtuse 1.
            // Kui on olemas, võtame selle väärtuse, suurendame ühe võrra ja paneme tagasi.

    }
}