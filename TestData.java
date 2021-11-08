import java.util.HashSet;
import java.util.List;

public class TestData {
    public String path;
    public int wordLen;
    public char sentenceEnding;
    public HashSet<String> expectedResult; 
    
    public TestData(String _path, int _wordLen, 
            char _sentenceEnding, List<String> _expectedResult) { 
        path = _path; 
        wordLen = _wordLen; 
        sentenceEnding = _sentenceEnding; 
        expectedResult = new HashSet<String>(_expectedResult);
    } 
}