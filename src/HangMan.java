public class HangMan {
    private static final int MAX_MISTAKES = 8;

    private String guessWord;
    private String guessWordDisplay;
    private char[] userGuesses;
    private int guesses;
    private int mistakes;

    public HangMan(String guessWord) {
        this.guessWord = guessWord;
        userGuesses = new char[32];
        generateDisplay();
    }

    public String getGuessWord() {
        return guessWord;
    }

    public String getGuessWordDisplay() {
        return guessWordDisplay;
    }

    boolean userLose() {
        return MAX_MISTAKES <= mistakes;
    }

    boolean userWin() {
        return !guessWordDisplay.contains("*");
    }

    void checkLetter(char letter) {
        if (!arrayContains(userGuesses, letter)) {
            checkMistake(letter);
            rememberGuess(letter);
            generateDisplay();
        }
    }

    private void generateDisplay() {
        String display = "";
        for (int i = 0; i < guessWord.length(); i++) {
            char nextChar = guessWord.charAt(i);
            if(arrayContains(userGuesses, nextChar))
                display += nextChar;
            else if (nextChar == ' ')
                display += nextChar;
            else{
                display += "*";
            }
            this.guessWordDisplay = display;
        }
    }

    private void rememberGuess(char letter) {
        userGuesses[guesses] = letter;
        guesses++;
    }

    private void checkMistake(char letter) {
        if (guessWord.indexOf(letter) == -1)
            mistakes++;
    }

    private boolean arrayContains(char[] userGuesses, char letter) {
        for (char userGuess : userGuesses) {
            if (userGuess == letter)
                return true;
        }
        return false;
    }
}
