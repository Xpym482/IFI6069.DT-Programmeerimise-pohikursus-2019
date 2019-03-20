import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FileHandling {
    
    public List<String> readWholeFileAsLines(String path) throws IOException {
        List<String> fileContent = Files.readAllLines(Paths.get(path));
        return fileContent;
    }

    public String readWholeFileAsString(String path) throws IOException{
        return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);

    }

    public void readFileLineByLine(String path) throws IOException {

        // Wrapping everything into a try/catch block is necessarry for closing the
        // stream.
        // Otherwise it will happen with normal Garbage Collection.
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(System.out::println);
        }
    }

    //public void readFileLineByLineWithApacheCommons(String path) throws IOException {
    //    List<String> lines = FileUtils.readLines(path, "UTF-8");
    //    for (String line : lines) {
    //        // process the line
    //    }
    //}

    public void writeFile(String path) throws IOException {
        Path file_path = Paths.get(path);
        String data = "Hello world~!";
        Files.write(file_path, data.getBytes());
    }

    public void createTextFile(String path) throws IOException {
        List<String> lines = Arrays.asList("The first line", "The second line");
        Path file = Paths.get(path);
        Files.write(file, lines, Charset.forName("UTF-8"));
    }



    public static void main(String[] args) {
        FileHandling fh = new FileHandling();
        try {
            String file = fh.readWholeFileAsString("C:\\Users\\marko\\Downloads\\lambipirn.txt");
            System.out.println(file);
        } catch (Exception e) {
            System.out.println("There was a major error.");
        }

        try {
            fh.createTextFile("help.txt");
        } catch (Exception e) {
            System.out.println("There was an exception.");
        }

    }
}