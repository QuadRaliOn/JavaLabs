public class Main {
    public static void main(String[] args) {
        Text text = new Text();

        Sentence sentence = new Sentence();
        sentence.addElement(new Word("abba"));
        sentence.addElement(new Punctuation('.'));
        sentence.addElement(new Word("This              "));
        sentence.addElement(new Word("word"));
        sentence.addElement(new Word("is"));
        sentence.addElement(new Word("palindome"));
        sentence.addElement(new Word("sssosssasd"));
        text.addSentence(sentence);

        String longest = PalindromeExecutor.findLongestPalindrome(text);
        System.out.println("Longest palindrome: " + longest);
    }
}

