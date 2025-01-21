package classWork20january;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LearnWriteFile {
    private String filepath;
    private List<String[]> arrayString = new ArrayList<>();

    public LearnWriteFile(String filepath, List<String[]> arrayString) {
        this.filepath = filepath;
        this.arrayString = arrayString;
    }

    public void LearnWriteFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            for (String[] row : arrayString) {
                writer.write(String.join(",", row));
                writer.newLine();
            }
            System.out.println("File has been written");

        } catch (IOException e) {
            System.err.println("An error occurred"+e.getMessage());
        }
    }
}
