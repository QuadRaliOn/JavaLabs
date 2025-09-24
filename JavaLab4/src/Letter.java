public class Letter {
    private char value;

    /**
     * @param value The character of the letter.
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * Gets the character value of this letter.
     * @return The character of the letter.
     */
    public char getValue() {
        return value;
    }
    @Override
    public String toString() {
        return Character.toString(value);
    }
}