package SemesterWork1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test {
    static Random random = new Random();
    public static int iterations;

    public static void main(String[] args) {
        int numArrays = 100;
        List<String> randomString = new ArrayList<>();
        String fileName = "C:/Users/Ралина/IdeaProjects/AICD/src/main/java/SemesterWork1/arrays100.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 1; i <= numArrays; i++) {
                iterations = 0;
                int size1 = 100 * i;
                int size2 = 10 * i;
                String randomString1 = usingRandom(size1);
                String randomString2 = usingRandom(size2);
                randomString.add(randomString1);
                randomString.add(randomString2);

                long start = System.nanoTime();
                ArrayList<Integer> ind = KMPSearch.Search(randomString1,randomString2);
                long end = System.nanoTime();

                int size = size1 + size2;
                writer.write(size + " ");              //размер
                writer.write((end - start) + " ");      //время
                writer.write(iterations + " " + "\r\n" );  //итерации
                //writer.write(randomString1 + "\r\n");
                //writer.write(randomString2 +  "\r\n");
                //String[] array = new String[ind.size()];
                //ind.toArray(array);
                //writer.write(Arrays.toString(array) + "\r\n");
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }

    //создание рандомной строки
    static String usingRandom(int k) {
        String alphabetsInUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetsInLowerCase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String allCharacters = alphabetsInLowerCase + alphabetsInUpperCase + numbers;

        StringBuffer randomString = new StringBuffer();
        for (int i = 0; i < k; i++) {
            // generate a random number between 0 and length of all characters
            int randomIndex = random.nextInt(allCharacters.length());
            randomString.append(allCharacters.charAt(randomIndex));
        }
        return randomString.toString();
    }
}
