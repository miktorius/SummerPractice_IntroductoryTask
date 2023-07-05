import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        String text = scanner.nextLine();
        CustomList<Integer> answer = KMPAlgorithm.knuthMorrisPratt(pattern, text);
        KMPAlgorithm.formatAnswer(answer);
    }
}
