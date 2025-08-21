    public class Chara {
    /*public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }*/
    public static void printLine(long length) {
        for (long i = 0; i < length; i+=1) {
            System.out.print('_');
        }
        System.out.println();
    }

    public static void main(String[] args) {
        long lineLen = 50;
        printLine(lineLen);
        System.out.println("Hello! I'm Chara!");
        System.out.println("What can I do for you?");
        printLine(lineLen);
        System.out.println(" Bye. Hope to see you again soon!");
        printLine(lineLen);
    }
}
