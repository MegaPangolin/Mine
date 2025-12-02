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

    public static 

}