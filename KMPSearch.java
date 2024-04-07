package SemesterWork1;

import java.util.ArrayList;

public class KMPSearch {

     //функция создания массива префиксов
    static int[] prefixFunction(String sample) {
        int [] values = new int[sample.length()]; //создаем массив по длине образа
        for (int i = 1; i < sample.length(); i++) {
            Test.iterations++;
            int j = 0;
            while (i + j < sample.length() && sample.charAt(j) == sample.charAt(i + j)) {
                values[i + j] = Math.max(values[i + j], j + 1);
                j++;
                Test.iterations++;
            }
        }
        return values;
    }

    //функция нахождения подстрок
    public static ArrayList<Integer> Search(String text, String sample) {
        ArrayList<Integer> found = new ArrayList<>();
        int[] prefixFunc = prefixFunction(sample); //вызываем префикс функцию для данной подстроки

        int i = 0;
        int j = 0;

        //проходим по всей строке
        while (i < text.length()) {
            Test.iterations++;
            if (sample.charAt(j) == text.charAt(i)) { //если символы совпадают, увеличиваем i и j и сравниваем дальше
                j++;
                i++;
            }
            if (j == sample.length()) {     //если нашли подстроку,
                found.add(i - j);           //добавляем в ArrayList индекс начала вхождения
                j = prefixFunc[j - 1];      //меняем j исходя из значений массива префиксов
            } else if (i < text.length() && sample.charAt(j) != text.charAt(i)) {       //если символы не совпали
                if (j != 0) {                                                           //меняем j исходя из значений массива префиксов
                    j = prefixFunc[j - 1];
                } else {
                    i = i + 1;                                                          //рассматриваем след символ строки
                }
            }
        }
        return found;                      //возвращаем ArrayList состоящий из индексов начала вхождений
    }
}
