public class PalindromeExecutor {
    public static String findLongestPalindrome(Text text) {
        String fullText = text.getText(); // отримуємо рядок з Text
        for (int size = fullText.length(); size > 0; size--) {
            for (int i = 0; i <= fullText.length() - size; i++) {
                String substring = fullText.substring(i, i + size);
                if (isPalindrome(substring)) {
                    return substring;
                }
            }
        }
        return "";
    }

    private static boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
