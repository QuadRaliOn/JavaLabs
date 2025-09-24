public class Punctuation {
    private char value;

    /**
     * Constructs a Punctuation object with the specified character.
     * @param value The punctuation character.
     */
    public Punctuation(char value) {
        this.value = value;
    }

    /**
     * Gets the punctuation character.
     * @return The punctuation character.
     */
    public char getValue() {
        return value;
    }
    @Override
    public String toString() {
        return Character.toString(value);
    }
}
