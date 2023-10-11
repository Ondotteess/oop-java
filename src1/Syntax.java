public class Syntax {
    private Mystack stack;
    public Syntax(Mystack stack1){
        this.stack = stack1;
    }

    boolean elseincommand(String command){
        String[] tokens = command.split(" ");
        int i = 0;
        int count = 1;
        String token = tokens[++i];
        while (i < tokens.length){
            if (token.equals("if")) {
                count++;
            }
            if (token.equals("else")|| token.equals("then")) {
                count--;
                if (count == 0) return true;
            }
            token = tokens[++i];
        }
        return false;
    }

    int elseposition(String command){

        String[] tokens = command.split(" ");
        int i = 0;
        int count = 1;
        String token = tokens[++i];
        while (i < tokens.length){
            if (token.equals("if")) {
                count++;
            }
            if (token.equals("else")|| token.equals("then")) {
                count--;
                if (count == 0) return i;
            }
            token = tokens[++i];
        }
        return -1;
    }

    public String branches(String branch){
        System.out.println(branch);
        String command = "";
        int first = stack.top();
        if (first != 0){                              // если на вершине не ноль
            String[] tokens = branch.split(" ");      // ищем границу ифа и пишем ее в команду
            StringBuilder sb = new StringBuilder();         // команду скармливаем парсеру
            int i = 0;
            int count = 1;
            String token = tokens[++i];
            while (i < tokens.length){
                if (token.equals("if") || token.equals("do")) {
                    count++;
                }
                if (token.equals(";") || token.equals("else")) {
                    count--;
                    if (count == 0) break;
                }
                sb.append(" ").append(token);
                token = tokens[++i];
            }
            command = sb.toString();
            return command;

        } else if (first == 0 && elseincommand(branch)){
            String[] tokens = branch.split(" ");
            StringBuilder sb = new StringBuilder();
            int i = elseposition(branch);
            int count = 1;
            String token = tokens[++i];
            while (i < tokens.length){
                if (token.equals("if") || token.equals("do")) {
                    count++;
                }
                if (token.equals("then") || token.equals(";")) {
                    count--;
                    if (count == 0) break;
                }
                sb.append(" ").append(token);
                token = tokens[++i];
            }
            command = sb.toString().trim();
            System.out.println(command);
            return command;

        }

        else {
            System.out.println("Kill yourself it wont be painfull");
        }
        // TODO : СКОРМИТЬ КОМАНДУ ПАРСЕРУ ПОВТОРНО
        System.out.println(command);
        return command;
    }
    // 25 45 dup dup rot if 24 if do i 19 . loop ; then ; 35 else 52 do i 52 . loop ; then ;


    public void cycle(String command){      //TODO: RENAME MTHRFUUUKAA

    }

    public void commands(String command){

    }

    public void variable(String command){

    }

    public void arrays(){

    }
}
