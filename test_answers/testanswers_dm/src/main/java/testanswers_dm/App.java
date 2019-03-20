package kontrolltoo_naidis;

import java.util.Arrays;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Naidis minu_naidis = new Naidis("C:\\Users\\Student Admin\\Desktop\\kontrolltoo_naidis\\src\\main\\java\\kontrolltoo_naidis\\sisu.txt");
        minu_naidis.countLetterOccurances('e');
    }
}
