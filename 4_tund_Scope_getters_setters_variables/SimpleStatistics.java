import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

class SimpleStatistics {

    public static void main(String[] args) {
        List<ExamplePerson> list = Arrays.asList(
                new ExamplePerson("John Blue", 28, true),
                new ExamplePerson("Anna Brown", 53, true),
                new ExamplePerson("Paul Black", 47, true)
        );

        int min = list.stream()
                .mapToInt(ExamplePerson::getAge)
                .min()
                .orElseThrow(NoSuchElementException::new);

        int max = list.stream()
                .mapToInt(ExamplePerson::getAge)
                .max()
                .orElseThrow(NoSuchElementException::new);


        System.out.println(min);
        System.out.println(max);
    }
}