import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.lang.Object;

public class BasicConstructs {
    // In Java, you can only create arrays with elements of a single type.
    String[] array_of_strings = { "One", "Two", "Three" };
    int[] array_of_numbers = { 1, 2, 3, 4, 5 };

    // Create a linked list.
    LinkedList<Object> linkedlist = new LinkedList<Object>();

    // This allows adding multiple datatypes, because all of them implement the class Object.
    public void addMultipleDatatypes() {
        this.linkedlist.add("Some string");
        this.linkedlist.add(1);
        //this.linkedlist.removeFirst();
        //this.linkedlist.removeLast();
        System.out.println(Arrays.toString(this.linkedlist.toArray()));
    }

    public void normalConditionals(){

        // You can not compare two strings like "hello" == "hello".
        if ("Hello".equals("Hello")) {
            System.out.println("Those two words match.");
        } else {
            System.out.println("Those two words don't match.");
        }
    }

    public void normalWhileLoop() {
        while (true) {
            System.out.println("This will loop forever because there is no exit condition.");
        }
    }

    public int catchErrors() throws ArithmeticException {
        try {
            int number = 5 / 0;
            return number;

        } catch (ArithmeticException e) {
            // Never catch with a broad Exception clause.
            System.out.println("You cant divide with zero.");
            return 0;
        }finally{
            System.out.println("This is a good place to close streams, files etc.");
        }
    }

    public void vanillaForLoop() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

    public void vanillaForeach() {
        String[] array = { "One", "Two", "Three" };
        for (String word : array) {
            System.out.println(word);
        }
    }

    public void streamForeach() {
        String[] word_array = { "One", "Two", "Three" };
        Arrays.stream(word_array).forEach(word -> {
            System.out.println(word);
        });
    }

    public void dictionarySample() {
        HashMap<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        // Get value with specified key.
        // RETURNS NULL IF KEY DOESN'T EXIST.
        int f = items.get("F");

        // Looping through the entries with streams.
        items.forEach((key, value) -> System.out.println("Item : " + key + " Count : " + value));

        // Looping through the entries with a vanilla foreach loop.
        for (HashMap.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }
    }


    public static void main(String[] args) {
        BasicConstructs bc = new BasicConstructs();
        bc.addMultipleDatatypes();
    }

}