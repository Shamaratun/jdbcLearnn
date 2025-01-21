package classWork20january;

import java.util.List;

public class MainReadWriteUpdate {
    public static void main(String[] args) {
        String inputPath = "input.txt"; // Example input file path
        ReadFileMustLearn readfile = new ReadFileMustLearn();

        readfile.readfile(inputPath); // Assuming the method takes a file path
        List<String[]> readData = readfile.getStringList();

        for (String[] data : readData) {
            data[2] = "bithy";
            data[3] = "chaity";
        }

        String filePath2 = "output.txt"; // Example output file path
        LearnWriteFile writer = new LearnWriteFile(filePath2, readData);
        writer.writeFile();

        System.out.println("Process completed successfully!");
    }
}
