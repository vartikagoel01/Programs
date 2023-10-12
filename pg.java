import java.util.*;
public class Main {
 public static void main(String[] args) {
 // A. Create an array with the values (1, 2, 3, 4, 5, 6, 7) and shuffle it.
 List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
 Collections.shuffle(numbers);
 System.out.println("Shuffled Array: " + numbers);
 // B. Enter Roman Number as input and convert it to an integer. (ex IX = 9)
 Scanner scanner = new Scanner(System.in);
 System.out.print("Enter a Roman numeral: ");
 String romanNumeral = scanner.nextLine();
 int decimalValue = romanToDecimal(romanNumeral);
 System.out.println("Decimal equivalent: " + decimalValue);
 // C. Check if the input is a pangram or not.
 System.out.print("Enter a sentence: ");
 String sentence = scanner.nextLine();
 boolean isPangram = checkPangram(sentence);
 if (isPangram) {
 System.out.println("The input is a pangram.");
 } else {
 System.out.println("The input is not a pangram.");
 }
 scanner.close();
 }
 // B. Roman numeral to decimal conversion function
 public static int romanToDecimal(String s) {
 Map<Character, Integer> romanMap = new HashMap<>();
 romanMap.put('I', 1);
 romanMap.put('V', 5);
 romanMap.put('X', 10);
 romanMap.put('L', 50);
 romanMap.put('C', 100);
 romanMap.put('D', 500);
 romanMap.put('M', 1000);
 int result = 0;
 int prevValue = 0;
 for (int i = s.length() - 1; i >= 0; i--) {
 int currentValue = romanMap.get(s.charAt(i));
 if (currentValue < prevValue) {
 result -= currentValue;
 } else {
 result += currentValue;
 }
 prevValue = currentValue;
 }
 return result;
 }
 // C. Pangram checking function
 public static boolean checkPangram(String sentence) {
 sentence = sentence.toLowerCase();
 boolean[] isAlphabetPresent = new boolean[26];
 for (int i = 0; i < sentence.length(); i++) {
 char c = sentence.charAt(i);
 if ('a' <= c && c <= 'z') {
 isAlphabetPresent[c - 'a'] = true;
 }
 }
 for (boolean alphabet : isAlphabetPresent) {
 if (!alphabet) {
 return false;
 }
 }
 return true;
 }
}