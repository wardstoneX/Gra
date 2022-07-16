import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parse {

static int count = 0;
static double total = 0;
public static void readFile(double total, int count) {
    Path path = Paths.get("/Users/selimmertkastan/CLionProjects/team285/Implementierung/output.txt");
    try {
        Stream<String> lines = Files.lines(path);
        List<String> list = new ArrayList<>();
        list =lines.map(s -> s + "\n").collect(Collectors.toList());
        //String data = lines.collect(Collectors.joining("\n"));
        //System.out.println(list);
        for(int i = 0;  i < list.size(); i++) {
            if(list.get(i).substring(0,3).equals("The")) {
                String[] s = list.get(i).split(" ");
                for(int j = 0; j < s.length; j++) {
                    if(s[j].equals("was")) {
                        total += Double.parseDouble(s[j+1]);
                        count++;

                    }
                }

            }
        }

        lines.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

}


    public static void main(String[] args) {

        //readFile();
        System.out.println("Total: " + total);
        System.out.println("Count: " + count);
        System.out.println("Durchschnitt: " + total/count);

        String s = "";
        for(int i = 0; i < 256; i++) {
            s += Character.toString(i);

        }
        System.out.println(s);

    }
}
