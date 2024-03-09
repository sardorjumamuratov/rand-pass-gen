import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        List<Character> symbols = List.of('!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~'
        );

        List<Character> lowerCases = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        );

        List<Character> upperCases = List.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');

        List<Character> numbers = List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');


        int length = 12;
        Random randomNumber = SecureRandom.getInstanceStrong();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = randomNumber.nextInt(lowerCases.size());
            sb.append(lowerCases.get(randomIndex));
        }

        int count = 0;

        ArrayList<Integer> indicesUppers = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (length / 4 == count) {
                break;
            }
            int randomIndex = randomNumber.nextInt(upperCases.size());
            int randomSbIndex = randomNumber.nextInt(sb.length());

            sb.replace(randomSbIndex, randomSbIndex + 1, String.valueOf(upperCases.get(randomIndex)));
            indicesUppers.add(randomSbIndex);
            count++;
        }


        count = 0;
        ArrayList<Integer> indicesNumbers = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (length / 4 == count) {
                break;
            }

            int randomIndex = randomNumber.nextInt(numbers.size());
            int randomSbIndex = randomNumber.nextInt(sb.length());
            while (indicesUppers.contains(randomSbIndex)) {
                randomSbIndex = randomNumber.nextInt(sb.length());
            }

            sb.replace(randomSbIndex, randomSbIndex + 1, String.valueOf(numbers.get(randomIndex)));
            count++;
        }

        count = 0;

        for (int i = 0; i < length; i++) {
            if (length / 4 == count) {
                break;
            }

            int randomIndex = randomNumber.nextInt(symbols.size());
            int randomSbIndex = randomNumber.nextInt(sb.length());
            while (indicesUppers.contains(randomSbIndex)) {
                randomSbIndex = randomNumber.nextInt(sb.length());
            }

            sb.replace(randomSbIndex, randomSbIndex + 1, String.valueOf(symbols.get(randomIndex)));
            count++;
        }


        System.out.println(sb.toString());
        System.out.println(sb.toString().length());
    }
}