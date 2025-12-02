/**
 * Name: Brandon Estrada
 * Date: 12/7/2025
 * Purpose: Cards Project
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

import java.util.*;

public class Cards_Project_Brandon_Estrada
{
    static Scanner input = new Scanner(System.in);

    static final int Hearts = 0;
    static final int Diamonds = 1;
    static final int Clubs = 2;
    static final int Spades = 3;

    static final String[] Suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    static int totalSimulations = 0;
    static int[] cumulativeSuitCounts = new int [4];
    static int totalGameRounds = 0;
    static int totalCorrectGuesses = 0;

    public static void main(String[] args)
    {
        boolean running = true;

        while (running)
        {
            System.out.println("\n====== MAIN MENU ======");
            System.out.println("1. Run Simulation");
            System.out.println("2. Play Game");
            System.out.println("3. View Statistics");
            System.out.println("4. Exit");

            int choice = input.nextInt();

            switch (choice)
            {
                case 1 -> simulation();
                case 2 -> playGame();
                case 3 -> viewStats();
                case 4 -> running = false;
                default -> System.out.println("Invalid entry. Choose 1 thru 4.");
            }
        }
        System.out.println("Sayonara Sucker!");
    }
    
    public static void simulation()
    {
        System.out.print("\nHow many cards do you want to draw? ");
        int draws = input.nextInt();

        int[] suitCounts = new int[4];

        for (int i = 0; i < draws; i++)
        {
            int suit = drawCard();
            suitCounts[suit]++;
            cumulativeSuitCounts[suit]++;
        }

        totalSimulations += draws;

        System.out.println("\n---Simulation Results ---");
        printSuitStats(suitCounts, draws);
    }

    public static void playGame
    {
        System.out.println("\n--- GAME MODE ---");
        System.out.print("How many rounds do you want to play? ");
        int rounds = input.nextInt();

        int score = 0

        for (int i = 0; i < rounds; i++)
        {
            System.out.println("\nRound " + (i+1));
            System.out.println("Guess the suit:");
            System.out.println("0 = Hearts, 1 = Diamonds, 2 = Clubs, 3 = Spades");
            System.out.print("Your guess: ");
            int suess = input.nextInt();

            while (guess < 0 || guess > 3)
            {
                System.out.print("Invalid. Guess 0-3: ";
                guess = input.nextInt();
            }

            int actual = drawCard();
            System.out.println("Card suit was: " + Suits[actual]);

            if (guess == actual)
            {
                System.out.println("Correct!");
                score++;
                totalCorrectGuesses++;
            }

            else
            {
                System.out.println("Wrong!");
            }

            cumulativeSuitCounts[actual]++;
            totalSimulations++;
        }

        totalGameRounds += rounds;

        System.out.println("\nGame Over! You scored: " + score + "/" + rounds);
    }

    public static void viewStats()
    {
        System.out.println("\n====== GLOBAL STATISTICS ======");

        if (totalSimulations == 0 && totalGameRounds == 0)
        {
            System.out.println("No data yet. Run a simulation or play a game first.");
            return;
        }

        System.out.println("\n--- Cumulative Suit Frequency ---");
        printSuitStats(cumulativeSuitCounts, totalSimulations);

        System.out.println("\n--- Game Mode Statistics ---");
        
        if (totalGameRounds > 0)
        {
            double percent = (100.0 * totalCorrectGuesses) / totalGameRounds;
            System.out.printf("Total Rounds Played: %d%n", totalGameRounds);
            System.out.printf("Correct Guesses: %d (%.f%%)%n", totalCorrectGuesses, percent);
        }
        
        else
        {
            System.out.println("No game rounds played yet.");
        }
    }

    public static int drawCard()
    {
        return (int) (Math.random() * 4);
    }

    public static void printSuitStats(int[] suitCounts, int total)
    {
        System.out.printf("%-10s %-10s %-10s%n", "Suit", "Count", "Percent");

        for (int i = 0; i < 4; i++)
        {
            double percent = (100.0 * suitCounts[i]) / total;
            System.out.printf("%-10s %-10d %-9.2f%%%n", Suits[i], suitCounts[i], percent);
        }
    }   
}