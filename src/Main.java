import java.util.Objects;
import java.util.Scanner;

public class Main {

    /*
     [0-255] [0][0][0][][][][][][][][][]...[] <- 30_000
      ^

     > - move caret right       +
     < - move caret left        +
     + - inc number in cell     +
     - - dec number in cell     +
     . - print as ascii         +
     , - read char from input and put it into the current cell +
     [ - ...
     ] - ...
     */

    public static void main(String[] args) {
        if (args.length >= 2) {
            System.err.println("Too many arguments");
            System.err.println("Usage: binterpreter [-p]");
            return;
        }
        if (args.length == 1) {
            String s1 = "-p";
            if (!s1.equals(args[0])) {
                System.err.println("Unknown argument: " + args[0]);
                System.err.println("Usage: binterpreter [-p]");
                return;
            }
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String line = scanner.nextLine();
                // ><..#.>
                int i = 0;
                while (i < line.length()) {
                    Command cmd = getCmd(line.charAt(i), i, line);
                    if (cmd == null) {
                        System.out.println("System.err.println(\"Unknown command: '\" + c + \"'\")");
                    } else {
                        System.out.println(cmd.print());
                    }
                    i++;
                }

            }
        }

        Scanner scanner = new Scanner(System.in);
        Context ctx = new Context(0, new char[30_000]);
        while (true) {
            String line = scanner.nextLine();
            int i = 0;
            while (i < line.length()) {
                char c = line.charAt(i);
                Command cmd = getCmd(c, i, line);
                if (cmd == null) {
                    if (!Objects.equals(line.charAt(i-1), ',')) {
                        System.err.println("Unknown command: '" + c + "'");
                    }
                } else {
                    cmd.apply(ctx);
                }
                i++;
            }
        }
    }

    private static Command getCmd(char c, int idx, String command) {
        return switch (c) {
            case '>' -> new Right();
            case '<' -> new Left();
            case '+' -> new Plus();
            case '-' -> new Minus();
            case '.' -> new Print();
            case ',' -> new Read(idx, command);

            default -> null;
        };
    }
}
