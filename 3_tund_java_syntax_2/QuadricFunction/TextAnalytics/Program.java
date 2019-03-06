import java.util.Arrays;

public class Program{

    public static void main(String[] args) {
        TextAnalytics jaguupi_text = new TextAnalytics("C:\\Users\\Student Admin\\Desktop\\TextAnalytics\\artiklikogumik.txt");
        System.out.println(Arrays.toString(jaguupi_text.array_of_words));
    }
}