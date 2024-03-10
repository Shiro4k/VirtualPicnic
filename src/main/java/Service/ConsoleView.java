package Service;

public class ConsoleView {
    public void start(){
        WordAnalyzer wordAnalyzer = new WordAnalyzer();
        wordAnalyzer.analyze("input.txt");
    }

}
