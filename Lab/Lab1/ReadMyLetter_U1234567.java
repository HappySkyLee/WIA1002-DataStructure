import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadMyLetter_U1234567 {
    public static void main(String[] args) {
        String filePath = "Lab/Lab1/HappySkyLee_U1234567.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}