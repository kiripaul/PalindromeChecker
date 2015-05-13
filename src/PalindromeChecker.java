import java.util.ArrayList;
public class PalindromeChecker {
    private static String originalInputString;                //String to hold the suspect word or phrase
    private static String inputString;                        //String to hold the formatted suspect word or phrase
    private static char[] inputCharArray;                     //Character array to hold all the chars of a word or phrase; this is a temp array
    private static char[] reversedCharArray;                  //Character array to hold the reversed word or phrase
    private static ArrayList<Character> alphaNumericArray;    //ArrayList to hold just the alpha-numeric values
    private static boolean isAPalindrome;                     //Boolean that tells whether a word or phrase is a palindrome: Default value is True

    //Default constructor
    public PalindromeChecker(String suspectString) {
        //The input phrase or string we want to evaluate
        originalInputString = suspectString;
        //Converting to lowercase to avoid case sensitive issues
        inputString = originalInputString.toLowerCase();
        //Initiating the character array; temporary holding
        inputCharArray = new char[inputString.length()];
        //Casting string into char array
        inputString.getChars(0, inputString.length(), inputCharArray, 0);
        //Initializing the alphaNumericArray
        alphaNumericArray = new ArrayList<>();
        //Removing any non-alphanumeric values
        alphaNumericArray = removeNonAlphanumerics(alphaNumericArray,inputCharArray);
        //Initializing the reversedCharArray: Needed to wait to see how big to make it
        reversedCharArray = new char[alphaNumericArray.size()];
        //Reversing the order of the alphaNumeric ArrayList
        reversedCharArray = reverseInput(alphaNumericArray,reversedCharArray);
        //Assume the phrase or word is a palindrome
        isAPalindrome = true;
        System.out.println("=====Palindrome Checker=====");
        //Determine if the phrase/word is a palindrome
        isAPalindrome = determinePalindrome(alphaNumericArray,reversedCharArray);
    }//End Public method default constructor

    //@@Simple getter to return a boolean value
    public boolean isThisAPalindrome(){
        return isAPalindrome;
    }
    //@@Removing any non alphanumeric characters from the character array
    private ArrayList removeNonAlphanumerics(ArrayList<Character> emptyArrayList, char[] charArray){
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetterOrDigit(charArray[i])) {
                char charToAdd = charArray[i];
                emptyArrayList.add(charToAdd);
            }
        }//End for
        return emptyArrayList;
    }//End private method
    //@@Return the character array backwards from N, N-1, N-2... 0 into a reversed Character array
    private char[] reverseInput(ArrayList<Character> arList, char[] emptyCharArray){
        //Counting sentinel
        int count = arList.size();
        while (count != 0) {
            int i = arList.size() - count;
            //Reversing the order of the alphaNumeric ArrayList
            emptyCharArray[i] = arList.get(count - 1);
            count -= 1;
        }
        return emptyCharArray;
    }//End Private method
    //@@Comparing the ArrayList and Character Array to see if the phrase/word is a palindrome
    private boolean determinePalindrome(ArrayList<Character> arList, char[] charArray){
        //Checking to see if the characters at each position match and then formatting output accordingly
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != arList.get(i)) {
                isAPalindrome = false;
                System.out.println("\t" + arList.get(i) + " <---> " + charArray[i] + " --Different");
            } else {
                System.out.println("\t" + arList.get(i) + " <---> " + charArray[i] + " --Same");
            }//End if
        }//End for
        return isAPalindrome;
    }//End private method
}//End Class
