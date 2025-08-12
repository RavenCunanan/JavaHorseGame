import java.util.Scanner;
import java.util.Random;

public class horseSim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Stats
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
        
        while (running) {
            System.out.println("\nStats: ");
            System.out.println("Energy: " + energy + "/10");
            System.out.println("Speed: " + speed + "/10");
            System.out.println("Power: " + power + "/10");
            System.out.println("Stamina: " + stamina + "/10");
          
            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
     
                default:
                    System.out.println("Invalid command, try again!");
            }
        }
        
        scanner.close();
    }
}

