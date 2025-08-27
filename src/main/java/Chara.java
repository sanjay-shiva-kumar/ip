import java.util.Scanner;

public class Chara {
    public static long lineLen = 80;

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
        String charaSprite = """
                ⣿⣿⡿⠛⠉⠉⠉⠉⠉⠉⠉⠛⣿⣿⣿
                ⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠹⣿
                ⡏⠁⠀⣤⣶⣦⠀⣤⣤⣤⡀⠀⠀⠀⢿
                ⠁⠀⣶⣿⡇⢸⣿⣿⡇⢸⣿⠀⣀⡆⠀
                ⠀⠀⣿⣿⣷⡞⢿⠿⠓⣾⣿⡶⠋⠁⠀
                ⡀⢀⠀⠉⠩⠿⠶⣶⣿⠏⠉⠀⢀⡀⣀
                ⣧⣼⣦⣤⣤⡤⠐⠿⠿⠠⢤⣤⣸⣧⣿
                ⣿⣿⠛⣭⠉⡵⠤⡤⠤⡴⣤⠉⡝⢻⣿
                ⣿⡇⠇⠀⣿⣿⣿⣿⣿⣿⣿⡄⠸⠇⣿
                ⣿⡇⠒⠀⠁⠈⠀⠁⠈⠀⠀⠁⠐⠂⣿
                ⣿⣿⣿⠀⠀⠀⢠⣤⠀⠀⠀⠀⢸⣿⣿
                ⣿⣿⣿⣶⠒⠀⠰⣿⠀⠀⠀⠒⣾⣿⣿""";
        System.out.println(logo);
        System.out.println(charaSprite);
        System.out.println("Chara: Greetings.");
        System.out.println("Chara: I am Chara! =)");
        printLine(lineLen);
    }

    public static void printList(String[] list, int listLength) {
        for (int i = 0; i < listLength; i += 1) {
            System.out.println(i+1 + ". " + list[i]);
        }
        return;
    }

    public static void main(String[] args) {
        initialPrint();
        Scanner echo = new Scanner(System.in);
        /*while (true) {
            System.out.print("User: ");

            String userIn = echo.nextLine();
            if (userIn.equals("bye")) {
                System.out.println("Chara: Let us erase this chat, and move on to the next.");
                printLine(lineLen);
                return;
            } else {
                System.out.println("Chara: " + userIn);
                printLine(lineLen);
            }
        }*/
        String[] inputList = new String[100];
        int listLength = 0;
        while (true) {
            System.out.print("User: ");
            String userIn = echo.nextLine();
            if (userIn.equals("bye")) {
                System.out.println("Chara: Let us erase this chat, and move on to the next =)");
                printLine(lineLen);
                return;
            } else if (userIn.equals("list") && listLength == 0) {
                System.out.println("Chara: Your list is empty, silly!");
                printLine(lineLen);
            } else if (userIn.equals("list") && listLength != 0) {
                System.out.println("Chara: Here's your list! (What's it for anyway?)");
                printList(inputList, listLength);
                printLine(lineLen);
            } else {
                inputList[listLength] = userIn;
                listLength += 1;
                System.out.println("Chara has added \"" + userIn + "\" to your list =)");
                printLine(lineLen);
            }
        }
    }
}
