import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JavaKeywords {
    public static void main(String[] args) {
        ArrayBag<String> keywordBag = new ArrayBag<>();

        // Load keywords from the file
        int keywordCount = loadKeywords(keywordBag, "JavaKeywords.txt");

        // Print program header
        System.out.println("Java Keywords by F. Last");
        System.out.println("# " + keywordCount + " Java keywords loaded.");

        // Check each argument
        for (String arg : args) {
            if (keywordBag.contains(arg)) {
                System.out.println(arg + " is a keyword");
            } else {
                System.out.println(arg + " is not a keyword");
            }
        }

        // Additional tests for BagInterface
        testBagInterface();
    }

    private static int loadKeywords(ArrayBag<String> keywordBag, String fileName) {
        int count = 0;
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String keyword = scanner.next();
                keywordBag.add(keyword);
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File " + fileName + " not found.");
        }
        return count;
    }

    private static void testBagInterface() {
        ArrayBag<String> testBag = new ArrayBag<>();
        testBag.add("abstract");
        testBag.add("while");
        testBag.add("null");

        // Hardcoded tests
        System.out.println("\nTesting ArrayBag:");
        System.out.println("Contains 'while': " + testBag.contains("while")); // true
        System.out.println("Contains 'int': " + testBag.contains("int")); // false
        System.out.println("Remove 'null': " + testBag.remove("null")); // true
        System.out.println("Current size: " + testBag.getCurrentSize()); // 2
    }
}
