import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fortherpretator forth = new Fortherpretator();
        while (true) {
            String line = scanner.nextLine();
            forth.interpret(line);
        }
    }
}