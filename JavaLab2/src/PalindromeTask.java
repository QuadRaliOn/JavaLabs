public class PalindromeTask{
    public static String findLongestPalindrome(String text){
        String startLength;
        for (int size = text.length(); size > 0; size--) {
            for (int i = 0; i <= text.length() - size; i++) {
                if(isPalindrome(text.substring(i, i + size))){
                    return text.substring(i, i + size);
                }
            }
        }
        return "";
    }

    private static Boolean isPalindrome(String text){
        for(int i = 0; i < text.length()/2f; i++){
            if(text.charAt(i) != text.charAt(text.length()-i-1))
                return false;
        }
        return true;
    }
}
