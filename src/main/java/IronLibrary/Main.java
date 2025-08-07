package IronLibrary;

import java.util.Scanner;

import static IronLibrary.menu.LibraryMenu.mainMenuInput;
import static IronLibrary.utils.Prints.printTitle;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printTitle(scanner);
        while (true)
            mainMenuInput(scanner);
    }
}