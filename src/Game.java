import java.util.Scanner;

public class Game {
    private static final int START_GAME = 1;
    private static final int END_GAME = 2;
    DataBase dataBase = new DataBase();
    Scanner sc = new Scanner(System.in);

    void mainLoop(){
        int option = START_GAME;
        while (option != END_GAME){
            play();
            printOption();
            option = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("Bye bye!");
    }

    private void printOption() {
        System.out.println(START_GAME + " - Graj dalej");
        System.out.println(END_GAME + " - Koniec programu");
    }

    private void play() {
        HangMan hangMan = new HangMan(dataBase.getRandomWord());
        System.out.println("Hasło do zgadnięcia:");
        System.out.println(hangMan.getGuessWordDisplay());
        while (!hangMan.userLose() && !hangMan.userWin()) {
            System.out.println("Podaj literę:");
            char letter = sc.nextLine().charAt(0);
            hangMan.checkLetter(letter);
            System.out.println(hangMan.getGuessWordDisplay());
            System.out.println();
            if (hangMan.userWin()) {
                System.out.println("Wygrałeś!");
                System.out.println("Hasło: " + hangMan.getGuessWord());
            } else if (hangMan.userLose()) {
                System.out.println("Niestety przegrałeś");
                System.out.println("Hasło: " + hangMan.getGuessWord());
            }
        }
    }
}
