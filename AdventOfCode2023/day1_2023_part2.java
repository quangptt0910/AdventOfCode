package AdventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
// 55686
public class day1_2023_part2 {
    public static void main(String[] args) {
        try {
            File file = new File("src/AdventOfCode2023/day1_2023_part2.txt");
            Scanner sc = new Scanner(file);

            int sum = 0;
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
                System.out.println(digitLettersFromString(data));
                sum += digitLettersFromString(data);

            }
            System.out.println(sum);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static int digitLettersFromString(String data){
        String[] letters = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int[] pos = new int[18];
        Arrays.fill(pos, -1);
        int low = data.length() + 1;
        int firstNum = 0;
        for(int i = 0; i < 18; i++){
            pos[i] = data.indexOf(letters[i]);
            if (-1 < pos[i] && pos[i] < low) {
                low = pos[i];
                firstNum = i + 1;
            }
        }
        int upp = low;
        int lastNum = 0;
        for(int i = 0; i < 18; i++){
            pos[i] = data.lastIndexOf(letters[i]);
            if(pos[i] > upp) {
                upp = pos[i];
                lastNum = i + 1;
            }
        }
        firstNum = (firstNum > 9) ? firstNum - 9 : firstNum;
        if(lastNum == 0) lastNum = firstNum;
        lastNum = (lastNum > 9) ? lastNum - 9 : lastNum;
        int[] res = {firstNum, lastNum};
        //return res;
        return firstNum * 10 + lastNum;
    }
}
