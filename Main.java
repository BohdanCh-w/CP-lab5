import static org.junit.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import org.junit.Test;

public class Main { 
    public static void main(String[] args) throws Exception {
        
    }

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
    public void test_void_file() throws Exception {
        String input = readFile("G:\\Bohdan-G\\.univer\\5semestr\\CP\\.lab\\CP-lab5\\empty.txt");
        WordFinder wf = new WordFinder(5, '?');
        var result = wf.GetWords(input);
        var lst = result.stream().collect(Collectors.toList());
        prettyPrint(lst);
        assertTrue(result.equals(
            new HashSet<String>(java.util.Arrays.asList())));
    }

    @Test
    public void test_several_outputs_4() throws Exception {
        String input = readFile("G:\\Bohdan-G\\.univer\\5semestr\\CP\\.lab\\CP-lab5\\avrg.txt");
        WordFinder wf = new WordFinder(4, '?');
        var result = wf.GetWords(input);
        var lst = result.stream().collect(Collectors.toList());
        prettyPrint(lst);
        assertTrue(result.equals(
            new HashSet<String>(java.util.Arrays.asList("this", "word", "sure"))));
    }

    @Test
    public void test_several_outputs_9() throws Exception {
        String input = readFile("G:\\Bohdan-G\\.univer\\5semestr\\CP\\.lab\\CP-lab5\\avrg.txt");
        WordFinder wf = new WordFinder(9, '?');
        var result = wf.GetWords(input);
        var lst = result.stream().collect(Collectors.toList());
        prettyPrint(lst);
        assertTrue(result.equals(
            new HashSet<String>(java.util.Arrays.asList("Duplicate", "sentences"))));
    }

    @Test
    public void test_one_output() throws Exception {
        String input = readFile("G:\\Bohdan-G\\.univer\\5semestr\\CP\\.lab\\CP-lab5\\avrg.txt");
        WordFinder wf = new WordFinder(1, '?');
        var result = wf.GetWords(input);
        var lst = result.stream().collect(Collectors.toList());
        prettyPrint(lst);
        assertTrue(result.equals(
            new HashSet<String>(java.util.Arrays.asList("I"))));
    }

    @Test
    public void test_zero_output() throws Exception {
        String input = readFile("G:\\Bohdan-G\\.univer\\5semestr\\CP\\.lab\\CP-lab5\\avrg.txt");
        WordFinder wf = new WordFinder(5, '?');
        var result = wf.GetWords(input);
        var lst = result.stream().collect(Collectors.toList());
        prettyPrint(lst);
        assertTrue(result.equals(
            new HashSet<String>(java.util.Arrays.asList())));
    }

    @Test
    public void test_other_sentence_type() throws Exception {
        String input = readFile("G:\\Bohdan-G\\.univer\\5semestr\\CP\\.lab\\CP-lab5\\avrg.txt");
        WordFinder wf = new WordFinder(3, '.');
        var result = wf.GetWords(input);
        var lst = result.stream().collect(Collectors.toList());
        prettyPrint(lst);
        assertTrue(result.equals(
            new HashSet<String>(java.util.Arrays.asList("one", "lot", "Two"))));
    }
}