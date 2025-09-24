import java.util.ArrayList;
import java.util.List;
public class Sentence {
    private List<Object> elements; // Word або Punctuation
    public Sentence() {
        elements = new ArrayList<>();
    }

    /**
     * Adds an element to the sentence.
     * @param elem The element to add (Word or Punctuation).
     */
    public void addElement(Object elem) {
        elements.add(elem);
    }

    /**
     * Returns the textual representation of the sentence.
     * Words are separated by spaces, punctuation is attached directly.
     * @return The string representation of the sentence.
     */
    public String getText() {
        StringBuilder sb = new StringBuilder();
        Object prevElem = null;

        for (Object elem : elements) {
            if (elem instanceof Word) {
                if (prevElem instanceof Word) {
                    sb.append(" ");
                }
                sb.append(((Word) elem).getText());
            } else if (elem instanceof Punctuation) {
                sb.append(elem.toString());
            }
            prevElem = elem;
        }

        return sb.toString();
    }
    public List<Object> getElements() {
        return elements;
    }
}



