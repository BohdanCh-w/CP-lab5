import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import org.junit.Test;

public class Tester {
    public static void prettyPrint(List<?> lst) {
        if(lst.size() == 0) {
            System.out.println("<Void list>");
            return;
        }

        ListIterator<?> it = lst.listIterator();
        while (it.hasNext()) {
            System.out.println(String.format("%3d : %s", it.nextIndex(), it.next()));
        }
    }

    private static String readFile(String path) throws Exception {
        String ret = Files.readString(Path.of(path));
        return ret;
    }

    @Test
    public void test_void_file(Object Arrays) throws Exception {
        String input = readFile("empty.txt");
        WordFinder wf = new WordFinder(5, '?');
        var result = wf.GetWords(input);
        var lst = result.stream().collect(Collectors.toList());
        prettyPrint(lst);
        assertTrue(result.equals(
            new HashSet<String>(java.util.Arrays.asList(" "))));
    }
}
