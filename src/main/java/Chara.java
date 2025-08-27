import java.util.Scanner;

public class Chara {
    public static long lineLen = 50;

    public static void printLine(long length) {
        for (long i = 0; i < length; i+=1) {
            System.out.print('_');
        }
        System.out.println();
    }

    public static void initialPrint() {
        printLine(lineLen);
        String logo = """
                  ____ _   _    _    ____   _   \s
                 / ___| | | |  / \\  |  _ \\ / \\  \s
                | |   | |_| | / _ \\ | |_) / _ \\ \s
                | |___|  _  |/ ___ \\|  _ < ___ \\\s
                 \\____|_| |_/_/   \\_\\_| \\_\\_/ \\_\\
                """;
        System.out.print(logo);
        printLine(lineLen);
        System.out.println("Hello! I'm Chara!");
        System.out.println("What can I do for you?");
        printLine(lineLen);
    }
    public static void main(String[] args) {
        initialPrint();
        Scanner echo = new Scanner(System.in);
        while (true) {
            System.out.print("User: ");

            String userIn = echo.nextLine();
            if (userIn.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                printLine(lineLen);
                return;
            } else {
                System.out.println(userIn);
                printLine(lineLen);
            }
        }

    }
}
