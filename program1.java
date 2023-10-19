import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = {1, 2, 3, 4, 5, 6, 7};
        shuffleArray(array);
        System.out.print("Shuffled Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Enter a Roman Numeral: ");
        String romanNumeral = scanner.nextLine();
        int integerEquivalent = romanToInteger(romanNumeral);
        System.out.println("Integer Equivalent: " + integerEquivalent);

        System.out.print("Enter a sentence to check for a pangram: ");
        String sentence = scanner.nextLine();
        boolean isPangram = isPangram(sentence);
        if (isPangram) {
            System.out.println("The input is a pangram.");
        } else {
            System.out.println("The input is not a pangram.");
        }
    }

    public static void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static int romanToInteger(String romanNumeral) {
        int result = 0;
        int previousValue = 0;
        
        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            char c = romanNumeral.charAt(i);
            int value = romanDigitValue(c);
            
            if (value < previousValue) {
                result -= value;
            } else {
                result += value;
            }
            
            previousValue = value;
        }
        
        return result;
    }

    public static int romanDigitValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0; 
        }
    }


    public static boolean isPangram(String sentence) {
        sentence = sentence.toLowerCase();
        boolean[] alphabet = new boolean[26];
        int totalAlphabets = 0;

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (Character.isLetter(c)) {
                int index = c - 'a';
                if (!alphabet[index]) {
                    alphabet[index] = true;
                    totalAlphabets++;
                }
            }

            if (totalAlphabets == 26) {
                return true;
            }
        }

        return false;
    }
}
