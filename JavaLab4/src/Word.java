import java.util.ArrayList;
import java.util.List;

public class Word {
    private List<Letter> letters;

    /*
    * @param word The string representing the word.
    */
    public Word(String word) {
        letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    /**
     * Gets the list of letters that make up the word.
     * @return List of letters.
     */
    public List<Letter> getLetters() {
        return letters;
    }

    /**
     * Gets the textual representation of the word.
     * @return String representing the word.
     */
    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (Letter l : letters) {
            sb.append(l.getValue());
        }
        return sb.toString();
    }


    /**
     * Gets the number of letters in the word.
     * @return Number of letters.
     */
    public int length() {
        return letters.size();
    }

    /**
     * Gets the letter at the specified index.
     * @param index Index of the letter.
     * @return Letter at the given index.
     */
    public Letter getLetter(int index) {
        return letters.get(index);
    }
}

