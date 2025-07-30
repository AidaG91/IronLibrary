package IronLibrary;

import IronLibrary.menu.LibraryMenu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryMenu menu = new LibraryMenu();

        while (true)
            menu.mainMenuInput(scanner);
    }
}