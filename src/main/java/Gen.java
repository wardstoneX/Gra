import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Gen {




    public static String generateNumber(String alphabet, int length) {
    String number = "";
    Random rand = new Random();

    for(int i = 0; i < length; i++) {
        int random = rand.nextInt(alphabet.length());
        char c = alphabet.charAt(random);
        number = number + c;
    }
    return number;
}

public static void writeToFile(String version, String z1, String z2, int base,String alphabet,String operation) {
    FileWriter fileWriter = null;
    BufferedWriter bufferedWriter = null;
    PrintWriter printWriter = null;

    try {
        fileWriter = new FileWriter("input1.txt", true);
        bufferedWriter = new BufferedWriter(fileWriter);
        printWriter = new PrintWriter(bufferedWriter);

        String line = version + " " + z1 + " " + z2 + " -b" + base + " -a" + alphabet + " -o" + operation + " -B100";
        printWriter.println(line);

        printWriter.flush();
    } catch (IOException e) {

    } finally {
        try {
            fileWriter.close();
            bufferedWriter.close();
            printWriter.close();
        } catch (IOException e) {

        }
    }
}
    public static void writeToFile1(String line) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter("input.txt", true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);

            for(int i = 0; i < 15;i++) {
                printWriter.println(line);
            }



            printWriter.flush();
        } catch (IOException e) {

        } finally {
            try {
                fileWriter.close();
                bufferedWriter.close();
                printWriter.close();
            } catch (IOException e) {

            }
        }
    }
    public static void readFile(double total, int count,int beginning, int end) {
        Path path = Paths.get("output.txt");
        try {
            Stream<String> lines = Files.lines(path);
            List<String> list = new ArrayList<>();
            list =lines.map(s -> s + "\n").collect(Collectors.toList());
            //String data = lines.collect(Collectors.joining("\n"));
            //System.out.println(list);
            for(int i = beginning;  i < end; i++) {
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
            System.out.println(total);
            System.out.println(count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        int base = 16;
        //int length = 8;
        String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz !\"#$%&\\'()*+,-./:;<=>?@[\\\\]^_`{|}~";

        String operation = "+";
        //writeToFile("-V1",z1,z2,base,alphabet.substring(0,base),operation);
        String version = "-V0";
       // String line = "./main " +  version + " " +  " -b" + base + " -a" + alphabet.substring(0,base) + " -o" + operation + " -B100 " + z1 + " " + z2;
        //System.out.println(line);
        //String line = "./main -V0  -b10 -a0123456789 -o+ -B100 40956011 20007241";
        //writeToFile1(line);
        boolean b = false;
        String version1 = "-V1";
        /*
        for(int i = 8; i > 0; i--) {
            int length = i;
            String z1 = Gen.generateNumber(alphabet.substring(0,base),length);
            String z2 = Gen.generateNumber(alphabet.substring(0,base),length);
            String line;

                line = "./main " +  version + " " +  " -b" + base + " -a" + alphabet.substring(0,base) + " -o" + operation + " -B100 " + z1 + " " + z2;
            writeToFile1(line);

                line = "./main " +  version1 + " " +  " -b" + base + " -a" + alphabet.substring(0,base) + " -o" + operation + " -B100 " + z1 + " " + z2;
                writeToFile1(line);

        }

         */
        /*
        for(int i = 100;i <= 2000;i+=100) {
            for(int j = 0; j < 10;j++) {
                int length = i;
                String z1 = Gen.generateNumber(alphabet.substring(0, base), length);
                String z2 = Gen.generateNumber(alphabet.substring(0, base), length);
                String line = "./main " + version + " " + " -b" + base + " -a" + alphabet.substring(0, base) + " -o" + operation + " -B100 " + z1 + " " + z2;
                writeToFile1(line);
                line = "./main " + version1 + " " + " -b" + base + " -a" + alphabet.substring(0, base) + " -o" + operation + " -B100 " + z1 + " " + z2;
                writeToFile1(line);
            }
        }

         */



        /*
        for(int i = 2; i < 95; i++) {
            for(int j = 0; j < 100; j++) {
                z1 = Gen.generateNumber(alphabet.substring(0,base),length);
                z2 = Gen.generateNumber(alphabet.substring(0,base),length);
                writeToFile("-V0", z1,z2,base,alphabet.substring(0,base),operation);
            }

            base++;
            length++;

        }

         */

        int beginning = 0;
        int end = 30;
        for(int i = 100; i <= 2000; i+=200) {
            System.out.println("length: " + i);
            double total = 0;
            int count = 0;
            for(int j = 0; j < 15; j++) {
                System.out.println("index: " + j);
                readFile(total,count,beginning,end);
                beginning +=30;
                end += 30;
                readFile(total,count,beginning,end);
                beginning += 30;
                end += 30;
            }

            //System.out.println("length " + i);
            //System.out.println("version 0");
            //(total,count,beginning,end);
            //beginning += 202;
            //+=202;
            //.out.println("version 1");
            ////eadFile(total,count,beginning,end);
//            end+=202;

        }










    }

}
