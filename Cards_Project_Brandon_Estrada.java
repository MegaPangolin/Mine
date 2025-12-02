/**
 * Name: Brandon Estrada
 * Date: 12/7/2025
 * Purpose: Cards Project
 * 
 * This project allows you three options.
 * Run simulation. This simulates drawing that amount of cards and tells you the suit counts and percentages.
 * Play game. This is where you play a game guessing the suit of the next card drawn.
 * View statistics. This will allow you to view stats from the other choices.
 */

import java.util.*; //import scanner and other utilities

public class Cards_Project_Brandon_Estrada  //start of main class
{
    static Scanner input = new Scanner(System.in); //Scanner for user input

    static final int Hearts = 0; //0 means Hearts
    static final int Diamonds = 1; //1 means diamonds
    static final int Clubs = 2; //2 means clubs
    static final int Spades = 3; // 3 means spades

    static final String[] Suits = {"Hearts", "Diamonds", "Clubs", "Spades"}; //names for printing suit results
    static int totalSimulations = 0; //total number of cards drawn
    static int[] cumulativeSuitCounts = new int [4]; // stores how many times each suit appears
    static int totalGameRounds = 0; //number of rounds played in game
    static int totalCorrectGuesses = 0; //total correct guesses

    public static void main(String[] args) //program start
    {
        boolean running = true; //to keep menu running

        while (running) //menu is there unless exited
        {
            System.out.println("\n====== MAIN MENU ======"); //The main menu display
            System.out.println("1. Run Simulation");
            System.out.println("2. Play Game");
            System.out.println("3. View Statistics");
            System.out.println("4. Exit");

            int choice = input.nextInt(); //takes in choice

            switch (choice) //choice action by program
            {
                case 1:
                    simulation();
                    break;

                case 2:
                    playGame();
                    break;

                case 3:
                    viewStats();
                    break;

                case 4:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid entry. Choose 1 thru 4.");
            }
        }
        System.out.println("Sayonara Sucker!"); //program ending message
    }
    
    public static void simulation() //method to run card simulation
    {
        System.out.print("\nHow many cards do you want to draw? "); //question for user
        int draws = input.nextInt(); //takes input from question

        int[] suitCounts = new int[4]; //array to track suit counts

        for (int i = 0; i < draws; i++) //loop to simulate each card draw
        {
            int suit = drawCard(); //random suit
            suitCounts[suit]++; //increases count for suit drawn
            cumulativeSuitCounts[suit]++; // updates stats
        }

        totalSimulations += draws; // add to total cards drawn

        System.out.println("\n---Simulation Results ---"); //printing results
        printSuitStats(suitCounts, draws);
    }

    public static void playGame() // method to play game
    {
        System.out.println("\n--- GAME MODE ---"); 
        System.out.print("How many rounds do you want to play? "); //asking user question
        int rounds = input.nextInt(); // taking input from question

        int score = 0; // score for this round

        for (int i = 0; i < rounds; i++) //loop for each round
        {
            System.out.println("\nRound " + (i+1)); 
            System.out.println("Guess the suit:"); //displays input options
            System.out.println("0 = Hearts, 1 = Diamonds, 2 = Clubs, 3 = Spades");
            System.out.print("Your guess: ");
            int guess = input.nextInt(); //reads players input

            while (guess < 0 || guess > 3) //validates input
            {
                System.out.print("Invalid. Guess 0-3: "); 
                guess = input.nextInt();
            }

            int actual = drawCard(); //program draws suit
            System.out.println("Card suit was: " + Suits[actual]);

            if (guess == actual) //checking if player guessed right
            {
                System.out.println("Correct!"); //if correct outcome
                score++;
                totalCorrectGuesses++;
            }

            else
            {
                System.out.println("Wrong!"); // if incorrect outcome
            }

            cumulativeSuitCounts[actual]++; // update counters
            totalSimulations++; // counts total card draws
        }

        totalGameRounds += rounds; // add to number of rounds count

        System.out.println("\nGame Over! You scored: " + score + "/" + rounds); // prints statement declaring end of game 
    }

    public static void viewStats() //method to show cumulative stats
    {
        System.out.println("\n====== GLOBAL STATISTICS ======");

        if (totalSimulations == 0 && totalGameRounds == 0) //if nothing happened prior
        {
            System.out.println("No data yet. Run a simulation or play a game first.");
            return;
        }

        System.out.println("\n--- Cumulative Suit Frequency ---"); //shows suit frequency
        printSuitStats(cumulativeSuitCounts, totalSimulations);

        System.out.println("\n--- Game Mode Statistics ---"); 
        
        if (totalGameRounds > 0) //if game has been played
        {
            double percent = (100.0 * totalCorrectGuesses) / totalGameRounds;
            System.out.printf("Total Rounds Played: %d%n", totalGameRounds); //displays your total rounds played
            System.out.printf("Correct Guesses: %d (%.2f%%)%n", totalCorrectGuesses, percent); //displays correct guesses
        }
        
        else // if not played
        {
            System.out.println("No game rounds played yet."); //display to tell youve not played
        }
    }

    public static int drawCard() //returns a random suit
    {
        return (int) (Math.random() * 4); //random number gen
    }

    public static void printSuitStats(int[] suitCounts, int total) //prints table of suit counds and percentages
    {
        System.out.printf("%-10s %-10s %-10s%n", "Suit", "Count", "Percent"); 

        for (int i = 0; i < 4; i++)
        {
            double percent = (100.0 * suitCounts[i]) / total;
            System.out.printf("%-10s %-10d %-9.2f%%%n", Suits[i], suitCounts[i], percent);
        }
    }   
}