import java.util.LinkedList;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Program{

	// new Program().main() <- ilma static.
	// Program.main()       <- koos static.
	// java sample oun banaan. args[1] = oun, args[0] sample jne.
    public static void main(String[] args) {
        int number = 5;

        // Ennem panete paika muutja sisu.
        // Hiljem annate väärtuse.
        int second_number;
        second_number = 5;

        // Loome massiivi AINULT!!! string elementidega.
        // Tohib sisalda AINULT!!! kolm elementi.
        String[] names = {"Mari", "Uku", "Sten"};
        String[] second_names = new String[3];  // Koodi süntaks võib olla vale.
        second_names[0] = "Mari";
        second_names[1] = "Uku";
        second_names[2] = "Sten";

        // Puudub elementide arvu piirang, ERINEVALT TAVLISISEST MASSIIVIST.
        // <String> peale tema andmetüüpi, miirab the sisu elementide
        // andmetüüpi.
        // Kerge on lisada elemente, kustutada elemente aga läbimine nt tsükkliga on aeglane.
        LinkedList<String> third_names = new LinkedList<>();

        // VÄGA kiire läbida.
        // HALB idee on lisada ja kustudada elemente.
        ArrayList<String> fifth_names = new ArrayList<>();

        // Üks ühele Python'i dict, JavaScript JSON'le.
        // Sisaldab alati ühte võtit ja talle kuuluvat väärtust.
        // VÄGA kiire andme leidmisega, kui teada on võti.
        HashMap<String, String> fourth_names = new HashMap<>();

        // java Program õun laps
        // args[1] -> õun
        // args[0] -> Program
        // args[2] -> laps

        // main ilma sulgudeta oleks funktsiooni "keha".
        // main()  <- sulud panevad funktsiooni tööle.
        
        if (number < 5) {
            System.out.println("Number on väiksem kui viis.");
        } else {
            System.out.println("Number on suurem kui viis.");
        }

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        // Läbime massiivi elemendi, salvestame muutuja
        // sisse käesoleva elemendi väärtuse.
        for (String name : names) {
            System.out.println(name);
        }

        // Puudub võimalust muuta kui while sees on true.
        // Kood jätkub lõpmatult.
        while (number < 5) {
            System.out.println("This is an infinite loop.");
        }

        // Exception püüab KÕIK erroreid, mis on halb.
        // Püüame alati konkreetseid errori tüüpe, mida eeldame.
        // HALB NÄIDE
       /*  
       try {
            int error_creating_expression = 5/0;
        } catch (Exception e) {
            //TODO: handle exception
        } 
        */

        
        // ÕIGE NÄIDE
        // Püüab kinni konkreetse errori mis võib tekkida.
        // Kinni püütud errorid ei peata programmi.
        try {
            int error_creating_expression = 5/0;
        } catch (ArithmeticException my_error_variable) {
            int correct_expression = 5/1;
            my_error_variable.printStackTrace();
        }

        try {
             // Faili sisselugemine korraga, EI SOOVITA. MÄLU VÕIB OTSA SAADA.
            Path file_path = Paths.get("C:\\Users\\Student Admin\\Desktop\\sisu.txt"); // Olenevalt OS'st pane paika õige path. (\ ja / on erinevad nt Linux ja Win puhul)
            byte[] file_content_in_bytes = Files.readAllBytes(file_path); // Loeb byte'na sisse binaarkujus, selles teksti pole.
            String fail_content = new String(file_content_in_bytes, StandardCharsets.UTF_8); // String objekti loomisel, annab sisse byte'e kogumiku, mingi byte kogumikule, vastab UTF8 tähestik.
            System.out.println(fail_content);
        } catch (IOException e) {
            e.printStackTrace();
        }
     
        
        try {
            Path file_path = Paths.get("C:\\Users\\Student Admin\\Desktop\\sisu.txt");
            Stream<String> stream = Files.lines(file_path);
            stream.forEach((String name) -> {System.out.println(name);});
        } catch (Exception my_bad_error) {
            my_bad_error.printStackTrace();
        }
   
    
}
}