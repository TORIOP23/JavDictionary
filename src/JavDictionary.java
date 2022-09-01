import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class JavDictionary {
    public static void main(String[] args) {
        try 
        {
            Scanner scanner = new Scanner(System.in);
            Path path = Path.of("Data.txt"); // function static
            List<String> idol_data_list = Files.readAllLines(path); // throws IOException
            

            while(true)
            {
                System.out.print("Search for any idol: ");
                String search = scanner.next();

                System.out.format("%-15s %-5s %-10s %-10s\n", "NAME", "AGE", "HEIGHT", "WEIGHT");
                for (String idol_data : idol_data_list)
                {
                    String[] data = idol_data.split(";");
                    Idol idol = new Idol();
                    idol.name = data[0];
                    idol.age = Integer.valueOf(data[1]);
                    idol.height = Double.valueOf(data[2]);
                    idol.weight = Double.valueOf(data[3]);
                    
                    if (idol.name.contains(search))
                    {
                        System.out.format("%-15s %-5s %-10s %-10s\n", idol.name, idol.age, idol.height, idol.weight);
                    }
                }

                System.out.println("-----------------------------------------------\n");
            }
        }
        catch (IOException e) {}
    }
}
