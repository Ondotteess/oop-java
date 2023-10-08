import java.util.Scanner;

public class Main {

    /*
     *   ---BASIC---
     *
     *   1. Stack
     *       1.1 Type: Int
     *       1.2 Ops: / * + - mode < > =
     *           1.2.1 Pop first and second from top
     *           1.2.2 First - right; second - left
     *           1.2.3 Push result
     *
     *       1.3 Exceptions
     *           1.3.0 Numbers pop from stack
     *           1.3.1 Not enough items
     *           1.3.2 Illegal operation
     *
     *   2. Commands
     *       2.1 dup   V           2.5 emit     V
     *       2.2 drop  V           2.6 cr       V
     *       2.3 swap  V           2.7 exit
     *       2.4 rot   V           2.8 ."..."
     *
     *   ---Pro---
     *
     *   1. Language description
     *       1.1 if-branches
     *           1.1.0 if THEN_BRANCH then else ELSE_BRANCH (optional);
     *           1.1.1 pop num from top if num!=0 -> THEN_BRANCH
     *
     *       1.2 loops
     *           1.2.0 x y do LOOP_BODY loop;
     *           1.2.1 keyword i - current iteration in [x, y] range
     *
     *       1.3 custom commands
     *           1.3.0 : command_name COMMAND_BODY;
     *
     *       1.4 variables
     *           1.4.1 variable VAR_NAME - init var with zero value
     *           1.4.2 VAR_NAME push address on top
     *           1.4.3 @ dereferencing - put value on top
     *           1.4.4 ! write in address on top value of second number
     *
     *       1.5 arrays
     *           1.5.1 int array lenght = 1
     *           1.5.2 N cells allot allocate (N * cells) memory for next variables
     *
     */

    public static void main(String[] args) {
        // if (args.length >= 2) {
        //     System.err.println("Too many arguments");
        //     System.err.println("Usage: binterpreter [-p]");
        //     return;
        // }
        // if (args.length == 1) {
        //     String s1 = "-p";
        //     if (!s1.equals(args[0])) {
        //         System.err.println("Unknown argument: " + args[0]);
        //         System.err.println("Usage: binterpreter [-p]");
        //         return;
        //     }
        //     return;
        // }







        /*  ----------  Stack tester  ----------
        for (int i = 0; i < 100; i++){
            stack.push(i);
            String formString = String.format("Size: %d, Element: %d, Capacity: %d", stack.size(), stack.top(), stack.capacity());
            System.out.println(formString);
        };

        for (int i = 0; i < 100; i++){
            String formString = String.format("Size: %d, Element: %d, Capacity: %d", stack.size(), stack.pop(), stack.capacity());
            System.out.println(formString);
        };
          ----------  Stack tester  ----------  */



        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();

        while (true) {
            String line = scanner.nextLine();
            parser.parse(line);


        }
    }
}

