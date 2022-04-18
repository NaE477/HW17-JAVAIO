import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.concurrent.atomic.AtomicReference;

public class FileReaderUtil {

    public void printFile(String inputFile) {
        try {
            Files.readAllLines(Paths.get(inputFile)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StringBuilder outputFile(String inputFile) {
        StringBuilder output = new StringBuilder();
        try {
            Files.readAllLines(Paths.get(inputFile)).forEach(s -> output.append(s).append("\n"));
        }  catch (NoSuchFileException noSuchFileException) {
            System.out.println("No such file exists");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    public void appendTextToFile(String text, String inputFile) {
        try {
            Files.write(Paths.get(inputFile),text.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String findBiggestStringInFile(String inputFile) {
        AtomicReference<String> output = new AtomicReference<>("");
        try {
            Files.readAllLines(Paths.get(inputFile)).forEach(s -> {
                if (s.length() > output.get().length()) output.set(s);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.get();
    }
}
