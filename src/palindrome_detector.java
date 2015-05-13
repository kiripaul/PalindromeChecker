public class palindrome_detector {
    public static String originalInputString;                //String to hold the suspect word or phrase
    public static boolean isAPalindrome;                     //Boolean that tells whether a word or phrase is a palindrome: Default value is True
    public static void main(String[] args) {
        ////The input phrase or string we want to evaluate
        //originalInputString = "A Palindrome begets more Palindromes.";//Not a Palindrome
        //originalInputString = "pop is pop"; //Not a Palindrome
        //originalInputString = "A dog! A panic in a pagoda!";//Palindrome
        //originalInputString = "Ah, Satan sees Natasha";//Palindrome
        //originalInputString = "Race Car";//Palindrome
        //originalInputString = "1110111";//Palindrome
        originalInputString = "1110111a";//Not a Palindrome

        //Instantiating a class of Palindrome Checker
        PalindromeChecker pChecker = new PalindromeChecker(originalInputString);
        //Getter for boolean value
        isAPalindrome = pChecker.isThisAPalindrome();
        if (!isAPalindrome) {
            System.out.println("\nThe input, \"" + originalInputString + "\", is NOT a palindrome");
        } else {
            System.out.println("\nThe input, \"" + originalInputString + "\", IS a palindrome");
        }
    }//End main
}//End class
