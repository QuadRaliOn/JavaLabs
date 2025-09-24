import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Sentence> sentences;

    public Text() {
        sentences = new ArrayList<>();
    }

    /**
     * Adds a sentence to the text.
     * @param sentence The Sentence object to add.
     */
    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    /**
     * Returns the full textual representation of the text.
     * Replaces multiple spaces and tabs with a single space.
     * @return The string representation of the text.
     */
    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (Sentence s : sentences) {
            sb.append(s.getText()).append(" ");
        }
        return sb.toString().trim().replaceAll("\\s+", " ");
    }

    /**
     * Returns the list of sentences in the text.
     * @return List of Sentence objects.
     */
    public List<Sentence> getSentences() {
        return sentences;
    }
}

