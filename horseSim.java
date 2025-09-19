//Raven Cunanan Sep 2025
//Gameplay Hint: Rest at 6/10 energy 

import java.util.Scanner;
import java.util.Random;

public class horseSim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        
        // Player Stats
        int speed = 1;  
        int power = 1;   
        int stamina = 1;   
        int energy = 10;

        System.out.println("Welcome to Horse Simulator");
        System.out.println("Get ready to raise a champion race horse 🐎");
        System.out.println("Train your horse but be careful to watch its energy levels");
        
        String horseArt = """
               .'' 
        ._.-.___.' (`\\
       //(        ( `'
       '/ )\\ ).__. ) 
       ' <' `\\ ._/'\\
          `   \\     \\
        """;
        System.out.println(horseArt);

        System.out.print("What would you like to name your horse? ");
        String horseName = scanner.nextLine();
        System.out.println("Great! Your horse's name is " + horseName + ".");

        boolean running = true;
        int turn = 1;

        while (running && turn <= 15) {
            System.out.println("\n--- Turn " + turn + " ---");
            System.out.println("Stats: ");
            System.out.println("Energy: " + energy + "/10");
            System.out.println("Speed: " + speed);
            System.out.println("Power: " + power);
            System.out.println("Stamina: " + stamina);

            int successChance = energy * 10;
            System.out.println("\nTraining success chance: " + successChance + "%");

            System.out.println("\nChoose an action: ");
            System.out.println("1. Train Speed");
            System.out.println("2. Train Power");
            System.out.println("3. Train Stamina");
            System.out.println("4. Rest");
            System.out.println("5. Quit \n");

            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "1":
                case "train speed":
                    int energyUsedS = rand.nextInt(2) + 1; // 1–2
                    energy = Math.max(0, energy - energyUsedS);
                    int[] newStatsS = train("Speed", horseName, rand, energy, speed, power, stamina);
                    speed = newStatsS[0];
                    power = newStatsS[1];
                    stamina = newStatsS[2];
                    break;

                case "2":
                case "train power":
                    int energyUsedP = rand.nextInt(2) + 1;
                    energy = Math.max(0, energy - energyUsedP);
                    int[] newStatsP = train("Power", horseName, rand, energy, power, speed, stamina);
                    power = newStatsP[0];
                    speed = newStatsP[1];
                    stamina = newStatsP[2];
                    break;

                case "3":
                case "train stamina":
                    int energyUsedSt = rand.nextInt(2) + 1;
                    energy = Math.max(0, energy - energyUsedSt);
                    int[] newStatsSt = train("Stamina", horseName, rand, energy, stamina, speed, power);
                    stamina = newStatsSt[0];
                    speed = newStatsSt[1];
                    power = newStatsSt[2];
                    break;

                case "4":
                case "rest":
                    int restGain = rand.nextInt(4) + 2; // 2–5
                    energy = Math.min(10, energy + restGain); // cap at 10
                    System.out.println(horseName + " rests and regains " + restGain + " energy!");
                    break;

                case "5":
                case "quit":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid command, try again!");
            }

            turn++;
        }

        // Opponent Stats (Base 6 + randomness)
        Random randOpponent = new Random();
        int oppSpeed = 6 + randOpponent.nextInt(11) - 5;   // ±5
        int oppPower = 6 + randOpponent.nextInt(11) - 5;
        int oppStamina = 6 + randOpponent.nextInt(11) - 5;

        System.out.println("\n--- Final Race ---");
        System.out.println("Your horse " + horseName + " VS Speed Biscuit 🐴");

        // Race narration
        System.out.println("\n🏁 The race begins!");
        System.out.println(horseName + " bursts out of the gate...");
        System.out.println("Speed Biscuit surges forward...");
        System.out.println("They're neck and neck down the stretch...");
        System.out.println("The crowd is on their feet as they approach the finish line!");

        // Player & Opponent rolls
        int playerPerformance = speed + power + stamina + (rand.nextInt(11) - 5);   // ±5 RNG
        int opponentPerformance = oppSpeed + oppPower + oppStamina + (rand.nextInt(11) - 5);

        // Reveal stats after narration
        System.out.println("\n--- Stats ---");
        System.out.println(horseName + " -> Speed: " + speed + ", Power: " + power + ", Stamina: " + stamina);
        System.out.println("Speed Biscuit -> Speed: " + oppSpeed + ", Power: " + oppPower + ", Stamina: " + oppStamina);

        System.out.println("\n--- Results ---");
        System.out.println(horseName + " total performance: " + playerPerformance);
        System.out.println("Speed Biscuit total performance: " + opponentPerformance);

        if (playerPerformance >= opponentPerformance) {
            System.out.println("\n🎉 Congratulations! " + horseName + " wins the race!");
        } else {
            System.out.println("\n💀 Oh no... Speed Biscuit outran " + horseName + ". Better luck next time!");
        }

        scanner.close();
    }

    private static int[] train(String statName, String horseName, Random rand, int energy, int mainStat, int otherStat1, int otherStat2) {
        int chance = rand.nextInt(100) + 1; // 1–100
        boolean success = (energy * 12 + 10) > chance; //+10% baseline
        boolean bigSuccess = rand.nextInt(10) == 0; // 1/10 chance

        if (success) {
            int gain = rand.nextInt(3) + 1; // 1–3
            mainStat += gain;
            System.out.println(horseName + " trained " + statName + " successfully! +" + gain);

            if (bigSuccess) {
                otherStat1 += 1; 
                System.out.println("BIG SUCCESS! Another stat increased by +1!");
            }
        } else {
            mainStat = Math.max(0, mainStat - 1);
            otherStat1 = Math.max(0, otherStat1 - 1);
            otherStat2 = Math.max(0, otherStat2 - 1);
            System.out.println(horseName + " failed training... -1 to all stats!");
        }

        return new int[]{mainStat, otherStat1, otherStat2};
    }
}
