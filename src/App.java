import Menus.MainMenu;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        run();
    }

    /**
     * Starts the program and manages the main loop.
     */
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu(scanner);
        boolean continueProgram = true;
        
        while (continueProgram) {
            continueProgram = mainMenu.prompt();
        }
    }
}
