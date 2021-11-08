import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;
import java.util.HashSet;

public class WordFinder {
    private Pattern sentencePattern;
    private Pattern wordPattern;

    public WordFinder(int wordLen, char sentenceEnd) {
        sentencePattern = Pattern.compile(
            String.format("[\\w\\(\\)\\[\\]\"][\\w\\s,:;\\(\\)\\[\\]\"']*[%c]", sentenceEnd));
        wordPattern = Pattern.compile(String.format("\\b\\w{%d}\\b", wordLen));
    }

    public Set<String> GetWords(String input) {
        Matcher matcher = sentencePattern.matcher(input);
        ArrayList<String> sentences = new ArrayList<String>();
        while(matcher.find()) {
            sentences.add(matcher.group());
        }

        Set<String> goodWords = new HashSet<String>();
        for (String sentence : sentences) {
            Matcher wordMatcher = wordPattern.matcher(sentence);
            while (wordMatcher.find()) {
                goodWords.add(wordMatcher.group());
            }
        }
        return goodWords;
    }
}
