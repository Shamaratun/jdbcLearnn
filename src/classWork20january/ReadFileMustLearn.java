package classWork20january;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileMustLearn {
    public static void main(String[] args) {
        try {
            // Correcting the file path, removed extra backslash and misplaced quote
            File myObj = new File("C:\\Users\\Java Student PC-4\\Desktop\\javaZ\\jdbcLearn\\src\\Book2.csv");
            Scanner meme = new Scanner(myObj);
            while (meme.hasNextLine()) {
                String data = meme.nextLine();
                System.out.println(data);
            }
            meme.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. File not found.");
        }
    }
}


