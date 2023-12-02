package AdventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
// 55029
public class day1_2023 {
    public static void main(String[] args) {
        try {
            File file = new File("src/AdventOfCode2023/day1_2023.txt");
            Scanner sc = new Scanner(file);
            int sum = 0;
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
                String digit = digitFromString(data);

                if(digit.length() == 1){
                    // string to int
                    int number = Integer.parseInt(digit);
                    number = number * 10 + number;
                    sum += number;
                }
                else if (digit.length() == 2){

                    sum += Integer.parseInt(digit);
                }
                else if (digit.length() > 2){
                    // character to int
                    int first = Character.getNumericValue(digit.charAt(0));
                    int last  = Character.getNumericValue(digit.charAt(digit.length() - 1));
                    sum += first * 10 + last;
                }

            }
            System.out.println(sum);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String digitFromString(String data){
        Pattern regex = Pattern.compile("[^0-9]");  // digit
        return regex.matcher(data).replaceAll("");
    }
}
