import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // The word to be guessed
        String word = "hangman";

        // Convert the word to a char array to make it easier to work with
        char[] wordArray = word.toCharArray();

        // The number of tries the player has
        int tries = 6;

        // The current state of the game, represented by a char array
        char[] currentState = new char[wordArray.length];
        for (int i = 0; i < currentState.length; i++) {
            currentState[i] = '_';
        }

        // The letters that have already been guessed
        String guessedLetters = "";

        // Main game loop
        while (tries > 0) {
            System.out.println("Current state: " + String.valueOf(currentState));
            System.out.println("Tries left: " + tries);
            System.out.println("Guessed letters: " + guessedLetters);

            // Get the player's guess
            System.out.print("Guess a letter: ");
            char guess = scanner.nextLine().charAt(0);

            // Check if the player has already guessed this letter
            if (guessedLetters.indexOf(guess) >= 0) {
                System.out.println("You already guessed that letter. Try again.");
                continue;
            }

            // Add the guessed letter to the list of guessed letters
            guessedLetters += guess;

            // Check if the guessed letter is in the word
            boolean foundLetter = false;
            for (int i = 0; i < wordArray.length; i++) {
                if (wordArray[i] == guess) {
                    currentState[i] = guess;
                    foundLetter = true;
                }
            }

            // If the guessed letter is not in the word, decrement the number of tries left
            if (!foundLetter) {
                tries--;
                System.out.println("Sorry, that letter is not in the word.");
            }

            // Check if the player has won
            boolean allLettersGuessed = true;
            for (int i = 0; i < currentState.length; i++) {
                if (currentState[i] == '_') {
                    allLettersGuessed = false;
                    break;
                }
            }
            if (allLettersGuessed) {
                System.out.println("Congratulations, you win!");
                return;
            }
        }

        // If the player has run out of tries, the game is over and the player has lost
        System.out.println("Sorry, you lose. The word was \"" + word + "\".");
    }
}
