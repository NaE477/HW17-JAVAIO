import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FileReaderUtil fileReaderUtil = new FileReaderUtil();
        fileReaderUtil.printFile("src/main/java/List.txt");

        System.out.println("-------------------------------\nEnd of raw file printing");
        System.out.println("-------------------------------\nSaving file content in a variable process starting:");


        Thread.sleep(2000);


        var fileLines = fileReaderUtil.outputFile("src/main/java/List.txt");
        System.out.println(fileLines);

        System.out.println("-------------------------------\nEnd of saving file lines in a variable and printing it");
        System.out.println("-------------------------------\nAppending a text in a file process starting:");


        Thread.sleep(2000);

        fileReaderUtil.appendTextToFile(randomGenerator(),"src/main/java/toAppend.txt");
        fileReaderUtil.printFile("src/main/java/toAppend.txt");

        System.out.println("-------------------------------\nEnd of appending a text to an existing file");
        System.out.println("-------------------------------\nStarting to search for the biggest word in a file:");


        Thread.sleep(2000);

        String biggestString = fileReaderUtil.findBiggestStringInFile("src/main/java/List.txt");
        System.out.println(biggestString);

        System.out.println("-------------------------------\nEnd of finding biggest word in a file");
        System.out.println("-------------------------------\nStarting reverse printing lines of a linked list:");


        Thread.sleep(2000);

        LinkedList<String> lines = fileReaderUtil.saveLinesToLinkedList("src/main/java/List.txt");
        printListInReverse(lines);
    }

    public static String randomGenerator() {
        StringBuilder output = new StringBuilder();
        while (output.length() < 10) {
            output.append((char) ((int) (Math.random() * (122 - 65) + 65)));
        }
        return output.append("\n").toString();
    }

    public static void printListInReverse(LinkedList<String> input) {
        for (int i = input.size() - 1; i >= 0; i--) {
            System.out.println(input.get(i));
        }
    }
}
